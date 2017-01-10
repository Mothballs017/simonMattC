package gui.screens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.Components.Action;
import gui.Components.Clickable;
import gui.Components.TextLabel;
import gui.Components.Visible;
import gui.sampleGames.MouseFollower;
import sampleImages.ClickableGraphic;
import sampleImages.Graphic;

public class MovementScreen extends Screen implements MouseMotionListener,MouseListener{

	private ClickableGraphic bat;
	private TextLabel text;
	
	public MovementScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		bat = new ClickableGraphic(100,75,2.0,"resources/sampleImages/bat.jpg");
		bat.setAction(new Action(){
			public void act(){
				//MouseFollower.game.setScreen(MouseFollower.cs);
				bat.setX(bat.getX()+1);
				bat.setY(bat.getY()+0);
			}});
		text = new TextLabel(300, 450, 500, 40, "NANANANA BATMAN");
		viewObjects.add(bat);
		viewObjects.add(text);
	}

	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(bat.isHovered(e.getX(), e.getY())){
			bat.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
