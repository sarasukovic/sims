package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class Resistor extends Element {
	
	private float resistance;

	public Resistor() {
		super();
	}

	public Resistor(BufferedImage image, elementType t) {
		super(image, t);
	}

	public Resistor(Element e) {
		super(e);
	}

	public Resistor(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
	}

	public Resistor(int x, int y, String path) {
		super(x, y, path);
	}

	public Resistor(String path) {
		super(path);
	}

	public float getResistance() {
		return resistance;
	}

	public void setResistance(float resistance) {
		this.resistance = resistance;
	}
	
	
}
