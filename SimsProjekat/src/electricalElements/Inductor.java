package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class Inductor extends Element {
	
	private float inductance;

	public Inductor() {
		super();
		inductance = 0;
	}

	public Inductor(BufferedImage image, elementType t) {
		super(image, t);
		inductance = 0;
	}

	public Inductor(Element e) {
		super(e);
		inductance = 0;
	}

	public Inductor(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
		inductance = 0;
	}

	public Inductor(int x, int y, String path) {
		super(x, y, path);
		inductance = 0;
	}

	public Inductor(String path) {
		super(path);
		inductance = 0;
	}

	public float getInductance() {
		return inductance;
	}

	public void setInductance(float inductance) {
		this.inductance = inductance;
	}
	
	
}
