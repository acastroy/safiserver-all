package com.safi.workshop.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.ide.StatusUtil;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.application.ChooseSafiServerWorkspaceData.SafiWorkspaceProfile;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.SafiWorkshopEditorUtil;
import com.safi.workshop.preferences.AudioControlsPrefPage;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * @generated
 */
public class AsteriskApplication implements IApplication {

  public static final String METADATA_FOLDER = ".metadata"; //$NON-NLS-1$

  private static final String VERSION_FILENAME = "version.ini"; //$NON-NLS-1$

  private static final String WORKSPACE_VERSION_KEY = "org.eclipse.core.runtime"; //$NON-NLS-1$

  private static final String WORKSPACE_VERSION_VALUE = "1"; //$NON-NLS-1$

  private static final String PROP_EXIT_CODE = "eclipse.exitcode"; //$NON-NLS-1$

  /**
   * @generated NOT
   */
  // public Object run(Object args) throws Exception {
  //
  // Display display = PlatformUI.createDisplay();
  //
  // Shell shell = new Shell(display, SWT.ON_TOP);
  //
  // try {
  // if (!checkInstanceLocation(shell)) {
  // Platform.endSplash();
  // return EXIT_OK;
  // }
  // } finally {
  // if (shell != null) {
  // shell.dispose();
  // }
  // }
  //
  // try {
  // int returnCode = PlatformUI.createAndRunWorkbench(display,
  // new DiagramEditorWorkbenchAdvisor() {
  // @Override
  // public void postStartup() {
  // super.postStartup();
  //
  // AsteriskDiagramEditorUtil.initializePalette();
  // AsteriskDiagramEditorUtil.getSafiNavigator().switchToSafletPerspective();
  // //AsteriskDiagramEditorUtil.getSafiNavigator().resetPerspective();
  // // SafiJavaScriptEditor jeditor = new SafiJavaScriptEditor();
  //
  // // AsteriskDiagramEditorPlugin.getInstance().initSQLPlugin();
  // }
  //
  // @Override
  // public void postShutdown() {
  // AudioControlsPrefPage.closeOpenedLines();
  // // AsteriskDiagramEditorUtil.getSafiNavigator().switchToSafletPerspective();
  // super.postShutdown();
  // }
  // });
  // if (returnCode == PlatformUI.RETURN_RESTART) {
  // return IPlatformRunnable.EXIT_RESTART;
  // }
  // return IPlatformRunnable.EXIT_OK;
  // } finally {
  // if (!display.isDisposed())
  // display.dispose();
  // }
  // }
  /**
   * Return true if a valid workspace path has been set and false otherwise. Prompt for
   * and set the path if possible and required.
   * 
   * @return true if a valid instance location has been set and false otherwise
   */
  private boolean checkInstanceLocation(Shell shell) {
    // -data @none was specified but an ide requires workspace
    Location instanceLoc = Platform.getInstanceLocation();

    if (instanceLoc == null) {
      MessageDialog.openError(shell, IDEWorkbenchMessages.IDEApplication_workspaceMandatoryTitle,
          IDEWorkbenchMessages.IDEApplication_workspaceMandatoryMessage);
      return false;
    }

    // -data "/valid/path", workspace already set
    if (instanceLoc.isSet()) {
      // make sure the meta data version is compatible (or the user has
      // chosen to overwrite it).
      if (!checkValidWorkspace(shell, instanceLoc.getURL())) {
        return false;
      }

      // at this point its valid, so try to lock it and update the
      // metadata version information if successful
      try {
        if (instanceLoc.lock()) {
          writeWorkspaceVersion();
          return true;
        }

        // we failed to create the directory.
        // Two possibilities:
        // 1. directory is already in use
        // 2. directory could not be created
        File workspaceDirectory = new File(instanceLoc.getURL().getFile());
        if (workspaceDirectory.exists()) {
          MessageDialog.openError(shell,
              IDEWorkbenchMessages.IDEApplication_workspaceCannotLockTitle,
              IDEWorkbenchMessages.IDEApplication_workspaceCannotLockMessage);
        } else {
          MessageDialog.openError(shell,
              IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetTitle,
              IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetMessage);
        }
      } catch (IOException e) {
        IDEWorkbenchPlugin.log("Could not obtain lock for workspace location", //$NON-NLS-1$
            e);
        MessageDialog.openError(shell, IDEWorkbenchMessages.InternalError, e.getMessage());
      }
      return false;
    }

    // -data @noDefault or -data not specified, prompt and set
    ChooseSafiServerWorkspaceData launchData = new ChooseSafiServerWorkspaceData(instanceLoc
        .getDefault());

    boolean force = false;
    while (true) {
      URL workspaceUrl = promptForWorkspace(shell, launchData, force);
      if (workspaceUrl == null) {
        return false;
      }

      // if there is an error with the first selection, then force the
      // dialog to open to give the user a chance to correct
      force = true;

      try {
        // the operation will fail if the url is not a valid
        // instance data area, so other checking is unneeded
        if (instanceLoc.setURL(workspaceUrl, true)) {
          launchData.writePersistedData();
          writeWorkspaceVersion();
          // try {
          // System.setProperty("org.eclipse.emf.ecore.plugin.EcorePlugin.doNotLoadResourcesPlugin",
          // null);
          // EcorePlugin.getPlugin().start(AsteriskDiagramEditorPlugin.getDefault().getBundle().getBundleContext());
          // } catch (Exception e) {
          // e.printStackTrace();
          // }
          return true;
        }
      } catch (IllegalStateException e) {
        MessageDialog.openError(shell,
            IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetTitle,
            IDEWorkbenchMessages.IDEApplication_workspaceCannotBeSetMessage);
        return false;
      }

      // by this point it has been determined that the workspace is
      // already in use -- force the user to choose again
      MessageDialog.openError(shell, IDEWorkbenchMessages.IDEApplication_workspaceInUseTitle,
          IDEWorkbenchMessages.IDEApplication_workspaceInUseMessage);
    }
  }

