package com.safi.workshop.part;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.safi.db.provider.DbItemProviderAdapterFactory;
import com.safi.db.server.config.SafiServer;
import com.safi.server.manager.DebugEventListener;
import com.safi.server.manager.SafiServerManagementException;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.SafiServerStatusListener;
import com.safi.server.saflet.mbean.SysInfo;
import com.safi.workshop.application.DiagramEditorPerspective;
import com.safi.workshop.application.DiagramEditorWorkbenchWindowAdvisor;
import com.safi.workshop.application.SafiDBPerspective;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.edit.policies.ActionPakCreateCommandFactory;
import com.safi.workshop.edit.policies.ActionstepCreateCommandFactory;
import com.safi.workshop.edit.policies.HandlerItemSemanticEditPolicy;
import com.safi.workshop.providers.AsteriskElementTypes;
import com.safi.workshop.providers.AsteriskModelingAssistantProvider;
import com.safi.workshop.serverview.ServerViewEditorInput;
import com.safi.workshop.serverview.editors.SafiServerPanel;
import com.safi.workshop.sheet.ActionPakEditorDialogFactory;
import com.safi.workshop.sheet.ActionstepEditorDialogFactory;
import com.safi.workshop.sheet.ActionstepEditorDialogFactoryManager;
import com.safi.workshop.sheet.DynamicValueEditorPage;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.view.factories.ActionPakEditPartFactory;
import com.safi.workshop.view.factories.ActionPakElementFactory;
import com.safi.workshop.view.factories.ActionPakModelFactory;
import com.safi.workshop.view.factories.ActionPakViewFactoryFactory;
import com.safi.workshop.view.factories.ActionstepEditPartFactory;
import com.safi.workshop.view.factories.ActionstepElementFactory;
import com.safi.workshop.view.factories.ActionstepModelFactory;
import com.safi.workshop.view.factories.ActionstepViewFactoryFactory;

import de.schlichtherle.io.ArchiveDetector;
import de.schlichtherle.io.DefaultArchiveDetector;

/**
 * @generated
 */
public class AsteriskDiagramEditorPlugin extends AbstractUIPlugin {

	/**
	 * @generated
	 */
	public static final String ID = "AsteriskSafletDesigner.diagram"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(ID);

	/**
	 * @generated
	 */
	private static AsteriskDiagramEditorPlugin instance;

	static {
		de.schlichtherle.io.File.setDefaultArchiveDetector(new DefaultArchiveDetector(
				ArchiveDetector.NULL, // delegate
				new String[] { "sar", "de.schlichtherle.io.archive.zip.JarDriver" }));
	}
	/**
	 * @generated
	 */
	private ComposedAdapterFactory adapterFactory;

	/**
	 * @generated
	 */
	private AsteriskDocumentProvider documentProvider;

	private boolean debug;
	private SafiDBPerspective safiDBPerspective;
	private DiagramEditorPerspective safletPerspective;

	private SafiServerStatusListener safiServerAuthListener;
	// private List<ActionStepProfile> actionstepProfiles = new
	// ArrayList<ActionStepProfile>();
	private List<ActionPak> actionPaks = new ArrayList<ActionPak>();
	// private List<URL> actionpakJars = new ArrayList<URL>();
	// private List<URL> serverJars = new ArrayList<URL>();
	private boolean completedActionpakSynch = false;

	private DiagramEditorWorkbenchWindowAdvisor windowAdvisor;

	private Map<String, IConfigurationElement> dynamicValueEditorContributionItems = new HashMap<String, IConfigurationElement>();
	protected SafiServerPanel safiServerPanel;
	private DebugEventListener debugEventListener;

	/**
	 * @generated NOT
	 */
	public AsteriskDiagramEditorPlugin() {
		super();
		instance = this;
		// new SQLExplorerPlugin();
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());
		// adapterFactory = createAdapterFactory();

		// initDebugConsole();
		safiServerAuthListener = new SafiServerStatusListener() {
			@Override
			public void resourcesChanged() {
				updateWindowTitle();
				SafiWorkshopEditorUtil.getSafiNavigator().refresh();
			}

			@Override
			public void serverConnectionChange(boolean connected) {
				updateWindowTitle();

				// if (connected) {
				// syncActionPaks(new NullProgressMonitor());
				// }
				updateServerView(connected, false);
				// if (connected)
				SafiWorkshopEditorUtil.getSafiNavigator().modelChanged(connected);
				// if (connected){
				// }
				// else
				// AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged();
				// DirtyDecorator.getDirtyDecorator().refresh();
			}

			@Override
			public void serverInfoUpdate(SysInfo info) {
				updateServerView(info);

			}

		};

		if (SafiServerPlugin.getDefault() == null) {
			SafiServerPlugin p = new SafiServerPlugin();
			p.start(context);
		}
		SafiServerPlugin.getDefault().addAuthListener(safiServerAuthListener);

