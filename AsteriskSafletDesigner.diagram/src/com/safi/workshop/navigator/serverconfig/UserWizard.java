package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 */
public class UserWizard extends Wizard {

  static final String DIALOG_SETTING_FILE = "userInfo.xml";

  static final String KEY_CUSTOMER_NAME = "customer-name";
  static final String KEY_CUSTOMER_EMAIL = "customer-email";
  static final String KEY_CUSTOMER_PHONE = "customer-phone";
  static final String KEY_CUSTOMER_ADDRESS = "customer-address";

  public UserWizard() {
    super();
    setWindowTitle("User Administor");
    setNeedsProgressMonitor(true);
    setDefaultPageImageDescriptor(ImageDescriptor.createFromFile(null, "icons/User.gif"));

    /*
     * DialogSettings dialogSettings = new DialogSettings("userInfo"); try { // loads
     * existing settings if any. dialogSettings.load(DIALOG_SETTING_FILE); } catch
     * (IOException e) { e.printStackTrace(); }
     * 
     * setDialogSettings(dialogSettings);
     */
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.wizard.IWizard#addPages()
   */
  @Override
  public void addPages() {

  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.wizard.IWizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    /*
     * if(getDialogSettings() != null) { getDialogSettings().put(KEY_CUSTOMER_NAME,
     * data.customerName); getDialogSettings().put(KEY_CUSTOMER_PHONE,
     * data.customerPhone); getDialogSettings().put(KEY_CUSTOMER_EMAIL,
     * data.customerEmail); getDialogSettings().put(KEY_CUSTOMER_ADDRESS,
     * data.customerAddress); try { // Saves the dialog settings into the specified file.
     * getDialogSettings().save(DIALOG_SETTING_FILE); } catch (IOException e1) {
     * e1.printStackTrace(); } }
     * 
     * try { // puts the data into a database ... getContainer().run(true, true, new
     * IRunnableWithProgress() { public void run(IProgressMonitor monitor) throws
     * InvocationTargetException, InterruptedException { monitor.beginTask("Store data",
     * 100); monitor.worked(40);
     * 
     * // store data here ... System.out.println(data);
     * 
     * Thread.sleep(2000); monitor.done(); } }); } catch (InvocationTargetException e) {
     * e.printStackTrace(); } catch (InterruptedException e) { e.printStackTrace(); }
     */
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.wizard.IWizard#performCancel()
   */
  @Override
  public boolean performCancel() {
    /*
     * boolean ans = MessageDialog.openConfirm(getShell(), "Confirmation",
     * "Are you sure to cancel the task?"); if(ans) return true; else
     */
    return false;
  }

  public static void main(String[] args) {
    Shell shell = new Shell();
    UserWizard user = new UserWizard();
    user.addPage(new UserWizardPage());

    WizardDialog dialog = new WizardDialog(shell, user);
    dialog.open();

  }

}