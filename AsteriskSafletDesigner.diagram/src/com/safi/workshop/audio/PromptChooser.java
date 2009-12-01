package com.safi.workshop.audio;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.audio.utils.AudioUtils;
import com.safi.workshop.audio.utils.PromptCache;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class PromptChooser extends Composite implements ISelectionChangedListener,
    PromptChangeListener {
	public enum Mode {
		SINGLE, MULTIPLE
	};

	enum NodeMode {
		ROOT, TOP_LEVEL, SUBDIR, PROJECT, PROMPT, DISCONNECTED
	};

	private Button synchronizeButton;
	private Button systemCheckbox;
	private Mode mode = Mode.SINGLE;
	private Tree tree;
	private Text filterText;
	private TreeViewer treeViewer;
	private PromptNode model;
	private PromptNode projectPromptNode;
	private PromptNode sharedPromptNode;
	private PromptNode systemPromptNode;
	private Button projectCheckbox;
	private Button sharedCheckbox;
	private HideProjectFilter projectFilter;
	private HideSharedFilter sharedFilter;
	private PathFilter nameFilter;
	private PromptNode selectedNode;
	// private ArrayList<String> filterSegs;
	// private Pattern pattern;
	private Map<PromptNode, String> categories;
	private ScheduledThreadPoolExecutor executor;
	// private static Pattern wildcardPattern = Pattern.compile("\\*");
	// private AutoCompleteField autocomplete;
	private String[] currPatternSegments;
	private String lastText = null;
	private PlayerDialog playerDialog;
	private Button playPromptButton;
	private HideSystemFilter systemFilter;
	private Button deleteButton;
	private Button newButton;
	private Button editButton;
	private boolean needsSynch;
	private Listener filterListener;
	private boolean pathFilterActive;

	public PromptChooser(Composite parent, Mode mode) {
		this(parent, SWT.NONE, mode);
	}

	/**
	 * Create the composite
	 * 
	 * @param parent
	 * @param style
	 */
	public PromptChooser(Composite parent, int style, Mode mode) {
		super(parent, style);
		this.mode = mode;
		executor = new ScheduledThreadPoolExecutor(1);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 9;
		setLayout(gridLayout);
		final Composite composite = new Composite(this, SWT.NONE);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		composite.setLayout(gridLayout_1);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 9, 1));
		final Label filterLabel = new Label(composite, SWT.SHADOW_NONE | SWT.RIGHT);
		filterLabel.setText("Filter by Name");
		filterText = new Text(composite, SWT.BORDER);
		filterListener = new Listener() {
			long lastUpdate = 0;
			StringBuilder sb = new StringBuilder();

			final Display display = getShell().getDisplay();
			ScheduledFuture<Boolean> future = null;
			Callable<Boolean> runna = new Callable<Boolean>() {
				@Override
				public Boolean call() {
					try {
						updateFilter();
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}
					return true;
				}

			};

			@Override
			public void handleEvent(Event event) {
				if (event.type == SWT.Modify) {
					long now = event.time & 0xFFFFFFFFL;

					if (future != null) {
						if (!future.cancel(true)) {
							display.syncExec(new Runnable() {
								@Override
								public void run() {
									try {
										future.get();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							});
						}
					}

					future = executor.schedule(runna, 500, TimeUnit.MILLISECONDS);
				}
			}
		};
		filterText.addListener(SWT.Modify, filterListener);
		final GridData gd_filterText = new GridData(SWT.FILL, SWT.CENTER, true, false);
		filterText.setLayoutData(gd_filterText);

		final Button clearButton = new Button(composite, SWT.NONE);
		clearButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				filterText.setText("");
				updateFilter();
			}
		});
		clearButton.setToolTipText("Clear text");
		// clearButton.setText("Clear");
		clearButton.setImage(AudioUtils.clearTextImage);
		sharedCheckbox = new Button(this, SWT.CHECK);
		sharedCheckbox.setToolTipText("Hide Shared Prompts");
		sharedCheckbox.setSelection(false);
		sharedCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (sharedCheckbox.getSelection())
					treeViewer.addFilter(sharedFilter);
				else
					treeViewer.removeFilter(sharedFilter);
			}
		});
		sharedCheckbox.setLayoutData(new GridData());
		sharedCheckbox.setText("Hide Shared");
		projectCheckbox = new Button(this, SWT.CHECK);
		projectCheckbox.setToolTipText("Hide Project Prompts");
		projectCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (projectCheckbox.getSelection())
					treeViewer.addFilter(projectFilter);
				else
					treeViewer.removeFilter(projectFilter);
			}
		});
		projectCheckbox.setLayoutData(new GridData());
		projectCheckbox.setText("Hide Project");
		systemCheckbox = new Button(this, SWT.CHECK);
		systemCheckbox.setToolTipText("Hide System Prompts");
		systemCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (systemCheckbox.getSelection())
					treeViewer.addFilter(systemFilter);
				else
					treeViewer.removeFilter(systemFilter);
			}
		});
		systemCheckbox.setLayoutData(new GridData());
		systemCheckbox.setText("Hide System");
		if (mode == Mode.MULTIPLE) {
			systemCheckbox.setSelection(true);
			systemCheckbox.setVisible(false);
		}
		playPromptButton = new Button(this, SWT.NONE);
		playPromptButton.setToolTipText("Play selected prompt");
		playPromptButton.setLayoutData(new GridData());
		playPromptButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				playSelectedPrompt();
			}
		});
		playPromptButton.setEnabled(false);
		playPromptButton.setImage(AudioUtils.playImage);
		editButton = new Button(this, SWT.NONE);
		editButton.setEnabled(false);
		editButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode == null)
					return;
				ImportAudioFileWizard ipt = new ImportAudioFileWizard(
				    ImportAudioFileWizard.Mode.EDIT, false);
				Prompt prompt = (Prompt) selectedNode.serverResource;
				ipt.setPrompt(prompt);
				WizardDialog dlg = new WizardDialog(AsteriskDiagramEditorUtil.getActiveShell(),
				    ipt);
				int result = dlg.open();
				if (result == Window.OK) {
					needsSynch = true;
					removeNode(selectedNode);
					selectedNode = addPrompt(ipt.getPrompt());
					PromptNode changed = selectedNode;
					modelChanged();
					treeViewer.setSelection(new StructuredSelection(changed), true);
					// treeViewer.expandToLevel(changed, 0);

				}
			}
		});
		editButton.setToolTipText("edit selected prompt");
		editButton.setLayoutData(new GridData());
		editButton.setImage(AudioUtils.editPromptImage);
		if (mode == Mode.MULTIPLE) {
			editButton.setVisible(false);
		}
		deleteButton = new Button(this, SWT.NONE);
		deleteButton.setEnabled(false);
		deleteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (selectedNode == null)
					return;
				Prompt prompt = (Prompt) selectedNode.serverResource;
				if (prompt.isSystem()) {
					MessageDialog
					    .openWarning(
					        getShell(),
					        "System Prompt",
					        "Asterisk system prompts may not be deleted from here.  Those must be manually deleted from each Asterisk server on which they reside.");
				}
				boolean b = MessageDialog.openConfirm(getShell(), "Delete Prompt?",
				    "Are you sure you want to permanently delete the prompt "
				        + selectedNode.serverResource.getName() + "?");
				if (b) {
					try {
						needsSynch = true;
						SafletProject project = prompt.getProject();
						if (project != null) {
							project.getPrompts().remove(prompt);
							DBManager.getInstance().delete(prompt);
							// DBManager.getInstance().saveOrUpdateServerResource(project);
						} else
							DBManager.getInstance().delete(prompt);

						removeNode(selectedNode);
						if (project != null)
							PromptCache.projectPromptCache.remove(prompt);
						else if (prompt.isSystem())
							PromptCache.systemPromptCache.remove(prompt);
						else
							PromptCache.sharedPromptCache.remove(prompt);
						selectedNode = null;
						treeViewer.setSelection(StructuredSelection.EMPTY);
						treeViewer.refresh(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						MessageDialog.openError(getShell(), "Delete Error",
						    "Couldn't delete the selected prompt: "
						        + (e1.getCause() == null ? e1.getLocalizedMessage() : e1.getCause()
						            .getLocalizedMessage()));
					}
				}
			}
		});
		final GridData gd_deleteButton = new GridData();
		deleteButton.setLayoutData(gd_deleteButton);
		deleteButton.setToolTipText("Delete selected prompt");
		// deleteButton.setText("Delete");
		deleteButton.setImage(AudioUtils.deleteImage);
		if (mode == Mode.MULTIPLE) {
			deleteButton.setVisible(false);
		}
		newButton = new Button(this, SWT.NONE);
		newButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				ImportAudioFileWizard ipt = new ImportAudioFileWizard(
				    ImportAudioFileWizard.Mode.NEW, false);
				WizardDialog dlg = new WizardDialog(AsteriskDiagramEditorUtil.getActiveShell(),
				    ipt);
				int result = dlg.open();
				if (result == WizardDialog.OK) {
					Prompt p = ipt.getPrompt();
					if (p != null) {
						needsSynch = true;
						PromptNode node = addPrompt(p);
						modelChanged();

						treeViewer.setSelection(new StructuredSelection(node), true);
						// treeViewer.expandToLevel(node, 0);

					}
				}
			}
		});
		newButton.setLayoutData(new GridData());
		newButton.setToolTipText("Create new prompt");
		newButton.setImage(AudioUtils.newPromptImage);
		if (mode == Mode.MULTIPLE) {
			newButton.setVisible(false);
		}

		synchronizeButton = new Button(this, SWT.NONE);
		synchronizeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				MultiSynchronizePromptsAction action = new MultiSynchronizePromptsAction();
				action.run(null);
				needsSynch = false;
				try {
					refreshModel();
				} catch (DBManagerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					AsteriskDiagramEditorPlugin.getInstance().logError(
					    "Couldn't retrieve all prompts", e1);
					MessageDialog.openError(getShell(), "Retrieve Prompts Error",
					    "Couldn't retrieve all prompts: " + e1.getLocalizedMessage());
				}
			}
		});
		synchronizeButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
		synchronizeButton.setImage(AudioUtils.synchronizeImage);
		synchronizeButton.setToolTipText("Synchronize prompts with Asterisk server(s)");
		if (mode == Mode.MULTIPLE) {
			synchronizeButton.setVisible(false);
		}
		final Button refreshButton = new Button(this, SWT.NONE);
		refreshButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				try {
					refreshModel();
				} catch (DBManagerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					MessageDialog.openError(getShell(), "Retrieve Prompts Error",
					    "Couldn't retrieve all prompts: " + e1.getLocalizedMessage());
				}
			}
		});
		final GridData gd_refreshButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		refreshButton.setLayoutData(gd_refreshButton);
		refreshButton.setToolTipText("Refresh prompts from database");
		refreshButton.setImage(AudioUtils.refreshImage);
		if (mode == Mode.MULTIPLE) {
			refreshButton.setVisible(false);
		}
		if (mode == Mode.MULTIPLE) {
			treeViewer = new CheckboxTreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
			((CheckboxTreeViewer) treeViewer).addCheckStateListener(new ICheckStateListener() {

				@Override
				public void checkStateChanged(CheckStateChangedEvent event) {
					PromptNode node = (PromptNode) event.getElement();
					Object[] checkedElements = ((CheckboxTreeViewer) treeViewer)
					    .getCheckedElements();
					updateTree(node, checkedElements, event.getChecked());
					checkedElements = ((CheckboxTreeViewer) treeViewer).getCheckedElements();

				}

			});
		} else
			treeViewer = new TreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
		treeViewer.addSelectionChangedListener(this);
		projectFilter = new HideProjectFilter();
		sharedFilter = new HideSharedFilter();
		systemFilter = new HideSystemFilter();
		if (mode == Mode.MULTIPLE) {
			treeViewer.addFilter(systemFilter);
		}
		nameFilter = new PathFilter();
		// treeViewer.setFilters(new ViewerFilter[] { nameFilter });
		treeViewer.setContentProvider(new TreeContentProvider());
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				playSelectedPrompt();
			}
		});
		tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 9, 1));
		// new Label(this, SWT.NONE);
		// new Label(this, SWT.NONE);
		final TreeViewerColumn nameColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		nameColumn.getColumn().setWidth(130);
		nameColumn.getColumn().setMoveable(true);
		nameColumn.getColumn().setText("Name");
		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PromptNode node = (PromptNode) element;
				return node.name;
			}

			@Override
			public Color getForeground(Object element) {
				return null;
			}
		});
		TreeViewerColumn descCol = new TreeViewerColumn(treeViewer, SWT.NONE);
		descCol.getColumn().setWidth(250);
		descCol.getColumn().setMoveable(false);
		descCol.getColumn().setText("Description");
		descCol.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PromptNode node = (PromptNode) element;
				if (node.serverResource != null) {
					return node.serverResource.getDescription();
				}
				return "";
			}

			@Override
			public String getToolTipText(Object element) {
				PromptNode node = (PromptNode) element;
				if (node.serverResource != null) {
					return node.serverResource.getDescription();
				}
				return super.getToolTipText(element);
			}

			@Override
			public int getToolTipDisplayDelayTime(Object object) {
				return 200;
			}
		});
		final DateFormat format = DateFormat.getDateTimeInstance();
		final TreeViewerColumn lastModifiedCol = new TreeViewerColumn(treeViewer, SWT.NONE);
		lastModifiedCol.getColumn().setWidth(100);
		lastModifiedCol.getColumn().setMoveable(true);
		lastModifiedCol.getColumn().setText("Last Modified");
		lastModifiedCol.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PromptNode node = (PromptNode) element;
				if (node.serverResource != null) {
					Date lastModified = node.serverResource.getLastModified();
					if (lastModified == null)
						return "";
					return format.format(lastModified);
				}
				return "";
			}
		});
		final TreeViewerColumn createdByCol = new TreeViewerColumn(treeViewer, SWT.NONE);
		createdByCol.getColumn().setWidth(120);
		createdByCol.getColumn().setMoveable(true);
		createdByCol.getColumn().setText("Created By");
		createdByCol.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				PromptNode node = (PromptNode) element;
				if (node.serverResource != null) {
					User createdBy = node.serverResource.getCreatedBy();
					if (createdBy != null)
						return createdBy.getName();
					else
						return "";
				}
				return "";
			}

			@Override
			public String getToolTipText(Object element) {
				PromptNode node = (PromptNode) element;
				if (node.serverResource != null) {
					User createdBy = node.serverResource.getCreatedBy();
					if (createdBy != null) {
						return createdBy.getLastname() + ", " + createdBy.getFirstname() + "\n"
						    + createdBy.getDescription();
					}
				}
				return "";
			}

			@Override
			public int getToolTipDisplayDelayTime(Object object) {
				// TODO Auto-generated method stub
				return 200;
			}
		});
		Listener sortListener = new Listener() {
			public void handleEvent(Event e) {
				// determine new sort column and direction
				TreeColumn sortColumn = treeViewer.getTree().getSortColumn();
				TreeColumn currentColumn = (TreeColumn) e.widget;
				int dir = treeViewer.getTree().getSortDirection();
				if (sortColumn == currentColumn) {
					dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
				} else {
					treeViewer.getTree().setSortColumn(currentColumn);
					dir = SWT.UP;
				}
				// sort the data based on column and direction
				PromptSorter.ColumnID sortIdentifier = null;
				if (currentColumn == nameColumn.getColumn()) {
					sortIdentifier = PromptSorter.ColumnID.NAME;
				}
				if (currentColumn == createdByCol.getColumn()) {
					sortIdentifier = PromptSorter.ColumnID.CREATED_BY;
				}
				if (currentColumn == lastModifiedCol.getColumn()) {
					sortIdentifier = PromptSorter.ColumnID.LAST_MODIFIED;
				}
				treeViewer.getTree().setSortDirection(dir);
				treeViewer.setSorter(new PromptSorter(sortIdentifier, dir));
				// treeViewer.refresh(true);
			}
		};
		nameColumn.getColumn().addListener(SWT.Selection, sortListener);
		createdByCol.getColumn().addListener(SWT.Selection, sortListener);
		lastModifiedCol.getColumn().addListener(SWT.Selection, sortListener);
		playerDialog = new PlayerDialog(getShell());
		// promptController = new PromptMediaController(this, SWT.NONE);
		// GridData layoutData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 3,
		// 1);
		// layoutData.widthHint=200;
		// promptController.setLayoutData(layoutData);
		//
		// if (projectCache != null)
		categories = new HashMap<PromptNode, String>();
		// autocomplete = new AutoCompleteField(filterText, new
		// TextContentAdapter(),
		// categories.toArray(new String[categories.size()]));
		constructModel(false);
		treeViewer.setUseHashlookup(true);
		try {
			if (mode == Mode.MULTIPLE) {
				refreshModel();
			} else
				forceLoad();
		} catch (DBManagerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			MessageDialog.openError(getShell(), "Retrieve Prompts Error",
			    "Couldn't retrieve all prompts: " + e1.getLocalizedMessage());
		}
		treeViewer.setInput(model);
		// tree.setItemCount(2);
	}

	private void modelChanged() {
		// TODO Auto-generated method stub
		treeViewer.setInput(model);

	}

	private void playSelectedPrompt() {
		if (selectedNode != null)
			loadPromptForPlayback(selectedNode);
	}

	@Override
	public void dispose() {
		if (needsSynch && SafiServerPlugin.getDefault().hasAsteriskServers()) {
			boolean b = MessageDialog
			    .openQuestion(
			        AsteriskDiagramEditorUtil.getActiveShell(),
			        "Synchronize Now?",
			        "One or more prompts were changed and may need to be synchronized "
			            + "with the Asterisk servers. Do you wish to synchronize audio prompts now?");
			if (b) {
				AudioUtils.synchronizePrompts(SafiServerPlugin.getDefault()
				    .getAvailableAsteriskServers());
			}
		}
		if (playerDialog != null) {
			playerDialog.close();
		}
		super.dispose();
	}

	private void buildFilterSeg(String text) {
		currPatternSegments = text.split("/");
		for (int i = 0; i < currPatternSegments.length; i++) {
			currPatternSegments[i] = currPatternSegments[i].replaceAll("\\*\\*", ".*");
			currPatternSegments[i] = currPatternSegments[i].replaceAll("\\*", "*");
		}
		String lastSeg = currPatternSegments[currPatternSegments.length - 1];
		if (!lastSeg.endsWith("*")) {
			currPatternSegments[currPatternSegments.length - 1] += "*";
		}
	}

	public void selectionChanged(final SelectionChangedEvent event) {
		ISelection sel = event.getSelection();
		selectedNode = null;
		try {
			if (sel == null || sel.isEmpty()) {
				return;
			}
			if (sel instanceof StructuredSelection) {
				Object firstElement = ((StructuredSelection) sel).getFirstElement();
				if (firstElement instanceof PromptNode) {
					PromptNode node = (PromptNode) firstElement;
					if (node.mode == NodeMode.PROMPT) {
						selectedNode = node;
					}
				}
			}
		} finally {
			playPromptButton.setEnabled(selectedNode != null);
			editButton.setEnabled(selectedNode != null);
			deleteButton.setEnabled(selectedNode != null);
		}
	}

	private void loadPromptForPlayback(PromptNode node) {
		final Prompt p = (Prompt) node.serverResource;
		IRunnableWithProgress runna = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
			    InterruptedException {
				try {
					monitor.beginTask("Retrieving Audio", IProgressMonitor.UNKNOWN);
					final File f = AsteriskDiagramEditorUtil.getPromptFile(p);
					Display d = Display.getDefault();
					d.asyncExec(new Runnable() {
						@Override
						public void run() {
							try {
								// promptController.loadFile(f);
								playerDialog.setPromptName(p.getName() + "." + p.getExtension());
								playerDialog.loadFile(f);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								MessageDialog.openError(getShell(), "Load Audio Error",
								    "Couldn't load audio data for prompt "
								        + p.getName()
								        + ": "
								        + (e.getCause() != null ? e.getCause().getLocalizedMessage() : e
								            .getLocalizedMessage()));
								return;
							}
						}
					});
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				}
			}
		};
		ProgressMonitorDialog pd = new ProgressMonitorDialog(getShell());
		try {
			pd.run(true, false, runna);
			playerDialog.open();
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(getShell(), "Playback Error",
			    "Couldn't retrieve audio data for prompt "
			        + p.getName()
			        + ": "
			        + (e.getCause() != null ? e.getCause().getLocalizedMessage() : e
			            .getLocalizedMessage()));
		}
	}

	PromptNode initialNode;

	public void selectPromptByName(String name, boolean filter) {
		String[] path = name.split("/");
		if (path[0].startsWith("safi/")) {
			if (path.length == 1)
				return;
			String[] newpath = new String[path.length - 1];
			System.arraycopy(path, 0, newpath, 1, newpath.length);
			path = newpath;
		}
		PromptNode node = findNode(path, 0, model);
		if (node != null) {
			treeViewer.setSelection(new StructuredSelection(node), true);
			// treeViewer.expandToLevel(node, 0);

		}
		initialNode = node;
		if (!filter) {
			setNameFilterActive(false);
			// filterText.removeListener(SWT.Modify, filterListener);
		}
		filterText.setText(name);
		// if (node != null && getShell().isVisible())
		// expandElement(node);
		treeViewer.refresh();
		// if (!filter)
		// filterText.addListener(SWT.Modify, filterListener);
		// if (!filter)
		// setNameFilterActive(true);
		// treeViewer.refresh(node, true);
	}

	// private void revealSelectedElement() {
	// IStructuredSelection sel = ((IStructuredSelection)
	// treeViewer.getSelection());
	// if (sel.isEmpty())
	// return;
	// Object o = sel.getFirstElement();
	// expandElement(o, false);
	// }

	private void setNameFilterActive(boolean b) {
		nameFilter.setActive(b);

	}

	private PromptNode findNode(String[] path, int idx, PromptNode parent) {
		for (PromptNode node : parent.getChildren()) {
			if (node.mode == NodeMode.TOP_LEVEL) {
				PromptNode n = findNode(path, idx, node);
				if (n != null)
					return n;
			}
			if (StringUtils.equals(path[idx], node.name)) {
				if ((path.length - 1) == idx)
					return node;
				return findNode(path, ++idx, node);
			}
		}
		return null;
	}

	private void removeNode(PromptNode node) {
		if (node.mode == NodeMode.DISCONNECTED || node.mode == NodeMode.TOP_LEVEL
		    || node.mode == NodeMode.PROJECT || node.mode == NodeMode.ROOT)
			return;
		if (node.mode == NodeMode.SUBDIR && node.getNumChildren() == 0)
			node.parent.getChildren().remove(node);
		else if (node.mode == NodeMode.PROMPT) {
			node.parent.getChildren().remove(node);
			if (node.parent.getNumChildren() == 0)
				removeNode(node.parent);
		}
		node.clear();
	}

	public void constructModel(boolean startup) {
		if (!SafiServerPlugin.getDefault().isConnected()) {
			model = new PromptNode();
			model.mode = NodeMode.ROOT;
			model.name = "root";
			PromptNode disconnected = new PromptNode();
			disconnected.name = "Not connected to SafiServer";
			disconnected.mode = NodeMode.DISCONNECTED;
			disconnected.project = true;
			model.addChild(disconnected);
		} else if (startup) {
			model = new PromptNode();
			model.mode = NodeMode.ROOT;
			model.name = "root";
			PromptNode disconnected = new PromptNode();
			disconnected.name = "click refresh to populate data";
			disconnected.mode = NodeMode.DISCONNECTED;
			disconnected.project = true;
			model.addChild(disconnected);
		} else {
			model = new PromptNode();
			model.mode = NodeMode.ROOT;
			model.name = "root";
			projectPromptNode = new PromptNode();
			projectPromptNode.name = "project";
			projectPromptNode.mode = NodeMode.TOP_LEVEL;
			projectPromptNode.project = true;
			model.addChild(projectPromptNode);
			categories.put(projectPromptNode, projectPromptNode.name);
			sharedPromptNode = new PromptNode();
			sharedPromptNode.name = "shared";
			sharedPromptNode.mode = NodeMode.TOP_LEVEL;
			sharedPromptNode.project = false;
			model.addChild(sharedPromptNode);
			categories.put(sharedPromptNode, sharedPromptNode.name);
			systemPromptNode = new PromptNode();
			systemPromptNode.name = "system";
			systemPromptNode.mode = NodeMode.TOP_LEVEL;
			systemPromptNode.project = false;
			model.addChild(systemPromptNode);
			categories.put(systemPromptNode, systemPromptNode.name);
		}
		// DBManager.getInstance().getPromptCategories();
	}

	public void forceLoad() throws DBManagerException {
		if (projectPromptNode != null)
			buildChildren(projectPromptNode);
		if (sharedPromptNode != null)
			buildChildren(sharedPromptNode);
		if (systemPromptNode != null)
			buildChildren(systemPromptNode);
	}

	public PromptNode addPrompt(Prompt p) {
		PromptNode start = null;
		if (p.isSystem()) {
			start = systemPromptNode;
			PromptCache.systemPromptCache.add(p);
		} else if (p.getProject() != null) {
			start = projectPromptNode;
			List<Prompt> cache = PromptCache.projectPromptCache.get(p.getProject().getId());
			if (cache == null) {
				cache = new ArrayList<Prompt>();
				PromptCache.projectPromptCache.put(p.getProject().getId(), cache);
			}
			cache.add(p);
		} else {
			start = sharedPromptNode;
			PromptCache.sharedPromptCache.add(p);
		}
		return addNode(start, p, p.getProject() != null);
	}

	public void buildChildren(PromptNode promptNode) throws DBManagerException {
		if (promptNode.mode == NodeMode.ROOT)
			return;
		if (promptNode.mode == NodeMode.TOP_LEVEL) {
			if (promptNode.project) {
				if (PromptCache.projectCache == null) {
					loadProjectCache();
				}
				List<SafletProject> ps = PromptCache.projectCache;
				for (SafletProject p : ps) {
					PromptNode project = new PromptNode();
					project.name = p.getName();
					project.serverResource = p;
					project.mode = NodeMode.PROJECT;
					promptNode.addChild(project);
					project.project = true;
					buildChildren(project);
					categories.put(project, "project/" + project.name);
				}
			} else if (promptNode == sharedPromptNode) {
				if (PromptCache.sharedPromptCache == null) {
					loadSharedPromptCache();
				}
				List<Prompt> ps = PromptCache.sharedPromptCache;
				for (Prompt p : ps) {
					addNode(promptNode, p, false);
				}
			} else if (promptNode == systemPromptNode) {
				if (PromptCache.systemPromptCache == null) {
					loadSharedPromptCache();
				}
				List<Prompt> ps = PromptCache.systemPromptCache;
				for (Prompt p : ps) {
					addNode(promptNode, p, false);
				}
			}
		} else if (promptNode.mode == NodeMode.PROJECT) {

			List<Prompt> cache = PromptCache.projectPromptCache
			    .get(((SafletProject) promptNode.serverResource).getId());
			if (cache == null) {
				cache = loadProjectPromptCache(promptNode);
			}
			for (Prompt p : cache) {
				addNode(promptNode, p, true);
				// String[] path = p.getName().split("/");
				// PromptNode prev = promptNode;
				// for (String s : path) {
				// PromptNode nn = new PromptNode();
				// nn.name = s;
				// nn.project = true;
				// nn.mode = NodeMode.SUBDIR;
				// if (prev != null) {
				// nn = prev.getChildNamed(s);
				// }
				// if (nn != null) {
				// prev = nn;
				// continue;
				// }
				// prev.addChild(nn);
				// categories.put(nn, getPath(nn));
				// prev = nn;
				// }
				// prev.mode = NodeMode.PROMPT;
				// prev.serverResource = p;
			}
		}

		// updateProposals();
		// TODO Auto-generated method stub
		// String prefix = getPrefix(promptNode);
		// DBManager.getInstance().getPromptNamesLike(prefix, promptNode.project);
	}

	private PromptNode addNode(PromptNode startNode, Prompt p, boolean project) {
		String[] path = p.getName().split("/");
		if (project && startNode.mode == NodeMode.TOP_LEVEL) {
			String[] newpath = new String[path.length + 1];
			newpath[0] = p.getProject().getName();
			System.arraycopy(path, 0, newpath, 1, path.length);
			path = newpath;
		}
		PromptNode prev = startNode;
		for (String s : path) {
			PromptNode nn = null;
			if (prev != null) {
				nn = prev.getChildNamed(s);
			}
			if (nn != null) {
				prev = nn;
				continue;
			}
			nn = new PromptNode();
			nn.name = s;
			nn.project = project;
			nn.mode = NodeMode.SUBDIR;
			if (prev != null)
				prev.addChild(nn);
			categories.put(nn, getPath(nn));
			prev = nn;
		}
		prev.mode = NodeMode.PROMPT;
		prev.serverResource = p;

		return prev;
	}

	private List<Prompt> loadProjectPromptCache(final PromptNode promptNode)
	    throws DBManagerException {
		final List<Prompt>[] result = new List[1];

		IRunnableWithProgress runna = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
			    InterruptedException {
				try {
					monitor.beginTask("Retrieving Prompts", IProgressMonitor.UNKNOWN);
					List<Prompt> cache = DBManager.getInstance().getProjectPrompts(
					    (SafletProject) promptNode.serverResource);
					PromptCache.projectPromptCache.put(((SafletProject) promptNode.serverResource)
					    .getId(), cache);
					result[0] = cache;
				} catch (DBManagerException e) {
					throw new InvocationTargetException(e);
				}
			}
		};
		ProgressMonitorDialog pd = new ProgressMonitorDialog(getShell());
		try {
			pd.run(true, false, runna);
		} catch (Exception e) {
			e.printStackTrace();
			Throwable th = e.getCause();
			if (th != null && th instanceof DBManagerException) {
				throw (DBManagerException) th;
			}
			throw new DBManagerException(e);
		}
		return result[0];
	}

	private void loadSharedPromptCache() throws DBManagerException {
		IRunnableWithProgress runna = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
			    InterruptedException {
				try {
					monitor.beginTask("Retrieving Prompts", IProgressMonitor.UNKNOWN);
					List<Prompt> sharedPrompts = DBManager.getInstance().getSharedPrompts();
					PromptCache.sharedPromptCache = new ArrayList<Prompt>();
					PromptCache.systemPromptCache = new ArrayList<Prompt>();
					for (Prompt p : sharedPrompts) {
						if (p.isSystem())
							PromptCache.systemPromptCache.add(p);
						else
							PromptCache.sharedPromptCache.add(p);
					}
				} catch (DBManagerException e) {
					throw new InvocationTargetException(e);
				}
			}
		};
		ProgressMonitorDialog pd = new ProgressMonitorDialog(getShell());
		try {
			pd.run(true, false, runna);
		} catch (Exception e) {
			e.printStackTrace();
			Throwable th = e.getCause();
			if (th != null && th instanceof DBManagerException) {
				throw (DBManagerException) th;
			}
			throw new DBManagerException(e);
		}
	}

	private void loadProjectCache() throws DBManagerException {
		IRunnableWithProgress runna = new IRunnableWithProgress() {
			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException,
			    InterruptedException {
				try {
					monitor.beginTask("Retrieving Prompts", IProgressMonitor.UNKNOWN);
					PromptCache.projectCache = DBManager.getInstance().getProjects();
				} catch (DBManagerException e) {
					throw new InvocationTargetException(e);
				}
			}
		};
		ProgressMonitorDialog pd = new ProgressMonitorDialog(getShell());
		try {
			pd.run(true, false, runna);
		} catch (Exception e) {
			e.printStackTrace();
			Throwable th = e.getCause();
			if (th != null && th instanceof DBManagerException) {
				throw (DBManagerException) th;
			}
			throw new DBManagerException(e);
		}
	}

	// public List<SafletProject> getProjects(IProgressMonitor monitor) throws
	// DBManagerException {
	// Session session = DBManager.getInstance().createSession();
	// try {
	// int num = (Integer)session.createQuery("select count(*) from
	// SafletProject").uniqueResult();
	//      
	// return (List<SafletProject>)
	// session.createCriteria(SafletProject.class).setFetchMode(
	// "saflets", FetchMode.SELECT).list();
	//
	// } catch (Exception ex) {
	// throw new DBManagerException(ex);
	// } finally {
	// session.close();
	// }
	// }
	private String getPath(PromptNode promptNode) {
		StringBuffer buf = null;
		// if (promptNode.mode == NodeMode.PROJECT)
		// buf = new
		// StringBuffer(String.valueOf(promptNode.serverResource.getId()));
		// else
		buf = new StringBuffer(promptNode.name);
		PromptNode n = promptNode;
		while ((n = n.parent) != null) {
			if (n.mode == NodeMode.SUBDIR) {
				buf.insert(0, n.name + '/');
			} else if (n.mode == NodeMode.PROJECT) {
				buf.insert(0, ((SafletProject) n.serverResource).getName() + "/");
			} else if (n.mode == NodeMode.TOP_LEVEL) {
				if (n.project) {
					buf.insert(0, "project/");
				} else if ("shared".equals(n.name)) {
					buf.insert(0, "shared/");
				}

				break;
			}
		}
		if (promptNode.mode == NodeMode.PROMPT
		    && !((Prompt) promptNode.serverResource).isSystem()) {
			buf.insert(0, "safi/");
		}
		return buf.toString();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private class PromptNode {
		String name;
		NodeMode mode;
		PromptNode parent;
		List<PromptNode> children;
		ServerResource serverResource;
		boolean project;

		void addChild(PromptNode node) {
			if (children == null)
				children = new ArrayList<PromptNode>();
			children.add(node);
			node.parent = this;
		}

		public void clear() {
			if (children != null)
				children.clear();
			children = null;
			parent = null;
			name = null;
			serverResource = null;
		}

		public PromptNode getChildNamed(String s) {
			if (children == null)
				return null;
			for (PromptNode node : children) {
				if (s.equals(node.name))
					return node;
			}
			return null;
		}

		public int getNumChildren() {
			if (children == null) {
				initChildren();
			}
			return children == null ? 0 : children.size();
		}

		public void initChildren() {
			if (children == null) {
				try {
					buildChildren(PromptNode.this);
				} catch (Exception e) {
					e.printStackTrace();
					MessageDialog.openError(getShell(), "Retrieve Error",
					    "Couldn't retrieve all children of " + name + ": "
					        + e.getLocalizedMessage());
				}
			}
		}

		public boolean isProject() {
			return project;
		}

		public void setProject(boolean project) {
			this.project = project;
		}

		public List<PromptNode> getChildren() {
			if (children == null) {
				children = new ArrayList<PromptNode>();
				initChildren();
			}
			return children;
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("name",
			    name).append("mode", mode).append("project", project).toString();
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof PromptNode))
				return false;
			if (obj == this)
				return true;
			PromptNode p = (PromptNode) obj;
			return StringUtils.equals(p.name, name) && mode == p.mode && project == p.project
			    && serverResource == p.serverResource;
		}
	}

	class TreeContentProvider implements ITreeContentProvider {
		@Override
		public Object getParent(Object element) {
			return ((PromptNode) element).parent;
		}

		@Override
		public void dispose() {
			// TODO Auto-generated method stub
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// TODO Auto-generated method stub
			// viewer.refresh();
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return ((PromptNode) parentElement).getChildren().toArray();
			// TODO Auto-generated method stub
		}

		@Override
		public boolean hasChildren(Object element) {
			return ((PromptNode) element).getChildren().size() > 0;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}
	}

	public String getPromptPath() {
		if (selectedNode == null)
			return "";
		return getPath(selectedNode);
	}

	public Prompt getPrompt() {
		if (selectedNode == null || selectedNode.mode != NodeMode.PROMPT)
			return null;
		return (Prompt) selectedNode.serverResource;
	}

	public void refreshModel() throws DBManagerException {
		model = null;
		PromptCache.clear();
		currPatternSegments = null;
		categories.clear();
		constructModel(false);
		forceLoad();
		treeViewer.setInput(model);
	}

	private void updateFilter() {
		if (isDisposed())
			return;

		Display d = treeViewer.getControl().getDisplay();
		d.syncExec(new Runnable() {
			@Override
			public void run() {
				String ft = filterText.getText();
				if (StringUtils.equals(lastText, ft)) {
					return;
				}
				lastText = ft;
				treeViewer.setSelection(StructuredSelection.EMPTY);
				System.err.println("just cleared selection and running filter again...");
				if (!pathFilterActive) {
					ViewerFilter[] filters = treeViewer.getFilters();
					ViewerFilter[] newf = new ViewerFilter[filters.length + 1];
					System.arraycopy(filters, 0, newf, 0, filters.length);
					newf[filters.length] = nameFilter;
					treeViewer.setFilters(newf);
					pathFilterActive = true;
				}
				else
					treeViewer.refresh(false);
				
				// boolean found = false;
				// ViewerFilter[] filters = treeViewer.getFilters();
				// if (filters != null){
				// for (ViewerFilter filter : filters){
				// if (filter == nameFilter){
				// found = true;
				// break;
				// }
				// }
				// }
				// if (!found){
				// ViewerFilter[] newf = new ViewerFilter[filters.length+1];
				// System.arraycopy(filters, 0, newf, 0, filters.length);
				// newf[filters.length] = nameFilter;
				// treeViewer.setFilters(newf);
				// }

				
				// if (initialNode != null)
				// Item[] items = treeViewer.getChildren(tree, null);

				PromptNode[] leaves = getLeaves();
				if (initialNode != null) {
					expandElement(initialNode, true);
					// treeViewer.setSelection(new StructuredSelection(initialNode),
					// true);

					// Runnable runna = new Runnable() {
					// @Override
					// public void run() {
					// try {
					// Thread.sleep(500);
					// } catch (InterruptedException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// Display.getDefault().asyncExec(new Runnable() {
					// public void run() {
					// expandElement(initialNode);
					// treeViewer.setSelection(new StructuredSelection(initialNode),
					// true);
					// treeViewer.refresh(initialNode);
					// // treeViewer.expandToLevel(initialNode, 0);
					// initialNode = null;
					// };
					// });
					// //
					// }
					// };
					// new Thread(runna).start();
				} else if (leaves.length == 1) {
					treeViewer.setSelection(new StructuredSelection(leaves[0]), true);
					treeViewer.expandToLevel(leaves[0], 0);
				} else if (!treeViewer.getSelection().isEmpty()) {
					final IStructuredSelection selection = (IStructuredSelection) treeViewer
					    .getSelection();

					final Object elem = selection.getFirstElement();
					treeViewer.setSelection(new StructuredSelection(elem), true);
					// if (selection.toArray().length > 1){
					// treeViewer.setSelection(new StructuredSelection(elem), true);
					// }
					// else
					// treeViewer.reveal(elem);
					treeViewer.setExpandedState(elem, true);
					// treeViewer.expandToLevel(((IStructuredSelection)treeViewer.getSelection()).getFirstElement(),
					// TreeViewer.ALL_LEVELS);
				} else {
					System.err.println("no selection boiz");
				}
				// treeViewer.setSelection(StructuredSelection.EMPTY);

				if (!nameFilter.isActive()) {
					nameFilter.setActive(true);
				}
			}
		});
	}

	private PromptNode[] getLeaves() {
		ArrayList<PromptNode> l = new ArrayList<PromptNode>();
		collectLeaves(l, treeViewer.getChildren(tree, null));
		return l.toArray(new PromptNode[l.size()]);
	}

	private void collectLeaves(ArrayList<PromptNode> l, Item[] items) {
		for (Item item : items) {
			PromptNode p = (PromptNode) item.getData();
			if (p != null && p.mode == NodeMode.PROMPT)
				l.add(p);
			else {
				collectLeaves(l, treeViewer.getChildren(item, null));
			}
		}
	}

	class HideProjectFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			PromptNode node = (PromptNode) element;
			if (node.mode == NodeMode.ROOT || node.mode == NodeMode.TOP_LEVEL)
				return true;
			return !node.project;
		}
	}

	class HideSharedFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			PromptNode node = (PromptNode) element;
			if (node.mode == NodeMode.ROOT || node.mode == NodeMode.TOP_LEVEL)
				return true;
			return node.project
			    || (node.mode == NodeMode.PROMPT && ((Prompt) node.serverResource).isSystem());
		}
	}

	class HideSystemFilter extends ViewerFilter {
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			PromptNode node = (PromptNode) element;
			if (node.mode == NodeMode.ROOT || node.mode == NodeMode.TOP_LEVEL
			    || node.mode == NodeMode.SUBDIR)
				return true;
			if (node.project)
				return true;
			if (node.mode == NodeMode.PROMPT && ((Prompt) node.serverResource).isSystem())
				return false;
			return true;
		}
	}

	class PathFilter extends ViewerFilter {

		boolean active = true;

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {

			PromptNode node = (PromptNode) element;
			boolean expand = false;
			boolean select = false;
			try {
				if (node.mode == NodeMode.ROOT || node.mode == NodeMode.TOP_LEVEL
				    || node.mode == NodeMode.SUBDIR || node.mode == NodeMode.PROJECT) {
					expand = true;
					return true;
				}

				if (node.mode != NodeMode.PROMPT) {
					return false;
				}
				if (node.project && projectCheckbox.getSelection()) {
					// hiding projects
					return false;
				}

				if (node.serverResource != null && node.mode == NodeMode.PROMPT
				    && ((Prompt) node.serverResource).isSystem() && systemCheckbox.getSelection()) {
					// hiding system prompts
					return false;
				}
				if (node.serverResource != null && node.mode == NodeMode.PROMPT && !node.project
				    && !((Prompt) node.serverResource).isSystem()
				    && sharedCheckbox.getSelection()) {
					// hide shared
					return false;
				}

				// if (node.mode == NodeMode.SUBDIR){
				// return true;
				// }
				//        
				String text = filterText.getText().toLowerCase();
				if (StringUtils.isBlank(text)) {
					return true;
				}

				String nodeName = node.name;
				int idx = nodeName.lastIndexOf('/');
				if (idx >= 0)
					nodeName = nodeName.substring(idx + 1, nodeName.length());

				if (StringUtils.equalsIgnoreCase(StringUtils.trim(nodeName), StringUtils
				    .trim(text))) {
					System.err.println("ok nodeName " + nodeName + " and text " + text);
					expand = true;
					select = true;
					return true;
				}
				// idx = text.lastIndexOf('/');
				// if (idx >= 0)
				// text = text.substring(idx + 1, text.length());

				if (!text.endsWith("*"))
					text += '*';
				text = text.replaceAll("\\*", "[a-zA-Z0-9\\-_\\$ ]*");
				String pathnode = null;

				if (nodeName.matches(text)) {
					expand = true;
					return true;
				} else if ((pathnode = getPath(node)).matches(text)) {
					expand = true;
					return true;
				} else if (initialNode != null && initialNode == element) {
					expand = true;
					return true;
				}
				return !active;

			} finally {

				if (expand) {
					expandElement(element, select);
				}
			}

		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}
	}

	private PromptNode findPromptNode(Prompt payload) {
		if (model == null)
			return null;
		return findNodeHelper(payload, model);
	}

	public void expandElement(final Object element, final boolean select) {
		if (!treeViewer.isBusy()) {
			if (select) {
				treeViewer.setSelection(new StructuredSelection(element));
				treeViewer.reveal(element);
			}
			treeViewer.setExpandedState(element, true);

			// treeViewer.reveal(element);
		} else {
			Display d = getDisplay();
			d.asyncExec(new Runnable() {

				@Override
				public void run() {
					int tries = 0;
					while (tries++ < 20 && treeViewer.isBusy()) {
						if (getDisplay().readAndDispatch()) {
							try {
								Thread.sleep(200);
							} catch (Exception e) {
							}
						}
					}
					if (!treeViewer.isBusy()) {
						if (select) {
							treeViewer.setSelection(new StructuredSelection(element));
							treeViewer.reveal(element);
						}
						treeViewer.setExpandedState(element, true);
						// treeViewer.expandToLevel(felement, TreeViewer.ALL_LEVELS);
						// treeViewer.reveal(felement);
					}

				}

			});
		}
	}

	private PromptNode findNodeHelper(Prompt payload, PromptNode current) {
		if (current.mode == NodeMode.PROMPT
		    && payload.getId() == current.serverResource.getId())
			return current;
		if (current.children == null)
			return null;
		for (PromptNode n : current.children) {
			PromptNode p = findNodeHelper(payload, n);
			if (p != null)
				return p;
		}
		return null;
	}

	static class PromptSorter extends ViewerSorter {
		public enum ColumnID {
			NAME, LAST_MODIFIED, CREATED_BY
		};

		private ColumnID column = null;
		private int dir = SWT.DOWN;

		/**
		 * @param column
		 * @param dir
		 */
		public PromptSorter(ColumnID column, int dir) {
			super();
			this.column = column;
			this.dir = dir;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.
		 * viewers.Viewer , java.lang.Object, java.lang.Object)
		 */
		public int compare(Viewer viewer, Object e1, Object e2) {
			int returnValue = 0;
			PromptNode n1 = (PromptNode) e1;
			PromptNode n2 = (PromptNode) e2;
			if (this.column == ColumnID.NAME) {
				if (n1.mode == NodeMode.PROMPT && n2.mode != NodeMode.PROMPT)
					returnValue = -1;
				else if (n1.mode != NodeMode.PROMPT && n2.mode == NodeMode.PROMPT)
					return 1;
				else if (n1.mode == NodeMode.PROMPT && n2.mode == n1.mode)
					returnValue = n1.serverResource.getName()
					    .compareTo(n2.serverResource.getName());
			} else if (this.column == ColumnID.LAST_MODIFIED) {
				if (n1.mode == NodeMode.PROMPT && n2.mode != NodeMode.PROMPT)
					returnValue = -1;
				else if (n1.mode != NodeMode.PROMPT && n2.mode == NodeMode.PROMPT)
					return 1;
				else if (n1.mode == NodeMode.PROMPT && n2.mode == n1.mode)
					returnValue = n1.serverResource.getLastModified().compareTo(
					    n2.serverResource.getLastModified());
			} else if (this.column == ColumnID.CREATED_BY) {
				if (n1.mode == NodeMode.PROMPT && n2.mode != NodeMode.PROMPT)
					returnValue = -1;
				else if (n1.mode != NodeMode.PROMPT && n2.mode == NodeMode.PROMPT)
					return 1;
				else if (n1.mode == NodeMode.PROMPT && n2.mode == n1.mode) {
					User user1 = n1.serverResource.getCreatedBy();
					User user2 = n2.serverResource.getCreatedBy();
					returnValue = (user1 == null ? "" : user1.getName())
					    .compareTo((user2 == null ? "" : user2.getName()));
				}
			}
			if (this.dir == SWT.DOWN) {
				returnValue = returnValue * -1;
			}
			return returnValue;
		}
	}

	@Override
	public void promptAdded(Prompt prompt) {
		addPrompt(prompt);
		treeViewer.refresh();
	}

	@Override
	public void promptModified(Prompt prompt, boolean pathChanged) {
		// TODO Auto-generated method stub
		PromptNode node = findPromptNode(prompt);
		if (node == null) {
			return;
		}
		if (!pathChanged)
			treeViewer.refresh(node, true);
		else {
			removeNode(node);
			addPrompt(prompt);
			treeViewer.refresh();
		}
	}

	@Override
	public void promptRemoved(Prompt prompt) {
		// TODO Auto-generated method stub
		PromptNode node = findPromptNode(prompt);
		if (node == null) {
			return;
		}
		removeNode(node);
		treeViewer.refresh();
	}

	public List<Prompt> getSelectedPrompts() {
		if (mode != Mode.MULTIPLE) {
			return Collections.singletonList(getPrompt());
		}

		List<Prompt> list = new ArrayList<Prompt>();
		for (Object o : ((CheckboxTreeViewer) treeViewer).getCheckedElements()) {
			if (o instanceof PromptNode && ((PromptNode) o).mode == NodeMode.PROMPT) {
				list.add((Prompt) ((PromptNode) o).serverResource);
			}
		}
		return list;
	}

	protected void updateTree(PromptNode node, Object[] checkedElements, boolean checked) {
		List<PromptNode> descendants = getDescendants(node);
		Set<Object> checkedList2 = new HashSet<Object>(Arrays.asList(checkedElements));
		for (PromptNode n : descendants) {
			((CheckboxTreeViewer) treeViewer).setGrayChecked(n, false);
			((CheckboxTreeViewer) treeViewer).setChecked(n, checked);
			if (checked)
				checkedList2.add(n);
			else
				checkedList2.remove(n);
		}

		updateParents(node, checkedList2);
	}

	private void updateParents(PromptNode child, Set checkedElements) {
		PromptNode parent = child.parent;
		if (parent == null)
			return;

		List children = parent.getChildren();
		List cloned = (List) ((ArrayList) children).clone();
		cloned.removeAll(checkedElements);
		if (cloned.isEmpty()) { // all checked
			((CheckboxTreeViewer) treeViewer).setGrayed(parent, false);
			((CheckboxTreeViewer) treeViewer).setChecked(parent, true);
			checkedElements.add(parent);
		} else {
			if (cloned.size() == children.size()) { // no sibs checked
				((CheckboxTreeViewer) treeViewer).setGrayChecked(parent, false);
			} else {
				((CheckboxTreeViewer) treeViewer).setGrayChecked(parent, true);
			}
			checkedElements.remove(parent);
		}
		updateParents(parent, checkedElements);
	}

	private List<PromptNode> getDescendants(PromptNode node) {
		List<PromptNode> desc = new ArrayList<PromptNode>();
		getDescendantsHelper(desc, node);
		return desc;

	}

	private void getDescendantsHelper(List<PromptNode> descendants, PromptNode node) {
		List<PromptNode> childs = node.getChildren();
		if (childs.isEmpty())
			return;
		descendants.addAll(childs);
		for (PromptNode child : childs) {
			getDescendantsHelper(descendants, child);
		}

	}
}
