package NoobCreate;

import java.awt.Color;
import java.awt.Font;

public class EveryGra {
	int GraType = 2;
	Color GraColor;
	boolean isFilled = false;
	int sx,sy,ex,ey;
	String GraText;
	Font TextFont;
	public EveryGra(int graType, Color graColor, boolean isFilled, int sx,
			int sy, int ex, int ey, String graText, Font textFont) {
		GraType = graType;
		GraColor = graColor;
		this.isFilled = isFilled;
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
		GraText = graText;
		TextFont = textFont;
	}
	
}
