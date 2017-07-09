
package paket;
public class SelectElement extends State {
	
	public SelectElement(Editor ed) {
		editor = ed;
	}
	
	@Override
	public void doAction(){
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
					editor.panel.revalidate();
					editor.panel.repaint();
					break;

				}
			}
	}
}
