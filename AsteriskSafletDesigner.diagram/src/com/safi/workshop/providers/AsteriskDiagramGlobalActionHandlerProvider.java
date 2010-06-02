package com.safi.workshop.providers;

import java.util.Hashtable;

import org.eclipse.gmf.runtime.common.ui.services.action.global.AbstractGlobalActionHandlerProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

public class AsteriskDiagramGlobalActionHandlerProvider extends AbstractGlobalActionHandlerProvider {

  /**
   * List that contains all the IGlobalActionHandlers mapped to the IWorkbenchParts
   */
  private Hashtable<IWorkbenchPart, IGlobalActionHandler> handlerList = new Hashtable<IWorkbenchPart, IGlobalActionHandler>();

  public AsteriskDiagramGlobalActionHandlerProvider() {
    // TODO Auto-generated constructor stub
  }

  // @Override
  // public IGlobalActionHandler getGlobalActionHandler(IGlobalActionHandlerContext
  // context) {
  // // TODO Auto-generated method stub
  // return new AsteriskDiagramGlobalActionHandler();
  // }

  @Override
  public IGlobalActionHandler getGlobalActionHandler(final IGlobalActionHandlerContext context) {
    /* create the handler */
    if (!getHandlerList().containsKey(context.getActivePart())) {
      getHandlerList().put(context.getActivePart(), new AsteriskDiagramGlobalActionHandler());
      /*
       * register as a part listener so that the cache can be cleared when the part is
       * disposed
       */
      context.getActivePart().getSite().getPage().addPartListener(new IPartListener() {

        private IWorkbenchPart localPart = context.getActivePart();

        /**
         * @see org.eclipse.ui.IPartListener#partActivated(IWorkbenchPart)
         */
        public void partActivated(IWorkbenchPart part) {
          // NULL implementation
        }

        /**
         * @see org.eclipse.ui.IPartListener#partBroughtToTop(IWorkbenchPart)
         */
        public void partBroughtToTop(IWorkbenchPart part) {
          // NULL implementation
        }

        /**
         * @see org.eclipse.ui.IPartListener#partClosed(IWorkbenchPart)
         */
        public void partClosed(IWorkbenchPart part) {
          /* remove the cache associated with the part */
          if (part != null && part == localPart && getHandlerList().containsKey(part)) {
            getHandlerList().remove(part);
            localPart.getSite().getPage().removePartListener(this);
            localPart = null;
          }
        }

        /**
         * @see org.eclipse.ui.IPartListener#partDeactivated(IWorkbenchPart)
         */
        public void partDeactivated(IWorkbenchPart part) {
          // NULL implementation
        }

        /**
         * @see org.eclipse.ui.IPartListener#partOpened(IWorkbenchPart)
         */
        public void partOpened(IWorkbenchPart part) {
          // NULL implementation
        }
      });
    }
    return getHandlerList().get(context.getActivePart());
  }

  /**
   * Returns the handlerList.
   * 
   * @return Hashtable
   */
  private Hashtable<IWorkbenchPart, IGlobalActionHandler> getHandlerList() {
    return handlerList;
  }
}
