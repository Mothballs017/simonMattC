package simonMattC;

import java.awt.Color;

import gui.Components.Action;
import gui.Components.Clickable;

public interface ButtonInterfaceChu extends Clickable {
	void setColor(Color color); 
	void setX(int x);
	void setY(int y);

	void setAction(Action a);
	void highlight();
	void dim();
}
