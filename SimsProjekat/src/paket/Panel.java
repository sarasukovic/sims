package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.JPanel;

/*
 Nasa panel klasa koja sadrzi jos i listu elemenata koje iscrtavamo. Ova lista
 sadrzi bas elemente (ne grupu) zbog repaint-a
 */
public class Panel extends JPanel {
	private ArrayList<Element> elements;
	private ArrayList<Line> lines;
	public Panel() {
		this.elements= new ArrayList<Element>();
    }

    public ArrayList<Element> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}

	@Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        for(Element e : elements){
        	g.drawImage(e.getImage(), e.getX(), e.getY(), null);
        	//g.drawRect(e.rect.x, e.rect.y, e.rect.width, e.rect.width);
        }
        //isto i za linije
    }


}

