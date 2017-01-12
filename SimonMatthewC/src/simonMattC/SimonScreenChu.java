package simonMattC;

import java.awt.Color;


import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import gui.Components.Action;
import gui.Components.TextLabel;
import gui.Components.Visible;
import gui.screens.ClickableScreen;
import partnerCodeInHerePlease.Button;
import simonMattC.ButtonInterfaceChu;
import simonMattC.MoveInterfaceChu;
import simonMattC.SimonScreenChu;

public class SimonScreenChu extends ClickableScreen implements Runnable {

	private ArrayList<MoveInterfaceChu> sequence;
	private ButtonInterfaceChu[] buttons;
	private ProgressInterfaceChu progress;
	private TextLabel label;
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;

	public SimonScreenChu(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		Color[] colors = {Color.red, Color.blue, Color.orange, Color.green, Color.yellow};
		int buttonCount = 5;
		buttons = new ButtonInterfaceChu[buttonCount];
		for(int i = 0; i < buttonCount; i++ ){
			buttons[i] = getAButton();
			buttons[i].setColor(colors[i]);
			buttons[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(buttonCount))));
			buttons[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(buttonCount))));
			final ButtonInterfaceChu b = buttons[i];
			System.out.println(b+" has x = "+b.getX()+", y ="+b.getY());
			b.dim();
			buttons[i].setAction(new Action() {

				public void act() {

						Thread buttonPress = new Thread(new Runnable() {
							
							public void run() {
								b.highlight();
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								b.dim();
								
							}
						});
						buttonPress.start();
						

						if(acceptingInput && sequence.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}else if(acceptingInput){
							progress.gameOver();
							return;
						}
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreenChu.this);
							nextRound.start();
						}
					}

			});
			viewObjects.add(buttons[i]);
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceChu>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;

		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceChu randomMove() {
		ButtonInterfaceChu b = null;//SUBJECT TO CHANGE
		int randButton = (int)(Math.random()*buttons.length);
		while(randButton != lastSelectedButton){
			randButton = (int)(Math.random()*buttons.length);
		}
		lastSelectedButton = randButton;
		return getMove(b);
	}

	private MoveInterfaceChu getMove(ButtonInterfaceChu b) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
		Placeholder until partner finishes implementation of ProgressInterface
	 */
	private ProgressInterfaceChu getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		randomMove();
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceChu b = null;
		for(MoveInterfaceChu m: sequence){
			if(b != null){
				b.dim();
			}
			b = m.getButton();
			b.highlight();
			int sleepTime = (int)(2000*(2.0/(roundNumber+2)));
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private ButtonInterfaceChu getAButton() {
		return null;
	}

}
