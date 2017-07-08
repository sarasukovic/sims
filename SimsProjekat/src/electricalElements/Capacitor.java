package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class Capacitor extends Element {

	private float capacity;
	
	public Capacitor() {
		super();
		capacity = 0;
	}

	public Capacitor(BufferedImage image, elementType t) {
		super(image, t);
		capacity = 0;
	}

	public Capacitor(Element e) {
		super(e);
		capacity = 0;
	}

	public Capacitor(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
		capacity = 0;
	}

	public Capacitor(int x, int y, String path) {
		super(x, y, path);
		capacity = 0;
	}

	public Capacitor(String path) {
		super(path);
		capacity = 0;
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	
}
