package gui.Components;

import java.awt.image.BufferedImage;

public interface Visible {

	public BufferedImage getImage();
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public int getWidth();
	public int getHeight();
	public boolean isAnimated();
	public void update();
	
}
