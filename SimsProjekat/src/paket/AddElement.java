package paket;

import electricalElements.*;
import javax.swing.JOptionPane;


public class AddElement extends State {

	public AddElement(Editor ed){
		editor = ed;
	}
	
	@Override
	public void doAction(){
		if(editor.getEvent().getActionCommand() == Element.elementType.GROUND.name()){
    		editor.setElementOnPanel(new Ground("src/images/ground.png"));
    	}
    	else if(editor.getEvent().getActionCommand() == Element.elementType.CAPACITOR.name()){
    		editor.setElementOnPanel(new Capacitor("src/images/capacitor.png"));
    	}
    	else if(editor.getEvent().getActionCommand() == Element.elementType.VOLTAGESRC.name()){
    		editor.setElementOnPanel(new VoltageSource("src/images/voltageSrc.png"));
    	}
    	else if(editor.getEvent().getActionCommand() == Element.elementType.CURRENTSRC.name()){
    		editor.setElementOnPanel(new CurrentSource("src/images/currentSrc.png"));
    	}
    	else if(editor.getEvent().getActionCommand() == Element.elementType.INDUCTOR.name()){
    		editor.setElementOnPanel(new Inductor("src/images/inductor.png"));
    	}
    	else if(editor.getEvent().getActionCommand() == Element.elementType.RESISTOR.name()){
    		editor.setElementOnPanel(new Resistor("src/images/resistor.png"));
    	}else{
    		JOptionPane.showMessageDialog(null, "Symbol is not chosen ",
    				"InfoBox: " + "Error",	JOptionPane.INFORMATION_MESSAGE);
    	}
    	
		editor.getGroup().setHeigth(editor.getElementFromPanel().getHeigth());
	    editor.getGroup().setWidth(editor.getElementFromPanel().getWidth());
	    	
	    	
	    editor.getElementFromPanel().setX((int)editor.panel.getMousePosition().getX());
	    editor.getElementFromPanel().setY((int)editor.panel.getMousePosition().getY());
	    editor.getElementFromPanel().rect.x = editor.getElementFromPanel().getX()-30;
	    editor.getElementFromPanel().rect.y = editor.getElementFromPanel().getY()-30;
	    editor.getElementFromPanel().rectSelect.x = editor.getElementFromPanel().getX();
	    editor.getElementFromPanel().rectSelect.y = editor.getElementFromPanel().getY();
	    	
	    	// doda u listu pa ako postoji na toj poziciji obrise ga
	    editor.getGroup().getElements().add(editor.getElementFromPanel());
		editor.panel.getElements().add(editor.getElementFromPanel());
	    	
	    if(editor.checkPosition(editor.getElementFromPanel()) == false){
              	    		
	    	editor.panel.repaint();
	    		
	    	}else{
	    		editor.panel.getElements().remove(editor.getElementFromPanel());
	    		editor.panel.revalidate();
	    		editor.panel.repaint();
    	}
	}

}
