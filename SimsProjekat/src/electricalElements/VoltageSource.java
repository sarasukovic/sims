package electricalElements;

import java.awt.image.BufferedImage;

import paket.Element;

public class VoltageSource extends Element {
	
	private float voltage;

	public VoltageSource() {
		super();
		voltage = 0;
	}

	public VoltageSource(BufferedImage image, elementType t) {
		super(image, t);
		voltage = 0;
	}

	public VoltageSource(Element e) {
		super(e);
		voltage = 0;
	}

	public VoltageSource(int x, int y, BufferedImage image, elementType t) {
		super(x, y, image, t);
		voltage = 0;
	}

	public VoltageSource(int x, int y, String path) {
		super(x, y, path);
		voltage = 0;
	}

	public VoltageSource(String path) {
		super(path);
		voltage = 0;
	}

	public float getVoltage() {
		return voltage;
	}

	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}
	
	
}