  /**
   * Open a workspace selection dialog on the argument shell, populating the argument data
   * with the user's selection. Perform first level validation on the selection by
   * comparing the version information. This method does not examine the runtime state
   * (e.g., is the workspace already locked?).
   * 
   * @param shell
   * @param launchData
   * @param force
   *          setting to true makes the dialog open regardless of the showDialog value
   * @return An URL storing the selected workspace or null if the user has canceled the
   *         launch operation.
   */
  // private URL promptForWorkspace(Shell shell, ChooseWorkspaceData launchData, boolean
  // force) {
  // URL url = null;
  // do {
  // // don't use the parent shell to make the dialog a top-level
  // // shell. See bug 84881.
  // new ChooseWorkspaceDialog(null, launchData, false, true).prompt(force);
  // String instancePath = launchData.getSelection();
  // if (instancePath == null) {
  // return null;
  // }
  //
  // // the dialog is not forced on the first iteration, but is on every
  // // subsequent one -- if there was an error then the user needs to be
  // // allowed to fix it
  // force = true;
  //
  // // 70576: don't accept empty input
  // if (instancePath.length() <= 0) {
  // MessageDialog.openError(shell,
  // IDEWorkbenchMessages.IDEApplication_workspaceEmptyTitle,
  // IDEWorkbenchMessages.IDEApplication_workspaceEmptyMessage);
  // continue;
  // }
  //
  // // create the workspace if it does not already exist
  // File workspace = new File(instancePath);
  // if (!workspace.exists()) {
  // workspace.mkdir();
  // }
  //
  // try {
  // // Don't use File.toURL() since it adds a leading slash that
  // // Platform does not
  // // handle properly. See bug 54081 for more details.
  // String path = workspace.getAbsolutePath().replace(File.separatorChar, '/');
  //        url = new URL("file", null, path); //$NON-NLS-1$
  // } catch (MalformedURLException e) {
  // MessageDialog.openError(shell,
  // IDEWorkbenchMessages.IDEApplication_workspaceInvalidTitle,
  // IDEWorkbenchMessages.IDEApplication_workspaceInvalidMessage);
  // continue;
  // }
  // } while (!checkValidWorkspace(shell, url));
  //
  // return url;
  // }
  /**
   * Return true if the argument directory is ok to use as a workspace and false
   * otherwise. A version check will be performed, and a confirmation box may be displayed
   * on the argument shell if an older version is detected.
   * 
   * @return true if the argument URL is ok to use as a workspace and false otherwise.
   */
  private boolean checkValidWorkspace(Shell shell, URL url) {
    // a null url is not a valid workspace
    if (url == null) {
      return false;
    }

    String version = readWorkspaceVersion(url);

    // if the version could not be read, then there is not any existing
    // workspace data to trample, e.g., perhaps its a new directory that
    // is just starting to be used as a workspace
    if (version == null) {
      return true;
    }

    final int ide_version = Integer.parseInt(WORKSPACE_VERSION_VALUE);
    int workspace_version = Integer.parseInt(version);

    // equality test is required since any version difference (newer
    // or older) may result in data being trampled
    if (workspace_version == ide_version) {
      return true;
    }

    // At this point workspace has been detected to be from a version
    // other than the current ide version -- find out if the user wants
    // to use it anyhow.
    String title = IDEWorkbenchMessages.IDEApplication_versionTitle;
    String message = NLS.bind(IDEWorkbenchMessages.IDEApplication_versionMessage, url.getFile());

    MessageBox mbox = new MessageBox(shell, SWT.OK | SWT.CANCEL | SWT.ICON_WARNING
        | SWT.APPLICATION_MODAL);
    mbox.setText(title);
    mbox.setMessage(message);
    return mbox.open() == SWT.OK;
  }

