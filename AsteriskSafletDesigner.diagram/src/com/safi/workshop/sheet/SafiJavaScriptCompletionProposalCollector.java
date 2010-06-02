package com.safi.workshop.sheet;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.javascript.reference.resolvers.SelfCompletingReference;
import org.eclipse.dltk.internal.javascript.typeinference.IReference;
import org.eclipse.dltk.javascript.internal.ui.text.completion.JavaScriptCompletionProposal;
import org.eclipse.dltk.javascript.internal.ui.text.completion.JavaScriptCompletionProposalLabelProvider;
import org.eclipse.dltk.javascript.internal.ui.text.completion.JavaScriptOverrideCompletionProposal;
import org.eclipse.dltk.javascript.scriptdoc.ScriptDocumentationProvider;
import org.eclipse.dltk.ui.text.completion.AbstractScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.dltk.ui.text.completion.IScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.ProposalInfo;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.swt.graphics.Image;

public class SafiJavaScriptCompletionProposalCollector extends
    ScriptCompletionProposalCollector {

	protected final static char[] VAR_TRIGGER = new char[] { '\t', ' ', '=', ';', '.' };

	private final HashSet doubleFilter = new HashSet();

	protected char[] getVarTrigger() {
		return VAR_TRIGGER;
	}

	public SafiJavaScriptCompletionProposalCollector(ISourceModule module) {
		super(module);
	}

	// Label provider
	protected CompletionProposalLabelProvider createLabelProvider() {
		return new JavaScriptCompletionProposalLabelProvider();
	}

	// Invocation context
	protected ScriptContentAssistInvocationContext createScriptContentAssistInvocationContext(
	    ISourceModule sourceModule) {
		return new ScriptContentAssistInvocationContext(sourceModule) {
			protected CompletionProposalLabelProvider createLabelProvider() {
				return new JavaScriptCompletionProposalLabelProvider();
			}
		};
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector#beginReporting()
	 */
	public void beginReporting() {
		super.beginReporting();
		doubleFilter.clear();
	}

	/**
	 * @see org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector#isFiltered(org.eclipse.dltk.core.CompletionProposal)
	 */
	protected boolean isFiltered(CompletionProposal proposal) {
		if (!doubleFilter.add(new String(proposal.getName()))) {
			return true;
		}
		return super.isFiltered(proposal);
	}

	// Specific proposals creation. May be use factory?
	protected IScriptCompletionProposal createScriptCompletionProposal(
	    CompletionProposal proposal) {
		// TODO Auto-generated method stub
		final IScriptCompletionProposal createScriptCompletionProposal2 = super
		    .createScriptCompletionProposal(proposal);
		AbstractScriptCompletionProposal createScriptCompletionProposal = (AbstractScriptCompletionProposal) createScriptCompletionProposal2;
		final Object ref = (Object) proposal.extraInfo;

		ProposalInfo proposalInfo = new ProposalInfo(null) {

			public String getInfo(IProgressMonitor monitor) {

				if (ref instanceof SelfCompletingReference
				    && ((SelfCompletingReference) ref).getProposalInfo() != null) {
					return ((SelfCompletingReference) ref).getProposalInfo();
				} else if (ref instanceof IReference) {
					ArrayList ms = new ArrayList();
					((IReference) ref).addModelElements(ms);
					if (ms.size() > 0) {
						Reader contentReader = new ScriptDocumentationProvider().getInfo((IMember) ms
						    .get(0), true, true);
						if (contentReader != null) {
							String string = getString(contentReader);
							return string;
						}
					}
				} else if (ref instanceof IMember) {
					Reader contentReader = new ScriptDocumentationProvider().getInfo((IMember) ref,
					    true, true);
					if (contentReader != null) {
						String string = getString(contentReader);
						return string;
					}
				} else if (ref instanceof String) {
					return (String) ref;
				}
				return "Documentation not resolved";
			}

			/**
			 * Gets the reader content as a String
			 */
			private String getString(Reader reader) {
				StringBuffer buf = new StringBuffer();
				char[] buffer = new char[1024];
				int count;
				try {
					while ((count = reader.read(buffer)) != -1)
						buf.append(buffer, 0, count);
				} catch (IOException e) {
					return null;
				}
				return buf.toString();
			}
		};
		createScriptCompletionProposal.setProposalInfo(proposalInfo);
		return createScriptCompletionProposal;
	}

	protected ScriptCompletionProposal createScriptCompletionProposal(String completion,
	    int replaceStart, int length, Image image, String displayString, int i) {
		JavaScriptCompletionProposal javaScriptCompletionProposal = new JavaScriptCompletionProposal(
		    completion, replaceStart, length, image, displayString, i);

		return javaScriptCompletionProposal;
	}

	protected ScriptCompletionProposal createScriptCompletionProposal(String completion,
	    int replaceStart, int length, Image image, String displayString, int i,
	    boolean isInDoc) {
		JavaScriptCompletionProposal javaScriptCompletionProposal = new JavaScriptCompletionProposal(
		    completion, replaceStart, length, image, displayString, i, isInDoc);
		return javaScriptCompletionProposal;
	}

	protected ScriptCompletionProposal createOverrideCompletionProposal(
	    IScriptProject scriptProject, ISourceModule compilationUnit, String name,
	    String[] paramTypes, int start, int length, String displayName,
	    String completionProposal) {
		return new JavaScriptOverrideCompletionProposal(scriptProject, compilationUnit, name,
		    paramTypes, start, length, displayName, completionProposal);
	}

	protected IScriptCompletionProposal createKeywordProposal(CompletionProposal proposal) {
		String completion = String.valueOf(proposal.getCompletion());
		int start = proposal.getReplaceStart();
		int length = getLength(proposal);
		String label = getLabelProvider().createSimpleLabel(proposal);
		Image img = getImage(getLabelProvider().createMethodImageDescriptor(proposal));
		int relevance = computeRelevance(proposal);
		return createScriptCompletionProposal(completion, start, length, img, label,
		    relevance);
	}
}
