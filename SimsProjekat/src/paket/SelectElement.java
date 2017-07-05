package paket;

public class SelectElement extends State {
	
	public SelectElement(Editor ed) {
		editor = ed;
	}
	
	@Override
	public void doAction(){
		System.out.println("select");
	}
}
