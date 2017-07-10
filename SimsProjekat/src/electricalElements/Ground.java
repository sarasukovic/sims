package electricalElements;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import paket.Element;

public class Ground extends Element {

	public Ground() {
		super();
	}

	public Ground(BufferedImage image, Element.elementType t) {
		super(image, t);
	}

	public Ground(Element e) {
		super(e);
	}

	public Ground(int x, int y, BufferedImage image, Element.elementType t) {
		super(x, y, image, t);
	}

	public Ground(int x, int y, String path) {
		super(x, y, path);
	}

	public Ground(String path) {
		super(path);
	}
	
	
}

