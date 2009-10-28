package com.safi.workshop.audio;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.SafletProject;
import com.safi.workshop.audio.utils.MyAutoCompleteField;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class AudioCategoryPage extends WizardPage {

  private Combo projectCombo;
  private String[] projectNames;
  private String[] categoryNames;
  private MyAutoCompleteField autocompleteField;
  private Text categoryText;
  private Button projectCheckbox;

  /**
   * Create the wizard
   */
  public AudioCategoryPage() {
    super("wizardPage");
    setTitle("New Prompt Wizard");
    setDescription("Specify how you want to categorize this prompt");
    setImageDescriptor(ResourceManager.getPluginImageDescriptor(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/wizban/PromptWizard.gif"));
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    //
    setControl(container);

    projectCheckbox = new Button(container, SWT.CHECK);
    projectCheckbox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        projectCombo.setEnabled(projectCheckbox.getSelection());
      }
    });
    projectCheckbox.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true));
    projectCheckbox.setText("project specific");

    projectCombo = new Combo(container, SWT.NONE);
    projectCombo.setEnabled(false);
    final GridData gd_projectCombo = new GridData(SWT.FILL, SWT.BOTTOM, true, true);
    projectCombo.setLayoutData(gd_projectCombo);

    final Label subCategoryLabel = new Label(container, SWT.RIGHT);
    final GridData gd_subCategoryLabel = new GridData(SWT.RIGHT, SWT.TOP, false, true);
    gd_subCategoryLabel.verticalIndent = 4;
    subCategoryLabel.setLayoutData(gd_subCategoryLabel);
    subCategoryLabel.setText("sub category:");

    categoryText = new Text(container, SWT.SINGLE | SWT.BORDER);
    categoryText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

  }

  @Override
  public void setVisible(boolean visible) {
    if (visible) {
      if (projectNames == null) {
        projectNames = getProjectNames();
      }
      projectCombo.setItems(projectNames);
      ImportAudioFileWizard wiz = (ImportAudioFileWizard) getWizard();
      if (wiz.getPrompt() != null) {
        Prompt p = wiz.getPrompt();
        if (p.getProject() != null) {
          SafletProject proj = p.getProject();
          int i = 0;
          for (String pn : projectCombo.getItems()) {
            if (proj.getName().equals(pn)) {
              projectCombo.select(i);
              projectCheckbox.setSelection(true);
              projectCombo.setEnabled(true);
              break;
            }
            i++;
          }
        }
        String path = p.getName();
        int idx = path.lastIndexOf('/');
        if (idx >= 0) {
          path = path.substring(0, idx);
          categoryText.setText(path);
        }
      }
      if (categoryNames == null) {
        categoryNames = getCategoryNames();
        if (categoryNames != null && categoryNames.length > 0) {
          autocompleteField = new MyAutoCompleteField(categoryText, new TextContentAdapter(),
              categoryNames);
          autocompleteField.getAdapter().setAutoActivationDelay(3000);
        }

      }
    }
    setPageComplete(true);
    super.setVisible(visible);
  }

  private String[] getProjectNames() {
    final String[][] names = new String[1][];
    IRunnableWithProgress runna = new IRunnableWithProgress() {
      @Override
      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        try {
          monitor.beginTask("Retrieving Projects", IProgressMonitor.UNKNOWN);
          List<String> projectNames = DBManager.getInstance().getProjectNames();
          names[0] = projectNames.toArray(new String[projectNames.size()]);
        } catch (DBManagerException e) {
          throw new InvocationTargetException(e);
        }

      }
    };
    ProgressMonitorDialog pd = new ProgressMonitorDialog(getShell());
    try {
      pd.run(true, false, runna);
    } catch (Exception e) {
      e.printStackTrace();
      Throwable th = e.getCause();
      MessageDialog.openError(getShell(), "Retrieve Error", "Couldn't retrieve project names: "
          + (th == null ? e : th).getLocalizedMessage());
      return new String[] {};
    }
    // TODO Auto-generated method stub
    return names[0];
  }

  private String[] getCategoryNames() {
    final String[][] names = new String[1][];
    IRunnableWithProgress runna = new IRunnableWithProgress() {
      @Override
      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        try {
          monitor.beginTask("Retrieving Categories", IProgressMonitor.UNKNOWN);
          List<String> promptCategories = ((ImportAudioFileWizard) getWizard()).getPromptNames();
          Set<String> cset = new HashSet<String>();
          for (String name : promptCategories) {
            String[] segs = name.split("/");
            String sofar = "";
            if (segs.length == 1)
              continue;
            for (String seg : segs) {
              if (StringUtils.isBlank(seg))
                continue;
              sofar = sofar + '/' + seg;
              cset.add(sofar);
            }
            cset.remove(sofar);
          }
          names[0] = cset.toArray(new String[cset.size()]);
          for (int i = 0; i < names[0].length; i++) {
            String cat = names[0][i];
            if (cat.startsWith("/"))
              names[0][i] = cat.substring(1);
          }
        } catch (Exception e) {
          throw new InvocationTargetException(e);
        }

      }
    };
    ProgressMonitorDialog pd = new ProgressMonitorDialog(getShell());
    try {
      pd.run(true, false, runna);
    } catch (Exception e) {
      e.printStackTrace();
      Throwable th = e.getCause();
      MessageDialog.openError(getShell(), "Retrieve Error", "Couldn't retrieve category names: "
          + (th == null ? e : th).getLocalizedMessage());
      return new String[] {};
    }
    // TODO Auto-generated method stub
    return names[0];
  }

  public String getProjectName() {
    if (!projectCheckbox.getSelection())
      return null;
    int idx = projectCombo.getSelectionIndex();
    if (idx < 0)
      return null;
    return projectCombo.getItem(idx);
  }

  public String getCategory() {
    return categoryText.getText();
  }

}
