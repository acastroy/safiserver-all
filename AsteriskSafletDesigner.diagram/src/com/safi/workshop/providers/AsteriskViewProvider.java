package com.safi.workshop.providers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.diagram.core.internal.DiagramPlugin;
import org.eclipse.gmf.runtime.diagram.core.internal.DiagramStatusCodes;
import org.eclipse.gmf.runtime.diagram.core.internal.l10n.DiagramCoreMessages;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;

import com.safi.workshop.edit.parts.*;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.view.factories.*;

/**
 * @generated
 */
public class AsteriskViewProvider extends AbstractProvider
implements IViewProvider {

	//start from AbstractViewProvider.java
	
	private static String viewCreationMethodName = "createView"; //$NON-NLS-1$

	private static String diagramCreationMethodName = "createDiagram"; //$NON-NLS-1$
	
	static protected class ClassToCreationMethodMap
		extends HashMap {
		static final long serialVersionUID = 1;
		
		public void addMethod(Class clazz, Method method) {
			if (get(clazz) == null)
				put(clazz, method);
		}

		public Method getCreationMethod(Class clazz) {
			return (Method) get(clazz);
		}
	}

	static protected class ClazzToCreationMethodMap
	extends HashMap {
	static final long serialVersionUID = 1;
	
	public void addMethod(Class clazz, Method method) {
		if (get(clazz) == null)
			put(clazz, method);
	}

	public Method getCreationMethod(Class clazz) {
		return (Method) get(clazz);
	}
} 
	public static ClazzToCreationMethodMap classToCreateMethod = new ClazzToCreationMethodMap();
	
	/**
	 * Determines whether this view provider can provide for the required
	 * operation It inspects the type of view operation and calls the
	 * corresponding <code>provides</code> method.
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(IOperation)
	 */
	public final boolean provides(IOperation operation) {
		/* if this is the CreateViewForKindOperation operation */
		if (operation instanceof CreateViewForKindOperation)
			return provides((CreateViewForKindOperation) operation);

		/* Make sure it is a view operation */
		assert operation instanceof CreateViewOperation : "operation is not CreateViewOperation in AbstractViewProvider";//$NON-NLS-1$

		/* call the specific provides method */
		if (operation instanceof CreateDiagramViewOperation)
			return provides((CreateDiagramViewOperation) operation);
		else if (operation instanceof CreateEdgeViewOperation)
			return provides((CreateEdgeViewOperation) operation);
		else if (operation instanceof CreateNodeViewOperation)
			return provides((CreateNodeViewOperation) operation);
		return false;
	}

	public final Diagram createDiagram(IAdaptable contextElement,
			String diagramKind, PreferencesHint preferencesHint) {
		return (Diagram) createNewView(getDiagramViewClass(contextElement,
			diagramKind), new Object[] {contextElement, diagramKind,
			preferencesHint});
	}

	public final Edge createEdge(IAdaptable semanticAdapter,
			View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {

		return (Edge) createNewView(getEdgeViewClass(semanticAdapter,
			containerView, semanticHint), new Object[] {semanticAdapter,
			containerView, semanticHint, new Integer(index),
			Boolean.valueOf(persisted), preferencesHint});
	}

	public final Node createNode(IAdaptable semanticAdapter,
			View containerView, String semanticHint, int index,
			boolean persisted, PreferencesHint preferencesHint) {

		Object[] constructorParams = new Object[] {semanticAdapter,
				containerView, semanticHint, new Integer(index),
				Boolean.valueOf(persisted), preferencesHint};
		Object factory = createNodeViewFactory(semanticAdapter, containerView, semanticHint);
    
		if (factory != null) {
			return (Node) createNewView(factory, constructorParams);
		}
		else
			return (Node) createNewView( getNodeViewClass(semanticAdapter,
				containerView, semanticHint), constructorParams);
	}

	private Object createNodeViewFactory(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		int visualID;
		IElementType elementType = getSemanticElementType(semanticAdapter);
    EObject domainElement = getSemanticElement(semanticAdapter);
    if (semanticHint == null) {
      // Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
      // In this situation there should be NO elementType, visualID will be determined
      // by VisualIDRegistry.getNodeVisualID() for domainElement.
      if (elementType != null || domainElement == null) {
        return null;
      }
      visualID = AsteriskVisualIDRegistry.getNodeVisualID(containerView, domainElement);
    } else 
      visualID = AsteriskVisualIDRegistry.getVisualID(semanticHint);
    
    return getNodeViewFactory(containerView, visualID);
	}

	/**
	 * Determines whether this provider can provide for the specified view
	 * creation operation
	 * 
	 * @param operation
	 *            Contains a semantic kind and a containerView
	 * @return boolean
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		if (op.getViewKind() == Node.class)
			return getNodeViewClass(op.getSemanticAdapter(), op
				.getContainerView(), op.getSemanticHint()) != null;
		if (op.getViewKind() == Edge.class)
			return getEdgeViewClass(op.getSemanticAdapter(), op
				.getContainerView(), op.getSemanticHint()) != null;
		return true;
	}

	/**
	 * Determines whether this provider can provide for the specified diagram
	 * view operation
	 * 
	 * @param operation
	 * @return boolean
	 */
	protected boolean provides(CreateDiagramViewOperation operation) {
		return getDiagramViewClass(operation.getSemanticAdapter(), operation
			.getSemanticHint()) != null;
	}

	/**
	 * Determines whether this provider can provide for the specified edge view
	 * operation
	 * 
	 * @param operation
	 * @return boolean
	 */
	protected boolean provides(CreateEdgeViewOperation operation) {
		return (getEdgeViewClass(operation.getSemanticAdapter(), operation
			.getContainerView(), operation.getSemanticHint()) != null);
	}

	/**
	 * Determines whether this provider can provide for the specified node view
	 * operation
	 * 
	 * @param operation
	 * @return boolean
	 */
	protected boolean provides(CreateNodeViewOperation operation) {
		return (getNodeViewClass(operation.getSemanticAdapter(), operation
			.getContainerView(), operation.getSemanticHint()) != null);
	}

	
	/**
	 * creates a view instance via reflection.
	 * 
	 * @param constructorParams
	 *            the view's constructor parameters.
	 */
	private View createNewView(Class viewClass, Object[] constructorParams) {
		try {
			assert null != viewClass : "Null viewClass in AbstractProvider";//$NON-NLS-1$			
			assert null != constructorParams : "Null constructorParams in AbstractProvider";//$NON-NLS-1$

			Constructor constructor = getFactoryConstructor(viewClass);
			if (constructor == null) {
				Log
					.error(
						DiagramPlugin.getInstance(),
						DiagramStatusCodes.SERVICE_FAILURE,
						"View (" + viewClass + ") is missing a proper creation Factory"); //$NON-NLS-1$//$NON-NLS-2$
				return null;
			}

			Object factory = constructor.newInstance(null);
			Method method = getCreationMethod(viewClass, constructorParams);
			if (method == null) {
				Log
					.error(
						DiagramPlugin.getInstance(),
						DiagramStatusCodes.SERVICE_FAILURE,
						"View (" + viewClass + ") is missing a proper creation Factory"); //$NON-NLS-1$//$NON-NLS-2$
				return null;
			}
			return (View) method.invoke(factory, constructorParams);
		} catch (Throwable e) {
			String eMsg = NLS
				.bind(
					DiagramCoreMessages.AbstractViewProvider_create_view_failed_ERROR_,
					viewClass.getName());
			Log.warning(DiagramPlugin.getInstance(), IStatus.WARNING, eMsg, e);
			return null;
		}
	}

	private View createNewView(Object factory, Object[] constructorParams) {
		try {
			assert null != constructorParams : "Null constructorParams in AbstractProvider";//$NON-NLS-1$

			
			Method method = getCreationMethod(factory.getClass(), constructorParams);
			if (method == null) {
				Log
					.error(
						DiagramPlugin.getInstance(),
						DiagramStatusCodes.SERVICE_FAILURE,
						"View (" + factory.getClass() + ") is missing a proper creation Factory"); //$NON-NLS-1$//$NON-NLS-2$
				return null;
			}
			return (View) method.invoke(factory, constructorParams);
		} catch (Throwable e) {
			String eMsg = NLS
				.bind(
					DiagramCoreMessages.AbstractViewProvider_create_view_failed_ERROR_,
					factory.getClass().getName());
			Log.warning(DiagramPlugin.getInstance(), IStatus.WARNING, eMsg, e);
			return null;
		}
	}

	private Constructor getFactoryConstructor(Class viewClass) {
		if (viewClass != null) {
			Constructor[] ctors = viewClass.getConstructors();
			for (int i = 0; i < ctors.length; i++) {
				if (ctors[i].getParameterTypes().length == 0) {
					return ctors[i];
				}
			}
		}
		return null;
	}

	/** Return the <i>creation</i> constructor for the cached view class. */
	private Method getCreationMethod(Class viewClass, Object[] params) {
		if (viewClass != null) {
			Method method = classToCreateMethod.getCreationMethod(viewClass);
			if (method != null)
				return method;

			Method[] methods = viewClass.getMethods();
			for (int i = 0; i < methods.length; i++) {
				method = methods[i];
				String methodName = method.getName();
				if (methodName.equals(viewCreationMethodName)
					|| methodName.equals(diagramCreationMethodName)) {
					classToCreateMethod.addMethod(viewClass, method);
					return method;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the EClass associated with the semantic adapter
	 * 
	 * @param semanticAdapter
	 * @return EClass
	 */
	protected EClass getSemanticEClass(IAdaptable semanticAdapter) {
		if (semanticAdapter == null)
			return null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null)
			return EMFCoreUtil.getProxyClass(eObject);
		IElementType type = (IElementType) semanticAdapter
			.getAdapter(IElementType.class);
		if (type != null)
			return type.getEClass();
		return null;
	}

	/**
	 * Returns the semantic element associated with the semantic adapter
	 * 
	 * @param semanticAdapter
	 * @return EClass
	 */
	protected EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null)// TODO which MEditingDomain to use?
			return null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null)
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		return null;
	}

	/**
	 * Returns the semantic element associated with the semantic adapter
	 * 
	 * @param semanticAdapter
	 * @return EClass
	 */
	protected EObject getSemanticElement(IAdaptable semanticAdapter,
			TransactionalEditingDomain domain) {
		if (semanticAdapter == null)
			return null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null)
			return EMFCoreUtil.resolve(domain, eObject);
		return null;
	}

	
  /**
   * @generated
   */
  //@Override
  protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
    EObject semanticElement = getSemanticElement(semanticAdapter);
    if (HandlerEditPart.MODEL_ID.equals(diagramKind)
        && AsteriskVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
      return HandlerViewFactory.class;
    }
    return null;
  }

  //end from AbstractViewProvider
  
  // public final Node createNode(IAdaptable semanticAdapter,
  // View containerView, String semanticHint, int index,
  // boolean persisted, PreferencesHint preferencesHint) {
  //
  // return (Node) createNewView(getNodeViewClass(semanticAdapter,
  // containerView, semanticHint), new Object[] {semanticAdapter,
  // containerView, semanticHint, new Integer(index),
  // Boolean.valueOf(persisted), preferencesHint});
  // }

  
  /**
   * @generated NOT
   */
  //@Override
  protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView,
      String semanticHint) {
    if (containerView == null) {
      return null;
    }
    IElementType elementType = getSemanticElementType(semanticAdapter);
    EObject domainElement = getSemanticElement(semanticAdapter);
    int visualID;
    if (semanticHint == null) {
      // Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
      // In this situation there should be NO elementType, visualID will be determined
      // by VisualIDRegistry.getNodeVisualID() for domainElement.
      if (elementType != null || domainElement == null) {
        return null;
      }
      visualID = AsteriskVisualIDRegistry.getNodeVisualID(containerView, domainElement);
    } else {
      visualID = AsteriskVisualIDRegistry.getVisualID(semanticHint);
      if (elementType != null) {
        // Semantic hint is specified together with element type.
        // Both parameters should describe exactly the same diagram element.
        // In addition we check that visualID returned by
        // VisualIDRegistry.getNodeVisualID() for
        // domainElement (if specified) is the same as in element type.
        if (!AsteriskElementTypes.isKnownElementType(elementType)
            || (!(elementType instanceof IHintedType))) {
          return null; // foreign element type
        }
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        if (!semanticHint.equals(elementTypeHint)) {
          return null; // if semantic hint is specified it should be the same as in
          // element type
        }
        if (domainElement != null
            && visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
          return null; // visual id for node EClass should match visual id from element
          // type
        }
      } else {
        // Element type is not specified. Domain element should be present (except pure
        // design elements).
        // This method is called with EObjectAdapter as parameter from:
        // - ViewService.createNode(View container, EObject eObject, String type,
        // PreferencesHint preferencesHint)
        // - generated ViewFactory.decorateView() for parent element
        if (!HandlerEditPart.MODEL_ID.equals(AsteriskVisualIDRegistry.getModelID(containerView))) {
          return null; // foreign diagram
        }
        switch (visualID) {
          case AssignmentEditPart.VISUAL_ID:
          case ChoiceEditPart.VISUAL_ID:
          case IfThenEditPart.VISUAL_ID:
          case ExecuteScriptEditPart.VISUAL_ID:
          case InvokeSafletEditPart.VISUAL_ID:
          case DebugLogEditPart.VISUAL_ID:
          case OpenDBConnectionEditPart.VISUAL_ID:
          case CloseDBConnectionEditPart.VISUAL_ID:
          case OpenQueryEditPart.VISUAL_ID:
          case SetQueryParamEditPart.VISUAL_ID:
          case ExecuteUpdateEditPart.VISUAL_ID:
          case ExecuteQueryEditPart.VISUAL_ID:
          case NextRowEditPart.VISUAL_ID:
          case GetColValueEditPart.VISUAL_ID:
          case SetColValueEditPart.VISUAL_ID:
          case UpdatetRowEditPart.VISUAL_ID:
          case MoveToRowEditPart.VISUAL_ID:
          case MoveToLastRowEditPart.VISUAL_ID:
          case DeleteRowEditPart.VISUAL_ID:
          case MoveToInsertRowEditPart.VISUAL_ID:
          case InsertRowEditPart.VISUAL_ID:
          case MoveToFirstRowEditPart.VISUAL_ID:
          case PreviousRowEditPart.VISUAL_ID:
          case GetColValuesEditPart.VISUAL_ID:
          case SetColValuesEditPart.VISUAL_ID:
          case RunQueryEditPart.VISUAL_ID:
          case OutputEditPart.VISUAL_ID:
          case CaseItemEditPart.VISUAL_ID:
          case AudioFileItemEditPart.VISUAL_ID:
          case GetColMappingEditPart.VISUAL_ID:
          case SetColMappingEditPart.VISUAL_ID:
          case QueryParamMappingEditPart.VISUAL_ID:
            if (domainElement == null
                || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                    domainElement)) {
              return null; // visual id in semantic hint should match visual id for
              // domain element
            }
            break;
          case AssignmentNameEditPart.VISUAL_ID:
            if (AssignmentEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ChoiceNameEditPart.VISUAL_ID:
          case ChoiceItemPanelEditPart.VISUAL_ID:
            if (ChoiceEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case IfThenNameEditPart.VISUAL_ID:
            if (IfThenEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExecuteScriptNameEditPart.VISUAL_ID:
            if (ExecuteScriptEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case InvokeSafletNameEditPart.VISUAL_ID:
          case InvokeSafletLabelTextEditPart.VISUAL_ID:
            if (InvokeSafletEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DebugLogNameEditPart.VISUAL_ID:
            if (DebugLogEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case OpenDBConnectionNameEditPart.VISUAL_ID:
            if (OpenDBConnectionEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case CloseDBConnectionNameEditPart.VISUAL_ID:
            if (CloseDBConnectionEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case OpenQueryNameEditPart.VISUAL_ID:
            if (OpenQueryEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetQueryParamNameEditPart.VISUAL_ID:
            if (SetQueryParamEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExecuteUpdateNameEditPart.VISUAL_ID:
            if (ExecuteUpdateEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExecuteQueryNameEditPart.VISUAL_ID:
            if (ExecuteQueryEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case NextRowNameEditPart.VISUAL_ID:
            if (NextRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetColValueNameEditPart.VISUAL_ID:
            if (GetColValueEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetColValueNameEditPart.VISUAL_ID:
            if (SetColValueEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case UpdatetRowNameEditPart.VISUAL_ID:
            if (UpdatetRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToRowNameEditPart.VISUAL_ID:
            if (MoveToRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToLastRowNameEditPart.VISUAL_ID:
            if (MoveToLastRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DeleteRowNameEditPart.VISUAL_ID:
            if (DeleteRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToInsertRowNameEditPart.VISUAL_ID:
            if (MoveToInsertRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case InsertRowNameEditPart.VISUAL_ID:
            if (InsertRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToFirstRowNameEditPart.VISUAL_ID:
            if (MoveToFirstRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PreviousRowNameEditPart.VISUAL_ID:
            if (PreviousRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetColValuesNameEditPart.VISUAL_ID:
          case GetColValuesValuesPanelEditPart.VISUAL_ID:
            if (GetColValuesEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetColValuesNameEditPart.VISUAL_ID:
          case SetColValuesValuesPanelEditPart.VISUAL_ID:
            if (SetColValuesEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case RunQueryNameEditPart.VISUAL_ID:
          case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
            if (RunQueryEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case CaseItemLabelTextEditPart.VISUAL_ID:
            if (CaseItemEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case AudioFileItemLabelTextEditPart.VISUAL_ID:
            if (AudioFileItemEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
            if (GetColMappingEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
            if (SetColMappingEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case WrapLabelEditPart.VISUAL_ID:
            if (QueryParamMappingEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;

          default: {
            boolean found = false;
            for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
                .getInstance().getActionstepProfiles()) {
              if (p.labelSemanticHint.equals(String.valueOf(visualID))) {
                found = true;

                if (!p.semanticHint.equals(String.valueOf(AsteriskVisualIDRegistry
                    .getVisualID(containerView)))
                    || containerView.getElement() != domainElement) {
                  return null; // wrong container
                }
                break;
              } else if (p.semanticHint.equals(String.valueOf(visualID))) {
                found = true;
                if (domainElement == null
                    || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                        domainElement)) {
                  return null; // visual id in semantic hint should match visual id for
                  // domain element
                }
                break;
              }
              if (String.valueOf(visualID).equals(p.inputItemLabelSemanticHint)) {
                found = true;

                if (!String.valueOf(AsteriskVisualIDRegistry.getVisualID(containerView)).equals(
                    p.inputItemSemanticHint)
                    || containerView.getElement() != domainElement) {
                  return null; // wrong container
                }
                break;
              } else if (String.valueOf(visualID).equals(p.inputItemSemanticHint)) {
                found = true;
                if (domainElement == null
                    || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                        domainElement)) {
                  return null; // visual id in semantic hint should match visual id for
                  // domain element
                }
                break;
              } else if (String.valueOf(visualID).equals(p.inputItemPanelSemanticHint)) {
                found = true;
                if (Integer.parseInt(p.semanticHint) != AsteriskVisualIDRegistry
                    .getVisualID(containerView)
                    || containerView.getElement() != domainElement) {
                  // return null; // wrong container
                  found = false;
                  continue;
                }

                break;
              } else if (String.valueOf(visualID).equals(p.outputItemLabelSemanticHint)) {
                found = true;

                if (!String.valueOf(AsteriskVisualIDRegistry.getVisualID(containerView)).equals(
                    p.outputItemSemanticHint)
                    || containerView.getElement() != domainElement) {
                  return null; // wrong container
                }
                break;
              } else if (String.valueOf(visualID).equals(p.outputItemSemanticHint)) {
                found = true;
                if (domainElement == null
                    || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                        domainElement)) {
                  return null; // visual id in semantic hint should match visual id for
                  // domain element
                }
                break;
              } else if (String.valueOf(visualID).equals(p.outputItemPanelSemanticHint)) {
                found = true;
                if (Integer.parseInt(p.semanticHint) != AsteriskVisualIDRegistry
                    .getVisualID(containerView)
                    || containerView.getElement() != domainElement) {
                  // return null; // wrong container
                  found = false;
                  continue;
                }

                break;
              }
            }
            if (!found) {
              return null;
            }
          }
        }
      }
    }
    return getNodeViewClass(containerView, visualID);
  }
//
//  @Override
//  protected boolean provides(CreateNodeViewOperation operation) {
//    // TODO Auto-generated method stub
//    return super.provides(operation);
//  }
//
//  @Override
//  protected boolean provides(CreateViewForKindOperation op) {
//    // TODO Auto-generated method stub
//    return super.provides(op);
//  }

  protected Object getNodeViewFactory(View containerView, int visualID) {
    if (containerView == null || !AsteriskVisualIDRegistry.canCreateNode(containerView, visualID)) {
      return null;
    }
    try {
			
	
    switch (visualID) {
      case AssignmentEditPart.VISUAL_ID:
        return AssignmentViewFactory.class.newInstance();
      case AssignmentNameEditPart.VISUAL_ID:
        return AssignmentNameViewFactory.class.newInstance();
      case ChoiceEditPart.VISUAL_ID:
        return ChoiceViewFactory.class.newInstance();
      case ChoiceNameEditPart.VISUAL_ID:
        return ChoiceNameViewFactory.class.newInstance();
      case IfThenEditPart.VISUAL_ID:
        return IfThenViewFactory.class.newInstance();
      case IfThenNameEditPart.VISUAL_ID:
        return IfThenNameViewFactory.class.newInstance();
      case ExecuteScriptEditPart.VISUAL_ID:
        return ExecuteScriptViewFactory.class.newInstance();
      case ExecuteScriptNameEditPart.VISUAL_ID:
        return ExecuteScriptNameViewFactory.class.newInstance();
      case InvokeSafletEditPart.VISUAL_ID:
        return InvokeSafletViewFactory.class.newInstance();
      case InvokeSafletNameEditPart.VISUAL_ID:
        return InvokeSafletNameViewFactory.class.newInstance();
      case InvokeSafletLabelTextEditPart.VISUAL_ID:
        return InvokeSafletLabelTextViewFactory.class.newInstance();
      case DebugLogEditPart.VISUAL_ID:
        return DebugLogViewFactory.class.newInstance();
      case DebugLogNameEditPart.VISUAL_ID:
        return DebugLogNameViewFactory.class.newInstance();
      case OpenDBConnectionEditPart.VISUAL_ID:
        return OpenDBConnectionViewFactory.class.newInstance();
      case OpenDBConnectionNameEditPart.VISUAL_ID:
        return OpenDBConnectionNameViewFactory.class.newInstance();
      case CloseDBConnectionEditPart.VISUAL_ID:
        return CloseDBConnectionViewFactory.class.newInstance();
      case CloseDBConnectionNameEditPart.VISUAL_ID:
        return CloseDBConnectionNameViewFactory.class.newInstance();
      case OpenQueryEditPart.VISUAL_ID:
        return OpenQueryViewFactory.class.newInstance();
      case OpenQueryNameEditPart.VISUAL_ID:
        return OpenQueryNameViewFactory.class.newInstance();
      case SetQueryParamEditPart.VISUAL_ID:
        return SetQueryParamViewFactory.class.newInstance();
      case SetQueryParamNameEditPart.VISUAL_ID:
        return SetQueryParamNameViewFactory.class.newInstance();
      case ExecuteUpdateEditPart.VISUAL_ID:
        return ExecuteUpdateViewFactory.class.newInstance();
      case ExecuteUpdateNameEditPart.VISUAL_ID:
        return ExecuteUpdateNameViewFactory.class.newInstance();
      case ExecuteQueryEditPart.VISUAL_ID:
        return ExecuteQueryViewFactory.class.newInstance();
      case ExecuteQueryNameEditPart.VISUAL_ID:
        return ExecuteQueryNameViewFactory.class.newInstance();
      case NextRowEditPart.VISUAL_ID:
        return NextRowViewFactory.class.newInstance();
      case NextRowNameEditPart.VISUAL_ID:
        return NextRowNameViewFactory.class.newInstance();
      case GetColValueEditPart.VISUAL_ID:
        return GetColValueViewFactory.class.newInstance();
      case GetColValueNameEditPart.VISUAL_ID:
        return GetColValueNameViewFactory.class.newInstance();
      case SetColValueEditPart.VISUAL_ID:
        return SetColValueViewFactory.class.newInstance();
      case SetColValueNameEditPart.VISUAL_ID:
        return SetColValueNameViewFactory.class.newInstance();
      case UpdatetRowEditPart.VISUAL_ID:
        return UpdatetRowViewFactory.class.newInstance();
      case UpdatetRowNameEditPart.VISUAL_ID:
        return UpdatetRowNameViewFactory.class.newInstance();
      case MoveToRowEditPart.VISUAL_ID:
        return MoveToRowViewFactory.class.newInstance();
      case MoveToRowNameEditPart.VISUAL_ID:
        return MoveToRowNameViewFactory.class.newInstance();
      case MoveToLastRowEditPart.VISUAL_ID:
        return MoveToLastRowViewFactory.class.newInstance();
      case MoveToLastRowNameEditPart.VISUAL_ID:
        return MoveToLastRowNameViewFactory.class.newInstance();
      case DeleteRowEditPart.VISUAL_ID:
        return DeleteRowViewFactory.class.newInstance();
      case DeleteRowNameEditPart.VISUAL_ID:
        return DeleteRowNameViewFactory.class.newInstance();
      case MoveToInsertRowEditPart.VISUAL_ID:
        return MoveToInsertRowViewFactory.class.newInstance();
      case MoveToInsertRowNameEditPart.VISUAL_ID:
        return MoveToInsertRowNameViewFactory.class.newInstance();
      case InsertRowEditPart.VISUAL_ID:
        return InsertRowViewFactory.class.newInstance();
      case InsertRowNameEditPart.VISUAL_ID:
        return InsertRowNameViewFactory.class.newInstance();
      case MoveToFirstRowEditPart.VISUAL_ID:
        return MoveToFirstRowViewFactory.class.newInstance();
      case MoveToFirstRowNameEditPart.VISUAL_ID:
        return MoveToFirstRowNameViewFactory.class.newInstance();
      case PreviousRowEditPart.VISUAL_ID:
        return PreviousRowViewFactory.class.newInstance();
      case PreviousRowNameEditPart.VISUAL_ID:
        return PreviousRowNameViewFactory.class.newInstance();
      case GetColValuesEditPart.VISUAL_ID:
        return GetColValuesViewFactory.class.newInstance();
      case GetColValuesNameEditPart.VISUAL_ID:
        return GetColValuesNameViewFactory.class.newInstance();
      case SetColValuesEditPart.VISUAL_ID:
        return SetColValuesViewFactory.class.newInstance();
      case SetColValuesNameEditPart.VISUAL_ID:
        return SetColValuesNameViewFactory.class.newInstance();
      case RunQueryEditPart.VISUAL_ID:
        return RunQueryViewFactory.class.newInstance();
      case RunQueryNameEditPart.VISUAL_ID:
        return RunQueryNameViewFactory.class.newInstance();
      case OutputEditPart.VISUAL_ID:
        return OutputViewFactory.class.newInstance();
      case CaseItemEditPart.VISUAL_ID:
        return CaseItemViewFactory.class.newInstance();
      case CaseItemLabelTextEditPart.VISUAL_ID:
        return CaseItemLabelTextViewFactory.class.newInstance();
      case AudioFileItemEditPart.VISUAL_ID:
        return AudioFileItemViewFactory.class.newInstance();
      case AudioFileItemLabelTextEditPart.VISUAL_ID:
        return AudioFileItemLabelTextViewFactory.class.newInstance();
      case GetColMappingEditPart.VISUAL_ID:
        return GetColMappingViewFactory.class.newInstance();
      case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
        return GetColMappingGetAsDatatypeViewFactory.class.newInstance();
      case SetColMappingEditPart.VISUAL_ID:
        return SetColMappingViewFactory.class.newInstance();
      case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
        return SetColMappingSetAsDatatypeViewFactory.class.newInstance();
      case QueryParamMappingEditPart.VISUAL_ID:
        return QueryParamMappingViewFactory.class.newInstance();
      case WrapLabelEditPart.VISUAL_ID:
        return WrapLabelViewFactory.class.newInstance();
      case ChoiceItemPanelEditPart.VISUAL_ID:
        return ChoiceItemPanelViewFactory.class.newInstance();
      case GetColValuesValuesPanelEditPart.VISUAL_ID:
        return GetColValuesValuesPanelViewFactory.class.newInstance();
      case SetColValuesValuesPanelEditPart.VISUAL_ID:
        return SetColValuesValuesPanelViewFactory.class.newInstance();
      case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
        return RunQueryRunQueryValuesPanelViewFactory.class.newInstance();
      default:
        String id = String.valueOf(visualID);
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {
          BasicNodeViewFactory f = p.viewFactory.createShapeViewFactory(visualID);
          if (f != null)
            return f;
          // if (p.semanticHint.equals(id))
          // return ActionstepViewFactory.class;
          // else
          // if (p.labelSemanticHint.equals(id))
          // return ActionstepNameLabelViewFactory.class;
        }
        return null;
    }
  	} catch (Exception e) {
			e.printStackTrace();
			Log
			.error(
				DiagramPlugin.getInstance(),
				DiagramStatusCodes.SERVICE_FAILURE,
				"Element  (" + visualID + ") is missing a proper creation Factory", e); //$NON-NLS-1$//$NON-NLS-2$
		}
  	return null;
  }
  /**
   * @generated NOT
   */
  protected Class getNodeViewClass(View containerView, int visualID) {
    if (containerView == null || !AsteriskVisualIDRegistry.canCreateNode(containerView, visualID)) {
      return null;
    }
    switch (visualID) {
      case AssignmentEditPart.VISUAL_ID:
        return AssignmentViewFactory.class;
      case AssignmentNameEditPart.VISUAL_ID:
        return AssignmentNameViewFactory.class;
      case ChoiceEditPart.VISUAL_ID:
        return ChoiceViewFactory.class;
      case ChoiceNameEditPart.VISUAL_ID:
        return ChoiceNameViewFactory.class;
      case IfThenEditPart.VISUAL_ID:
        return IfThenViewFactory.class;
      case IfThenNameEditPart.VISUAL_ID:
        return IfThenNameViewFactory.class;
      case ExecuteScriptEditPart.VISUAL_ID:
        return ExecuteScriptViewFactory.class;
      case ExecuteScriptNameEditPart.VISUAL_ID:
        return ExecuteScriptNameViewFactory.class;
      case InvokeSafletEditPart.VISUAL_ID:
        return InvokeSafletViewFactory.class;
      case InvokeSafletNameEditPart.VISUAL_ID:
        return InvokeSafletNameViewFactory.class;
      case InvokeSafletLabelTextEditPart.VISUAL_ID:
        return InvokeSafletLabelTextViewFactory.class;
      case DebugLogEditPart.VISUAL_ID:
        return DebugLogViewFactory.class;
      case DebugLogNameEditPart.VISUAL_ID:
        return DebugLogNameViewFactory.class;
      case OpenDBConnectionEditPart.VISUAL_ID:
        return OpenDBConnectionViewFactory.class;
      case OpenDBConnectionNameEditPart.VISUAL_ID:
        return OpenDBConnectionNameViewFactory.class;
      case CloseDBConnectionEditPart.VISUAL_ID:
        return CloseDBConnectionViewFactory.class;
      case CloseDBConnectionNameEditPart.VISUAL_ID:
        return CloseDBConnectionNameViewFactory.class;
      case OpenQueryEditPart.VISUAL_ID:
        return OpenQueryViewFactory.class;
      case OpenQueryNameEditPart.VISUAL_ID:
        return OpenQueryNameViewFactory.class;
      case SetQueryParamEditPart.VISUAL_ID:
        return SetQueryParamViewFactory.class;
      case SetQueryParamNameEditPart.VISUAL_ID:
        return SetQueryParamNameViewFactory.class;
      case ExecuteUpdateEditPart.VISUAL_ID:
        return ExecuteUpdateViewFactory.class;
      case ExecuteUpdateNameEditPart.VISUAL_ID:
        return ExecuteUpdateNameViewFactory.class;
      case ExecuteQueryEditPart.VISUAL_ID:
        return ExecuteQueryViewFactory.class;
      case ExecuteQueryNameEditPart.VISUAL_ID:
        return ExecuteQueryNameViewFactory.class;
      case NextRowEditPart.VISUAL_ID:
        return NextRowViewFactory.class;
      case NextRowNameEditPart.VISUAL_ID:
        return NextRowNameViewFactory.class;
      case GetColValueEditPart.VISUAL_ID:
        return GetColValueViewFactory.class;
      case GetColValueNameEditPart.VISUAL_ID:
        return GetColValueNameViewFactory.class;
      case SetColValueEditPart.VISUAL_ID:
        return SetColValueViewFactory.class;
      case SetColValueNameEditPart.VISUAL_ID:
        return SetColValueNameViewFactory.class;
      case UpdatetRowEditPart.VISUAL_ID:
        return UpdatetRowViewFactory.class;
      case UpdatetRowNameEditPart.VISUAL_ID:
        return UpdatetRowNameViewFactory.class;
      case MoveToRowEditPart.VISUAL_ID:
        return MoveToRowViewFactory.class;
      case MoveToRowNameEditPart.VISUAL_ID:
        return MoveToRowNameViewFactory.class;
      case MoveToLastRowEditPart.VISUAL_ID:
        return MoveToLastRowViewFactory.class;
      case MoveToLastRowNameEditPart.VISUAL_ID:
        return MoveToLastRowNameViewFactory.class;
      case DeleteRowEditPart.VISUAL_ID:
        return DeleteRowViewFactory.class;
      case DeleteRowNameEditPart.VISUAL_ID:
        return DeleteRowNameViewFactory.class;
      case MoveToInsertRowEditPart.VISUAL_ID:
        return MoveToInsertRowViewFactory.class;
      case MoveToInsertRowNameEditPart.VISUAL_ID:
        return MoveToInsertRowNameViewFactory.class;
      case InsertRowEditPart.VISUAL_ID:
        return InsertRowViewFactory.class;
      case InsertRowNameEditPart.VISUAL_ID:
        return InsertRowNameViewFactory.class;
      case MoveToFirstRowEditPart.VISUAL_ID:
        return MoveToFirstRowViewFactory.class;
      case MoveToFirstRowNameEditPart.VISUAL_ID:
        return MoveToFirstRowNameViewFactory.class;
      case PreviousRowEditPart.VISUAL_ID:
        return PreviousRowViewFactory.class;
      case PreviousRowNameEditPart.VISUAL_ID:
        return PreviousRowNameViewFactory.class;
      case GetColValuesEditPart.VISUAL_ID:
        return GetColValuesViewFactory.class;
      case GetColValuesNameEditPart.VISUAL_ID:
        return GetColValuesNameViewFactory.class;
      case SetColValuesEditPart.VISUAL_ID:
        return SetColValuesViewFactory.class;
      case SetColValuesNameEditPart.VISUAL_ID:
        return SetColValuesNameViewFactory.class;
      case RunQueryEditPart.VISUAL_ID:
        return RunQueryViewFactory.class;
      case RunQueryNameEditPart.VISUAL_ID:
        return RunQueryNameViewFactory.class;
      case OutputEditPart.VISUAL_ID:
        return OutputViewFactory.class;
      case CaseItemEditPart.VISUAL_ID:
        return CaseItemViewFactory.class;
      case CaseItemLabelTextEditPart.VISUAL_ID:
        return CaseItemLabelTextViewFactory.class;
      case AudioFileItemEditPart.VISUAL_ID:
        return AudioFileItemViewFactory.class;
      case AudioFileItemLabelTextEditPart.VISUAL_ID:
        return AudioFileItemLabelTextViewFactory.class;
      case GetColMappingEditPart.VISUAL_ID:
        return GetColMappingViewFactory.class;
      case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
        return GetColMappingGetAsDatatypeViewFactory.class;
      case SetColMappingEditPart.VISUAL_ID:
        return SetColMappingViewFactory.class;
      case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
        return SetColMappingSetAsDatatypeViewFactory.class;
      case QueryParamMappingEditPart.VISUAL_ID:
        return QueryParamMappingViewFactory.class;
      case WrapLabelEditPart.VISUAL_ID:
        return WrapLabelViewFactory.class;
      case ChoiceItemPanelEditPart.VISUAL_ID:
        return ChoiceItemPanelViewFactory.class;
      case GetColValuesValuesPanelEditPart.VISUAL_ID:
        return GetColValuesValuesPanelViewFactory.class;
      case SetColValuesValuesPanelEditPart.VISUAL_ID:
        return SetColValuesValuesPanelViewFactory.class;
      case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
        return RunQueryRunQueryValuesPanelViewFactory.class;
      default:
        String id = String.valueOf(visualID);
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {
          BasicNodeViewFactory f = p.viewFactory.createShapeViewFactory(visualID);
          if (f != null)
            return f.getClass();
          // if (p.semanticHint.equals(id))
          // return ActionstepViewFactory.class;
          // else
          // if (p.labelSemanticHint.equals(id))
          // return ActionstepNameLabelViewFactory.class;
        }
        return null;
    }
  }

  /**
   * @generated
   */
  //@Override
  protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView,
      String semanticHint) {
    IElementType elementType = getSemanticElementType(semanticAdapter);
    if (!AsteriskElementTypes.isKnownElementType(elementType)
        || (!(elementType instanceof IHintedType))) {
      return null; // foreign element type
    }
    String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
    if (elementTypeHint == null) {
      return null; // our hint is visual id and must be specified
    }
    if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
      return null; // if semantic hint is specified it should be the same as in element
      // type
    }
    int visualID = AsteriskVisualIDRegistry.getVisualID(elementTypeHint);
    EObject domainElement = getSemanticElement(semanticAdapter);
    if (domainElement != null
        && visualID != AsteriskVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
      return null; // visual id for link EClass should match visual id from element type
    }
    return getEdgeViewClass(visualID);
  }

  /**
   * @generated
   */
  protected Class getEdgeViewClass(int visualID) {
    switch (visualID) {
      case OutputTargetEditPart.VISUAL_ID:
        return OutputTargetViewFactory.class;
      case CaseItemTargetToolstepEditPart.VISUAL_ID:
        return CaseItemTargetToolstepViewFactory.class;
    }
    return null;
  }

  /**
   * @generated
   */
  private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
    if (semanticAdapter == null) {
      return null;
    }
    return (IElementType) semanticAdapter.getAdapter(IElementType.class);
  }
}
