package org.squirrel.core;

import org.squirrel.utils.Debugger;

public class Ewok implements Runnable {
	
	 //  ______                _      ______                _              
	//  |  ____|              | |    |  ____|              (_)             
	//  | |__ __      __ ___  | | __ | |__    _ __    __ _  _  _ __    ___ 
	 // |  __|\ \ /\ / // _ \ | |/ / |  __|  | '_ \  / _` || || '_ \  / _ \
	//  | |____\ V  V /| (_) ||   <  | |____ | | | || (_| || || | | ||  __/
	//  |______|\_/\_/  \___/ |_|\_\ |______||_| |_| \__, ||_||_| |_| \___|
	//                                                __/ |                
	 //                                              |___/                 
	// Original Developer: DemSquirrel 
	
	private boolean running = false;
	private Thread tread;
	private String ewokVersion = "0.2.1 Feb 2. 2016";
	private double frameCap = 1.0 / 60.0;
	private EwokGame game;
	private EwokWindow window;
	private EwokInput ewokIn;
	private int width = 0;
	private int height = 0;
	private String title = "Ewok Engine "+ewokVersion;
	private int frames = 0;

	
	public int getFrames() {
		return frames;
	}

	public Ewok(EwokGame game){
		this.game = game;
	}
	
	public synchronized void start(){
		if(running)
			return;
		
		//Init game comp
		ewokIn = new EwokInput(game);
		window = new EwokWindow(width, height, title, game);
		
		running = true;
		tread = new Thread(this);
		tread.start();
	}
	
	public void run() {
		running = true;
		if(Debugger.isEnabled()){
			Debugger.printMsg("Gameloop started");
		}
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		double frameTime = 0;
		while(running){
			
			boolean render = false;
			
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			frameTime += passedTime;
			
			while(unprocessedTime >= frameCap){
				//Update
				game.update(this,  (float) frameCap);
				ewokIn.update();
				
				unprocessedTime -= frameCap;
				render = true;
				
				if(frameTime >= 1){
					frameTime = 0;
					if(Debugger.isEnabled()){
						Debugger.printMsg("FPS: "+frames);
					}
					frames = 0;
				}
			}
			if(render){
				//draw
				//game.paint(window.getGamePanel().getGraphics());
				window.update();
				
				frames++;
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}}
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}