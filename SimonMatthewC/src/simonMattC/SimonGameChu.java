package simonMattC;

import gui.GUIApplication;

public class SimonGameChu extends GUIApplication {

	public SimonGameChu(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		SimonScreenChu ss = new SimonScreenChu(getWidth(),getHeight());
		setScreen(ss);
	}

	public static void main(String[] args) {
		SimonGameChu sg = new SimonGameChu(800,500);
		Thread game = new Thread(sg);
		game.start();
	}

}
