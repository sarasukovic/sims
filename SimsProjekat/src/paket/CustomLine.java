package paket;


public class CustomLine {

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private boolean up1, up2, down1, down2;
	private Element e1;
	private Element e2;
	
	
	public boolean isUp1() {
		return up1;
	}

	public void setUp1(boolean up1) {
		this.up1 = up1;
	}

	public boolean isUp2() {
		return up2;
	}

	public void setUp2(boolean up2) {
		this.up2 = up2;
	}

	public boolean isDown1() {
		return down1;
	}

	public void setDown1(boolean down1) {
		this.down1 = down1;
	}

	public boolean isDown2() {
		return down2;
	}

	public void setDown2(boolean down2) {
		this.down2 = down2;
	}

	public Element getE1() {
		return e1;
	}

	public void setE1(Element e1) {
		this.e1 = e1;
	}

	public Element getE2() {
		return e2;
	}

	public void setE2(Element e2) {
		this.e2 = e2;
	}

	public CustomLine(){
		this.x1 = 0;
		this.x2 = 0;
		this.y1 = 0;
		this.y2 = 0;
	}
	
	public CustomLine(int x1, int y1, int x2, int y2) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public int getX1() {
		return x1;
	}
	
	public void setX1(int x1) {
		this.x1 = x1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public void setX2(int x2) {
		this.x2 = x2;
	}
	
	public int getY1() {
		return y1;
	}
	
	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	public int getY2() {
		return y2;
	}
	
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public void set(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	public void set2(Element e1, Element e2, boolean up1, boolean up2){
		this.e1 = e1;
		this.e2 = e2;
		this.up1 = up1;
		this.up2 = up2;
	}
	
}
