package simonMattC;

import java.awt.Color;
import java.util.ArrayList;
import gui.Components.Action;
import gui.Components.TextLabel;
import gui.Components.Visible;
import gui.screens.ClickableScreen;
import partnerCodeInHerePlease.Button;
import partnerCodeInHerePlease.Move;
import partnerCodeInHerePlease.Progress;

public class SimonScreenChu extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceChu[] buttons;
	private ProgressInterfaceChu progress;
	private ArrayList<MoveInterfaceChu> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelected;

	public SimonScreenChu(int width, int height) {
		super(width, height);
		Thread screen = new Thread(this);
		screen.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		Color[] colors = { Color.red, Color.blue, Color.orange, Color.green, Color.yellow };
		int buttonCount = 5;
		buttons = new ButtonInterfaceChu[buttonCount];
		for (int i = 0; i < buttonCount; i++) {
			buttons[i] = getAButton();
			buttons[i].setColor(colors[i]);
			buttons[i].setX(220 + (i * 75));
			buttons[i].setY(200);
			final ButtonInterfaceChu b = buttons[i];
			b.dim();
			buttons[i].setAction(new Action() {
				public void act() {
					if (acceptingInput) {
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
						if (acceptingInput && sequence.get(sequenceIndex).getButton() == b) {
							sequenceIndex++;
						} else if (acceptingInput) {
							gameOver();
							acceptingInput = false;
							return;
						}
						if (sequenceIndex == sequence.size()) {
							Thread nextRound = new Thread(SimonScreenChu.this);
							nextRound.start();
						}
					}
				}

			});
			viewObjects.add(buttons[i]);
		}
		progress = getProgress();
		label = new TextLabel(130, 300, 300, 40, "");
		sequence = new ArrayList<MoveInterfaceChu>();
		// add 2 moves to start
		lastSelected = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	public void gameOver() {
		progress.gameOver();
	}

	public void nextRound() {
		acceptingInput = false;
		roundNumber++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceLength(sequence.size());
		changeText("Simon's turn.");
		label.setText("");
		showSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private MoveInterfaceChu randomMove() {
		int select = (int) (Math.random() * buttons.length);
		while (select == lastSelected) {
			select = (int) (Math.random() * buttons.length);
		}
		lastSelected = select;
		return new Move(buttons[select]);
	}

	private ProgressInterfaceChu getProgress() {
		return new Progress();
	}

	private ButtonInterfaceChu getAButton() {
		return new Button();
	}

	private void changeText(String string) {
		try {
			label.setText(string);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		changeText("");
		nextRound();
	}

	private void showSequence() {
		ButtonInterfaceChu b = null;
		for (MoveInterfaceChu m : sequence) {
			if (b != null)
				b.dim();
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long) (2000 * (2.0 / (roundNumber + 2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

}