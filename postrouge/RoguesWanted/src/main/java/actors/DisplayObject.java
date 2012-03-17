package main.java.actors;

public class DisplayObject {
	private int background;
	private int foreground;
	private String character;
	
	public DisplayObject(int bg, int fg, String ch){
		background = bg;
		foreground = fg;
		character = ch;
	}
	
	public int getBackground() {
		return background;
	}
	public void setBackground(int background) {
		this.background = background;
	}
	public int getForeground() {
		return foreground;
	}
	public void setForeground(int foreground) {
		this.foreground = foreground;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
