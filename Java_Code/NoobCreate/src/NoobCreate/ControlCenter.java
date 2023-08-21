package NoobCreate;

import java.awt.Color;

public class ControlCenter {
	private static Color ShapeColor = Color.black;
	
	private static String DrawingText = "Text here";
	
	private static Color DrawingBackGroundColor = Color.white;
	
	private static Integer TextSize = 15;
	private static boolean FillShape = false;
	
	private static int PainterShape = 2;
	//Ä¬ÈÏÎª»­Ïß

	public static Color getShapeColor() {
		return ShapeColor;
	}

	public static void setShapeColor(Color shapeColor) {
		ShapeColor = shapeColor;
	}

	public static String getDrawingText() {
		return DrawingText;
	}

	public static void setDrawingText(String drawingText) {
		DrawingText = drawingText;
	}

	public static Color getDrawingBackGroundColor() {
		return DrawingBackGroundColor;
	}

	public static void setDrawingBackGroundColor(Color drawingBackGroundColor) {
		DrawingBackGroundColor = drawingBackGroundColor;
	}

	public static Integer getTextSize() {
		return TextSize;
	}

	public static void TextSizePlus1(){
		TextSize = TextSize + 1;
	}

	public static void TextSizeMinus1(){
		TextSize = TextSize - 1;
	}
	
	
	
	public static void setTextSize(Integer textSize) {
		TextSize = textSize;
	}

	public static boolean isFillShape() {
		return FillShape;
	}

	public static void setFillShape(boolean fillShape) {
		FillShape = fillShape;
	}

	public static int getPainterShape() {
		return PainterShape;
	}

	public static void setPainterShape(int painterShape) {
		PainterShape = painterShape;
	}
	
	
}
