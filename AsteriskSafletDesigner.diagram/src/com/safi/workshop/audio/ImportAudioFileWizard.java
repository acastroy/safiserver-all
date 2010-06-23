/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.safi.workshop.audio;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.SafletProject;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.server.saflet.manager.DBManagerException;
import com.safi.workshop.audio.ImportPromptStartPage.ImportMode;
import com.safi.workshop.audio.utils.AudioUtils;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class ImportAudioFileWizard extends Wizard implements IImportWizard {
  public enum Mode {
    NEW, EDIT
  };

  // ImportWizardPage mainPage;
  private Shell shell;
  private ImportPromptPage importPage;
  private AudioFileNamePage filenamePage;
  private AudioCategoryPage categoryPage;
  private RecordPromptPage recordPromptPage;
  private List<String> promptNames;
  private ImportPromptStartPage startPage;
  private IWizardPage currentPage;
  private Mode mode;
  private Prompt prompt;
  private boolean promptForSynch;

  public ImportAudioFileWizard(Mode mode, boolean promptForSynch) {
    super();
    this.mode = mode;
    this.promptForSynch = promptForSynch;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    // if (recordPromptPage != null)
    // recordPromptPage.dispose();
    String pname = categoryPage.getProjectName();
    SafletProject newProject = null;
    if (pname != null)
      try {
        newProject = DBManager.getInstance().getProjectByName(pname);
      } catch (DBManagerException e) {
        e.printStackTrace();
        Throwable th = e.getCause();
        MessageDialog.openError(getShell(), "Retrieve Error", "Couldn't find project named "
            + pname + ": " + (th == null ? e : th).getLocalizedMessage());
      }
    String cat = categoryPage.getCategory();
    if (cat.startsWith("/"))
      cat = cat.substring(1);
    String promptName = filenamePage.getName();
    int idx = promptName.lastIndexOf('.');
    String exten = null;
    if (idx > 0) {
      String tmp = promptName.substring(0, idx);
      exten = promptName.substring(idx + 1, promptName.length());
      promptName = tmp;
    } else
      exten = "gsm";
    if (StringUtils.isNotBlank(cat)) {
      if (!cat.endsWith("/")) {
        cat += '/';
      }
      promptName = cat + promptName;
    }
    String description = filenamePage.getDescription();
    boolean isNew = false;
    String oldPromptName = null;
    String oldPromptExtension = null;
    if (prompt == null) {
      isNew = true;
      prompt = ConfigFactory.eINSTANCE.createPrompt();
      prompt.setCreatedBy(SafiServerPlugin.getDefault().getCurrentUser());
    } else {
      oldPromptName = prompt.getName();
      oldPromptExtension = prompt.getExtension();
    }
    prompt.setName(promptName);
    prompt.setExtension(exten);
    if (StringUtils.isNotBlank(description))
      prompt.setDescription(description);
    prompt.setLastModified(new Date());
    // prompt.getAsteriskServers().addAll(serverPage.getAsteriskServers());
    try {
      SafletProject oldProject = isNew ? null : prompt.getProject();
      boolean projectChanged = newProject != null
          && (isNew || prompt.getProject() == null || prompt.getProject().getId() != newProject
              .getId());
      if (startPage.getImportMode() == ImportMode.KEEP_EXISTING) {
        if (!StringUtils.equals(oldPromptName, prompt.getName())
            || !StringUtils.equals(oldPromptExtension, prompt.getExtension()) || projectChanged)
          try {
            SafiServerRemoteManager.getInstance().renamePromptFile(prompt.getId(),
                newProject == null ? null : newProject.getName(), prompt.getName(),
                prompt.getExtension());
          } catch (Exception e) {
            e.printStackTrace();
            Throwable th = e.getCause();
            MessageDialog.openError(getShell(), "Rename Error", "Couldn't rename existing prompt: "
                + (th == null ? e : th).getLocalizedMessage());
            return false;
          }
      }
      if (projectChanged) {
        DBManager.getInstance().getProjectPrompts(newProject).add(prompt);
        projectChanged = true;
      }
      DBManager.getInstance().saveOrUpdateServerResource(prompt);
      if (projectChanged) {
        DBManager.getInstance().saveOrUpdateServerResource(newProject);
        if (oldProject != null)
          DBManager.getInstance().saveOrUpdateServerResource(oldProject);
      }
    } catch (DBManagerException e) {
      e.printStackTrace();
      Throwable th = e.getCause();
      MessageDialog.openError(getShell(), "Save Error", "Couldn't save prompt: "
          + (th == null ? e : th).getLocalizedMessage());
      return false;
    }
    File promptFile = null;
    switch (startPage.getImportMode()) {
      case IMPORT_EXISTING:
        promptFile = importPage.getAudioFile();
        break;
      case KEEP_EXISTING:
        break;
      case RECORD_NEW:
        try {
          promptFile = recordPromptPage.getConvertedFile();
        } catch (Exception e) {
          e.printStackTrace();
          Throwable th = e.getCause();
          MessageDialog.openError(getShell(), "Conversion Error",
              "Couldn't convert recorded prompt: " + (th == null ? e : th).getLocalizedMessage());
          return false;
        }
        break;
    }
    if (promptFile != null) {
      try {
        SafiWorkshopEditorUtil.uploadPromptFile(prompt, promptFile);
      } catch (Exception e1) {
        e1.printStackTrace();
        MessageDialog.openError(getShell(), "Save Error", "Couldn't upload file "
            + importPage.getFilename() + ": " + e1.getLocalizedMessage());
        return false;
      }
    }

    if (promptForSynch && SafiServerPlugin.getDefault().hasTelephonyModules()) {
      shell = SafiWorkshopEditorUtil.getActiveShell();
      boolean b = MessageDialog.openQuestion(shell, "Synchronize Now?",
          "One or more prompts were changed and may need to be synchronized "
              + "with the Telephony subsystems. Do you wish to synchronize audio prompts now?");
      if (b) {
        AudioUtils.synchronizeTelephonySubsystemPrompts(SafiServerPlugin.getDefault().getTelephonySubsystems());
      }
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
   * org.eclipse.jface.viewers.IStructuredSelection)
   */
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    setWindowTitle("File Import Wizard"); // NON-NLS-1
    setNeedsProgressMonitor(true);
    // mainPage = new ImportWizardPage("Import File",selection); //NON-NLS-1
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.wizard.IWizard#addPages()
   */
  @Override
  public void addPages() {
    super.addPages();
    startPage = new ImportPromptStartPage();
    addPage(startPage);
    getImportPage();
    getRecordPromptPage();
    getFilenamePage();
    getCategoryPage();
    currentPage = startPage;
  }

  @Override
  public IWizardPage getNextPage(IWizardPage page) {
    if (page instanceof ImportPromptStartPage) {
      ImportPromptStartPage sp = (ImportPromptStartPage) page;
      switch (sp.getImportMode()) {
        case IMPORT_EXISTING:
          currentPage = getImportPage();
          break;
        case KEEP_EXISTING:
          currentPage = getFilenamePage();
          break;
        case RECORD_NEW:
          currentPage = getRecordPromptPage();
          break;
      }
    } else if (page instanceof ImportPromptPage)
      currentPage = getFilenamePage();
    else if (page instanceof RecordPromptPage)
      currentPage = getFilenamePage();
    else if (page instanceof AudioFileNamePage)
      currentPage = getCategoryPage();
    else if (page instanceof AudioCategoryPage)
      return null;
    return currentPage;
  }

  private IWizardPage getRecordPromptPage() {
    if (recordPromptPage == null)
      addPage(recordPromptPage = new RecordPromptPage());
    return recordPromptPage;
  }

  @Override
  public boolean canFinish() {
    return currentPage instanceof AudioCategoryPage && currentPage.isPageComplete();
  }

  public List<String> getPromptNames() {
    if (promptNames == null) {
      try {
        promptNames = new ArrayList<String>();
        promptNames.addAll(DBManager.getInstance().getPromptNames());
      } catch (DBManagerException e) {
        AsteriskDiagramEditorPlugin.getInstance().logInfo("Couldn't retrieve prompt names", e);
        Throwable th = e.getCause();
        MessageDialog.openError(getShell(), "Retrieve Error", "Couldn't retrieve prompt names: "
            + (th == null ? e : th).getLocalizedMessage());
      }
    }
    return promptNames;
  }

  public ImportPromptPage getImportPage() {
    if (importPage == null)
      addPage(importPage = new ImportPromptPage());
    return importPage;
  }

  public AudioFileNamePage getFilenamePage() {
    if (filenamePage == null)
      addPage(filenamePage = new AudioFileNamePage());
    return filenamePage;
  }

  public AudioCategoryPage getCategoryPage() {
    if (categoryPage == null)
      addPage(categoryPage = new AudioCategoryPage());
    return categoryPage;
  }

  public void setPromptNames(List<String> promptNames) {
    this.promptNames = promptNames;
  }

//  public Object getAsteriskServers() {
//    try {
//      SafiServer server = SafiServerPlugin.getDefault().getSafiServer(true);
//      return server.getAsteriskServers();
//    } catch (Exception e) {
//      e.printStackTrace();
//      Throwable th = e.getCause();
//      MessageDialog.openError(getShell(), "Retrieve Error", "Couldn't retrieve asterisk servers: "
//          + (th == null ? e : th).getLocalizedMessage());
//    }
//    return null;
//  }

  public Prompt getPrompt() {
    return prompt;
  }

  public void setPrompt(Prompt prompt) {
    this.prompt = prompt;
  }

  public Mode getMode() {
    return mode;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public boolean isPromptForSynch() {
    return promptForSynch;
  }

  public void setPromptForSynch(boolean promptForSynch) {
    this.promptForSynch = promptForSynch;
  }
}
