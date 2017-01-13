package simonMattC;

import java.awt.Color;

import gui.Components.Action;
import gui.Components.Clickable;

public interface ButtonInterfaceChu extends Clickable {
	void setColor(Color color);
	void highlight();
	void dim();
	void setAction(Action action);
}
