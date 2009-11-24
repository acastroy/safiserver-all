package com.safi.workshop.sheet;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class DynamicValueEditorUtils {

	public static final String PATT_QUOTED_TEXT = "\"([^\\\\\"]|(\\\\\"))*[\\\"]\\s*\\;?\\s*$";

	public static DynamicValueEditorPage buildEditorPage(String classname,
	    SafletContext handlerContext, EditingDomain editingDomain) {
		Object obj = null;
		try {
			Class klass = null;
			try {
				klass = Class.forName(classname);
				obj = klass.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			} catch (IllegalAccessException e) {
				// e.printStackTrace();
			} catch (ClassNotFoundException cnf) {
			}
			if (obj == null) {
				try {
					obj = AsteriskDiagramEditorPlugin.getInstance().createEditorPage(classname);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (obj == null && klass != null) {
				try {
					obj = ConstructorUtils.invokeConstructor(klass, handlerContext);
				} catch (NoSuchMethodException e) {

				} catch (IllegalAccessException e) {

				} catch (InvocationTargetException e) {

				} catch (InstantiationException e) {

				}

			}

			if (obj == null && klass != null) {
				try {
					obj = ConstructorUtils.invokeConstructor(klass, editingDomain);
				} catch (NoSuchMethodException e) {

				} catch (IllegalAccessException e) {

				} catch (InvocationTargetException e) {

				} catch (InstantiationException e) {

				}

			}
			if (obj == null && klass != null) {
				try {
					obj = ConstructorUtils.invokeConstructor(klass, new Object[] { handlerContext,
					    editingDomain });
				} catch (NoSuchMethodException e) {

				} catch (IllegalAccessException e) {

				} catch (InvocationTargetException e) {

				} catch (InstantiationException e) {

				}
			}

			if (obj == null && klass != null) {
				try {
					obj = ConstructorUtils.invokeConstructor(klass, new Object[] { editingDomain,
					    handlerContext });
				} catch (NoSuchMethodException e) {

				} catch (IllegalAccessException e) {

				} catch (InvocationTargetException e) {

				} catch (InstantiationException e) {

				}
			}
			if (obj == null) {
				AsteriskDiagramEditorPlugin.getInstance().logError(
				    "Couldn't instantiate DynamicValueEditorPage " + classname);
				return null;
			}
			DynamicValueEditorPage page = (DynamicValueEditorPage) obj;
			try {
				BeanUtils.setProperty(page, "handlerContext", handlerContext);
			} catch (Exception e) {
			}

			try {
				BeanUtils.setProperty(page, "editingDomain", editingDomain);
			} catch (Exception e) {
			}
			return page;
		} catch (Exception e) {
			AsteriskDiagramEditorPlugin.getInstance().logError(
			    "Couldn't instantiate DynamicValueEditorPage " + classname, e);
		}
		return null;
	}

	public static DynamicValue copyDynamicValue(DynamicValue value) {
		if (value == null)
			return null;
		return (DynamicValue) EcoreUtil.copy(value);
		// SimpleDynamicValue val = new SimpleDynamicValue();
		// val.setPayload(value.getPayload()==null ? null :
		// EcoreUtil.copy(value.getPayload()));
		// val.setText(value.getText());
		// val.setType(value.getType());
		// for (Map.Entry<String, String> entry : value.getData().entrySet()){
		// val.getData().put(entry.getKey(), entry.getValue());
		// }
		// return val;
	}

	public static class DynamicValueAnnotationInfo {
		public String dynValDescription;
		public String attributeName;
		public String expectedReturnType;
		public String dynValueTypeStr;
		public boolean isTypeLocked;
		public String helperClass;
		public String[] enumeratedValues;
	}

	public static DynamicValueAnnotationInfo extractAnnotationInfo(final EObject obj,
	    final EStructuralFeature feature) {
		DynamicValueAnnotationInfo info = new DynamicValueAnnotationInfo();

		EAnnotation annotation = null;
		if (obj == null)
			return info;

		for (EAnnotation annot : obj.eClass().getEAnnotations()) {
			if (annot.getSource().startsWith("DynamicValueAnnotation")) {
				EMap<String, String> map = annot.getDetails();
				String propertyName = map.get("superProperty");

				if (StringUtils.isBlank(propertyName)
				    || !StringUtils.equals(propertyName, feature.getName())) {
					continue;
				} else {
					annotation = annot;
				}
			}

		}
		if (annotation == null && feature != null)
			annotation = feature.getEAnnotation("DynamicValueAnnotation");

		if (annotation != null) {
			EMap<String, String> map = annotation.getDetails();
			info.dynValDescription = map.get("description");
			info.expectedReturnType = map.get("expectedReturnType");
			info.dynValueTypeStr = map.get("type");
			info.isTypeLocked = Boolean.valueOf(map.get("isTypeLocked"));
			info.helperClass = map.get("helperClass");
			if ("com.safi.workshop.sheet.assist.SafletChooserAssistant"
			    .equals(info.helperClass))
				// return createSafletChooserDialog(composite);
				info.helperClass = "com.safi.workshop.sheet.SelectSafletDynamicValueEditorPage";

			String enumeratedVals = map.get("enumeratedValues");
			if (enumeratedVals != null) {
				info.enumeratedValues = enumeratedVals.split(",");
			}
		}
		info.attributeName = (obj instanceof ActionStep ? ((ActionStep) obj).getName() + "->"
		    : "")
		    + feature.getName();
		return info;
	}

	public static DynamicValueEditor2 createDynamicValueEditor(
	    final DynamicValueAnnotationInfo info, final EObject parent,
	    final EditingDomain editingDomain, final DynamicValue dynamicValue,
	    final SafletContext handlerContext, final Shell shell) {

		final DynamicValueEditor2 dve = new DynamicValueEditor2(shell);
		dve.setAttributeName(info.attributeName);
		dve.setExpectedReturnType(info.expectedReturnType);
		dve.setDescription(info.dynValDescription);
		dve.setTypeLocked(info.isTypeLocked);
		dve.setInfo(info);
		dve.setParent(parent);
		// SafletContext handlerContext = null;
		// if (object instanceof ActionStep) {
		// handlerContext = ((ActionStep) object).getHandler().getSafletContext();
		// } else
		// if (object instanceof Item){
		// ActionStep ts = ((Item)object).getParentActionStep();
		// if (ts != null)
		// handlerContext = ts.getHandler().getSafletContext();
		// }
		// else {
		// Saflet h = null;
		// Object obj = editingDomain.getRoot(object);
		// if (obj instanceof ResourceSet)
		// for (Resource r : ((ResourceSet) obj).getResources()) {
		// for (EObject o : r.getContents()) {
		// if (o instanceof Saflet) {
		// h = (Saflet) o;
		// break;
		// }
		//
		// }
		// }
		//
		// if (h != null)
		// handlerContext = h.getSafletContext();
		//
		// }
		//
		// if (handlerContext == null)
		// throw new
		// IllegalStateException("Couldn't retrieve SafletContext from object "+object);
		dve.setDynamicValue(dynamicValue);
		dve.setEditingDomain(editingDomain);

		final boolean hasHelperClass = StringUtils.isNotBlank(info.helperClass);

		final SafletContext handlerContextFinal = handlerContext;
		// LiteralDynamicValueEditorPage literalPage = new
		// LiteralDynamicValueEditorPage();
		// dve.addPage(literalPage);
		ProgressMonitorDialog pmd = new ProgressMonitorDialog(shell);

		try {
			pmd.run(true, false, new IRunnableWithProgress() {

				@Override
				public void run(final IProgressMonitor monitor) throws InvocationTargetException,
				    InterruptedException {
					monitor.beginTask("Open DynamicValue Editor", IProgressMonitor.UNKNOWN);
					Display d = Display.getDefault();
					d.asyncExec(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							if (!(hasHelperClass && info.isTypeLocked)) {
								VariableDynamicValueEditorPage variablePage = new VariableDynamicValueEditorPage(
								    handlerContext);
								dve.addPage(variablePage);

								ScriptDynamicValueEditorPage scriptPage = new ScriptDynamicValueEditorPage(
								    handlerContextFinal);
								dve.addPage(scriptPage);
							}
							if (hasHelperClass) {

								Thread currentThread = Thread.currentThread();
								ClassLoader oldLoader = currentThread.getContextClassLoader();
								try {

									currentThread.setContextClassLoader(AsteriskDiagramEditorPlugin.class
									    .getClassLoader());
									String[] classes = info.helperClass.split(";");
									for (String s : classes) {
										DynamicValueEditorPage page = DynamicValueEditorUtils
										    .buildEditorPage(s, handlerContext, editingDomain);
										if (page != null) {
											dve.addPage(page);
											dve.setDefaultPage(page);
										}
									}
								} finally {
									currentThread.setContextClassLoader(oldLoader);
								}
							}
						}
					});
				}

			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
		//
		// public void run() {
		// ScriptDynamicValueEditorPage scriptPage = new
		// ScriptDynamicValueEditorPage(
		// handlerContextFinal);
		// dve.addPage(scriptPage);
		// }
		// });

		// if (hasHelperClass) {
		// Thread.currentThread().setContextClassLoader(
		// AsteriskDiagramEditorPlugin.class.getClassLoader());
		// String[] classes = info.helperClass.split(";");
		// for (String s : classes) {
		// DynamicValueEditorPage page = DynamicValueEditorUtils.buildEditorPage(s,
		// handlerContext,
		// editingDomain);
		// if (page != null)
		// dve.addPage(page);
		// }
		// }

		if (dynamicValue == null) {
			
			DynamicValueEditorPage defaultPage = dve.getPageForType(info.expectedReturnType);
			if (defaultPage == null)
				defaultPage = dve.getPageForType(info.dynValueTypeStr);
			if (defaultPage != null)
				dve.setDefaultPage(defaultPage);
//			dve.setDefaultPageByType(info.dynValueTypeStr);
		} else if (dynamicValue.getType() == DynamicValueType.CUSTOM
		    && StringUtils.isNotBlank(info.expectedReturnType)) {
			for (int i = 0; i < dve.getNumPages(); i++) {
				if (StringUtils.equals(dve.getPage(i).getType(), info.expectedReturnType)) {
					dve.setDefaultPage(dve.getPage(i));
					break;
				}
			}
		} else
		if (dynamicValue != null && !info.isTypeLocked) {
			DynamicValueEditorPage defaultPage = dve.getPageForType(info.expectedReturnType);
			if (defaultPage == null)
				defaultPage = dve.getPageForType(info.dynValueTypeStr);
			if (defaultPage != null)
				dve.setDefaultPage(defaultPage);
			
//			DynamicValueEditorPage newDef = dve.getPageForType(dynamicValue.getType()
//			    .getLiteral());
//			if (newDef != null)
//				dve.setDefaultPage(newDef);
		}

		dve.setBlockOnOpen(true);
		return dve;
	}
}
