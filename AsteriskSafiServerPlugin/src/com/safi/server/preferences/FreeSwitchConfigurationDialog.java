package com.safi.server.preferences;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.hibernate.Session;

import com.safi.db.fsdb.FreeSwitchServer;
import com.safi.db.fsdb.FsdbFactory;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;

public class FreeSwitchConfigurationDialog extends Dialog {

	private static final String DEFAULT_PROMPT_DIR = "/var/lib/asterisk/sounds";
	private Text promptDirText;
	private Text nameField;
	private Text descField;
	private Text sftpPortField;
	private Text sftpPassField;
	private Text userField;
	private Text managerPortField;
	private Text managerPassField;
	private Text managerNameField;
	private Text hostnameField;
	private FreeSwitchServer fsServer;
	private Button activeButton;
	private Font titleFont;
	private boolean active;
	private Button privateCheckbox;
	private boolean privateServer;
	private boolean isDisable;
	private boolean isNew;
	private int advancedPanelHeight;
	private Button synchButton;
	protected boolean synch;

	/**
	 * Create the dialog
	 * 
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public FreeSwitchConfigurationDialog(Shell parentShell) {
		super(parentShell);
		parentShell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				if (titleFont != null && !titleFont.isDisposed())
					titleFont.dispose();
			}
		});
		fsServer = FsdbFactory.eINSTANCE.createFreeSwitchServer();
		isNew = true;
		active = true;
	}

	public FreeSwitchConfigurationDialog(Shell parentShell, FreeSwitchServer asterServer) {
		this(parentShell);
		isNew = false;
		this.fsServer = asterServer;
		if (asterServer != null) {
			setPrivateServer(asterServer.isPrivate());
			setActive(asterServer.isEnabled());
		}
	}

	/**
	 * Create contents of the dialog
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite container = (Composite) super.createDialogArea(parent);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);

		Label managerNameLabel;

		Label managerPasswordLabel;
		titleFont = new Font(Display.getCurrent(), "", 10, SWT.BOLD);
		final Label nameLabel = new Label(container, SWT.NONE);
		nameLabel.setText("Unique Server Name:*");

		nameField = new Text(container, SWT.BORDER);
		final GridData gd_text_servername = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_text_servername.widthHint = 163;
		nameField.setLayoutData(gd_text_servername);
		this.nameField.setText((isNew || this.fsServer.getName() == null) ? ""
		    : this.fsServer.getName());

		final Label hostNameLabel = new Label(container, SWT.NONE);
		hostNameLabel.setText("Host(IP):*");

		hostnameField = new Text(container, SWT.BORDER);
		final GridData gd_text_hostname = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_text_hostname.widthHint = 120;
		hostnameField.setLayoutData(gd_text_hostname);
		this.hostnameField
		    .setText(this.isNew || this.fsServer.getHostname() == null ? ""
		        : this.fsServer.getHostname());
		managerNameLabel = new Label(container, SWT.NONE);
		managerNameLabel.setText("Manager Name:*");

		managerNameField = new Text(container, SWT.BORDER);
		final GridData gd_text_manager_name = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_text_manager_name.widthHint = 150;
		managerNameField.setLayoutData(gd_text_manager_name);
		this.managerNameField.setText(this.isNew
		    || this.fsServer.getManagerName() == null ? "" : this.fsServer
		    .getManagerName());
		managerPasswordLabel = new Label(container, SWT.NONE);
		managerPasswordLabel.setText("Manager Password:*");

		managerPassField = new Text(container, SWT.BORDER | SWT.PASSWORD);
		final GridData gd_text_manager_pass = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_text_manager_pass.widthHint = 150;
		managerPassField.setLayoutData(gd_text_manager_pass);
		this.managerPassField.setText(this.isNew
		    || this.fsServer.getManagerPassword() == null ? "" : this.fsServer
		    .getManagerPassword());

		final Label managerPortLabel = new Label(container, SWT.NONE);
		managerPortLabel.setText("Manager Port:*");

		managerPortField = new Text(container, SWT.BORDER);
		final GridData gd_text_manager_port = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_text_manager_port.widthHint = 50;
		managerPortField.setLayoutData(gd_text_manager_port);
		this.managerPortField.setText(Integer.toString(this.isNew ? 5038
		    : this.fsServer.getManagerPort()));

//		if (isNew || StringUtils.isBlank(this.fsServer.getVisibleSafiServerIP())) {
//			String sshIP = SafiServerPlugin.getDefault().getPreferenceStore().getString(
//			    PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);
//			if ("127.0.0.1".equals(sshIP) || "0.0.0.0".equals(sshIP)
//			    || "localhost".equalsIgnoreCase(sshIP)) {
//				sshIP = Utils.getLocalIPAddress();
//			}
//			
//			this.safiServerIPField.setText(sshIP);
//		}
//		else {
//			this.safiServerIPField.setText(this.fsServer.getVisibleSafiServerIP());
//		}
//
//		this.safiServerIPField.setText(this.isNew
//		    || this.asteriskServer.getVisibleSafiServerIP() == null ? ""
//		    : this.asteriskServer.getVisibleSafiServerIP());

		final Label descriptionLabel = new Label(container, SWT.WRAP);
		final GridData gd_descriptionLabel = new GridData(SWT.LEFT, SWT.TOP, false, false);
		gd_descriptionLabel.widthHint = 110;
		descriptionLabel.setLayoutData(gd_descriptionLabel);
		descriptionLabel.setText("Server Description:");

		descField = new Text(container, SWT.WRAP | SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
		final GridData gd_descField = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd_descField.heightHint = 68;
		gd_descField.widthHint = 169;
		descField.setLayoutData(gd_descField);
		this.descField
		    .setText(this.isNew || this.fsServer.getDescription() == null ? ""
		        : this.fsServer.getDescription());

		final Group sftpGroup = new Group(container, SWT.NONE);
		final GridData gd_sftpGroup = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_sftpGroup.widthHint = 271;
		sftpGroup.setLayoutData(gd_sftpGroup);
		sftpGroup.setText("Prompt Managment Settings");
		sftpGroup.setLayout(new GridLayout());
		final Composite composite = new Composite(sftpGroup, SWT.NONE);

		composite.setRedraw(true);
		final GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_composite.widthHint = 295;
		composite.setLayoutData(gd_composite);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 2;
		composite.setLayout(gridLayout_1);

		final Label sftpuserLabel = new Label(composite, SWT.NONE);
		sftpuserLabel.setText("SFTP User:");

		userField = new Text(composite, SWT.BORDER);
		userField.setLayoutData(new GridData(150, SWT.DEFAULT));
		this.userField.setText(this.isNew || this.fsServer.getSftpUser() == null ? ""
		    : this.fsServer.getSftpUser());

		final Label sftpuserLabel_1 = new Label(composite, SWT.NONE);
		sftpuserLabel_1.setText("SFTP Password:");

		sftpPassField = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		final GridData gd_text_sftp_pass = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_text_sftp_pass.widthHint = 150;
		sftpPassField.setLayoutData(gd_text_sftp_pass);
		this.sftpPassField.setText(this.isNew
		    || this.fsServer.getSftpPassword() == null ? "" : this.fsServer
		    .getSftpPassword());

		final Label sftpPortLabel = new Label(composite, SWT.NONE);
		sftpPortLabel.setText("SFTP Port:");

		sftpPortField = new Text(composite, SWT.BORDER);
		final GridData gd_text_sftp_port = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		gd_text_sftp_port.widthHint = 50;
		sftpPortField.setLayoutData(gd_text_sftp_port);
		this.sftpPortField.setText(Integer.toString(this.isNew ? 22 : this.fsServer
		    .getSftpPort()));
		// new Label(composite, SWT.NONE);

		final Label promptDirLabel = new Label(composite, SWT.NONE);
		promptDirLabel.setToolTipText("Directory where Asterisk stores prompt files");
		promptDirLabel.setText("Prompt Dir:");

		promptDirText = new Text(composite, SWT.BORDER);
		promptDirText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		promptDirText
		    .setText((isNew || this.fsServer.getPromptDirectory() == null) ? DEFAULT_PROMPT_DIR
		        : this.fsServer.getPromptDirectory());
		new Label(composite, SWT.NONE);

		synchButton = new Button(composite, SWT.CHECK);
		synchButton
		    .setToolTipText("Synchronize audio files with server when 'OK' is pressed");
		synchButton.setText("Synch prompts when done");
		synchButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				synch = synchButton.getSelection();
			}
		});
		advancedPanelHeight = composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		// debugButton = new Button(container, SWT.NONE);
		// debugButton.setLayoutData(new GridData());
		// debugButton.setToolTipText("Use this Asterisk server for local debuggin");
		// debugButton.setText("Set as Debug Server");
		// debugButton.setEnabled(!debug);
		// debugButton.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// debug = true;
		// // SafiServerPlugin.getDefault().storeDebug(updateAsteriskServer(null));
		// // SafiServerPlugin.getDefault().createDebugAsteriskFromStore();
		// }
		// });

		final Composite composite_2 = new Composite(container, SWT.NONE);
		final GridData gd_composite_2 = new GridData(SWT.RIGHT, SWT.FILL, false, false);
		gd_composite_2.widthHint = 125;
		composite_2.setLayoutData(gd_composite_2);
		final GridLayout gridLayout_3 = new GridLayout();
		gridLayout_3.numColumns = 2;
		composite_2.setLayout(gridLayout_3);

		activeButton = new Button(composite_2, SWT.CHECK);
		activeButton.setSelection(true);
		activeButton
		    .setToolTipText("Production SafiServer will immediately begin handling connection requests from this Asterisk server");
		activeButton.setText("Active");
		activeButton.setSelection(active);
		activeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				active = activeButton.getSelection();
			}
		});

		activeButton.setEnabled(SafiServerPlugin.getDefault().isConnected());
		privateCheckbox = new Button(composite_2, SWT.CHECK);
		privateCheckbox.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				activeButton.setEnabled(!privateCheckbox.getSelection());
				if (privateCheckbox.getSelection())
					active = false;
			}
		});
		privateCheckbox.setToolTipText("Private servers are not visible to other users.");
		privateCheckbox.setText("Private");
		privateCheckbox.setSelection(privateServer);
		privateCheckbox.setEnabled(true);

		privateCheckbox.setEnabled(isCurrentUserOwner());

		// new Label(composite, SWT.NONE);
		// new Label(container, SWT.NONE);

		//
		if (this.fsServer != null) {
			if (isNew) {
				fsServer.setPromptDirectory(DEFAULT_PROMPT_DIR);
			}
		} else {
			// debugButton.setSelection(true);
			activeButton.setSelection(true);
		}
		// if(!SafiServerPlugin.getDefault().isCurrentUserAdmin()){
		// this.disableAll();
		// }else
		// {
		// this.isDisable=false;
		// }

		return container;
	}

	private void disableAll() {
		this.isDisable = true;
		nameField.setEnabled(false);
		descField.setEnabled(false);
		sftpPortField.setEnabled(false);
		sftpPassField.setEnabled(false);
		userField.setEnabled(false);
		managerPortField.setEnabled(false);
		managerPassField.setEnabled(false);
		managerNameField.setEnabled(false);
		hostnameField.setEnabled(false);
		activeButton.setEnabled(false);
		privateCheckbox.setEnabled(false);
		promptDirText.setEnabled(false);
	}

	private boolean isCurrentUserOwner() {
		if (isNew)
			return true;
		User u = SafiServerPlugin.getDefault().getCurrentUser();
		if (u == null)
			return true;
		User cu = fsServer.getCreatedBy();
		if (cu == null)
			return true;
		return u.getId() == cu.getId();
	}

	/**
	 * Create contents of the button bar
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(330, getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("FreeSWITCH Configration");
	}

	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.CANCEL_ID) {

			this.fsServer = null;
			cancelPressed();
			return;
		} else if (buttonId == IDialogConstants.OK_ID) {
			if (this.isDisable) {
				this.cancelPressed();
				return;
			}
			String msg = this.validate();
			if (msg == null) {
				this.updateAsteriskServer(this.fsServer);
				this.okPressed();
			} else
				MessageDialog.openError(getShell(), "Validation Error", msg);
			return;
		}
		super.buttonPressed(buttonId);
	}

	private FreeSwitchServer updateAsteriskServer(FreeSwitchServer asteriskServer) {

		String hostName = this.hostnameField.getText().trim();

		String managerName = this.managerNameField.getText().trim();

		String managerPass = this.managerPassField.getText().trim();

		String managerPort = this.managerPortField.getText().trim();

		int managerPortNumber = 5038;
		try {
			managerPortNumber = Integer.parseInt(managerPort);
		} catch (Exception ex) {
		}
		String sftp_user = this.userField.getText().trim();
		String sftp_pass = this.sftpPassField.getText().trim();
		String sftp_port = this.sftpPortField.getText().trim();
		int sftp_portNumber = 22;
		try {
			sftp_portNumber = Integer.parseInt(sftp_port);
		} catch (Exception ex) {
		}

		this.active = this.activeButton.getSelection();
		// this.debug = this.debugButton.getSelection();
		this.privateServer = privateCheckbox.getSelection();

		String desc = this.descField.getText().trim();
		asteriskServer.setHostname(hostName);
		asteriskServer.setManagerName(managerName);
		asteriskServer.setManagerPassword(managerPass);
		asteriskServer.setManagerPort(managerPortNumber);
		asteriskServer.setSftpUser(sftp_user);
		asteriskServer.setSftpPassword(sftp_pass);
		asteriskServer.setSftpPort(sftp_portNumber);
		asteriskServer.setDescription(desc);
		asteriskServer.setEnabled(active);
		asteriskServer.setName(this.nameField.getText());
		User u = SafiServerPlugin.getDefault().getCurrentUser();
		if (u != null) {
			if (isNew)
				asteriskServer.setCreatedBy(u);
			else
				asteriskServer.setModifiedBy(u);
		}
		asteriskServer.setLastModified(new java.util.Date());
		if (isCurrentUserOwner())
			asteriskServer.setPrivate(privateServer);

		asteriskServer.setPromptDirectory(promptDirText.getText());
		return asteriskServer;
	}

	private String validate() {
		String serverName = this.nameField.getText();
		if (serverName == "") {
			return "Server name is required";
		}
		String hostName = this.hostnameField.getText().trim();
		if (hostName == "") {
			return "Host name is required";
		}
		String managerName = this.managerNameField.getText().trim();
		if (managerName == "") {
			return "Manager name is required";
		}
		// String managerPass = this.managerPassField.getText().trim();
		// if (managerPass == "") {
		// return false;
		// }
		String managerPort = this.managerPortField.getText().trim();
		if (managerPort == "") {
			return "Manager port is required";
		}

		try {
			Integer.parseInt(managerPort);
		} catch (Exception ex) {
			return "Invalid manager port number";
		}

		return null;
	}

	public FreeSwitchServer getFsServer() {
		return this.fsServer;
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		FreeSwitchConfigurationDialog dlg = new FreeSwitchConfigurationDialog(shell);
		dlg.open();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isPrivateServer() {
		return privateServer;
	}

	public void setPrivateServer(boolean privateServer) {
		this.privateServer = privateServer;
	}

	@Override
	public int open() {
		// TODO Auto-generated method stub
		return super.open();
	}

	public boolean commit() {

		try {
			ProgressMonitorDialog pm = new ProgressMonitorDialog(SafiServerPlugin.getDefault()
			    .getWorkbench().getDisplay().getActiveShell());
			pm.run(true, true, new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException,
				    InterruptedException {
					Session session = null;
					try {
						monitor.beginTask("Saving Asterisk server", synch ? 2 : 1);
						session = DBManager.getInstance().createSession();
						session.beginTransaction();
						if (isNew) {
//							SafiServer production = SafiServerPlugin.getDefault().getSafiServer(true);
//							production.getTelephonySubsystems().add(fsServer);
							
//							session.saveOrUpdate(production);
							DBManager.getInstance().saveOrUpdateServerResource(session, fsServer);
						} else
							session.saveOrUpdate(fsServer);
						session.getTransaction().commit();
						monitor.worked(1);
						if (synch) {
							doSynch(monitor);
							monitor.worked(1);
							session.refresh(fsServer);
							SafiServerPlugin.getDefault().refreshSafiServer();
						}
					} catch (final Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						final Display d = Display.getDefault();
						d.asyncExec(new Runnable() {
							public void run() {
								MessageDialog
								    .openError(d.getActiveShell(), "Save Error",
								        "Error caught while committing resources: "
								            + e.getLocalizedMessage());
							}
						});
					} finally {
						if (session != null) {
							try {
								session.close();
								session = null;
							} catch (Exception ignore) {
							}
						}
					}
				}
			});

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MessageDialog.openError(SafiServerPlugin.getDefault().getWorkbench().getDisplay()
			    .getActiveShell(), "Save Error", "Error caught while publishing resources: "
			    + e.getLocalizedMessage());
			return false;
		}

	}

	private void doSynch(IProgressMonitor monitor) throws Exception {
		if (StringUtils.isBlank(this.fsServer.getPromptDirectory()))
			return;
		monitor.setTaskName("Synching audio files");
		SafiServerRemoteManager.getInstance().synchAudioFiles(this.fsServer);
	}

}
