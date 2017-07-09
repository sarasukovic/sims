
package paket;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
/*
 Klasa koja predstavlja element koji se iscrtava. 
 atributi: x, y koordinate, sirina i visina*/
public class Element {
	
	public enum elementType{		
		GROUND,
		CAPACITOR,
		VOLTAGESRC,
		CURRENTSRC,
		INDUCTOR,
		RESISTOR
	};
	
	private Element.elementType type;
	private int x;
	private int y;
	private int heigth;
	private int width;
	public Rectangle rect;
	public Rectangle rectSelect;
	private boolean select;
	private String id;
	public JLabel paramLabel;
	public JLabel idLabel;
	
	public JLabel getParamLabel() {
		return paramLabel;
	}
	public void setParamLabel(JLabel paramLabel) {
		this.paramLabel = paramLabel;
	}
	public JLabel getIdLabel() {
		return idLabel;
	}

	public void setIdLabel(JLabel idLabel) {
		this.idLabel = idLabel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
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
	
	
	public Element.elementType getType() {
		return type;
	}
	public void setType(Element.elementType type) {
		this.type = type;
	}


	private BufferedImage image;
	public Element() {
		
	}
	
	
	public Element(BufferedImage image, Element.elementType t) {
		this.type = t;
		this.select = false;
		this.image = image;
		this.heigth = image.getHeight();
		this.width =image.getWidth();
		this.rect = new Rectangle(0, 0, image.getWidth()+60, image.getHeight()+60);
		this.rectSelect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
		id = null;
		paramLabel = new JLabel();
		idLabel = new JLabel();
	}
	public Element(String path) {
		try {
		       this.image = ImageIO.read(new File(path));
		       if(path.compareTo("images/capacitor.png")==0) this.type = elementType.CAPACITOR;
		       if(path.compareTo("images/currentSrc.png")==0) this.type = elementType.CURRENTSRC;
		       if(path.compareTo("images/ground.png")==0) this.type = elementType.GROUND;
		       if(path.compareTo("images/inductor.png")==0) this.type = elementType.INDUCTOR;
		       if(path.compareTo("images/resistor.png")==0) this.type = elementType.RESISTOR;
		       if(path.compareTo("images/voltageSrc.png")==0) this.type = elementType.VOLTAGESRC;
		   } catch (IOException e) {
			   e.printStackTrace();
		   }

		paramLabel = new JLabel();
		idLabel = new JLabel();
		id = null;
		this.select = false;
		this.heigth = this.image.getHeight();
		this.width =this.image.getWidth();
		this.rect = new Rectangle(0, 0, image.getWidth()+60, image.getHeight()+60);
		this.rectSelect = new Rectangle(0, 0, image.getWidth(), image.getHeight());
	}
	public Element(Element e){
		id = null;
		paramLabel = new JLabel();
		idLabel = new JLabel();
		x = e.x;
		y = e.y;
		type = e.type;
		this.select = e.select;
		String path="";
		 if(type == elementType.CAPACITOR) path = "images/capacitor.png";
	       if(this.type == elementType.CURRENTSRC) path="images/currentSrc.png" ;
	       if(this.type == elementType.GROUND) path="images/ground.png" ;
	       if(this.type == elementType.INDUCTOR) path="images/inductor.png" ;
	       if(this.type == elementType.RESISTOR) path="images/resistor.png" ;
	       if(this.type == elementType.VOLTAGESRC) path="images/voltageSrc.png" ;

	       try {
		       this.image = ImageIO.read(new File(path));
		       
		   } catch (IOException exc) {
			   exc.printStackTrace();
		   }
	       heigth = image.getHeight();
	       width = image.getWidth();
	       rect = new Rectangle(x-30, y-30, image.getWidth()+60, image.getHeight()+60);
	   	   this.rectSelect = new Rectangle(x, y, image.getWidth(), image.getHeight());

	}
	public Element(int x, int y, BufferedImage image, Element.elementType t) {
		super();
		type = t;
		id = null;
		paramLabel = new JLabel();
		idLabel = new JLabel();
		this.x = x;
		this.y = y;
		this.select = false;
		this.heigth = image.getHeight();
		this.width = image.getWidth();
		this.image = image;
		this.rect = new Rectangle(x-30, y-30, image.getWidth()+60, image.getHeight()+60);
		this.rectSelect = new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	public Element(int x, int y, String path) {
		super();
		paramLabel = new JLabel();
		idLabel = new JLabel();
		this.x = x;
		id = null;
		this.y = y;
		this.select = false;
		try {
		       this.image = ImageIO.read(new File(path));
		       
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
		 if(path.compareTo("images/capacitor.png")==1) this.type = elementType.CAPACITOR;
	       if(path.compareTo("images/currentSrc.png")==1) this.type = elementType.CURRENTSRC;
	       if(path.compareTo("images/ground.png")==1) this.type = elementType.GROUND;
	       if(path.compareTo("images/inductor.png")==1) this.type = elementType.INDUCTOR;
	       if(path.compareTo("images/resistor.png")==1) this.type = elementType.RESISTOR;
	       if(path.compareTo("images/voltageSrc.png")==1) this.type = elementType.VOLTAGESRC;

	    this.heigth = image.getHeight();
		this.width =image.getWidth();
		this.rect = new Rectangle(x-30, y-30, image.getWidth()+60, image.getHeight()+60);
	
		this.rectSelect = new Rectangle(x, y, image.getWidth(), image.getHeight());
	}

}

