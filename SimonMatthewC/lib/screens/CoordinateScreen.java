package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gui.Components.Button;
import gui.Components.TextArea;
import gui.Components.Action;
import java.util.ArrayList;

import gui.Screen;
import gui.Components.TextLabel;
import gui.Components.Visible;
import gui.sampleGames.MouseFollower;
import sampleImages.Graphic;

public class CoordinateScreen extends Screen implements MouseMotionListener,MouseListener{

	private Button button;
	private TextLabel text;
	private TextArea area;
	private Graphic bat;

	public CoordinateScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(20, 200, 500, 40, "Batman");
		//		button = new Button(20,100,80,40,"Button", new Color(100,100,250), new Action() {
		//			public void act(){
		//				
		//			}
		//		});
		button = new Button(40,50,100,30,"Button",new Color(0,76,153), new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.myScreen);
			}
		});
		area = new TextArea(20, 300, 700, 100, "Click on button to see BATMAN in XL mode");
		//bat = new Graphic(150,30,.5,"resources/sampleImages/bat.jpg");
		viewObjects.add(text);
		viewObjects.add(button);
		viewObjects.add(area);
		//viewObjects.add(bat);
	}

	public MouseListener getMouseListener(){
		return this;
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		int mx = e.getX();//get mouse X coordinates
		int my = e.getY();//get Y coord
		text.setText("Mouse at: "+mx+", "+my);
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(button.isHovered(e.getX(), e.getY())){
			button.act();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
