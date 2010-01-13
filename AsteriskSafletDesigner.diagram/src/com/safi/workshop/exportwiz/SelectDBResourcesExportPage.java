package com.safi.workshop.exportwiz;

import java.util.List;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.safi.db.DBResource;
import com.safi.db.SafiDriverManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.navigator.db.SelectDBResourcesPanel;

public class SelectDBResourcesExportPage extends WizardPage {

  protected SelectDBResourcesPanel resourcesPanel;

  /**
   * Create the wizard
   */
  public SelectDBResourcesExportPage() {
    super("wizardPage");
    setTitle("Export SAR (Safi Archive File) - Select DB Resources");
    setDescription("Select all the DB Resources you want to include in this export");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginTop = 10;
    gridLayout.marginBottom = 10;
    gridLayout.marginLeft = 10;
    gridLayout.marginRight = 10;
    container.setLayout(gridLayout);
    //
    setControl(container);
    SafiDriverManager manager = SafiServerPlugin.getDefault().getDriverManager();
    resourcesPanel = new SelectDBResourcesPanel(container, manager,
        SelectDBResourcesPanel.Mode.EXPORT);
    resourcesPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
  }

  public List<DBResource> getCheckedItems() {
    return resourcesPanel.getCheckedItems();
  }

}