  /**
   * Look at the argument URL for the workspace's version information. Return that version
   * if found and null otherwise.
   */
  private static String readWorkspaceVersion(URL workspace) {
    File versionFile = getVersionFile(workspace, false);
    if (versionFile == null || !versionFile.exists()) {
      return null;
    }

    try {
      // Although the version file is not spec'ed to be a Java properties
      // file, it happens to follow the same format currently, so using
      // Properties to read it is convenient.
      Properties props = new Properties();
      FileInputStream is = new FileInputStream(versionFile);
      try {
        props.load(is);
      } finally {
        is.close();
      }

      return props.getProperty(WORKSPACE_VERSION_KEY);
    } catch (IOException e) {
      IDEWorkbenchPlugin.log("Could not read version file", new Status( //$NON-NLS-1$
          IStatus.ERROR, IDEWorkbenchPlugin.IDE_WORKBENCH, IStatus.ERROR,
          e.getMessage() == null ? "" : e.getMessage(), //$NON-NLS-1$,
          e));
      return null;
    }
  }

  /**
   * Write the version of the metadata into a known file overwriting any existing file
   * contents. Writing the version file isn't really crucial, so the function is silent
   * about failure
   */
  private static void writeWorkspaceVersion() {
    Location instanceLoc = Platform.getInstanceLocation();
    if (instanceLoc == null || instanceLoc.isReadOnly()) {
      return;
    }

    File versionFile = getVersionFile(instanceLoc.getURL(), true);
    if (versionFile == null) {
      return;
    }

    OutputStream output = null;
    try {
      String versionLine = WORKSPACE_VERSION_KEY + '=' + WORKSPACE_VERSION_VALUE;

      output = new FileOutputStream(versionFile);
      output.write(versionLine.getBytes("UTF-8")); //$NON-NLS-1$
    } catch (IOException e) {
      IDEWorkbenchPlugin.log("Could not write version file", //$NON-NLS-1$
          StatusUtil.newStatus(IStatus.ERROR, e.getMessage(), e));
    } finally {
      try {
        if (output != null) {
          output.close();
        }
      } catch (IOException e) {
        // do nothing
      }
    }
  }

  /**
   * The version file is stored in the metadata area of the workspace. This method returns
   * an URL to the file or null if the directory or file does not exist (and the create
   * parameter is false).
   * 
   * @param create
   *          If the directory and file does not exist this parameter controls whether it
   *          will be created.
   * @return An url to the file or null if the version file does not exist or could not be
   *         created.
   */
  private static File getVersionFile(URL workspaceUrl, boolean create) {
    if (workspaceUrl == null) {
      return null;
    }

    try {
      // make sure the directory exists
      File metaDir = new File(workspaceUrl.getPath(), METADATA_FOLDER);
      if (!metaDir.exists() && (!create || !metaDir.mkdir())) {
        return null;
      }

      // make sure the file exists
      File versionFile = new File(metaDir, VERSION_FILENAME);
      if (!versionFile.exists() && (!create || !versionFile.createNewFile())) {
        return null;
      }

      return versionFile;
    } catch (IOException e) {
      // cannot log because instance area has not been set
      return null;
    }
  }

