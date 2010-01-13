package com.safi.workshop.sheet;

import org.apache.commons.lang.StringUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;

public class ChannelTypeDVEP extends AbstractDynamicValueEditorPage {

	public final static String[] CHANNEL_TYPES = {"", "\"Local\"", "\"SIP\"", "\"Zap\"", "\"IAX2\"", "\"MGCP\"", "\"H.323\"", "\"Modem\"", "\"Phone\"", "\"CAPI\"", "\"ALSA\"", "\"Skinny\""};
	private CCombo combo;
	private Composite literalPanel;
	public ChannelTypeDVEP() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Composite createControl(Composite parent) {
		literalPanel = new Composite(parent, SWT.NONE);
    literalPanel.setLayout(new GridLayout());
		combo = new CCombo(literalPanel, SWT.BORDER);
		combo.setItems(CHANNEL_TYPES);
		combo.select(1);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		return literalPanel;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Channel Type Selector";
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return combo.getText();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Channel Type";
	}
	
	@Override
	public void show() {
		DynamicValue scratch = editor.getScratch();
		if (scratch != null && StringUtils.isNotBlank(scratch.getText())){
			String txt = StringUtils.trim(scratch.getText());
			
			int idx = -1;
			for (int i=0; i < CHANNEL_TYPES.length; i++){
				String type = CHANNEL_TYPES[i];
				if (StringUtils.equalsIgnoreCase(type, txt)){
					idx = i;
					break;
				}
			}
			if (idx >= 0){
				combo.select(idx);
			}
			else
			{
				combo.select(0);
				combo.setText(txt);
			}
		}
	}
	
	@Override
	public boolean commit() {
		DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.LITERAL_TEXT);
    String text = getText();
    String t = text.trim();
    if (!t.startsWith("\""))
    	t = '\"'+t;
    
    if (!t.endsWith("\""))
    	t += '\"';
    scratch.setText(t);
    return true;
	}
	

}