		// SQLExplorerPlugin.getDefault().start(context);
		// loadActionPaks(new NullProgressMonitor());

	}

	protected void updateServerView(SysInfo info) {
		if (safiServerPanel != null) {
			safiServerPanel.updateInfo(info);
		}

	}

	public void doInit(IProgressMonitor monitor) throws Exception {
		monitor.beginTask("Load Workshop Resources", 5);
		SafiServerPlugin.getDefault().getSafiServer(true);

		// if (SafiServerRemoteManager.getInstance().isConnected()) {
		// doActionpakSynch(monitor);
		// }

	}

	public void doSoftInit(IProgressMonitor monitor) throws Exception {
		monitor.beginTask("Load Workshop Resources", 5);
		SafiServerPlugin.getDefault().getSafiServer(false);

		// if (SafiServerRemoteManager.getInstance().isConnected()) {
		// doActionpakSynch(monitor);
		// }

	}

	public DynamicValueEditorPage createEditorPage(String className) throws CoreException {
		IConfigurationElement elem = dynamicValueEditorContributionItems.get(className);
		if (elem == null)
			return null;
		return (DynamicValueEditorPage) elem.createExecutableExtension("helperClass");
	}

	public void loadActionPaks(IProgressMonitor monitor) {

		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry.getExtensionPoint("AsteriskSafletDesigner.diagram.actionPak");
		if (point == null) {
			return;
		}

		IExtension[] extensions = point.getExtensions();
		// adapterFactory = createAdapterFactory();
		List factories = new ArrayList();
		monitor.subTask("Processing ActionPaks");
		// load factories first
		for (IExtension extension : extensions) {

			IConfigurationElement[] elements = extension.getConfigurationElements();

			for (IConfigurationElement element : elements) {
				if ("itemProviderAdapterFactory".equals(element.getName())) {
					try {
						ComposeableAdapterFactory factory = (ComposeableAdapterFactory) element
								.createExecutableExtension("factory");
						// this.adapterFactory.addAdapterFactory(factory);
						factories.add(factory);
					} catch (Exception e) {
						e.printStackTrace();
						logError("Couldn't load adapter factory", e);
					}
				} 
			}
		}
		fillItemProviderFactories(factories);
		adapterFactory = new ComposedAdapterFactory(factories);

		for (IExtension extension : extensions) {
			IConfigurationElement[] elements = extension.getConfigurationElements();
			ActionPak pak = new ActionPak();
			pak.name = extension.getSimpleIdentifier();

			Bundle bundle = null;

			bundle = Platform.getBundle(extension.getNamespaceIdentifier());

			// IExtension extension = extensions[i];
			// extension.get

			for (IConfigurationElement element : elements) {
				 if ("actionPakFactory".equals(element.getName())) {
					try {

						ActionPakFactoryProfile profile = new ActionPakFactoryProfile();

						ActionPakCreateCommandFactory createFactory = (ActionPakCreateCommandFactory) element
								.createExecutableExtension("createCommandFactory");

						ActionPakElementFactory elementFactory = (ActionPakElementFactory) element
								.createExecutableExtension("elementFactory");

						ActionPakModelFactory modelFactory = (ActionPakModelFactory) element
								.createExecutableExtension("modelFactory");

						ActionPakEditPartFactory editPartFactory = (ActionPakEditPartFactory) element
								.createExecutableExtension("editPartFactory");

						ActionPakViewFactoryFactory viewFactory = (ActionPakViewFactoryFactory) element
								.createExecutableExtension("viewFactory");
						profile.commandFactory = createFactory;
						profile.elementFactory = elementFactory;
						profile.modelFactory = modelFactory;
						profile.editPartFactory = editPartFactory;
						profile.viewFactory = viewFactory;
						
						pak.actionPakFactoryProfile=profile;
					} catch (Exception e) {
						e.printStackTrace();
						logError("Couldn't load actionPakFactory", e);
					}

				}
			}
			for (IConfigurationElement element : elements) {

				if ("pakjar".equals(element.getName())) {

					if (bundle != null) {
						String jar = element.getAttribute("jar");
						URL url = bundle.getEntry(jar);
						try {
							url = FileLocator.resolve(url);
							ActionPakJar apj = new ActionPakJar();
							apj.url = url;
							apj.version = element.getAttribute("version");
							apj.bundleSymbolicName = element.getAttribute("bundleSymbolicName");
							pak.addActionPakJar(apj);

						} catch (Exception e) {
							e.printStackTrace();
							logError("Couldn't load ActionPak jar " + jar, e);
						}

						// actionpakJars.add(url);
					}

				} else if ("serverjar".equals(element.getName())) {

					if (bundle != null) {
						String jar = element.getAttribute("jar");
						URL url = bundle.getEntry(jar);
						try {
							url = FileLocator.resolve(url);
							SafiServerJar ssj = new SafiServerJar();
							ssj.url = url;
							ssj.description = element.getAttribute("description");
							ssj.version = element.getAttribute("version");
							ssj.bundleSymbolicName = element.getAttribute("bundleSymbolicName");
							pak.addSafiServerJar(ssj);
						} catch (Exception e) {
							e.printStackTrace();
							logError("Couldn't load Server jar " + jar, e);
						}

						// serverJars.add(url);
					}

				} else if ("dynamicValueEditorPage".equals(element.getName())) {

					String className = element.getAttribute("helperClass");
					try {
						dynamicValueEditorContributionItems.put(className, element);
						// DynamicValueEditorPage page =
						// (DynamicValueEditorPage)elements[j].createExecutableExtension("helperClass");

					} catch (Exception e) {
						e.printStackTrace();
						logError("Couldn't load DynamicValueEditorPage", e);
					}

				} else if ("actionStep".equals(element.getName())) {
					try {

						ActionStepProfile profile = new ActionStepProfile();
						String enabled = element.getAttribute("enabled");
						if (!Boolean.parseBoolean(enabled))
							continue;
						String semanticHint = element.getAttribute("semanticHint");
						String labelSemanticHint = element.getAttribute("labelSemanticHint");
						String inputItemSemanticHint = element.getAttribute("inputItemSemanticHint");
						String inputItemLabelSemanticHint = element.getAttribute("inputItemLabelSemanticHint");
						String inputItemPanelSemanticHint = element.getAttribute("inputItemPanelSemanticHint");

						String outputItemSemanticHint = element.getAttribute("outputItemSemanticHint");
						String outputItemLabelSemanticHint = element
								.getAttribute("outputItemLabelSemanticHint");
						String outputItemPanelSemanticHint = element
								.getAttribute("outputItemPanelSemanticHint");

						String isInitiator = element.getAttribute("isInitiator");
						
						ActionstepCreateCommandFactory createFactory = null;
						
						if (StringUtils.isBlank(element.getAttribute("createCommandFactory"))){
						  if (pak.actionPakFactoryProfile != null && pak.actionPakFactoryProfile.commandFactory != null)
						  	createFactory = pak.actionPakFactoryProfile.commandFactory;
						}
						else
							createFactory = (ActionstepCreateCommandFactory) element
									.createExecutableExtension("createCommandFactory");

						ActionstepElementFactory elementFactory = null;
						if (StringUtils.isBlank(element.getAttribute("elementFactory"))){
						  if (pak.actionPakFactoryProfile != null && pak.actionPakFactoryProfile.elementFactory != null)
						  	elementFactory = pak.actionPakFactoryProfile.elementFactory;
						}
						else
						  elementFactory = (ActionstepElementFactory) element
								.createExecutableExtension("elementFactory");

						ActionstepModelFactory modelFactory = null;
						if (StringUtils.isBlank(element.getAttribute("modelFactory"))){
						  if (pak.actionPakFactoryProfile != null && pak.actionPakFactoryProfile.modelFactory != null)
						  	modelFactory = pak.actionPakFactoryProfile.modelFactory;
						}
						else						
							modelFactory = (ActionstepModelFactory) element
								.createExecutableExtension("modelFactory");

						ActionstepEditPartFactory editPartFactory = null;
						if (StringUtils.isBlank(element.getAttribute("editPartFactory"))){
						  if (pak.actionPakFactoryProfile != null && pak.actionPakFactoryProfile.editPartFactory != null)
						  	editPartFactory = pak.actionPakFactoryProfile.editPartFactory;
						}
						else						
						 editPartFactory = (ActionstepEditPartFactory) element
								.createExecutableExtension("editPartFactory");

						ActionstepViewFactoryFactory viewFactory = null;
						if (StringUtils.isBlank(element.getAttribute("viewFactory"))){
						  if (pak.actionPakFactoryProfile != null && pak.actionPakFactoryProfile.viewFactory != null)
						  	viewFactory = pak.actionPakFactoryProfile.viewFactory;
						}
						else						
						  viewFactory = (ActionstepViewFactoryFactory) element
								.createExecutableExtension("viewFactory");
						
						profile.semanticHint = semanticHint;
						profile.commandFactory = createFactory;
						profile.elementFactory = elementFactory;
						profile.modelFactory = modelFactory;
						profile.editPartFactory = editPartFactory;
						profile.labelSemanticHint = labelSemanticHint;
						profile.inputItemSemanticHint = inputItemSemanticHint;
						profile.inputItemLabelSemanticHint = inputItemLabelSemanticHint;
						profile.inputItemPanelSemanticHint = inputItemPanelSemanticHint;

						profile.outputItemSemanticHint = outputItemSemanticHint;
						profile.outputItemLabelSemanticHint = outputItemLabelSemanticHint;
						profile.outputItemPanelSemanticHint = outputItemPanelSemanticHint;

						profile.viewFactory = viewFactory;
						profile.isInitiator = Boolean.valueOf(isInitiator);

						IConfigurationElement[] paletteElems = element.getChildren("paletteEntry");
						if (paletteElems != null && paletteElems.length >= 1) {
							profile.palettePath = paletteElems[0].getAttribute("path");
							profile.displayName = paletteElems[0].getAttribute("displayName");
							profile.tooltip = paletteElems[0].getAttribute("tooltip");
						}
						pak.addActionStep(profile);
						// actionstepProfiles.add(profile);
						IElementType elementType = elementFactory.getElementType(Integer
								.parseInt(profile.semanticHint));
						// IElementType labelElementType =
						// elementFactory.getElementType(Integer.parseInt(profile.semanticHint));
						EClass modelEClass = modelFactory.getModel(Integer.parseInt(profile.semanticHint))
								.eClass();
						AsteriskVisualIDRegistry.registerVisualId(modelEClass, Integer
								.parseInt(((IHintedType) elementType).getSemanticHint()));

						if (!AsteriskElementTypes.isKnownElementType(elementType)) {
							AsteriskElementTypes.getKnownElementTypes().add(elementType);
						}
						if (!AsteriskModelingAssistantProvider.getToolstepTypes().contains(elementType))
							AsteriskModelingAssistantProvider.getToolstepTypes().add(elementType);
						HandlerItemSemanticEditPolicy.registerCreateCommandFactory(elementType, createFactory);
						ENamedElement elem = AsteriskElementTypes.getElement(elementType);
						if (elem == null) {
							AsteriskElementTypes.getElements().put(elementType, modelEClass);
						}

						if (StringUtils.isNotBlank(inputItemSemanticHint)) {
							elementType = elementFactory.getElementType(Integer
									.parseInt(profile.inputItemSemanticHint));
							// IElementType labelElementType =
							// elementFactory.getElementType(Integer.parseInt(profile.semanticHint));
							modelEClass = modelFactory.getModel(Integer.parseInt(profile.inputItemSemanticHint))
									.eClass();
							AsteriskVisualIDRegistry.registerVisualId(modelEClass, Integer
									.parseInt(((IHintedType) elementType).getSemanticHint()));

							if (!AsteriskElementTypes.isKnownElementType(elementType)) {
								AsteriskElementTypes.getKnownElementTypes().add(elementType);
							}
							if (!AsteriskModelingAssistantProvider.getToolstepTypes().contains(elementType))
								AsteriskModelingAssistantProvider.getToolstepTypes().add(elementType);
							HandlerItemSemanticEditPolicy
									.registerCreateCommandFactory(elementType, createFactory);
							elem = AsteriskElementTypes.getElement(elementType);
							if (elem == null) {
								AsteriskElementTypes.getElements().put(elementType, modelEClass);
							}
							AsteriskModelingAssistantProvider.registerPopupbarType(modelFactory.getModel(
									Integer.parseInt(semanticHint)).eClass(), elementType);
						}

						if (StringUtils.isNotBlank(outputItemSemanticHint)) {
							elementType = elementFactory.getElementType(Integer
									.parseInt(profile.outputItemSemanticHint));
							// IElementType labelElementType =
							// elementFactory.getElementType(Integer.parseInt(profile.semanticHint));
							modelEClass = modelFactory.getModel(Integer.parseInt(profile.outputItemSemanticHint))
									.eClass();
							AsteriskVisualIDRegistry.registerVisualId(modelEClass, Integer
									.parseInt(((IHintedType) elementType).getSemanticHint()));

							if (!AsteriskElementTypes.isKnownElementType(elementType)) {
								AsteriskElementTypes.getKnownElementTypes().add(elementType);
							}
							if (!AsteriskModelingAssistantProvider.getToolstepTypes().contains(elementType))
								AsteriskModelingAssistantProvider.getToolstepTypes().add(elementType);
							HandlerItemSemanticEditPolicy
									.registerCreateCommandFactory(elementType, createFactory);
							elem = AsteriskElementTypes.getElement(elementType);
							if (elem == null) {
								AsteriskElementTypes.getElements().put(elementType, modelEClass);
							}
							AsteriskModelingAssistantProvider.registerPopupbarType(modelFactory.getModel(
									Integer.parseInt(semanticHint)).eClass(), elementType);
						}
						System.err.println("I have executed my plan...now i will bask");
					} catch (Exception e) {
						e.printStackTrace();
						logError("Couldn't load actionpak", e);
					}
				} else if ("description".equals(element.getName())) {
					pak.description = element.getAttribute("descriptionText");
				} else if ("actionstepEditorDialogFactory".equals(element.getName())) {
					try {
						ActionstepEditorDialogFactory factory = (ActionstepEditorDialogFactory) element
								.createExecutableExtension("factory");

						if (factory instanceof ActionPakEditorDialogFactory) {
							ActionPakEditorDialogFactory ape = (ActionPakEditorDialogFactory) factory;
							for (String classname : ape.getSupportedActionstepEditPartNames()) {
								ActionstepEditorDialogFactoryManager.getInstance()
										.registerActionstepEditorDialogFactory(classname, factory);
							}
						} else {
							String classname = element.getAttribute("actionstepClass");
							// Class<ActionStep> toolstepClass =
							// (Class<ActionStep>)Class.forName(classname);
							// this.adapterFactory.addAdapterFactory(factory);
							ActionstepEditorDialogFactoryManager.getInstance()
									.registerActionstepEditorDialogFactory(classname, factory);
						}
					} catch (Exception e) {
						e.printStackTrace();
						logError("Couldn't load ActionstepEditorDialogFactory", e);
					}
				}
				// if ("someObject".equals(elements[j].getName())) {
				// ISomeInterface object =
				// (ISomeInterface)elements[j].createExecutableExtension("run");
				// System.out.println("Found an executable extension: " + object);
				// }
			}
			actionPaks.add(pak);
		}
		monitor.worked(1);

	}

	// public synchronized void syncActionPaks(IProgressMonitor monitor) {
	// if (completedActionpakSynch)
	// return;
	// monitor.subTask("Updating server-side libraries if necessary");
	// final Display dis = Display.getDefault();
	// final int[] result = new int[] { -1 };
	//
	// for (ActionPakJar jar : getActionpakJars()) {
	// final URL url = jar.url;
	// try {
	// File f = new File(url.getFile());
	// if (!f.exists()) {
	// logError("Couldn't find actionpak file " + f);
	// continue;
	// }
	// String name = f.getName();
	//
	// if (SafiServerRemoteManager.getInstance().needsUpdate(name)) {
	// if (result[0] == -1 || result[0] != 0) {
	// dis.syncExec(new Runnable() {
	// @Override
	// public void run() {
	// MessageDialog dialog = new MessageDialog(dis.getActiveShell(),
	// "Push ActionPak to Server?", null,
	// "The SafiServer is missing or has an older version of ActionPack "
	// + url.getFile() + ". Do you want to update it on the server?",
	// SWT.ICON_QUESTION, new String[] { "YES TO ALL", "YES", "NO" }, 2);
	// result[0] = dialog.open();
	// }
	// });
	// if (result[0] == 2)
	// continue;
	// }
	//
	// byte[] data = new byte[(int) f.length()];
	// BufferedInputStream bis = new BufferedInputStream(url.openStream());
	// bis.read(data);
	// bis.close();
	// SafiServerRemoteManager.getInstance().transfer(name, data);
	// }
	// } catch (Exception e) {
	// log.error("Couldn't transfer to server: " + url, e);
	// }
	// }
	// monitor.worked(1);
	// boolean serverJarsTransported = false;
	// for (SafiServerJar jar : getServerJars()) {
	// final URL url = jar.url;
	// try {
	// File f = new File(url.getFile());
	// if (!f.exists()) {
	// logError("Couldn't find server jar file " + f);
	// continue;
	// }
	// String name = f.getName();
	//
	// if (SafiServerRemoteManager.getInstance().serverJarNeedsUpdate(name)) {
	// if (result[0] == -1 || result[0] != 0) {
	// dis.syncExec(new Runnable() {
	// @Override
	// public void run() {
	// MessageDialog dialog = new MessageDialog(dis.getActiveShell(),
	// "Push updated SafiServer core jars to server?", null,
	// "The SafiServer is missing or has an older version of SafiServer core jar "
	// + url.getFile() + ". Do you want to update it on the server?",
	// SWT.ICON_QUESTION, new String[] { "YES TO ALL", "YES", "NO" }, 2);
	// result[0] = dialog.open();
	// }
	// });
	// if (result[0] == 2)
	// continue;
	// }
	//
	// byte[] data = new byte[(int) f.length()];
	// BufferedInputStream bis = new BufferedInputStream(url.openStream());
	// bis.read(data);
	// bis.close();
	// SafiServerRemoteManager.getInstance().transferServerJar(name, data);
	// serverJarsTransported = true;
	// }
	// } catch (Exception e) {
	// log.error("Couldn't transfer to server: " + url, e);
	// }
	// }
	// monitor.worked(1);
	// if (serverJarsTransported) {
	// if (MessageDialog
	// .openQuestion(
	// dis.getActiveShell(),
	// "Restart SafiServer?",
	// "The SafiServer must be restarted for changes to take effect.  Would you like to restart the server now?"))
	// {
	// try {
	// SafiServerRemoteManager.getInstance().restartServerService();
	// } catch (SafiServerManagementException e) {
	// logError("Couldn't restart SafiServer: ", e);
	// MessageDialog.openError(dis.getActiveShell(), "Restart Server Error",
	// "The remote SafiServer couldn't be restarted: " + e.getLocalizedMessage());
	// e.printStackTrace();
	// }
	// }
	// }
	// }

	private void closeDebugEditors() {
		IWorkbenchWindow[] windows = getWorkbench().getWorkbenchWindows();
		for (IWorkbenchWindow window : windows) {
			IWorkbenchPage[] pages = window.getPages();
			for (IWorkbenchPage page : pages) {
				IEditorReference[] editors = page.getEditorReferences();
				for (IEditorReference editor2 : editors) {
					IEditorPart editor = editor2.getEditor(true);

					if (editor != null && editor instanceof AsteriskDiagramEditor) {
						AsteriskDiagramEditor astEditor = (AsteriskDiagramEditor) editor;
						if (((HandlerEditPart) astEditor.getDiagramEditPart()).isDebug()) {
							astEditor.close(false);
						}
					}
				}
			}
		}
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		if (adapterFactory != null)
			adapterFactory.dispose();
		adapterFactory = null;
		instance = null;
		super.stop(context);

		if (SafiServerPlugin.getDefault() != null) {
			SQLExplorerPlugin.getDefault().stop(context);
			SafiServerPlugin.getDefault().removeAuthListener(safiServerAuthListener);
		}
	}

	@Override
	protected void saveDialogSettings() {
		super.saveDialogSettings();
	}

	/**
	 * @generated NOT
	 */
	public static AsteriskDiagramEditorPlugin getDefault() {
		return instance;
	}

	/**
	 * @generated
	 */
	public static AsteriskDiagramEditorPlugin getInstance() {
		return instance;
	}

	/**
	 * @generated
	 */
	// protected ComposedAdapterFactory createAdapterFactory() {
	// List factories = new ArrayList();
	// fillItemProviderFactories(factories);
	// return new ComposedAdapterFactory(factories);
	// }
	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected void fillItemProviderFactories(List factories) {
		factories.add(new com.safi.core.provider.CoreItemProviderAdapterFactory());
		factories.add(new com.safi.core.actionstep.provider.ActionStepItemProviderAdapterFactory());
		factories.add(new com.safi.core.scripting.provider.ScriptingItemProviderAdapterFactory());
		factories.add(new com.safi.core.saflet.provider.SafletItemProviderAdapterFactory());
		factories.add(new com.safi.core.initiator.provider.InitiatorItemProviderAdapterFactory());

		factories.add(new com.safi.asterisk.provider.AsteriskItemProviderAdapterFactory());
		factories.add(new com.safi.asterisk.actionstep.provider.ActionstepItemProviderAdapterFactory());
		factories.add(new com.safi.asterisk.initiator.provider.InitiatorItemProviderAdapterFactory());
		factories.add(new com.safi.asterisk.saflet.provider.SafletItemProviderAdapterFactory());

		factories.add(new DbItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	 * @generated
	 */
	public AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @generated
	 */
	public ImageDescriptor getItemImageDescriptor(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item,
				IItemLabelProvider.class);
		if (labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(item));
		}
		return null;
	}

	public Image getItemImage(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item,
				IItemLabelProvider.class);
		if (labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImage(labelProvider.getImage(item));
		}
		return null;
	}

	public String getItemLabelText(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item,
				IItemLabelProvider.class);
		if (labelProvider != null) {
			return labelProvider.getText(item);
		}
		return null;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @generated NOT
	 * @param path
	 *          the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

	/**
	 * Respects images residing in any plug-in. If path is relative, then this
	 * bundle is looked up for the image, otherwise, for absolute path, first
	 * segment is taken as id of plug-in with image
	 * 
	 * @generated
	 * @param path
	 *          the path to image, either absolute (with plug-in id as first
	 *          segment), or relative for bundled images
	 * @return the image descriptor
	 */
	public static ImageDescriptor findImageDescriptor(String path) {
		final IPath p = new Path(path);
		if (p.isAbsolute() && p.segmentCount() > 1) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(p.segment(0), p.removeFirstSegments(1)
					.makeAbsolute().toString());
		} else {
			return getBundledImageDescriptor(p.makeAbsolute().toString());
		}
	}

	/**
	 * Returns an image for the image file at the given plug-in relative path.
	 * Client do not need to dispose this image. Images will be disposed
	 * automatically.
	 * 
	 * @generated
	 * @param path
	 *          the path
	 * @return image instance
	 */
	public Image getBundledImage(String path) {
		Image image = getImageRegistry().get(path);
		if (image == null) {
			getImageRegistry().put(path, getBundledImageDescriptor(path));
			image = getImageRegistry().get(path);
		}
		return image;
	}

	/**
	 * Returns string from plug-in's resource bundle
	 * 
	 * @generated
	 */
	public static String getString(String key) {
		return Platform.getResourceString(getInstance().getBundle(), "%" + key); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public AsteriskDocumentProvider getDocumentProvider() {
		if (documentProvider == null) {
			documentProvider = new AsteriskDocumentProvider();
		}
		return documentProvider;
	}

	/**
	 * @generated
	 */
	public void logError(String error) {
		logError(error, null);
	}

	/**
	 * @generated
	 */
	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	/**
	 * @generated
	 */
	public void logInfo(String message) {
		logInfo(message, null);
	}

	/**
	 * @generated
	 */
	public void logInfo(String message, Throwable throwable) {
		if (message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.INFO, AsteriskDiagramEditorPlugin.ID, IStatus.OK, message, throwable));
		debug(message, throwable);
	}

	public void logWarn(String message) {
		logWarn(message, null);
	}

	public void logWarn(String message, Throwable throwable) {
		if (message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getLog()
				.log(
						new Status(IStatus.WARNING, AsteriskDiagramEditorPlugin.ID, IStatus.OK, message,
								throwable));
		debug(message, throwable);
	}

	/**
	 * @generated
	 */
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void initSQLPlugin() {
		Bundle bundle = getBundle();
		if (bundle != null) {
			try {
				SQLExplorerPlugin.getDefault().start(bundle.getBundleContext());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setDBPerspective(SafiDBPerspective safiDBPerspective) {
		this.safiDBPerspective = safiDBPerspective;

	}

	public void setSafletPerspective(DiagramEditorPerspective diagramEditorPerspective) {
		this.safletPerspective = diagramEditorPerspective;

	}

	public SafiDBPerspective getDBPerspective() {
		return safiDBPerspective;
	}

	public DiagramEditorPerspective getSafletPerspective() {
		return safletPerspective;
	}

	public List<ActionStepProfile> getActionstepProfiles() {
		List<ActionStepProfile> result = new ArrayList<ActionStepProfile>();
		for (ActionPak pak : actionPaks) {
			if (pak.actionSteps != null)
				result.addAll(pak.actionSteps);
		}
		return result;
	}

	public void setWindowAdvisor(
			DiagramEditorWorkbenchWindowAdvisor diagramEditorWorkbenchWindowAdvisor) {
		this.windowAdvisor = diagramEditorWorkbenchWindowAdvisor;
		updateWindowTitle();
	}

	public void updateWindowTitle() {
		if (windowAdvisor != null) {
			Display d = Display.getDefault();
			d.asyncExec(new Runnable() {
				@Override
				public void run() {
					windowAdvisor.getWindowConfigurer().setTitle(
							SafiServerPlugin.getDefault().getCurrentUser() == null
									|| !SafiServerPlugin.getDefault().isConnected() ? "SafiWorkshop - Not Connected"
									: "SafiWorkshop - User "
											+ SafiServerPlugin.getDefault().getCurrentUser().getName() + " connected");

				}
			});

		}
	}

	public void requestImmediateServerInfoUpdate() {
		try {
			SafiServerRemoteManager.getInstance().requestServerInfoUpdate();
		} catch (SafiServerManagementException e) {
			e.printStackTrace();
			logError("Couldn't update SafiServer info", e);
		}
	}

	private ReentrantLock serverViewLock = new ReentrantLock();

	public void updateServerView(final boolean connected, final boolean selectLicenseView) {

		if (windowAdvisor == null)
			return;
		if (!serverViewLock.tryLock()) {
			System.err.println("Serverlock couldn't be acquired!");
			return;
		}
		try {
			Runnable runna = new Runnable() {
				@Override
				public void run() {

					for (IWorkbenchWindow window : getWorkbench().getWorkbenchWindows()) {
						// IWorkbenchWindow window =
						// getWorkbench().getActiveWorkbenchWindow();
						for (IWorkbenchPage page : window.getPages()) {
							// IWorkbenchPage page = window.getActivePage();

							if (connected) {
								try {
									final SafiServer safiServer = SafiServerPlugin.getDefault().getSafiServer(true);
									if (safiServer == null) {
										logError("Unable to open SafiServer View: couldn't find SafiServer");
										for (IEditorReference ref : page.getEditorReferences()) {
											try {
												if (ref.getEditorInput() instanceof ServerViewEditorInput) {
													page.closeEditors(new IEditorReference[] { ref }, false);
												}
											} catch (PartInitException e) {
												e.printStackTrace();
											}
										}
										return;
									}
									ServerViewEditorInput input = new ServerViewEditorInput(safiServer);
									SafiServerPanel serverPanel = (SafiServerPanel) page.findEditor(input);
									if (serverPanel == null) {
										IEditorPart ep = page.openEditor(input,
												"com.safi.workshop.serverview.editors.SafiServerPanel");
										if (ep instanceof SafiServerPanel) {
											serverPanel = (SafiServerPanel) ep;
										} else {
											logError("Unable to open SafiServer View");
											return;
										}
									}
									safiServerPanel = serverPanel;
									if (selectLicenseView)
										safiServerPanel.selectLicenseViewTab();
									requestImmediateServerInfoUpdate();
								} catch (Exception e) {
									e.printStackTrace();
									logError("Unable to open SafiServer View", e);
								}
							} else {
								for (IEditorReference ref : page.getEditorReferences()) {
									try {
										if (ref.getEditorInput() instanceof ServerViewEditorInput) {
											page.closeEditors(new IEditorReference[] { ref }, false);
										}
									} catch (PartInitException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			};
			Display d = Display.getDefault();
			d.syncExec(runna);
		} finally {
			serverViewLock.unlock();
		}
	}

	//  
	//  
	// public User getUser() throws DBManagerException{
	// IPreferenceStore store =
	// SafiServerPlugin.getDefault().getPreferenceStore();
	// if (store == null)
	// return null;
	// String user =
	// store.getString(PreferenceConstants.PREF_SAFISERVER_USER_PROD);
	// String pass = store.getString(PreferenceConstants.PREF_SAFISERVER_PASS);
	// return DBManager.getInstance().getUser(user, pass);
	// }

	// public List<URL> getActionpakJars() {
	// return actionpakJars;
	// }
	//
	// public List<URL> getServerJars() {
	// return serverJars;
	// }

	public List<ActionPakJar> getActionpakJars() {
		List<ActionPakJar> result = new ArrayList<ActionPakJar>();
		for (ActionPak pak : actionPaks) {
			if (pak.actionPakJars != null)
				result.addAll(pak.actionPakJars);
		}
		return result;
	}

	public List<ActionPak> getActionPaks() {
		return actionPaks;
	}

	public List<SafiServerJar> getServerJars() {
		List<SafiServerJar> result = new ArrayList<SafiServerJar>();
		for (ActionPak pak : actionPaks) {
			if (pak.serverJars != null)
				result.addAll(pak.serverJars);
		}
		return result;
	}

	public static class ActionPak {
		public String name;
		public String description;
		public ActionPakFactoryProfile actionPakFactoryProfile;
		public List<ActionStepProfile> actionSteps;
		public List<ActionPakJar> actionPakJars;
		public List<SafiServerJar> serverJars;

		public void addActionStep(ActionStepProfile profile) {
			if (actionSteps == null)
				actionSteps = new ArrayList<ActionStepProfile>();

			profile.actionPak = this;
			actionSteps.add(profile);
		}

		public void addActionPakJar(ActionPakJar jar) {
			if (actionPakJars == null)
				actionPakJars = new ArrayList<ActionPakJar>();
			jar.actionPak = this;
			actionPakJars.add(jar);
		}

		public void addSafiServerJar(SafiServerJar jar) {
			if (serverJars == null)
				serverJars = new ArrayList<SafiServerJar>();
			jar.actionPak = this;
			serverJars.add(jar);
		}
	}

	public static class ActionStepProfile {
		public ActionPak actionPak;
		public ActionstepViewFactoryFactory viewFactory;
		public String inputItemLabelSemanticHint;
		public String inputItemSemanticHint;
		public String inputItemPanelSemanticHint;
		public String outputItemLabelSemanticHint;
		public String outputItemSemanticHint;
		public String outputItemPanelSemanticHint;
		public ActionstepCreateCommandFactory commandFactory;
		public ActionstepElementFactory elementFactory;
		public ActionstepModelFactory modelFactory;
		public ActionstepEditPartFactory editPartFactory;
		public String palettePath;
		public String displayName;
		public String tooltip;
		public String semanticHint;
		public String labelSemanticHint;

		public boolean isInitiator;
	}

	public static class ActionPakFactoryProfile {
		public ActionPak actionPak;
		public ActionPakViewFactoryFactory viewFactory;
		public ActionPakCreateCommandFactory commandFactory;
		public ActionPakElementFactory elementFactory;
		public ActionPakModelFactory modelFactory;
		public ActionPakEditPartFactory editPartFactory;
	}

	public static class Jar {
		public ActionPak actionPak;
		public URL url;
		public String version;
		public String bundleSymbolicName;
	}

	public static class SafiServerJar extends Jar {
		public String description;

	}

	public static class ActionPakJar extends Jar {
	}

	public void setDebugListener(DebugEventListener debugEventListener) {
		if (this.debugEventListener != null && this.debugEventListener != debugEventListener) {
			SafiServerPlugin.getDefault().removeDebugEventListener(this.debugEventListener);
		}
		this.debugEventListener = debugEventListener;
		SafiServerPlugin.getDefault().addDebugEventListener(debugEventListener);
	}
}
