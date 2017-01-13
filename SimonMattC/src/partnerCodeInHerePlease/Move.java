package partnerCodeInHerePlease;

import simonMattC.ButtonInterfaceChu;
import simonMattC.MoveInterfaceChu;

public class Move implements MoveInterfaceChu {

	private ButtonInterfaceChu b; 
	
	public Move(ButtonInterfaceChu b) {
		this.b = b;
	}

	public ButtonInterfaceChu getButton() {
		return b;
	}

}