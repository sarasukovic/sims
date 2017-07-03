package paket;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/*
 Klasa koja predstavlja element koji se iscrtava. 
 atributi: x, y koordinate, sirina i visina*/
public class Element {
	
	private int x;
	private int y;
	private int heigth;
	private int width;
	public Rectangle rect;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	private BufferedImage image;
	public Element() {
		
	}
	
	
	public Element(BufferedImage image) {
		this.image = image;
		this.heigth = image.getHeight();
		this.width =image.getWidth();
		this.rect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
	}
	public Element(String path) {
		try {
		       this.image = ImageIO.read(new File(path));
		       
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
		this.heigth = this.image.getHeight();
		this.width =this.image.getWidth();
		this.rect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
	}
	
	public Element(int x, int y, BufferedImage image) {
		super();
		this.x = x;
		this.y = y;
		this.heigth = image.getHeight();
		this.width = image.getWidth();
		this.image = image;
		this.rect = new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	public Element(int x, int y, String path) {
		super();
		this.x = x;
		this.y = y;
		try {
		       this.image = ImageIO.read(new File(path));
		       
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
		this.heigth = image.getHeight();
		this.width =image.getWidth();
		this.rect = new Rectangle(x, y, image.getWidth(), image.getHeight());
	
	}

}

