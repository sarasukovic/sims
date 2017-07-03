package paket;

import java.util.ArrayList;

public class GroupOfElements {
	private ArrayList<Element> elements;
	private int x;
	private int y;
	private int heigth;
	private int width;
	public GroupOfElements() {
		elements = new ArrayList<Element>();
		width = 0;
		heigth = 0;
	}
	public ArrayList<Element> getElements() {
		return elements;
	}
	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	

}

