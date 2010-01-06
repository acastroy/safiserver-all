package com.safi.workshop.actionpak1.command;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sheet.DynamicValueEditor2;
import com.safi.workshop.sheet.ScriptDynamicValueEditorPage;
import com.safi.workshop.sheet.VariableDynamicValueEditorPage;

public class SetManagerInputItemValueCommand extends SetInputItemValueCommand {

	public SetManagerInputItemValueCommand(InputItemEditPart part,
			boolean canChangeName) {
		super(part, canChangeName);
		// TODO Auto-generated constructor stub
	}
	
	public static boolean executeCmd(final InputItem item, final EditingDomain domain,
		      final SafletContext context, final boolean canChangeName) {
		
            String labelText=item.getLabelText();
		    String paramName = item.getParameterName();
		    if (canChangeName) {
		      InputDialog dlg = new InputDialog(Display.getDefault().getActiveShell(), "Parameter Name",
		          "Enter parameter name", paramName, new IInputValidator() {
		            @Override
		            public String isValid(String newText) {
		              if (StringUtils.isBlank(newText)) {
		                return "Parameter name must be non-blank";
		              }
		              ActionStep parentToolstep = item.getParentActionStep();
		              if (parentToolstep != null) {
		                List<InputItem> inputs = ((ParameterizedActionstep) parentToolstep).getInputs();

		                for (InputItem itm : inputs) {
		                  if (itm == item)
		                    continue;
		                  if (StringUtils.equals(itm.getParameterName(), newText)) {
		                    return "Parameter with name " + newText
		                        + " already exists.  Please enter a different name";
		                  }
		                }
		              }
		              return null;
		            }
		          });
		      int res = dlg.open();
		      if (res == InputDialog.CANCEL)
		        return false;
		      paramName = dlg.getValue();
		    }
		    final String newParamName = paramName;
		    // for (Variable v :
		    // item.getParentActionStep().getHandler().getSafletContext().getVariables()){
		    //
		    // }

		    DynamicValue dynamicValue = item.getDynamicValue();
		    List<InputItem> inputs = null;

		    ActionStep parentToolstep = item.getParentActionStep();

		    if (parentToolstep != null && parentToolstep instanceof ParameterizedActionstep) {
		      inputs = ((ParameterizedActionstep) parentToolstep).getInputs();
		    }

		    DynamicValueEditor2 dve = createDynamicValueEditor(inputs == null ? "Input Item"
		        : "Input Item #" + inputs.indexOf(item), "Variable Name",
		        "Select variable to receive value of parameter named " + newParamName, false,
		        DynamicValueType.VARIABLE_NAME.toString(), dynamicValue, context, domain);
		    int result = dve.open();
		    if (DynamicValueEditor2.OK == result) {

		      final DynamicValue newval = dve.getDynamicValue();
		      item.setDynamicValue(newval);
		      item.setParameterName(newParamName);
		      item.setLabelText(labelText);
		      item.setParentActionStep(parentToolstep);
		   

		      return true;
		    } else
		    {
		    	 // final DynamicValue newval = dve.getDynamicValue();
			      item.setDynamicValue(dynamicValue);
			      item.setParameterName(newParamName);
			      item.setLabelText(labelText);
			      item.setParentActionStep(parentToolstep);
		    	
		    }
		      return false;
		  }
	
	
	private static DynamicValueEditor2 createDynamicValueEditor(String attributeName,
		      String expectedReturnType, String description, boolean isTypeLocked, String dynValueTypeStr,
		      DynamicValue dynamicValue, final SafletContext handlerContext, EditingDomain domain) {

		    final DynamicValueEditor2 dve2 = new DynamicValueEditor2(AsteriskDiagramEditorUtil
		        .getActiveShell());
		    dve2.setAttributeName(attributeName);
		    dve2.setExpectedReturnType(expectedReturnType);
		    dve2.setDescription(description);
		    dve2.setTypeLocked(isTypeLocked);
		    dve2.setDynamicValue(dynamicValue);
		    dve2.setEditingDomain(domain);

		    VariableDynamicValueEditorPage variablePage = new VariableDynamicValueEditorPage(handlerContext);
		    dve2.addPage(variablePage);
		    ProgressMonitorDialog pmd = new ProgressMonitorDialog(AsteriskDiagramEditorUtil
		        .getActiveShell());
		    try {
		      pmd.run(true, false, new IRunnableWithProgress() {

		        @Override
		        public void run(IProgressMonitor monitor) throws InvocationTargetException,
		            InterruptedException {
		          monitor.beginTask("Open Dynamic Value Editor", IProgressMonitor.UNKNOWN);
		          Display.getDefault().asyncExec(new Runnable() {

		            public void run() {
		              ScriptDynamicValueEditorPage scriptPage = new ScriptDynamicValueEditorPage(
		                  handlerContext);
		              dve2.addPage(scriptPage);
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

	

		    if (dynamicValue == null) {
		      dve2.setDefaultPage(variablePage);
		    }
		    return dve2;

		  }


}
