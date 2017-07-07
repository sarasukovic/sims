package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class VoltageSource extends Element {
	
	private float voltage;

	public VoltageSource() {
		super();
	}

	public VoltageSource(BufferedImage image, elementType t) {
		super(image, t);
	}

	public VoltageSource(Element e) {
		super(e);
	}

	public VoltageSource(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
	}

	public VoltageSource(int x, int y, String path) {
		super(x, y, path);
	}

	public VoltageSource(String path) {
		super(path);
	}

	public float getVoltage() {
		return voltage;
	}

	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	
	
}
