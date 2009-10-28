package com.safi.workshop.sheet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.javascript.internal.ui.text.completion.JavaScriptCompletionProposalCollector;
import org.eclipse.dltk.javascript.internal.ui.text.completion.JavaScriptTypeCompletionProposalComputer;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.dltk.ui.text.completion.ContentAssistInvocationContext;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.dltk.ui.text.completion.ScriptTextMessages;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

public class SafiJavaScriptTypeCompletionProposalComputer extends
    JavaScriptTypeCompletionProposalComputer {

	private String fErrorMessage;
	
	public SafiJavaScriptTypeCompletionProposalComputer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ScriptCompletionProposalCollector createCollector(
	    ScriptContentAssistInvocationContext context) {
		return new SafiJavaScriptCompletionProposalCollector(context
				.getSourceModule());
	}
	
	private void handleCodeCompletionException(ModelException e,
			ScriptContentAssistInvocationContext context) {
		ISourceModule module = context.getSourceModule();
		Shell shell = context.getViewer().getTextWidget().getShell();
		if (e.isDoesNotExist()
				&& !module.getScriptProject().isOnBuildpath(module)) {
			IPreferenceStore store = DLTKUIPlugin.getDefault()
					.getPreferenceStore();
			boolean value = store
					.getBoolean(PreferenceConstants.NOTIFICATION_NOT_ON_BUILDPATH_MESSAGE);
			if (!value) {
				MessageDialog
						.openInformation(
								shell,
								ScriptTextMessages.CompletionProcessor_error_notOnBuildPath_title,
								ScriptTextMessages.CompletionProcessor_error_notOnBuildPath_message);
			}
			store.setValue(
					PreferenceConstants.NOTIFICATION_NOT_ON_BUILDPATH_MESSAGE,
					true);
		} else
			ErrorDialog
					.openError(
							shell,
							ScriptTextMessages.CompletionProcessor_error_accessing_title,
							ScriptTextMessages.CompletionProcessor_error_accessing_message,
							e.getStatus());
	}
	
	@Override
	protected List computeScriptCompletionProposals(int offset,
	    ScriptContentAssistInvocationContext context, IProgressMonitor monitor) {
	 
		// Source module getting
		ISourceModule sourceModule = context.getSourceModule();
		if (sourceModule == null) {
			return Collections.EMPTY_LIST;
		}

		// Create and configure collector
		ScriptCompletionProposalCollector collector = createCollector(context);
		if (collector == null) {
			return Collections.EMPTY_LIST;
		}

		collector.setInvocationContext(context);
		Point selection = context.getViewer().getSelectedRange();
		if (selection.y > 0) {
			collector.setReplacementLength(selection.y);
		}

		// Filling collector with proposals
		try {
			if (DLTKCore.DEBUG_COMPLETION) {
				IModelElement element = sourceModule.getElementAt(offset);
				if (element != null) {
					System.out.println("========= Model element: " //$NON-NLS-1$
							+ element.getClass());
				}
			}
			int timeout = DLTKUIPlugin.getDefault().getPreferenceStore()
					.getInt(PreferenceConstants.CODEASSIST_TIMEOUT);
			sourceModule.codeComplete(offset, collector, timeout);
		} catch (ModelException e) {
			handleCodeCompletionException(e, context);
		}

		ICompletionProposal[] proposals = collector
				.getScriptCompletionProposals();

		// Checking proposals
		if (proposals.length == 0) {
			String error = collector.getErrorMessage();
			if (error.length() > 0) {
				fErrorMessage = error;
			}

			return Collections.EMPTY_LIST;
		}

		return Arrays.asList(proposals);
	}
}
