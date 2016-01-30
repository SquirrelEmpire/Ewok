package org.squirrel.core;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class EwokGame extends JPanel{
	
	private static final long serialVersionUID = 2932088123388575115L;
	public EwokGame() {
		setFocusable(true);
	}
	public abstract void update(Ewok ew);
	public abstract void paint(Graphics g);
}
