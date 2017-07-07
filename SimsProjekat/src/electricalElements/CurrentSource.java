package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class CurrentSource extends Element {

	private float power;

	public CurrentSource() {
		super();
	}

	public CurrentSource(BufferedImage image, elementType t) {
		super(image, t);
	}

	public CurrentSource(Element e) {
		super(e);
	}

	public CurrentSource(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
	}

	public CurrentSource(int x, int y, String path) {
		super(x, y, path);
	}

	public CurrentSource(String path) {
		super(path);
	}

	public float getPower() {
		return power;
	}

	public void setPower(float power) {
		this.power = power;
	}
	
	
	
}