  private URL promptForWorkspace(Shell shell, ChooseSafiServerWorkspaceData launchData,
      boolean force) {
    URL url = null;
    do {
      // don't use the parent shell to make the dialog a top-level
      // shell. See bug 84881.
      SafiWorkspaceProfile instancePath = null;
      if (launchData != null && !launchData.getShowDialog()) {
        instancePath = launchData.getSelection();
        if (instancePath == null) {
          List<SafiWorkspaceProfile> profils = launchData.getRecentWorkspaces();
          if (profils != null && !profils.isEmpty())
            instancePath = profils.get(0);
        }
        // ChooseSafiServerWorkspaceData.setShowDialogValue(true);
        launchData.setShowDialog(false);
        launchData.writePersistedData();
      } else {
        // Preferences pref =
        // Preferences.userNodeForPackage(ChooseSafiWorkspaceDialog.class);
        // if (launchData.getSelection() == null
        // || !pref.getBoolean(ChooseSafiWorkspaceDialog.KEY_REMEMBER_WORKSPACE_PREF,
        // false)) {
        ChooseSafiWorkspaceDialog dlg = new ChooseSafiWorkspaceDialog(null, launchData);
        if (dlg.open() != Window.OK)
          return null;
        // }

        instancePath = launchData.getSelection();

      }
      if (instancePath == null) {
        return null;
      }

      // the dialog is not forced on the first iteration, but is on every
      // subsequent one -- if there was an error then the user needs to be
      // allowed to fix it
      force = true;

      // 70576: don't accept empty input
      if (StringUtils.isBlank(instancePath.getPath())) {
        MessageDialog.openError(shell, IDEWorkbenchMessages.IDEApplication_workspaceEmptyTitle,
            IDEWorkbenchMessages.IDEApplication_workspaceEmptyMessage);
        continue;
      }

      // create the workspace if it does not already exist
      File workspace = new File(instancePath.getPath());
      if (!workspace.exists()) {
        workspace.mkdir();
      }

      try {
        // Don't use File.toURL() since it adds a leading slash that
        // Platform does not
        // handle properly. See bug 54081 for more details.
        String path = workspace.getAbsolutePath().replace(File.separatorChar, '/');
        url = new URL("file", null, path); //$NON-NLS-1$
      } catch (MalformedURLException e) {
        MessageDialog.openError(shell, IDEWorkbenchMessages.IDEApplication_workspaceInvalidTitle,
            IDEWorkbenchMessages.IDEApplication_workspaceInvalidMessage);
        continue;
      }
    } while (!checkValidWorkspace(shell, url));

    return url;
  }

