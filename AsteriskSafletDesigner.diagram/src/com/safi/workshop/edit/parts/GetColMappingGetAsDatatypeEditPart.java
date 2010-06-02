/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.GetColMapping;
import com.safi.workshop.edit.policies.AsteriskTextSelectionEditPolicy;
import com.safi.workshop.providers.AsteriskElementTypes;
import com.safi.workshop.providers.AsteriskParserProvider;

/**
 * @generated
 */
public class GetColMappingGetAsDatatypeEditPart extends CompartmentEditPart implements
    ITextAwareEditPart {

  private static final int MAX_COLMAPPINGNAME_LEN = 15;

  /**
   * @generated
   */
  public static final int VISUAL_ID = 4097;

  /**
   * @generated
   */
  private DirectEditManager manager;

  /**
   * @generated
   */
  private IParser parser;

  /**
   * @generated
   */
  private List parserElements;

  /**
   * @generated
   */
  private String defaultText;

  private Adapter columnAdapter;

  /**
   * @generated
   */
  public GetColMappingGetAsDatatypeEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
    installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicy() {

      @Override
      protected List createSelectionHandles() {
        List handles = new ArrayList();
        NonResizableHandleKit.addMoveHandle((GraphicalEditPart) getHost(), handles);
        return handles;
      }

      @Override
      public Command getCommand(Request request) {
        return null;
      }

      @Override
      public boolean understandsRequest(Request request) {
        return false;
      }
    });
  }

  /**
   * @generated
   */
  protected String getLabelTextHelper(IFigure figure) {
    if (figure instanceof WrapLabel) {
      return ((WrapLabel) figure).getText();
    } else {
      return ((Label) figure).getText();
    }
  }

  /**
   * @generated
   */
  protected void setLabelTextHelper(IFigure figure, String text) {
    if (figure instanceof WrapLabel) {
      ((WrapLabel) figure).setText(text);
    } else {
      ((Label) figure).setText(text);
    }
  }

  /**
   * @generated
   */
  protected Image getLabelIconHelper(IFigure figure) {
    if (figure instanceof WrapLabel) {
      return ((WrapLabel) figure).getIcon();
    } else {
      return ((Label) figure).getIcon();
    }
  }

  /**
   * @generated
   */
  protected void setLabelIconHelper(IFigure figure, Image icon) {
    if (figure instanceof WrapLabel) {
      ((WrapLabel) figure).setIcon(icon);
    } else {
      ((Label) figure).setIcon(icon);
    }
  }

  /**
   * @generated
   */
  public void setLabel(WrapLabel figure) {
    unregisterVisuals();
    setFigure(figure);
    defaultText = getLabelTextHelper(figure);
    registerVisuals();
    refreshVisuals();
  }

  /**
   * @generated
   */
  @Override
  protected List getModelChildren() {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  @Override
  public IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
    return null;
  }

  /**
   * @generated
   */
  protected EObject getParserElement() {
    return resolveSemanticElement();
  }

  /**
   * @generated
   */
  protected Image getLabelIcon() {
    return null;
  }

  /**
   * @generated NOT
   */
  protected String getLabelText() {
    // SetColMapping mapping = (SetColMapping)resolveSemanticElement();
    // return mapping.getColumn() == null ? "" : mapping.getColumn().getText();

    String text = null;
    EObject parserElement = getParserElement();
    GetColMapping mapping = (GetColMapping) parserElement;
    text = mapping.getColumn() == null ? "-not set-" : mapping.getColumn().getText();
    if (text != null && text.length() > MAX_COLMAPPINGNAME_LEN)
      return text.substring(0, MAX_COLMAPPINGNAME_LEN - 3) + "...";
    return text;
    // if (parserElement != null && getParser() != null) {
    // text = getParser().getPrintString(new EObjectAdapter(parserElement),
    // getParserOptions().intValue());
    // }
    // if (text == null || text.length() == 0) {
    // text = defaultText;
    // }
    // return text;
  }

  @Override
  public void setModel(Object model) {
    Adapter adapter = getColumnAdapter();
    GetColMapping oldMapping = getColMappingModel();
    super.setModel(model);
    GetColMapping newMapping = getColMappingModel();
    if (oldMapping != null && newMapping != oldMapping) {
      oldMapping.eAdapters().remove(adapter);
    }
    if (newMapping != null)
      newMapping.eAdapters().add(adapter);
  }

  public GetColMapping getColMappingModel() {
    if (basicGetModel() == null)
      return null;
    return (GetColMapping) resolveSemanticElement();
  }

  @Override
  public void deactivate() {
    Adapter adapter = getColumnAdapter();
    GetColMapping oldMapping = getColMappingModel();
    if (oldMapping != null)
      oldMapping.eAdapters().remove(adapter);
    ((ColAdapter) adapter).dispose();
    super.deactivate();
  }

  /**
   * @generated
   */
  public void setLabelText(String text) {
    setLabelTextHelper(getFigure(), text);
    Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
    if (pdEditPolicy instanceof AsteriskTextSelectionEditPolicy) {
      ((AsteriskTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
    }
  }

  /**
   * @generated
   */
  public String getEditText() {
    if (getParserElement() == null || getParser() == null) {
      return ""; //$NON-NLS-1$
    }
    return getParser().getEditString(new EObjectAdapter(getParserElement()),
        getParserOptions().intValue());
  }

  /**
   * @generated
   */
  protected boolean isEditable() {
    return false;
  }

  /**
   * @generated
   */
  public ICellEditorValidator getEditTextValidator() {
    return new ICellEditorValidator() {

      public String isValid(final Object value) {
        if (value instanceof String) {
          final EObject element = getParserElement();
          final IParser parser = getParser();
          try {
            IParserEditStatus valid = (IParserEditStatus) getEditingDomain().runExclusive(
                new RunnableWithResult.Impl() {

                  public void run() {
                    setResult(parser.isValidEditString(new EObjectAdapter(element), (String) value));
                  }
                });
            return valid.getCode() == IParserEditStatus.EDITABLE ? null : valid.getMessage();
          } catch (InterruptedException ie) {
            ie.printStackTrace();
          }
        }

        // shouldn't get here
        return null;
      }
    };
  }

  /**
   * @generated
   */
  public IContentAssistProcessor getCompletionProcessor() {
    if (getParserElement() == null || getParser() == null) {
      return null;
    }
    return getParser().getCompletionProcessor(new EObjectAdapter(getParserElement()));
  }

  /**
   * @generated
   */
  public ParserOptions getParserOptions() {
    return ParserOptions.NONE;
  }

  /**
   * @generated
   */
  public IParser getParser() {
    if (parser == null) {
      String parserHint = ((View) getModel()).getType();
      IAdaptable hintAdapter = new AsteriskParserProvider.HintAdapter(
          AsteriskElementTypes.GetColMapping_2004, getParserElement(), parserHint);
      parser = ParserService.getInstance().getParser(hintAdapter);
    }
    return parser;
  }

  /**
   * @generated
   */
  protected DirectEditManager getManager() {
    if (manager == null) {
      setManager(new TextDirectEditManager(this,
          TextDirectEditManager.getTextCellEditorClass(this), AsteriskEditPartFactory
              .getTextCellEditorLocator(this)));
    }
    return manager;
  }

  /**
   * @generated
   */
  protected void setManager(DirectEditManager manager) {
    this.manager = manager;
  }

  /**
   * @generated
   */
  protected void performDirectEdit() {
    getManager().show();
  }

  /**
   * @generated
   */
  protected void performDirectEdit(Point eventLocation) {
    if (getManager().getClass() == TextDirectEditManager.class) {
      ((TextDirectEditManager) getManager()).show(eventLocation.getSWTPoint());
    }
  }

  /**
   * @generated
   */
  private void performDirectEdit(char initialCharacter) {
    if (getManager() instanceof TextDirectEditManager) {
      ((TextDirectEditManager) getManager()).show(initialCharacter);
    } else {
      performDirectEdit();
    }
  }

  /**
   * @generated
   */
  @Override
  protected void performDirectEditRequest(Request request) {
    final Request theRequest = request;
    try {
      getEditingDomain().runExclusive(new Runnable() {

        public void run() {
          if (isActive() && isEditable()) {
            if (theRequest.getExtendedData().get(
                RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
              Character initialChar = (Character) theRequest.getExtendedData().get(
                  RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
              performDirectEdit(initialChar.charValue());
            } else if ((theRequest instanceof DirectEditRequest)
                && (getEditText().equals(getLabelText()))) {
              DirectEditRequest editRequest = (DirectEditRequest) theRequest;
              performDirectEdit(editRequest.getLocation());
            } else {
              performDirectEdit();
            }
          }
        }
      });
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * @generated
   */
  @Override
  protected void refreshVisuals() {
    super.refreshVisuals();
    refreshLabel();
    refreshFont();
    refreshFontColor();
    refreshUnderline();
    refreshStrikeThrough();
  }

  /**
   * @generated
   */
  protected void refreshLabel() {
    setLabelTextHelper(getFigure(), getLabelText());
    setLabelIconHelper(getFigure(), getLabelIcon());
    Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
    if (pdEditPolicy instanceof AsteriskTextSelectionEditPolicy) {
      ((AsteriskTextSelectionEditPolicy) pdEditPolicy).refreshFeedback();
    }
  }

  /**
   * @generated
   */
  protected void refreshUnderline() {
    FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(
        NotationPackage.eINSTANCE.getFontStyle());
    if (style != null && getFigure() instanceof WrapLabel) {
      ((WrapLabel) getFigure()).setTextUnderline(style.isUnderline());
    }
  }

  /**
   * @generated
   */
  protected void refreshStrikeThrough() {
    FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(
        NotationPackage.eINSTANCE.getFontStyle());
    if (style != null && getFigure() instanceof WrapLabel) {
      ((WrapLabel) getFigure()).setTextStrikeThrough(style.isStrikeThrough());
    }
  }

  /**
   * @generated
   */
  @Override
  protected void refreshFont() {
    FontStyle style = (FontStyle) getFontStyleOwnerView().getStyle(
        NotationPackage.eINSTANCE.getFontStyle());
    if (style != null) {
      FontData fontData = new FontData(style.getFontName(), style.getFontHeight(),
          (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
      setFont(fontData);
    }
  }

  /**
   * @generated
   */
  @Override
  protected void setFontColor(Color color) {
    getFigure().setForegroundColor(color);
  }

  /**
   * @generated
   */
  @Override
  protected void addSemanticListeners() {
    if (getParser() instanceof ISemanticParser) {
      EObject element = resolveSemanticElement();
      parserElements = ((ISemanticParser) getParser()).getSemanticElementsBeingParsed(element);
      for (int i = 0; i < parserElements.size(); i++) {
        addListenerFilter("SemanticModel" + i, this, (EObject) parserElements.get(i)); //$NON-NLS-1$
      }
    } else {
      super.addSemanticListeners();
    }
  }

  /**
   * @generated
   */
  @Override
  protected void removeSemanticListeners() {
    if (parserElements != null) {
      for (int i = 0; i < parserElements.size(); i++) {
        removeListenerFilter("SemanticModel" + i); //$NON-NLS-1$
      }
    } else {
      super.removeSemanticListeners();
    }
  }

  /**
   * @generated
   */
  @Override
  protected AccessibleEditPart getAccessibleEditPart() {
    if (accessibleEP == null) {
      accessibleEP = new AccessibleGraphicalEditPart() {

        @Override
        public void getName(AccessibleEvent e) {
          e.result = getLabelTextHelper(getFigure());
        }
      };
    }
    return accessibleEP;
  }

  /**
   * @generated
   */
  private View getFontStyleOwnerView() {
    return getPrimaryView();
  }

  /**
   * @generated
   */
  @Override
  protected void addNotationalListeners() {
    super.addNotationalListeners();
    addListenerFilter("PrimaryView", this, getPrimaryView()); //$NON-NLS-1$
  }

  /**
   * @generated
   */
  @Override
  protected void removeNotationalListeners() {
    super.removeNotationalListeners();
    removeListenerFilter("PrimaryView"); //$NON-NLS-1$
  }

  /**
   * @generated
   */
  @Override
  protected void handleNotificationEvent(Notification event) {
    Object feature = event.getFeature();
    if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
      Integer c = (Integer) event.getNewValue();
      setFontColor(DiagramColorRegistry.getInstance().getColor(c));
    } else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
      refreshUnderline();
    } else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
      refreshStrikeThrough();
    } else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature)
        || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
        || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature)
        || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
      refreshFont();
    } else {
      if (getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {
        refreshLabel();
      }
      if (getParser() instanceof ISemanticParser) {
        ISemanticParser modelParser = (ISemanticParser) getParser();
        if (modelParser.areSemanticElementsAffected(null, event)) {
          removeSemanticListeners();
          if (resolveSemanticElement() != null) {
            addSemanticListeners();
          }
          refreshLabel();
        }
      }
    }
    super.handleNotificationEvent(event);
  }

  /**
   * @generated
   */
  @Override
  protected IFigure createFigure() {
    // Parent should assign one using setLabel() method
    return null;
  }

  private Adapter getColumnAdapter() {
    if (columnAdapter == null) {
      // TODO Auto-generated method stub
      columnAdapter = new ColAdapter();
    }
    return columnAdapter;
  }

  class ColAdapter implements Adapter {

    DynamicValue oldValue;

    @Override
    public Notifier getTarget() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public boolean isAdapterForType(Object type) {
      if (type instanceof GetColMapping)
        return true;
      return false;
    }

    public void dispose() {
      if (oldValue != null)
        oldValue.eAdapters().remove(this);
    }

    @Override
    public void notifyChanged(Notification notification) {
      // TODO Auto-generated method stub
      if (notification.getEventType() == Notification.SET
          && ActionStepPackage.eINSTANCE.getGetColMapping_Column() == notification.getFeature()
          && (notification.getNotifier() instanceof GetColMapping)) {
        GetColMapping mapping = (GetColMapping) notification.getNotifier();
        if (oldValue != null)
          oldValue.eAdapters().remove(this);

        DynamicValue newVal = null;
        if (mapping != null) {
          newVal = mapping.getColumn();
          if (newVal != null)
            newVal.eAdapters().add(this);
        }
        oldValue = newVal;
        refreshLabel();

      } else if (notification.getNotifier() instanceof DynamicValue
          && notification.getEventType() == Notification.SET) {
        refreshLabel();
      }
    }

    @Override
    public void setTarget(Notifier newTarget) {
      // TODO Auto-generated method stub

    }

  }
}
