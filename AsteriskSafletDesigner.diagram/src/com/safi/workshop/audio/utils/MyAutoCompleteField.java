package com.safi.workshop.audio.utils;

/*******************************************************************************
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;

/**
 * AutoCompleteField is a class which attempts to auto-complete a user's keystrokes by
 * activating a popup that filters a list of proposals according to the content typed by
 * the user.
 * 
 * @see ContentProposalAdapter
 * @see SimpleContentProposalProvider
 * 
 * @since 3.3
 */
public class MyAutoCompleteField {

  private SimpleContentProposalProvider proposalProvider;
  private ContentProposalAdapter adapter;

  /**
   * Construct an AutoComplete field on the specified control, whose completions are
   * characterized by the specified array of Strings.
   * 
   * @param control
   *          the control for which autocomplete is desired. May not be <code>null</code>.
   * @param controlContentAdapter
   *          the <code>IControlContentAdapter</code> used to obtain and update the
   *          control's contents. May not be <code>null</code>.
   * @param proposals
   *          the array of Strings representing valid content proposals for the field.
   */
  public MyAutoCompleteField(Control control, IControlContentAdapter controlContentAdapter,
      String[] proposals) {
    proposalProvider = new SimpleContentProposalProvider(proposals);
    proposalProvider.setFiltering(true);
    KeyStroke stroke = KeyStroke.getInstance(SWT.CTRL, ' ');
    adapter = new ContentProposalAdapter(control, controlContentAdapter, proposalProvider, null,
        null);
    adapter.setPropagateKeys(true);
    adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
    adapter.setAutoActivationDelay(2000);
  }

  /**
   * Set the Strings to be used as content proposals.
   * 
   * @param proposals
   *          the array of Strings to be used as proposals.
   */
  public void setProposals(String[] proposals) {
    proposalProvider.setProposals(proposals);
  }

  public ContentProposalAdapter getAdapter() {
    return adapter;
  }
}
