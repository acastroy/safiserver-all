package com.safi.workshop.util;

/*
 * Created on May 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;
import java.util.Vector;

public class BrowserControl {

  public static String[] exec = null;

  public static void init() {
    exec = defaultCommands();
  }

  /**
   * Retrieve the default commands to open a browser for this system.
   */
  public static String[] defaultCommands() {
    String[] exec = null;
    if (System.getProperty("os.name").startsWith("Windows")) {
      exec = new String[] { "rundll32 url.dll,FileProtocolHandler {0}", };
    }
    return exec;
  }

  /**
   * Display a URL in the system browser.
   * 
   * BrowserControl.init() should be called before calling this function or
   * BrowserControl.exec should be set explicitly.
   * 
   * For security reasons, the URL will may not be passed directly to the browser as it is
   * passed to this method. The URL may be made safe for the exec command by URLEncoding
   * the URL before passing it.
   * 
   * @param url
   *          the url to display
   * @throws IOException
   *           if the url is not valid or the browser fails to star
   */
  public static void displayURL(String url) throws IOException {
    if (exec == null || exec.length == 0) {
      if (System.getProperty("os.name").startsWith("Mac")) {
        boolean success = false;
        try {
          Class nSWorkspace;
          if (new File("/System/Library/Java/com/apple/cocoa/application/NSWorkspace.class")
              .exists()) {
            // Mac OS X has NSWorkspace, but it is not in the classpath, add it.
            ClassLoader classLoader = new URLClassLoader(new URL[] { new File(
                "/System/Library/Java").toURL() });
            nSWorkspace = Class.forName("com.apple.cocoa.application.NSWorkspace", true,
                classLoader);
          } else {
            nSWorkspace = Class.forName("com.apple.cocoa.application.NSWorkspace");
          }
          Method sharedWorkspace = nSWorkspace.getMethod("sharedWorkspace", new Class[] {});
          Object workspace = sharedWorkspace.invoke(null, new Object[] {});
          Method openURL = nSWorkspace.getMethod("openURL", new Class[] { Class
              .forName("java.net.URL") });
          success = ((Boolean) openURL.invoke(workspace, new Object[] { new java.net.URL(url) }))
              .booleanValue();
          // success =
          // com.apple.cocoa.application.NSWorkspace.sharedWorkspace().openURL(new
          // java.net.URL(url));
        } catch (Exception x) {
        }
        if (!success) {
          try {
            Class mrjFileUtils = Class.forName("com.apple.mrj.MRJFileUtils");
            Method openURL = mrjFileUtils.getMethod("openURL", new Class[] { Class
                .forName("java.lang.String") });
            openURL.invoke(null, new Object[] { url });
            // com.apple.mrj.MRJFileUtils.openURL(url);
          } catch (Exception x) {
            throw new IOException("Couoldn't execute: " + x.getLocalizedMessage());
          }
        }
      } else {
        throw new IOException("No command found");
      }
    } else {
      // for security, see if the url is valid.
      // this is primarily to catch an attack in which the url
      // starts with a - to fool the command line flags, bu
      // it could catch other stuff as well, and will throw a
      // MalformedURLException which will give the caller of this
      // function useful information.
      new URL(url);
      // escape any weird characters in the url. This is primarily
      // to prevent an attacker from putting in spaces
      // that might fool exec into allowing
      // the attacker to execute arbitrary code.
      StringBuffer sb = new StringBuffer(url.length());
      for (int i = 0; i < url.length(); i++) {
        char c = url.charAt(i);
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '.'
            || c == ':' || c == '&' || c == '@' || c == '/' || c == '?' || c == '%' || c == '+'
            || c == '=' || c == '#' || c == '-' || c == '\\') {
          // characters that are necessary for URLs and should be safe
          // to pass to exec. Exec uses a default string tokenizer with
          // the default arguments (whitespace) to separate command line
          // arguments, so there should be no problem with anything bu
          // whitespace.
          sb.append(c);
        } else {
          c = (char) (c & 0xFF); // get the lowest 8 bits (URLEncoding)
          if (c < 0x10) {
            sb.append("%0" + Integer.toHexString(c));
          } else {
            sb.append("%" + Integer.toHexString(c));
          }
        }
      }
      String[] messageArray = new String[1];
      messageArray[0] = sb.toString();
      String command = null;
      boolean found = false;
      // try each of the exec commands until something works
      try {
        for (int i = 0; i < exec.length && !found; i++) {
          try {
            // stick the url into the command
            command = MessageFormat.format(exec[i], (Object[]) messageArray);
            // parse the command line.
            Vector argsVector = new Vector();
            BrowserCommandLexer lex = new BrowserCommandLexer(new StringReader(command));
            String t;
            while ((t = lex.getNextToken()) != null) {
              argsVector.add(t);
            }
            String[] args = new String[argsVector.size()];
            args = (String[]) argsVector.toArray(args);
            // the windows url protocol handler doesn't work well with file URLs.
            // Correct those problems here before continuing
            // Java File.toURL() gives only one / following file: bu
            // we need two.
            // If there are escaped characters in the url, we will have
            // to create an Internet shortcut and open that, as the command
            // line version of the rundll doesn't like them.
            boolean useShortCut = false;
            if (args[0].equals("rundll32") && args[1].equals("url.dll,FileProtocolHandler")) {
              if (args[2].startsWith("file:/")) {
                if (args[2].charAt(6) != '/') {
                  args[2] = "file://" + args[2].substring(6);
                }
                if (args[2].charAt(7) != '/') {
                  args[2] = "file:///" + args[2].substring(7);
                }
                useShortCut = true;
              } else if (args[2].toLowerCase().endsWith("html")
                  || args[2].toLowerCase().endsWith("htm")) {
                useShortCut = true;
              }
            }
            if (useShortCut) {
              File shortcut = File.createTempFile("OpenInBrowser", ".url");
              shortcut = shortcut.getCanonicalFile();
              shortcut.deleteOnExit();
              PrintWriter out = new PrintWriter(new FileWriter(shortcut));
              out.println("[InternetShortcut]");
              out.println("URL=" + args[2]);
              out.close();
              args[2] = shortcut.getCanonicalPath();
            }
            // start the browser
            Process p = Runtime.getRuntime().exec(args);

            // give the browser a bit of time to fail.
            // I have found that sometimes sleep doesn't work
            // the first time, so do it twice. My tests
            // seem to show that 1000 milliseconds is enough
            // time for the browsers I'm using.
            for (int j = 0; j < 2; j++) {
              try {
                Thread.currentThread().sleep(1000);
              } catch (InterruptedException inte) {
              }
            }
            if (p.exitValue() == 0) {
              // this is a weird case. The browser exited after
              // a couple seconds saying that it successfully
              // displayed the url. Either the browser is lying
              // or the user closed it *really* quickly. Oh well.
              found = true;
            }
          } catch (IOException x) {
            // the command was not a valid command.
            System.err.println("invalid command: " + x.getMessage());
          }
        }
        if (!found) {
          // we never found a command that didn't terminate with an error.
          throw new IOException("No command was successful");
        }
      } catch (IllegalThreadStateException e) {
        // the browser is still running. This is a good sign.
        // lets just say that it is displaying the url right now!
      }
    }
  }

  /**
   * Display the URLs, each in their own window, in the system browser.
   * 
   * BrowserControl.init() should be called before calling this function or
   * BrowserControl.exec should be set explicitly.
   * 
   * If more than one URL is given an HTML page containing JavaScript will be written to
   * the local drive, that page will be opened, and it will open the rest of the URLs.
   * 
   * @param urls
   *          the list of urls to display
   * @throws IOException
   *           if the url is not valid or the browser fails to star
   */
  public static void displayURLs(String[] urls) throws IOException {
    if (urls == null || urls.length == 0) {
      return;
    }
    if (urls.length == 1) {
      displayURL(urls[0]);
      return;
    }
    File shortcut = File.createTempFile("DisplayURLs", ".html");
    shortcut = shortcut.getCanonicalFile();
    shortcut.deleteOnExit();
    PrintWriter out = new PrintWriter(new FileWriter(shortcut));
    out.println("<!-- saved from url=(0014)about:internet -->");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>" + "Autodial Opening URLS" + "</title>");
    out.println("<script language=\"javascript\" type=\"text/javascript\">");
    out.println("function displayURLs(){");
    for (int i = 1; i < urls.length; i++) {
      out
          .println("window.open(\""
              + urls[i]
              + "\", \"_blank\", \"toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,resizable=yes\");");
    }
    out.println("location.href=\"" + urls[0] + "\";");
    out.println("}");
    out.println("</script>");
    out.println("</head>");
    out.println("<body onload=\"javascript:displayURLs()\">");
    out.println("<noscript>");
    for (String url : urls) {
      out.println("<a target=\"_blank\" href=\"" + url + "\">" + url + "</a><br>");
    }
    out.println("</noscript>");
    out.println("</body>");
    out.println("</html>");
    out.close();
    displayURL(shortcut.toURL().toString());
  }

  /**
   * Display the URL in a new window.
   * 
   * Uses javascript to check history.length to determine if the browser opened a new
   * window already. If it did, the url is shown in that window, if not, it is shown in
   * new window.
   * 
   * Some browsers do not allow the length of history to be viewed by a web page. In that
   * case, the url will be displayed in the current window.
   * 
   * BrowserControl.init() should be called before calling this function or
   * BrowserControl.exec should be set explicitly.
   * 
   * @param url
   *          the url to display in a new window.
   * @throws IOException
   *           if the url is not valid or the browser fails to star
   */
  public static void displayURLinNew(String url) throws IOException {
    displayURLsinNew(new String[] { url });
  }

  /**
   * Display the URLs, each in their own window, in the system browser and the first in
   * the named window.
   * 
   * The first URL will only be opened in the named window if the browser did no open it
   * in a new window to begin with.
   * 
   * BrowserControl.init() should be called before calling this function or
   * BrowserControl.exec should be set explicitly.
   * 
   * An html page containing javascript will be written to the local drive, that page will
   * be opened, and it will open all the urls.
   * 
   * @param urls
   *          the list of urls to display
   * @throws IOException
   *           if the url is not valid or the browser fails to star
   */
  public static void displayURLsinNew(String[] urls) throws IOException {
    if (urls == null || urls.length == 0) {
      return;
    }
    File shortcut = File.createTempFile("DisplayURLs", ".html");
    shortcut.deleteOnExit();
    shortcut = shortcut.getCanonicalFile();
    PrintWriter out = new PrintWriter(new FileWriter(shortcut));
    out.println("<!-- saved from url=(0014)about:internet -->");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>" + "AutoDial Opening URLs" + "</title>");
    out.println("<script language=\"javascript\" type=\"text/javascript\">");
    out.println("function displayURLs(){");
    out.println("var hlength = 0;");
    out.println("try {");
    out.println("hlength = history.length;");
    out.println("} catch (e) {}");
    out.println("if (hlength>0) {");
    out
        .println("window.open(\""
            + urls[0]
            + "\", \"_blank\", \"toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,resizable=yes\");");
    out.println("}");
    for (int i = 1; i < urls.length; i++) {
      out
          .println("window.open(\""
              + urls[i]
              + "\", \"_blank\", \"toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,resizable=yes\");");
    }
    out.println("if (hlength==0) {");
    out.println("location.href=\"" + urls[0] + "\";");
    out.println("} else {");
    out.println("history.back()");
    out.println("}");
    out.println("}");
    out.println("</script>");
    out.println("</head>");
    out.println("<body onload=\"javascript:displayURLs()\">");
    out.println("<noscript>");
    for (String url : urls) {
      out.println("<a target=\"_blank\" href=\"" + url + "\">" + url + "</a><br>");
    }
    out.println("</noscript>");
    out.println("</body>");
    out.println("</html>");
    out.close();
    displayURL(shortcut.toURL().toString());
  }

  /**
   * Display the URL in the named window.
   * 
   * If the browser opens a new window by default, this will likely cause a duplicate
   * window to be opened.
   * 
   * BrowserControl.init() should be called before calling this function or
   * BrowserControl.exec should be set explicitly.
   * 
   * @param url
   *          the url to display
   * @param namedWindow
   *          the name of the desired window.
   * @throws IOException
   *           if the url is not valid or the browser fails to star
   */
  public static void displayURL(String url, String namedWindow) throws IOException {
    displayURLs(new String[] { url }, new String[] { namedWindow });
  }

  /**
   * Display the URLs in the named windows.
   * 
   * If the browser opens a new window by default, this will likely cause a duplicate
   * window to be opened. This method relies on the browser to support javascript.
   * 
   * BrowserControl.init() should be called before calling this function or
   * BrowserControl.exec should be set explicitly.
   * 
   * Extra names for windows will be ignored, and if there are too few names, the
   * remaining windows will be named "_blank".
   * 
   * @param urls
   *          the list of urls to display
   * @param namedWindows
   *          the list of names for the windows.
   * @throws IOException
   *           if the url is not valid or the browser fails to star
   */
  public static void displayURLs(String[] urls, String[] namedWindows) throws IOException {
    if (urls == null || urls.length == 0) {
      return;
    }
    File shortcut = File.createTempFile("DisplayURLs", ".html");
    shortcut.deleteOnExit();
    shortcut = shortcut.getCanonicalFile();
    PrintWriter out = new PrintWriter(new FileWriter(shortcut));
    out.println("<!-- saved from url=(0014)about:internet -->");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>" + "AutoDial Opening URLs" + "</title>");
    out.println("<base target=\""
        + ((namedWindows == null || namedWindows.length == 0 || namedWindows[0] == null) ? "_blank"
            : namedWindows[0]) + "\">");
    out.println("<script language=\"javascript\" type=\"text/javascript\">");
    for (int i = 1; i < urls.length; i++) {
      out
          .println("window.open(\""
              + urls[i]
              + "\", \""
              + ((namedWindows == null || namedWindows.length <= i || namedWindows[i] == null) ? "_blank"
                  : namedWindows[i])
              + "\", \"toolbar=yes,location=yes,directories=yes,status=yes,menubar=yes,scrollbars=yes,resizable=yes\");");
    }
    out.println("location.href=\"" + urls[0] + "\";");
    out.println("</script>");
    out.println("</head>");
    out.println("<body onload=\"javascript:displayURLs()\">");
    out.println("<noscript>");
    for (String url : urls) {
      out
          .println("<a target=\""
              + ((namedWindows == null || namedWindows.length == 0 || namedWindows[0] == null) ? "_blank"
                  : namedWindows[0]) + "\" href=\"" + url + "\">" + url + "</a><br>");
    }
    out.println("</noscript>");
    out.println("</body>");
    out.println("</html>");
    out.close();
    displayURL(shortcut.toURL().toString());
  }

  /**
   * Display the URLs the first in the given named window.
   * 
   * If the browser opens a new window by default, this will likely cause a duplicate
   * window to be opened. This method relies on the browser to support javascript.
   * 
   * BrowserControl.init() should be called before calling this function or
   * BrowserControl.exec should be set explicitly.
   * 
   * @param urls
   *          the list of urls to display
   * @param namedWindow
   *          the name of the first window to use.
   * @throws IOException
   *           if the url is not valid or the browser fails to star
   */
  public static void displayURLs(String[] urls, String namedWindow) throws IOException {
    displayURLs(urls, new String[] { namedWindow });
  }

  /**
   * Open the url(s) specified on the command line in your browser.
   * 
   * @param args
   *          Command line arguments (URLs)
   */
  public static void main(String[] args) {
    try {
      if (args.length == 0) {
        BrowserControl.displayURLs(new String[] { "http://www.google.com/", "http://dmoz.org/",
            "http://ostermiller.org", }, "fun");
      } else if (args.length == 1) {
        BrowserControl.displayURL(args[0], "fun");
      } else {
        BrowserControl.displayURLs(args, "fun");
      }
      try {
        Thread.sleep(10000);
      } catch (InterruptedException x) {
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    System.exit(0);
  }

  private static void setCommands(String[] newExec) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; newExec != null && i < newExec.length; i++) {
      sb.append(newExec[i]).append('\n');
    }
  }

  /**
   * If you are using the getDialogPanel() method to create your own dialog, this method
   * should be called every time before you display the dialog.
   * 
   * mydialog.add(Browser.getDialogPanel(mydialog)); Browser.initPanel(); mydialog.show();
   * if (ok_pressed){ &nbsp;&nbsp;Browser.userOKedPanelChanges(); }
   * 
   * @since ostermillerutils 1.02.22
   */
  public static void initPanel() {
    setCommands(exec);
  }

  static class BrowserCommandLexer {

    private static int[] zzUnpackAction() {
      int ai[] = new int[14];
      int i = 0;
      i = zzUnpackAction(
          "\002\001\002\002\001\001\003\000\001\003\001\001\001\003\001\000\002\003", i, ai);
      return ai;
    }

    private static int zzUnpackAction(String s, int i, int ai[]) {
      int j = 0;
      int k = i;
      for (int l = s.length(); j < l;) {
        int i1 = s.charAt(j++);
        char c = s.charAt(j++);
        do
          ai[k++] = c;
        while (--i1 > 0);
      }

      return k;
    }

    private static int[] zzUnpackRowMap() {
      int ai[] = new int[14];
      int i = 0;
      i = zzUnpackRowMap(
          "\000\000\000\004\000\b\000\f\000\020\000\b\000\024\000\030\000\004\000\034\000\020\000 \000\f\000\030",
          i, ai);
      return ai;
    }

    private static int zzUnpackRowMap(String s, int i, int ai[]) {
      int j = 0;
      int k = i;
      for (int l = s.length(); j < l;) {
        int i1 = s.charAt(j++) << 16;
        ai[k++] = i1 | s.charAt(j++);
      }

      return k;
    }

    private static int[] zzUnpackTrans() {
      int ai[] = new int[36];
      int i = 0;
      i = zzUnpackTrans(
          "\001\002\001\003\001\004\001\005\001\002\001\006\001\000\005\002\004\000\001\005\001\007\001\b\001\t\001\005\001\n\001\005\001\013\001\b\001\f\001\b\001\r\001\005\001\007\001\b\001\013\001\b\001\f\001\b\001\016",
          i, ai);
      return ai;
    }

    private static int zzUnpackTrans(String s, int i, int ai[]) {
      int j = 0;
      int k = i;
      for (int l = s.length(); j < l;) {
        int i1 = s.charAt(j++);
        int j1 = s.charAt(j++);
        j1--;
        do
          ai[k++] = j1;
        while (--i1 > 0);
      }

      return k;
    }

    private static int[] zzUnpackAttribute() {
      int ai[] = new int[14];
      int i = 0;
      i = zzUnpackAttribute("\003\001\001\t\001\001\003\000\003\001\001\000\001\t\001\001", i, ai);
      return ai;
    }

    private static int zzUnpackAttribute(String s, int i, int ai[]) {
      int j = 0;
      int k = i;
      for (int l = s.length(); j < l;) {
        int i1 = s.charAt(j++);
        char c = s.charAt(j++);
        do
          ai[k++] = c;
        while (--i1 > 0);
      }

      return k;
    }

    private static void main(String args[]) {
      try {
        Object obj;
        if (args.length > 0) {
          File file = new File(args[0]);
          if (file.exists()) {
            if (file.canRead())
              obj = new FileInputStream(file);
            else
              throw new IOException("Could not open " + args[0]);
          } else {
            throw new IOException("Could not find " + args[0]);
          }
        } else {
          obj = System.in;
        }
        BrowserCommandLexer browsercommandlexer = new BrowserCommandLexer(((InputStream) (obj)));
        String s;
        while ((s = browsercommandlexer.getNextToken()) != null)
          System.out.println(s);
      } catch (IOException ioexception) {
        System.out.println(ioexception.getMessage());
      }
    }

    public String getNextToken() throws IOException {
      return getToken();
    }

    private static String unescape(String s) {
      StringBuffer stringbuffer = new StringBuffer(s.length());
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '\\' && i < s.length())
          i++;
        stringbuffer.append(s.charAt(i));
      }

      return stringbuffer.toString();
    }

    BrowserCommandLexer(Reader reader) {
      zzLexicalState = 0;
      zzBuffer = new char[16384];
      zzAtBOL = true;
      zzReader = reader;
    }

    BrowserCommandLexer(InputStream inputstream) {
      this(((Reader) (new InputStreamReader(inputstream))));
    }

    private static char[] zzUnpackCMap(String s) {
      char ac[] = new char[0x10000];
      int i = 0;
      int j = 0;
      while (i < 26) {
        int k = s.charAt(i++);
        char c = s.charAt(i++);
        do
          ac[j++] = c;
        while (--k > 0);
      }
      return ac;
    }

    private boolean zzRefill() throws IOException {
      if (zzStartRead > 0) {
        System.arraycopy(zzBuffer, zzStartRead, zzBuffer, 0, zzEndRead - zzStartRead);
        zzEndRead -= zzStartRead;
        zzCurrentPos -= zzStartRead;
        zzMarkedPos -= zzStartRead;
        zzPushbackPos -= zzStartRead;
        zzStartRead = 0;
      }
      if (zzCurrentPos >= zzBuffer.length) {
        char ac[] = new char[zzCurrentPos * 2];
        System.arraycopy(zzBuffer, 0, ac, 0, zzBuffer.length);
        zzBuffer = ac;
      }
      int i = zzReader.read(zzBuffer, zzEndRead, zzBuffer.length - zzEndRead);
      if (i < 0) {
        return true;
      } else {
        zzEndRead += i;
        return false;
      }
    }

    private final void yyclose() throws IOException {
      zzAtEOF = true;
      zzEndRead = zzStartRead;
      if (zzReader != null)
        zzReader.close();
    }

    private final void yyreset(Reader reader) {
      zzReader = reader;
      zzAtBOL = true;
      zzAtEOF = false;
      zzEndRead = zzStartRead = 0;
      zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
      yyline = yychar = yycolumn = 0;
      zzLexicalState = 0;
    }

    private final int yystate() {
      return zzLexicalState;
    }

    private final void yybegin(int i) {
      zzLexicalState = i;
    }

    private final String yytext() {
      return new String(zzBuffer, zzStartRead, zzMarkedPos - zzStartRead);
    }

    private final char yycharat(int i) {
      return zzBuffer[zzStartRead + i];
    }

    private final int yylength() {
      return zzMarkedPos - zzStartRead;
    }

    private void zzScanError(int i) {
      String s;
      try {
        s = ZZ_ERROR_MSG[i];
      } catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception) {
        s = ZZ_ERROR_MSG[0];
      }
      throw new Error(s);
    }

    private void yypushback(int i) {
      if (i > yylength())
        zzScanError(2);
      zzMarkedPos -= i;
    }

    private String getToken() throws IOException {
      int l = zzEndRead;
      char ac[] = zzBuffer;
      char ac1[] = ZZ_CMAP;
      int ai[] = ZZ_TRANS;
      int ai1[] = ZZ_ROWMAP;
      int ai2[] = ZZ_ATTRIBUTE;
      do {
        int k = zzMarkedPos;
        int i = -1;
        int j = zzCurrentPos = zzStartRead = k;
        zzState = zzLexicalState;
        char c;
        int j1;
        label0: do {
          do {
            if (j < l) {
              c = ac[j++];
            } else {
              if (zzAtEOF) {
                c = '\uFFFF';
                break label0;
              }
              zzCurrentPos = j;
              zzMarkedPos = k;
              boolean flag = zzRefill();
              j = zzCurrentPos;
              k = zzMarkedPos;
              ac = zzBuffer;
              l = zzEndRead;
              if (flag) {
                c = '\uFFFF';
                break label0;
              }
              c = ac[j++];
            }
            int i1 = ai[ai1[zzState] + ac1[c]];
            if (i1 == -1)
              break label0;
            zzState = i1;
            j1 = ai2[zzState];
          } while ((j1 & 1) != 1);
          i = zzState;
          k = j;
        } while ((j1 & 8) != 8);
        zzMarkedPos = k;
        switch (i >= 0 ? ZZ_ACTION[i] : i) {
          case 3: // '\003'
            return unescape(yytext().substring(1, yytext().length() - 1));

          case 1: // '\001'
            return unescape(yytext());

          default:
            if (c == '\uFFFF' && zzStartRead == zzCurrentPos) {
              zzAtEOF = true;
              return null;
            }
            zzScanError(1);
            break;

          case 2: // '\002'
          case 4: // '\004'
          case 5: // '\005'
          case 6: // '\006'
            break;
        }
      } while (true);
    }

    private static final int YYEOF = -1;
    private static final int ZZ_BUFFERSIZE = 16384;
    private static final int YYINITIAL = 0;
    private static final String ZZ_CMAP_PACKED = "\t\000\002\002\001\000\002\002\022\000\001\002\001\000\001\003\036\000\001\000\032\000\001\001\uFFA3\0";
    private static final char ZZ_CMAP[] = zzUnpackCMap("\t\000\002\002\001\000\002\002\022\000\001\002\001\000\001\003\036\000\001\000\032\000\001\001\uFFA3\0");
    private static final int ZZ_ACTION[] = zzUnpackAction();
    private static final String ZZ_ACTION_PACKED_0 = "\002\001\002\002\001\001\003\000\001\003\001\001\001\003\001\000\002\003";
    private static final int ZZ_ROWMAP[] = zzUnpackRowMap();
    private static final String ZZ_ROWMAP_PACKED_0 = "\000\000\000\004\000\b\000\f\000\020\000\b\000\024\000\030\000\004\000\034\000\020\000 \000\f\000\030";
    private static final int ZZ_TRANS[] = zzUnpackTrans();
    private static final String ZZ_TRANS_PACKED_0 = "\001\002\001\003\001\004\001\005\001\002\001\006\001\000\005\002\004\000\001\005\001\007\001\b\001\t\001\005\001\n\001\005\001\013\001\b\001\f\001\b\001\r\001\005\001\007\001\b\001\013\001\b\001\f\001\b\001\016";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final String ZZ_ERROR_MSG[] = { "Unkown internal scanner error",
        "Error: could not match input", "Error: pushback value was too large" };
    private static final int ZZ_ATTRIBUTE[] = zzUnpackAttribute();
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\003\001\001\t\001\001\003\000\003\001\001\000\001\t\001\001";
    private Reader zzReader;
    private int zzState;
    private int zzLexicalState;
    private char zzBuffer[];
    private int zzMarkedPos;
    private int zzPushbackPos;
    private int zzCurrentPos;
    private int zzStartRead;
    private int zzEndRead;
    private int yyline;
    private int yychar;
    private int yycolumn;
    private boolean zzAtBOL;
    private boolean zzAtEOF;
  }

}
