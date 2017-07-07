package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class Inductor extends Element {
	
	private float inductance;

	public Inductor() {
		super();
	}

	public Inductor(BufferedImage image, elementType t) {
		super(image, t);
	}

	public Inductor(Element e) {
		super(e);
	}

	public Inductor(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
	}

	public Inductor(int x, int y, String path) {
		super(x, y, path);
	}

	public Inductor(String path) {
		super(path);
	}

	public float getInductance() {
		return inductance;
	}

	public void setInductance(float inductance) {
		this.inductance = inductance;
	}
	
	
}
