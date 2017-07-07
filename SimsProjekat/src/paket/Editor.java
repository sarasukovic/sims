package paket;

import java.awt.BorderLayout;
import java.awt.Color;
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
	private State activeState;
	private int selectedElements;
	private MouseAdapter mouseListener;

	public int getSelectedElements() {
		return selectedElements;
	}

	public void setSelectedElements(int selectedElements) {
		this.selectedElements = selectedElements;
	}
	
	public Panel getPanel() {return panel;}
	
	public void setState(State newState){
		activeState = newState;
	}
	
	public Element getElementFromPanel(){
		return e1;
	}
	
	public void setElementOnPanel(Element el){
		e1 = el;
	}
	
	public GroupOfElements getGroup() {
		return group;
	}
	
	public void doAction() {
		activeState.doAction();
	}
	
	public ActionEvent getEvent(){
		return event;
	}
	
	
	public Editor() {
	
		mouseListener = new MouseAdapter() {
    	    @Override
    	    public void mouseClicked(MouseEvent e) {
    	    	doAction();
    	    	panel.revalidate();
    	    	System.out.println("posle do action : ima "+selectedElements +" selekt elemenataa");

    	    	
    	    };    
    	 
		};
		group = new GroupOfElements();
		setBounds(0, 0, 800, 600);
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setTitle("ADMS Editor");
		ImageIcon img = new ImageIcon("images/icon.jpg");
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
	    
	    toolb.ground.setActionCommand(Element.elementType.GROUND.name());
        toolb.capacitor.setActionCommand(Element.elementType.CAPACITOR.name());
        toolb.voltageSrc.setActionCommand(Element.elementType.VOLTAGESRC.name());
        toolb.currentSrc.setActionCommand(Element.elementType.CURRENTSRC.name());
        toolb.inductor.setActionCommand(Element.elementType.INDUCTOR.name());
        toolb.resistor.setActionCommand(Element.elementType.RESISTOR.name());
        toolb.deleteB.setActionCommand("deleteElement");
        toolb.select.setActionCommand("selectElement");
        toolb.connect.setActionCommand("connectElements");
        
        toolb.ground.addActionListener(this);
        toolb.capacitor.addActionListener(this);
        toolb.voltageSrc.addActionListener(this);
        toolb.currentSrc.addActionListener(this);
        toolb.inductor.addActionListener(this);
        toolb.resistor.addActionListener(this);
        toolb.select.addActionListener(this);
        toolb.deleteB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("pokusaj brisanja");
				while(selectedElements>0){
			    	for(Element el: panel.getElements()){
			    		if(el.isSelect()){
			    			panel.getElements().remove(el);
			    			selectedElements--;
			    			break;
			    		}
			    	}
				}
				panel.revalidate();
		    	panel.repaint();
			}
		});
        toolb.connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedElements == 2){
					boolean prva = true;
					CustomLine l = new CustomLine();
					for (Element el : panel.getElements()){
						if (el.isSelect() ){
							if(!prva){
								l.setX1(el.getX());
								l.setY1(el.getY());
							}
							else{
								prva = false;
								l.setX2(el.getX());
								l.setY2(el.getY());
							}
						}
					}
					panel.getLines().add(l);
					panel.revalidate();
			    	panel.repaint();
				}
				else{
					System.out.println("moraju biti 2 elementa selektovana");
				}
			}
		});
		//setVisible(true);
		panel.setBackground(Color.white);
		panel.setVisible(true);
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
		removeMouseListener(mouseListener);
		if(event.getActionCommand() == "selectElement"){
    		setState(new SelectElement(Editor.this));
    	}
    	else{
    		selectedElements = 0;
    		for(Element elem: panel.getElements()){
    			elem.setSelect(false);
    		}
    		setState(new AddElement(Editor.this));
    	}
		this.addMouseListener(mouseListener);
		
	
	}
}
