package org.squirrel.core;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EwokWindow {
	
	private JFrame frame;
	private JPanel gamePanel;
	private BufferStrategy bs;
	
	public EwokWindow(int width, int height, String title, JPanel game){
		this.gamePanel = game;
		
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle(title);
		frame.setTitle(title);
		frame.add(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		frame.createBufferStrategy(3);
		bs = frame.getBufferStrategy();
		
	}
	public JPanel getGamePanel() {
		return gamePanel;
	}
	
	public void update(){
		frame.repaint();
		//bs.show();
	}
	public JFrame getFrame() {
		return frame;
	}
}
