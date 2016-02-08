package org.squirrel.utils;

import org.squirrel.enginecomponent.EngineComponent;

public class Debugger {
	
	private static boolean enabled = false;
	
	public static boolean isEnabled() {
		return enabled;
	}

	private static String tag = "[EWOK] ";
	
	public Debugger(){
		
	}
	
	public static void enableDebugger(){
		if(enabled == false){
			enabled = true;
		}
	}
	
	public static void printMsg(EngineComponent ec){
		if(enabled == true){
			System.out.println(tag+ec.getComponentName());
		}
	}
	
	public static void printMsg(String msg){
		if(enabled == true){
			System.out.println(tag+msg);
		}
	}

}
