package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class CurrentSource extends Element {

	private float power;

	public CurrentSource() {
		super();
		power = 0;
	}

	public CurrentSource(BufferedImage image, elementType t) {
		super(image, t);
		power = 0;
	}

	public CurrentSource(Element e) {
		super(e);
		power = 0;
	}

	public CurrentSource(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
		power = 0;
	}

	public CurrentSource(int x, int y, String path) {
		super(x, y, path);
		power = 0;
	}

	public CurrentSource(String path) {
		super(path);
		power = 0;
	}

	public float getPower() {
		return power;
	}

	public void setPower(float power) {
		this.power = power;
	}
	
	
	
}
