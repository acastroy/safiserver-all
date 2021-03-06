package com.safi.workshop.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.safi.workshop.expressions.AsteriskAbstractExpression;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

/**
 * @generated
 */
public class ElementInitializers {

  /**
   * @generated
   */
  public static class Initializers {

    /**
     * @generated
     */
    private Initializers() {
    }

    /**
     * @generated
     */
    public static interface IObjectInitializer {

      /**
       * @generated
       */
      public void init(EObject instance);
    }

    /**
     * @generated
     */
    public static abstract class ObjectInitializer implements IObjectInitializer {

      /**
       * @generated
       */
      final EClass element;

      /**
       * @generated
       */
      private List featureInitializers = new ArrayList();

      /**
       * @generated
       */
      ObjectInitializer(EClass element) {
        this.element = element;
        init();
      }

      /**
       * @generated
       */
      protected abstract void init();

      /**
       * @generated
       */
      protected final IFeatureInitializer add(IFeatureInitializer initializer) {
        featureInitializers.add(initializer);
        return initializer;
      }

      /**
       * @generated
       */
      public void init(EObject instance) {
        for (Iterator it = featureInitializers.iterator(); it.hasNext();) {
          IFeatureInitializer nextExpr = (IFeatureInitializer) it.next();
          try {
            nextExpr.init(instance);
          } catch (RuntimeException e) {
            AsteriskDiagramEditorPlugin.getInstance().logError("Feature initialization failed", e); //$NON-NLS-1$						
          }
        }
      }
    }

    /**
     * @generated
     */
    interface IFeatureInitializer {

      /**
       * @generated
       */
      void init(EObject contextInstance);
    }

    /**
     * @generated
     */
    static IFeatureInitializer createNewElementFeatureInitializer(EStructuralFeature initFeature,
        ObjectInitializer[] newObjectInitializers) {
      final EStructuralFeature feature = initFeature;
      final ObjectInitializer[] initializers = newObjectInitializers;
      return new IFeatureInitializer() {

        public void init(EObject contextInstance) {
          for (ObjectInitializer initializer : initializers) {
            EObject newInstance = initializer.element.getEPackage().getEFactoryInstance().create(
                initializer.element);
            if (feature.isMany()) {
              ((Collection) contextInstance.eGet(feature)).add(newInstance);
            } else {
              contextInstance.eSet(feature, newInstance);
            }
            initializer.init(newInstance);
          }
        }
      };
    }

    /**
     * @generated
     */
    static IFeatureInitializer createExpressionFeatureInitializer(EStructuralFeature initFeature,
        AsteriskAbstractExpression valueExpression) {
      final EStructuralFeature feature = initFeature;
      final AsteriskAbstractExpression expression = valueExpression;
      return new IFeatureInitializer() {

        public void init(EObject contextInstance) {
          expression.assignTo(feature, contextInstance);
        }
      };
    }

    /**
     * @generated
     */
    static class Java {
    }
  }
}
