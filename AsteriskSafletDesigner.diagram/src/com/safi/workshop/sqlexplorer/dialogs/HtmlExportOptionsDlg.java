package com.safi.workshop.sqlexplorer.dialogs;

import org.eclipse.swt.widgets.Shell;

import com.safi.workshop.sqlexplorer.Messages;

/**
 * Dialog for obtaining HTML export options.
 * 
 * @author Rocco Rutte <a href="mailto:pdmef@gmx.net">&lt;pdmef@gmx.net&gt;</a>.
 * 
 */
public class HtmlExportOptionsDlg extends AbstractExportOptionsDlg {

  private static final String[] FILTER = { "*.html", "*.htm" };

  private static final int FLAGS = FMT_CHARSET | FMT_NULL | OPT_HDR | OPT_QUOTE | OPT_RTRIM;

  public HtmlExportOptionsDlg(Shell parentShell) {
    super(parentShell);
  }

  @Override
  public String[] getFileFilter() {
    return FILTER;
  }

  @Override
  public int getFlags() {
    return FLAGS;
  }

  @Override
  public String getMessage() {
    return Messages.getString("ExportDialog.html.message");
  }

  @Override
  public String getTitle() {
    return Messages.getString("ExportDialog.html.title");
  }

}
