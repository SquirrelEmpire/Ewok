package org.squirrel.core;

public class Ewok implements Runnable {
	
	private boolean running = false;
	private Thread tread;
	private String ewokVersion = "0.1";
	private boolean showDebugInfo = false;
	private double frameCap = 1.0 / 60.0;
	private String debugTag = "[DEBUG] ";
	private EwokGame game;
	private EwokWindow window;
	private EwokInput ewokIn;
	
	public Ewok(EwokGame game, EwokWindow window){
		this.game = game;
		this.window = window;
	}
	
	public synchronized void start(){
		if(running)
			return;
		
		//Init game comp
		ewokIn = new EwokInput(this);
		
		running = true;
		tread = new Thread(this);
		tread.start();
	}
	
	public void run() {
		running = true;
		if(isShowDebugInfo()){
			System.out.println(debugTag+"Gameloop started");
		}
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		double frameTime = 0;
		int frames = 0;
		while(running){
			
			boolean render = false;
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= frameCap){
				//Update
				game.update(this);
				unprocessedTime -= frameCap;
				render = true;
				
				if(frameTime >= 1){
					frameTime = 0;
					System.out.println("FPS: "+frames);
					frames = 0;
				}
			}
			if(render){
				//draw
				window.getGamePanel().repaint();
				frames++;
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}}
}

	public boolean isShowDebugInfo() {
		return showDebugInfo;
	}

	public void setShowDebugInfo(boolean showDebugInfo) {
		this.showDebugInfo = showDebugInfo;
	}

	public boolean isRunning() {
		return running;
	}

	public String getEwokVersion() {
		return ewokVersion;
	}

	public EwokWindow getWindow() {
		return window;
	}


}
