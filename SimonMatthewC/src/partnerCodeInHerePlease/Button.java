package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import gui.Components.Action;
import gui.Components.Component;
import simonMattC.ButtonInterfaceChu;

public class Button extends Component implements ButtonInterfaceChu {

	private Action action;
	private Color color; 

	public Button(int x, int y, int w, int h, Color color, Action action) {
		super(x, y, w, h);
		this.color = color;
		this.action = action;
		update();
	}

	@Override
	public void act() {
		this.action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		return(x>getX() && x<(getX()+getWidth()) && y>getY() && y<(getY()+getHeight()));
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
		update();
	}

	@Override
	public void setX(int x) {

	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action a) {
		this.action = a;
	}

	@Override
	public void highlight() {
		Color oldColor = this.color;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dim();
		update();
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 25);	
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}


}
