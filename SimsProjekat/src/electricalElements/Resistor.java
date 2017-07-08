package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class Resistor extends Element {
	
	private float resistance;

	public Resistor() {
		super();
		resistance = 0;
	}

	public Resistor(BufferedImage image, elementType t) {
		super(image, t);
		resistance = 0;
	}

	public Resistor(Element e) {
		super(e);
		resistance = 0;
	}

	public Resistor(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
		resistance = 0;
	}

	public Resistor(int x, int y, String path) {
		super(x, y, path);
		resistance = 0;
	}

	public Resistor(String path) {
		super(path);
		resistance = 0;
	}

	public float getResistance() {
		return resistance;
	}

	public void setResistance(float resistance) {
		this.resistance = resistance;
	}
	
	
}
