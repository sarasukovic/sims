package paket;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MoveElement extends State {

	
	
	public MoveElement(Editor ed) {
		editor = ed;
	}
	
	@Override
	public void doAction(){
	    
        MouseListener m = new MouseListener() {
        	@Override
			public void mouseReleased(MouseEvent e) {
                //ako spusti element preko drugod
				if(editor.checkPositionMove(editor.elementMoved) == true) {
					for(Element el: editor.panel.getElements()){
						if(el.getX() == editor.elementMoved.getX() && el.getY() == editor.elementMoved.getY() ){
							el.setX(0);
							el.setY(0);
							el.rectSelect.x = 0;
							el.rectSelect.y = 0;
							el.rect.x = e.getX()-30;
							el.rect.y = e.getY()-30;
							el.paramLabel.setBounds(el.rect);
							
							el.idLabel.setBounds(el.rect.x+20, el.rect.y+20, el.rect.width, el.rect.height);
							editor.panel.revalidate();
							editor.panel.repaint();
							break;
							

						}
					}
					
					
				}
				
				editor.elementMoved = null;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					for(Element el: editor.panel.getElements()){
				
					     if(el.rectSelect.contains((int)editor.panel.getMousePosition().getX(),
						    	(int)editor.panel.getMousePosition().getY())){
						    editor.elementMoved = el;
						    break;
						

					    }
				   }
   			}catch (NullPointerException i) {
				
			}
				
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
    		@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				for(Element el: editor.panel.getElements()){
					
				     if(el.rectSelect.contains((int)editor.panel.getMousePosition().getX(),
					    	(int)editor.panel.getMousePosition().getY())){
					    editor.elementMoved = el;
					    break;
					

				    }
			   }

			}
	
			
		};

		
		
		
        MouseMotionListener mm = new MouseMotionListener() {
        	@Override
			public void mouseMoved(MouseEvent e) {
				
				
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				for(Element el: editor.panel.getElements()){
					if(el.getX() == editor.elementMoved.getX() && el.getY() == editor.elementMoved.getY() ){
						el.setX(e.getX());
						el.setY(e.getY());
						el.rectSelect.x = e.getX();
						el.rectSelect.y = e.getY();
						el.rect.x = e.getX()-30;
						el.rect.y = e.getY()-30;
						el.paramLabel.setBounds(el.rect);
						el.idLabel.setBounds(el.rect.x+20, el.rect.y+20, el.rect.width, el.rect.height);
						
						editor.elementMoved = el;
						editor.panel.revalidate();
						editor.panel.repaint();
						break;
						

					}
				}

			}
		};		
		
		editor.mouseListener2 = m;
		editor.mouseMotionLis = mm;
		editor.panel.addMouseListener(m);
		editor.panel.addMouseMotionListener(mm);
		
		
		

			}
			
	
}

