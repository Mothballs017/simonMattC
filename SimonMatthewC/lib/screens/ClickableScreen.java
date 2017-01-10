package gui.screens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Objects;

import gui.Screen;
import gui.Components.Clickable;
import gui.Components.Visible;
import sampleImages.ClickableGraphic;

public abstract class ClickableScreen extends Screen implements MouseMotionListener,MouseListener{

	ArrayList<Clickable> clickables;

	public ClickableScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		initAllObjects(viewObjects);
		clickables = new ArrayList<Clickable>();
		for(Clickable i: clickables){
			//size of ArrayList can be accessed using size()
			//element of ArrayList at index i is get(i)
			if(i instanceof Clickable){
				clickables.add((Clickable)i);
			}
		}
	}

	public abstract void initAllObjects(ArrayList<Visible> lst);

	public MouseListener getMouseListener(){
		return this;
	}

	public void mouseClicked(MouseEvent e) {
		for(Clickable i: clickables){
			if(i.isHovered(e.getX(), e.getY())){
				i.act();
			}
		}
	}
	
	public void addObject(Visible v){
		super.addObject(v);
		if(v instanceof Clickable){
			clickables.add((Clickable)v);
		}
	}



	public void remove(Visible v){
		super.remove(v);
		clickables.remove((Clickable)v);
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
