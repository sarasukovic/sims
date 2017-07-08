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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import electricalElements.Capacitor;
import electricalElements.CurrentSource;
import electricalElements.Ground;
import electricalElements.Inductor;
import electricalElements.Resistor;
import electricalElements.VoltageSource;


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
	public ArrayList<Element> selected;
	

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
	
	public boolean checkId(Element elem){
		boolean t = false;
		if(elem instanceof Capacitor){
			if(elem.getId() == null){
				t = true;
			}
		}else if(elem instanceof CurrentSource){
			if(elem.getId() == null){
				t = true;
			}
		}else if(elem instanceof Inductor){
			if(elem.getId() == null){
				t = true;
			}
		}else if(elem instanceof Resistor){
			if(elem.getId() == null){
				t = true;
			}
		}else if(elem instanceof VoltageSource){
			if(elem.getId() == null){
				t = true;
			}
		}
		return t;
	}
	
	public boolean checkParam(Element elem){
		boolean t = false;
		if(elem instanceof Capacitor){
			if(((Capacitor) elem).getCapacity() == 0){
				t = true;
			}
		}else if(elem instanceof CurrentSource){
			if(((CurrentSource) elem).getPower() == 0){
				t = true;
			}
		}else if(elem instanceof Inductor){
			if(((Inductor) elem).getInductance() == 0){
				t = true;
			}
		}else if(elem instanceof Resistor){
			if(((Resistor) elem).getResistance() == 0){
				t = true;
			}
		}else if(elem instanceof VoltageSource){
			if(((VoltageSource) elem).getVoltage() == 0){
				t = true;
			}
		}
		return t;
	}
	
	
	public void enterValue(Element elem){
		panel.setLayout(null);
		String ret = null;
		String id = null;
		String oldId = null;
		float old = 0;
		if(elem instanceof Ground){
			return;
			
		}else if(elem instanceof Capacitor){
			ret = JOptionPane.showInputDialog("Please input capacity (μF): ");
			old = ((Capacitor) elem).getCapacity();
			if(ret.length() == 0){
				elem.paramLabel.setText(String.valueOf(old) + "μF");
			}else{
				if(((Capacitor) elem).getCapacity() != 0){
					if(ret.length() > 0){
						elem.paramLabel.setText(ret + "μF");
					}
				}else{
					elem.paramLabel = new JLabel(ret + "μF");
					elem.paramLabel.setBounds(elem.rect);
					elem.paramLabel.setVisible(true);
				}
			}

			try{
				((Capacitor) elem).setCapacity(Float.valueOf(ret));
			}catch(NumberFormatException e){}
			
			id = JOptionPane.showInputDialog("Please input id : ");
			oldId = elem.getId();
			if(id.length() == 0){
				elem.idLabel.setText(oldId);
			}else{
				int t = (Integer.valueOf(id));
				if(elem.getId() != null){
					if(id.length() > 0){
						elem.idLabel.setText("C" + id);
						elem.setId("C" + t);
					}
				}else{
					elem.setId("C" + t);
					elem.idLabel = new JLabel("C" + t);
					elem.idLabel.setBounds(elem.rect.x+20, elem.rect.y+20, elem.rect.width, elem.rect.height);
					elem.idLabel.setVisible(true);
				}
			}
			panel.add(elem.paramLabel);
			EmptyBorder b = new EmptyBorder(5, 0, 5, 0);
			elem.paramLabel.setBorder(b);
			panel.add(elem.idLabel);
			
		}else if(elem instanceof CurrentSource){
			ret = JOptionPane.showInputDialog("Please input power (A): ");	
			old = ((CurrentSource) elem).getPower();
			if(ret.length() == 0){
				elem.paramLabel.setText(String.valueOf(old) + "A");
			}else{
				if(((CurrentSource) elem).getPower() != 0){
					if(ret.length() > 0){
						elem.paramLabel.setText(ret + "A");
					}
				}else{
					elem.paramLabel = new JLabel(ret + "A");
					elem.paramLabel.setBounds(elem.rect);
					elem.paramLabel.setVisible(true);
				}
			}

			try{
				((CurrentSource) elem).setPower(Float.valueOf(ret));
			}catch(NumberFormatException e){}
			
			id = JOptionPane.showInputDialog("Please input id : ");
			oldId = elem.getId();
			if(id.length() == 0){
				elem.idLabel.setText(oldId);
			}else{
				int t = (Integer.valueOf(id));
				if(elem.getId() != null){
					if(id.length() > 0){
						elem.idLabel.setText("I" + id);
						elem.setId("I" + t);
					}
				}else{
					elem.setId("I" + t);
					elem.idLabel = new JLabel("I" + t);
					elem.idLabel.setBounds(elem.rect.x+20, elem.rect.y+20, elem.rect.width, elem.rect.height);
					elem.idLabel.setVisible(true);
				}
			}
			
			panel.add(elem.paramLabel);
			EmptyBorder b = new EmptyBorder(5, 0, 5, 0);
			elem.paramLabel.setBorder(b);
			panel.add(elem.idLabel);
		
		}else if(elem instanceof Inductor){
			ret = JOptionPane.showInputDialog("Please input inductance (μH): ");
			old = ((Inductor) elem).getInductance();
			if(ret.length() == 0){
				elem.paramLabel.setText(String.valueOf(old) + "μH");
			}else{
				if(((Inductor) elem).getInductance() != 0){
					if(ret.length() > 0){
						elem.paramLabel.setText(ret + "μH");
					}
				}else{
					elem.paramLabel = new JLabel(ret + "μH");
					elem.paramLabel.setBounds(elem.rect);
					elem.paramLabel.setVisible(true);
				}
			}

			try{
				((Inductor) elem).setInductance(Float.valueOf(ret));
			}catch(NumberFormatException e){}
			
			id = JOptionPane.showInputDialog("Please input id : ");
			oldId = elem.getId();
			if(id.length() == 0){
				elem.idLabel.setText(oldId);
			}else{
				int t = (Integer.valueOf(id));
				if(elem.getId() != null){
					if(id.length() > 0){
						elem.idLabel.setText("L" + id);
						elem.setId("L" + t);
					}
				}else{
					elem.setId("L" + t);
					elem.idLabel = new JLabel("L" + t);
					elem.idLabel.setBounds(elem.rect.x+20, elem.rect.y+20, elem.rect.width, elem.rect.height);
					elem.idLabel.setVisible(true);
				}
			}
			
			panel.add(elem.paramLabel);
			EmptyBorder b = new EmptyBorder(5, 0, 5, 0);
			elem.paramLabel.setBorder(b);
			panel.add(elem.idLabel);
			
		}else if(elem instanceof Resistor){
			ret = JOptionPane.showInputDialog("Please input resistance (Ω): ");
			old = ((Resistor) elem).getResistance();
			if(ret.length() == 0){
				elem.paramLabel.setText(String.valueOf(old) + "Ω");
			}else{
				if(((Resistor) elem).getResistance() != 0){
					if(ret.length() > 0){
						elem.paramLabel.setText(ret + "Ω");
					}
				}else{
					elem.paramLabel = new JLabel(ret + "Ω");
					elem.paramLabel.setBounds(elem.rect);
					elem.paramLabel.setVisible(true);
				}
			}

			try{
				((Resistor) elem).setResistance(Float.valueOf(ret));
			}catch(NumberFormatException e){}
			
			id = JOptionPane.showInputDialog("Please input id : ");
			oldId = elem.getId();
			if(id.length() == 0){
				elem.idLabel.setText(oldId);
			}else{
				int t = (Integer.valueOf(id));
				if(elem.getId() != null){
					if(id.length() > 0){
						elem.idLabel.setText("R" + id);
						elem.setId("R" + t);
					}
				}else{
					elem.setId("R" + t);
					elem.idLabel = new JLabel("R" + t);
					elem.idLabel.setBounds(elem.rect.x+20, elem.rect.y+20, elem.rect.width, elem.rect.height);
					elem.idLabel.setVisible(true);
				}
			}
			
			panel.add(elem.paramLabel);
			EmptyBorder b = new EmptyBorder(5, 0, 5, 0);
			elem.paramLabel.setBorder(b);
			panel.add(elem.idLabel);
			
		}else if(elem instanceof VoltageSource){
			ret = JOptionPane.showInputDialog("Please input voltage (V): ");
			old = ((VoltageSource) elem).getVoltage();
			if(ret.length() == 0){
				elem.paramLabel.setText(String.valueOf(old) + "V");
			}else{
				if(((VoltageSource) elem).getVoltage() != 0){
					if(ret.length() > 0){
						elem.paramLabel.setText(ret + "V");
					}
				}else{
					elem.paramLabel = new JLabel(ret + "V");
					elem.paramLabel.setBounds(elem.rect);
					elem.paramLabel.setVisible(true);
				}
			}

			try{
				((VoltageSource) elem).setVoltage(Float.valueOf(ret));
			}catch(NumberFormatException e){}
			
			id = JOptionPane.showInputDialog("Please input id : ");
			oldId = elem.getId();
			if(id.length() == 0){
				elem.idLabel.setText(oldId);
			}else{
				int t = (Integer.valueOf(id));
				if(elem.getId() != null){
					if(id.length() > 0){
						elem.idLabel.setText("V" + id);
						elem.setId("V" + t);
					}
				}else{
					elem.setId("V" + t);
					elem.idLabel = new JLabel("V" + t);
					elem.idLabel.setBounds(elem.rect.x+20, elem.rect.y+20, elem.rect.width, elem.rect.height);
					elem.idLabel.setVisible(true);
				}
			}
			
			panel.add(elem.paramLabel);
			EmptyBorder b = new EmptyBorder(5, 0, 5, 0);
			elem.paramLabel.setBorder(b);
			panel.add(elem.idLabel);
		}
	
		panel.setVisible(true);
		panel.revalidate();
		panel.repaint();

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
		selected = new ArrayList<Element>();
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
        toolb.addParams.setActionCommand("addParams");
        
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
        
        toolb.addParams.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Element el : panel.getElements()){
					if(selectedElements == 1 && el.isSelect()){
						enterValue(el);
					}else{
						if(selectedElements > 1){
							selectedElements = 1;
							for(Element elem : panel.getElements()){
								if(elem != selected.get(selected.size()-1)){
									elem.setSelect(false);
								}
							}
							enterValue(selected.get(selected.size()-1));
							break;
						}
					}
				}
				selectedElements = 0;
	    		for(Element elem: panel.getElements()){
	    			elem.setSelect(false);
	    		}
	    		selected.removeAll(selected);
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
