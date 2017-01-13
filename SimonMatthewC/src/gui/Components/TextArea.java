package gui.Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class TextArea extends TextLabel {

	public TextArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
	}

	public void update(Graphics2D g) {
		g = clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font(getFont(), Font.PLAIN, getSize()));
		FontMetrics fm = g.getFontMetrics();
		g.setColor(Color.black);
		if(getText()!= null){
			String[] words = getText().split(" ");//splits word at every space
			if(words.length > 0){
				int i = 0;
				final int SPACING = 2;
				int y = 0 + fm.getHeight() + SPACING;
				String line = words[i] + " ";
				i++;
				while(i < words.length){//makes more lines
					//controls a single line of text
					while(i < words.length && fm.stringWidth(line) + fm.stringWidth(words[i]) < getWidth()){
						line += words[i]+ " ";
						i++;
					}
					if(y < getHeight()){
						g.drawString(line, 2, y);
						y += fm.getDescent() + fm.getHeight() + SPACING;
						line = "";
					}
					else{
						break; //print no more text
					}
				}
			}
		}
}
}
