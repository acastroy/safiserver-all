package com.safi.workshop.model.timeBasedRouting;

import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import com.safi.actionpak.ActionPak;

public class TimeBasedRoutingPakId implements ActionPak {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EPackage> getEPackages() {
		// TODO Auto-generated method stub
		return Collections.singletonList((EPackage)TimeBasedRoutingPackage.eINSTANCE);
	}

	@Override
	public String getName() {
		return TimeBasedRoutingPlugin.getInstance().getBundle().getSymbolicName();
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return TimeBasedRoutingPlugin.getInstance().getBundle().getVersion().toString();
	}

}