  @Override
  public Object start(IApplicationContext context) throws Exception {
    Display display = PlatformUI.createDisplay();
    try {
      Shell shell = new Shell(display, SWT.ON_TOP);
      try {
        if (!checkInstanceLocation(shell)) {
          Platform.endSplash();
          return EXIT_OK;
        }
      } finally {
        if (shell != null) {
          shell.dispose();
        }
      }
      /*
       * // the old Eclipse generated code
       * 
       * // and so on.. Location instanceLoc = Platform.getInstanceLocation(); // get what
       * the user last said about remembering the workspace location boolean remember =
       * PickWorkspaceDialog.isRememberWorkspace();
       * 
       * // get the last used workspace location String lastUsedWs =
       * PickWorkspaceDialog.getLastSetWorkspaceDirectory();
       * 
       * // if we have a "remember" but no last used workspace, it's not much to remember
       * if (remember && (lastUsedWs == null || lastUsedWs.length() == 0)) { remember =
       * false; }
       * 
       * // check to ensure the workspace location is still OK if (remember) { // if
       * there's any problem whatsoever with the workspace, force a dialog which in // its
       * turn will tell them what's bad String ret =
       * PickWorkspaceDialog.checkWorkspaceDirectory(Display.getDefault()
       * .getActiveShell(), lastUsedWs, false, false); if (ret != null) { remember =
       * false; }
       * 
       * }
       * 
       * 
       * // if we don't remember the workspace, show the dialog if (!remember) {
       * PickWorkspaceDialog pwd = new PickWorkspaceDialog(false, null); int pick =
       * pwd.open();
       * 
       * // if the user cancelled, we can't do anything as we need a workspace, so in this
       * // case, we tell them and exit if (pick == PickWorkspaceDialog.CANCEL) { if
       * (pwd.getSelectedWorkspaceLocation() == null) {
       * MessageDialog.openError(display.getActiveShell(), "Error",
       * "The application can not start without a workspace root and will now exit."); try
       * { PlatformUI.getWorkbench().close(); } catch (Exception err) {
       * 
       * } System.exit(0); return IApplication.EXIT_OK; } } else { // tell Eclipse what
       * the selected location was and continue instanceLoc.set(new URL("file", null,
       * pwd.getSelectedWorkspaceLocation()), false); } } else { // set the last used
       * location and continue instanceLoc.set(new URL("file", null, lastUsedWs), false);
       * }
       */

      // this is the normal default code from here on out
      int returnCode = PlatformUI.createAndRunWorkbench(display,
          new DiagramEditorWorkbenchAdvisor() {

            @Override
            public void preStartup() {
              super.preStartup();
              try {

                SafiServerPlugin.getDefault().getPreferenceStore();
                // SafiServerPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(
                // SafiServerPlugin.getDefault().new ProdServerPrefListener());
                
                AsteriskDiagramEditorPlugin.getInstance().loadActionPaks(new NullProgressMonitor());
                
              } catch (Exception e) {
                AsteriskDiagramEditorPlugin.getInstance().logError("Error in pre-startup", e);
              }
              SafiWorkshopEditorUtil.initializePalette();
              // AsteriskDiagramEditorUtil.getSafiNavigator().switchToSafletPerspective();
              // AsteriskDiagramEditorUtil.getSafiNavigator().switchToSafletPerspective();
            }

            @Override
            public void postStartup() {

              super.postStartup();

              // AsteriskDiagramEditorUtil.getSafiNavigator().switchToSafletPerspective();
              // AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
              try {
                SQLExplorerPlugin.getDefault().start(
                    AsteriskDiagramEditorPlugin.getInstance().getBundle().getBundleContext());
              } catch (Exception e) {
                AsteriskDiagramEditorPlugin.getInstance().logError("Error in pre-startup", e);
              }

              AsteriskDiagramEditorPlugin.getInstance().setDebugListener(
                  new com.safi.workshop.actions.DebugEventListenerImpl());
              SafiWorkshopEditorUtil.initializePalette();
              // AsteriskDiagramEditorUtil.getSafiNavigator().switchToSafletPerspective();
              SafiWorkshopEditorUtil.getSafiNavigator().refresh();
              AsteriskDiagramEditorPlugin.getInstance().intTelephonyModulePluginMap(new NullProgressMonitor());
              // SafiJavaScriptEditor jeditor = new SafiJavaScriptEditor();

              // AsteriskDiagramEditorPlugin.getInstance().initSQLPlugin();
            }

            @Override
            public void postShutdown() {
              AudioControlsPrefPage.closeOpenedLines();

              super.postShutdown();
            }
          });
      if (returnCode == PlatformUI.RETURN_RESTART) {
        return IApplication.EXIT_RESTART;
      }
      return IApplication.EXIT_OK;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (!display.isDisposed())
        display.dispose();
    }
    return null;
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub

  }

  // public static Image createImageFromPath(String path) {
  //
  // ImageDescriptor imgDesc = ImageDescriptor.createFromURL(FileLocator
  // .find(Platform.getBundle("AsteriskSafletDesigner.diagram"), new Path(path),
  // null));
  // ImageData data = imgDesc.getImageData();
  // //data = data.scaledTo(16, 16);
  // return ImageDescriptor.createFromImageData(data).createImage(true);
  // }

}
