package partnerCodeInHerePlease;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.Components.Component;
import simonMattC.ProgressInterfaceChu;

public class Progress extends Component implements ProgressInterfaceChu {

	private static final int WIDTH = 130;
	private static final int HEIGHT = 60;

	private boolean gameOver;
	private String round;
	private String sequence;

	public Progress() {
		super(330, 100, WIDTH, HEIGHT);
	}

	public void setRound(int roundNumber) {
		round = "Round " + roundNumber;
		update();
	}

	public void setSequenceLength(int size) {
		sequence = "Sequence length " + size;
		update();
	}

	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if (gameOver) {
			g.setColor(new Color(255, 55, 90));
			g.fillOval(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (WIDTH - fm.stringWidth(go)) / 2, 20);
			g.drawString(sequence, (WIDTH - fm.stringWidth(sequence)) / 2, 40);

		} else {
			g.setColor(new Color(220, 255, 230));
			g.fillOval(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.black);
			if (round != null && sequence != null) {

				g.drawString(round, (WIDTH - fm.stringWidth(round)) / 2, 20);
				g.drawString(sequence, (WIDTH - fm.stringWidth(sequence)) / 2, 40);
			}
		}
	}

}