package org.squirrel.enginecomponent;

import java.security.spec.ECField;

import org.squirrel.utils.Debugger;

public class EngineComponent {
	
	private String componentName = "";
	public EngineComponent(){
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	
	public void init(){
		if(Debugger.isEnabled()){
			Debugger.printMsg(this.componentName+" Have started");
		}
	}
}
