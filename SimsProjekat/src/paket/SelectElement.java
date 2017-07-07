
package paket;
public class SelectElement extends State {
	
	public SelectElement(Editor ed) {
		editor = ed;
	}
	
	@Override
	public void doAction(){
		System.out.println("select do action");

	    //if(editor.getEvent().getActionCommand() != "deleteElement"){
			for(Element el: editor.panel.getElements()){
				if(el.rect.contains((int)editor.panel.getMousePosition().getX(),
						(int)editor.panel.getMousePosition().getY())){
					el.setSelect(true);
					editor.setSelectedElements(editor.getSelectedElements()+1);
					System.out.println("slect do action: element je selektovans, sad ih je "+editor.getSelectedElements());
					break;

				}
			}
	    
	   // System.out.println(editor.getSelectedElements());
	    
	}
}
