package org.squirrel.core;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EwokWindow {
	
	private JFrame frame;
	private JPanel gamePanel;
	
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
	
		
	}
	public JPanel getGamePanel() {
		return gamePanel;
	}
	
	public void update(){
		frame.paintComponents(gamePanel.getGraphics());
	}
	public JFrame getFrame() {
		return frame;
	}
}
