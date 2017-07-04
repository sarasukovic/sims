package paket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Editor extends JFrame implements ActionListener{
	public final int element_size = 20;
	public final int line_size = 20;
    private MenuBar menu;	
    private ToolBar toolb;	
    public Panel panel;
    private Element e1;
	private GroupOfElements group;
	private ActionEvent event;
	
	private enum element{
		
		GROUND,
		CAPACITOR,
		VOLTAGESRC,
		CURRENTSRC,
		INDUCTOR,
		RESISTOR
	};
	
	public Panel getPanel() {return panel;}
	
	public Editor() {
	
		
		group = new GroupOfElements();
		setBounds(0, 0, 800, 600);
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setTitle("ADMS Editor");
		ImageIcon img = new ImageIcon("icon.jpg");
		setIconImage(img.getImage());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(confirm("Are you sure you want to close ?"))
					System.exit(0);
			}
		});
		
		panel = new Panel(); 
		menu = new MenuBar(this);
		toolb = new ToolBar(this);
		setJMenuBar(menu);		
	    this.add(toolb,BorderLayout.NORTH);
	    
	    toolb.ground.setActionCommand(element.GROUND.name());
        toolb.capacitor.setActionCommand(element.CAPACITOR.name());
        toolb.voltageSrc.setActionCommand(element.VOLTAGESRC.name());
        toolb.currentSrc.setActionCommand(element.CURRENTSRC.name());
        toolb.inductor.setActionCommand(element.INDUCTOR.name());
        toolb.resistor.setActionCommand(element.RESISTOR.name());
        toolb.deleteB.setActionCommand("DeleteElement");
        
        toolb.ground.addActionListener(this);
        toolb.capacitor.addActionListener(this);
        toolb.voltageSrc.addActionListener(this);
        toolb.currentSrc.addActionListener(this);
        toolb.inductor.addActionListener(this);
        toolb.resistor.addActionListener(this);
        toolb.deleteB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// brisanje
			}
		});
        
        this.add(panel);
		setVisible(true);
	}
	
	
	public void updateGroupSize(Element e){
		//ako se serijski dodaje
		if(toolb.ser.isSelected() && !toolb.par.isSelected()){
			//povecaj sirinu za sirinu elementa i liniju
			group.setWidth(group.getWidth() + e.getWidth() + line_size);
		}
		//paralelno
		else{
			//povecaj visinu za visinu elementa i liniju
			group.setHeigth(group.getHeigth() + e.getHeigth() + line_size);
		}
		
	}
	
	public boolean confirm(String message, String title) {
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this, message, title, 
										JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	
	public boolean confirm(String message) {
		return confirm(message, null);
	}
	
	public boolean checkPosition(Element e){
		for(int i = 0; i < panel.getElements().size()-1; i++){
			if(panel.getElements().get(i).rect.contains(e.getX(), e.getY())){
				return true;
			}
		}
		return false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		event = e;
		addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mouseClicked(MouseEvent e) {
    	    	
    	    	if(event.getActionCommand() == element.GROUND.name()){
    	    		e1 = new Element("ground.png");
    	    	}
    	    	else if(event.getActionCommand() == element.CAPACITOR.name()){
    	    		e1 = new Element("capacitor.png");
    	    	}
    	    	else if(event.getActionCommand() == element.VOLTAGESRC.name()){
    	    		e1 = new Element("voltageSrc.png");
    	    	}
    	    	else if(event.getActionCommand() == element.CURRENTSRC.name()){
    	    		e1 = new Element("currentSrc.png");
    	    	}
    	    	else if(event.getActionCommand() == element.INDUCTOR.name()){
    	    		e1 = new Element("inductor.png");
    	    	}
    	    	else if(event.getActionCommand() == element.RESISTOR.name()){
    	    		e1 = new Element("resistor.png");
    	    	}else{
    	    		JOptionPane.showMessageDialog(null, "Symbol is not chosen ",
    	    				"InfoBox: " + "Error",	JOptionPane.INFORMATION_MESSAGE);
    	    	}
    	    	
        		group.setHeigth(e1.getHeigth());
     	    	group.setWidth(e1.getWidth());
     	    	
     	    	
     	    	e1.setX((int)panel.getMousePosition().getX());
     	    	e1.setY((int)panel.getMousePosition().getY());
     	    	e1.rect.x = e1.getX();
     	    	e1.rect.y = e1.getY();
     	    	
     	    	// doda u listu pa ako postoji na toj poziciji obrise ga
     	    	group.getElements().add(e1);
	    		panel.getElements().add(e1);
     	    	
     	    	if(checkPosition(e1) == false){
                      	    		
    	    		/*group.getElements().add(e1);
    	    		panel.getElements().add(e1);*/
        	    	panel.repaint();
     	    		
     	    	}else{
     	    		panel.getElements().remove(e1);
     	    		panel.revalidate();
     	    		panel.repaint();
        	    /*	JOptionPane.showMessageDialog(null, "Symbol is already on this position ",
    	    				"InfoBox: " + " Error",	JOptionPane.INFORMATION_MESSAGE);
     	    		
     	    		*/
    	    	}
    	    };
		});
	
	}
}
