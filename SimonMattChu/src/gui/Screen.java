package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gui.Components.Visible;

public abstract class Screen {

	private BufferedImage image;
	private ArrayList<Visible> viewObjects;
	
	public Screen(int width, int height) {
		viewObjects = new ArrayList<Visible>();
		initObjects(viewObjects);
		initImage(width, height);
	}
	
	public abstract void initObjects(ArrayList<Visible> viewObjects);

	public void initImage(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		update();
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public int getWidth(){
		return image.getWidth();
	}
	
	public int getHeight(){
		return image.getHeight();
	}

	public void update() {
		Graphics2D g = image.createGraphics();
//		smooth the graphics
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.setColor(Color.black);
//		g.drawString("Hello World", 40, 100);
//		g.drawOval(22, 70, 100, 50);
//		for(int i = 0; i<viewObjects.size(); i++){
//		
//		}
		for(int i = 0; i < viewObjects.size(); i++){
			Visible v = viewObjects.get(i);
			g.drawImage(v.getImage(), v.getX(), v.getY(), null);
		}
	}
	
	public void addObject(Visible v){
		viewObjects.add(v);
	}
	
	public void remove(Visible v){
		/**
		 * in this implementation, we have a 
		 * very simple command: remove(v)
		 * however, remove is sorta a big deal 
		 * on the AP. Here's why:
		 * 
		 * when an object is removed from a List, every 
		 * other object AFTER that object is moved up
		 * in order. Therefore, all of their respective
		 * indices must change. You MUST, MUST MUST be aware
		 * of this.
		 * 
		 * Here is a CLAAAAASSIC example:
		 * 
		 * The following is WRONG
		 * Suppose you have a List<Integer> with 
		 * {4,8,7,1}
		 * and you want to remove all integers greater than 5. You do this:
		 * for(int i = 0; i<list.size(); i++){
		 * 	if(list.get(i) > 5) list.remove(i);
		 * }
		 * YOU FAAAAAAAILLL!!!!!!!!
		 * 
		 * Why do you fail?
		 * i = 0, nothing changes
		 * i = 1, the '8' is removed
		 * now we have: 
		 * {4,7,1}
		 * i = 2 nothing changes
		 * i = 3 exit the for loop. We have
		 * {4,7,1}
		 * 
		 * THESE TWO WAYS ARE CORRECT:
		 * 
		 * for(int i = 0; i<list.size(); i++){
		 * 	while(list.get(i) > 5) list.remove(i);
		 * }
		 * 
		 * for(int i = 0; i<list.size(); i++){
		 * 	if(list.get(i) > 5){
		 * 		list.remove(i);
		 * 		i--;//compensate for i++
		 *  }
		 * }
		 * 
		 * for the same reason, this doesnt work
		 * (because the size can be changed)
		 * for(Integer i: list){
		 * 	if( i > 5) list.remove(i);
		 * }
		 * 
		 * ONE MORE NOTE:
		 * if you call list.remove(int)
		 * it will return the object being removed at that index
		 * So you could do something like this
		 * System.out.println(list.remove(0).toString()+" was removed.");
		 * 
		 */
		viewObjects.remove(v);
	}
	
	public void moveToBack(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			//the "back" is index 0
			viewObjects.add(0,v);
			//This moves everything else forward in the list
		}
	}
	
	public void moveToFront(Visible v){
		if(viewObjects.contains(v)){
			viewObjects.remove(v);
			viewObjects.add(v);
		}
	}
	
	//represents ABILITY to listen to mouse but isnt actually doing something
	public MouseMotionListener getMouseMotionListener(){
		return null;
	}
	
	public MouseListener getMouseListener(){
		return null;
	}
}
//				Array				ArrayList
//												v wrapper class
//declaration	int[] numbs			ArrayList<Integer> numbs;
//					^primitive type
//instantiation	nums = new int[5]	nums = new ArrayList<Integer>();\
//										v appends to List increases size
//adding items	num[i] = 4;			nums.add(new Integer(5));
//					^overrides element at  
//length/size	nums.length;		nums.size();
//