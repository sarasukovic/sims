
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
				if(el.rectSelect.contains((int)editor.panel.getMousePosition().getX(),
						(int)editor.panel.getMousePosition().getY())){
					if(el.isSelect()){
						el.setSelect(false);
						editor.setSelectedElements(editor.getSelectedElements()-1);

					}
					else{
						el.setSelect(true);
						editor.selected.add(el);
						editor.setSelectedElements(editor.getSelectedElements()+1);

					}
					System.out.println("slect do action: element je selektovans, sad ih je "+editor.getSelectedElements());
					System.out.println("u listi " + editor.selected.size());
					break;

				}
			}
	    
	   // System.out.println(editor.getSelectedElements());
	    
	}
}
