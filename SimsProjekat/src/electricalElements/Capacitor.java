package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class Capacitor extends Element {

	private float capacity;
	
	public Capacitor() {
		super();
	}

	public Capacitor(BufferedImage image, elementType t) {
		super(image, t);
	}

	public Capacitor(Element e) {
		super(e);
	}

	public Capacitor(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
	}

	public Capacitor(int x, int y, String path) {
		super(x, y, path);
	}

	public Capacitor(String path) {
		super(path);
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	
}
