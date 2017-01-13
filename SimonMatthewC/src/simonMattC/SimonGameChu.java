package simonMattC;

import gui.GUIApplication;

public class SimonGameChu extends GUIApplication {


	public SimonGameChu(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		SimonScreenChu ss = new SimonScreenChu(getWidth(), getHeight());
		setScreen(ss);
	}

	public static void main(String[] args) {
		SimonGameChu game = new SimonGameChu(800, 500);
		Thread app = new Thread(game);
		app.start();
	}

}