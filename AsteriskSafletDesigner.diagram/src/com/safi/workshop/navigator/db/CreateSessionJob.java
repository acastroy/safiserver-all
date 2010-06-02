/*
 * Copyright (C) 2007 SQL Explorer Development Team
 * http://sourceforge.net/projects/eclipsesql
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.safi.workshop.navigator.db;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;
import org.hibernate.Session;

import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.Messages;

/**
 * Establishes a connection in the background and notifies a listener when complete; takes
 * care of prompting the user for new username/password credentials if the login fails etc
 * 
 * @author John Spackman
 */
public class CreateSessionJob extends Job {

  // The callback to give the new session to
  private SessionEstablishedListener listener;

  // Whether to ask for the password on the first pass, instead of trying a saved one
  private boolean requirePassword;

  // True if the password dialog was cancelled
  private boolean cancelled;

  /**
   * Constructor
   * 
   * @param alias
   *          Alias to connect
   * @param user
   *          User to establish a connection for (can be null, but if provided
   *          user.getAlias() must match alias)
   * @param listener
   *          Callback listener
   * @param requirePassword
   *          Whether to always prompt the user for a password, even if one is already
   *          known
   */
  public CreateSessionJob(SessionEstablishedListener listener) {
    super("Connecting to production SafiServer");
    this.listener = listener;
  }

  /**
   * Constructor; asks for a password on the first attempt only if the alias.isAutoLogin()
   * is false
   * 
   * @param alias
   *          Alias to connect
   * @param user
   *          User to establish a connection for
   * @param listener
   *          Callback listener
   */
  // public ConnectionJob(Alias alias, User user, SessionEstablishedListener listener) {
  // this(alias, user, listener, !alias.isAutoLogon());
  // }
  /**
   * Constructor; logs in a brand new user
   * 
   * @param alias
   *          Alias to connect
   * @param listener
   *          Callback listener
   */
  // public ConnectionJob(Alias alias, SessionEstablishedListener listener) {
  // this(alias, null, listener, true);
  // }
  @Override
  protected IStatus run(IProgressMonitor monitor) {
    Exception exception = null;
    while (!monitor.isCanceled() && !cancelled) {
      Session session = null;

      // Try to login

      try {
        session = DBManager.getInstance().createSession();

        if (session != null) {

          if (listener != null)
            listener.sessionEstablished(session);
          return new Status(IStatus.OK, getClass().getName(), IStatus.OK, "Session Established",
              null);
        }
      } catch (Exception e) {
        exception = e;
      }
      if (monitor.isCanceled())
        break;
    }

    // Can't do it
    if (listener != null)
      listener.cannotEstablishSession(exception);
    if (exception != null)
      return new Status(IStatus.ERROR, getClass().getName(), IStatus.ERROR,
          "Error occurred while attempting to establish connection", exception);
    else
      return new Status(IStatus.CANCEL, getClass().getName(), IStatus.CANCEL, Messages
          .getString("Progress.Connection.Cancelled"), null);
  }

  /**
   * Establishes a connection in the background
   * 
   * @param alias
   *          Alias to connect
   * @param user
   *          User to establish a connection for
   * @param listener
   *          Callback listener
   * @param requirePassword
   *          Whether to always prompt the user for a password, even if one is already
   *          known
   */
  public static void createSession(SessionEstablishedListener listener) {
    final CreateSessionJob bgJob = new CreateSessionJob(listener);
    final IWorkbenchSite site = AsteriskDiagramEditorUtil.getSafiNavigator().getSite();

    site.getShell().getDisplay().syncExec(new Runnable() {
      public void run() {
        IWorkbenchSiteProgressService siteps = (IWorkbenchSiteProgressService) site
            .getAdapter(IWorkbenchSiteProgressService.class);
        siteps.showInDialog(site.getShell(), bgJob);
        bgJob.schedule();
      }
    });
  }
}
