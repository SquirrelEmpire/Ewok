package org.squirrel.enginecomponent;

public abstract class EngineComponent {
	
	private String componentName = "";
	public EngineComponent(){
	}
	
	public abstract void update();

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
}
