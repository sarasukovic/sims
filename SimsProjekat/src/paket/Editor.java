package paket;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    public Element elementMoved;
	private GroupOfElements group;
	private ActionEvent event;
	private State activeState;
	private int selectedElements;
	private MouseAdapter mouseListener;
	public MouseListener mouseListener2;
	public MouseMotionListener mouseMotionLis;
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
	
	// checkId returns true if there is no id for elem
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
	
	//  checkParam returns true if there is no params for elem
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
			JOptionPane.showMessageDialog(null, "Ground has no parameters!");

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
			
			id = JOptionPane.showInputDialog("Please input id (number) : ");
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
			
			id = JOptionPane.showInputDialog("Please input id (number) : ");
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
			
			id = JOptionPane.showInputDialog("Please input id (number) : ");
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
			
			id = JOptionPane.showInputDialog("Please input id (number) : ");
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
			
			id = JOptionPane.showInputDialog("Please input id (number) : ");
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
    	    };    
    	 
		};
		group = new GroupOfElements();
		selected = new ArrayList<Element>();
		setBounds(0, 0, 800, 600);
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null);
		setTitle("ADMS Editor");
		ImageIcon img = new ImageIcon(getClass().getResource("/icon.jpg"));
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
        toolb.deleteC.setActionCommand("cutLine");
        toolb.select.setActionCommand("selectElement");
        toolb.connect.setActionCommand("connectElements");
        toolb.addParams.setActionCommand("addParams");
        toolb.moveB.setActionCommand("moveElement");
        
        toolb.ground.addActionListener(this);
        toolb.capacitor.addActionListener(this);
        toolb.voltageSrc.addActionListener(this);
        toolb.currentSrc.addActionListener(this);
        toolb.inductor.addActionListener(this);
        toolb.resistor.addActionListener(this);
        toolb.select.addActionListener(this);
        toolb.moveB.addActionListener(this);
        toolb.deleteB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				while(selectedElements>0){
			    	for(Element el: panel.getElements()){
			    		if(el.isSelect()){
			    			e1.idLabel.setVisible(false);
			    			e1.paramLabel.setVisible(false);
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
        toolb.deleteC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> indeksi = new ArrayList<Integer>();
				for(CustomLine l : panel.getLines()){
					if(l.getE1().isSelect() && l.getE2().isSelect()){
						if(l.isUp1()){
							l.getE1().setUpEnd(false);
						}
						else{
							l.getE1().setDownEnd(false);
						}
						if(l.isUp2()){
							l.getE2().setUpEnd(false);
						}
						else{
							l.getE2().setDownEnd(false);
						}
						indeksi.add(panel.getLines().indexOf(l));		
					}
				}
				for(int i : indeksi){
					panel.getLines().remove(i);
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
				deselectAll();
	    		selected.removeAll(selected);
			}
		});
  
        toolb.connect.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selectedElements == 2){
					boolean prva = true;
					for (Element el : panel.getElements()){
						if (el.isSelect()){
							prva = false;
							for(Element el2:panel.getElements()){
								if(!el2.equals(el)&& el2.isSelect()){
									if(toolb.ser.isSelected() && !toolb.par.isSelected()){
										serial(el, el2);
									}
									else if(toolb.par.isSelected() && !toolb.ser.isSelected()){
										parallel(el,el2);
									}
									else{
										JOptionPane.showMessageDialog(null, "Choose 1 type of connection!");
									}
									break;
								}
							}
							break;
						}
					}
					deselectAll();
					panel.revalidate();
			    	panel.repaint();
				}
				else{
					JOptionPane.showMessageDialog(null, "There must be exectly 2 elements selected");
				}
			}
		});
		panel.setBackground(Color.white);
		panel.setVisible(true);
        this.add(panel);
		
	}
	
	public void parallel(Element e1, Element e2){
		int x1 = e1.getX() + e1.getWidth()/2, y1 = e1.getY(), x2 =  e2.getX() + e2.getWidth()/2, y2 = e2.getY();
		boolean down1 = e1.isDownEnd(), up1 = e1.isUpEnd(), down2 = e2.isDownEnd(), up2 = e2.isUpEnd();
		if(!(down1||down2||up1||up2)){
			CustomLine hor1 = new CustomLine();
			CustomLine ver1 = new CustomLine();
			CustomLine hor2 = new CustomLine();
			CustomLine ver2 = new CustomLine();
			if(e1.getY() + e1.getHeigth()<e2.getY()){
				hor1.set(x1, y1, x2, y1);
				hor1.set2(e1, e2, true, true);
				ver1.set(x1, y1 + e1.getHeigth(), x1, y2 + e2.getHeigth());
				ver1.set2(e1, e2, false, false);
				hor2.set(x1, y2 + e2.getHeigth(), x2, y2+e2.getHeigth());
				hor2.set2(e1, e2, false, false);
				ver2.set(x2, y1, x2, y2);
				ver2.set2(e1, e2, true, true);
			}
			else{
				hor1.set(x2, y2, x1, y2);
				hor1.set2(e1, e2, true, true);
				ver1.set(x2, y2 + e2.getHeigth(), x2, y1 + e1.getHeigth());
				ver1.set2(e1, e2, false, false);

				hor2.set(x2, y1 + e1.getHeigth(), x1, y1+e1.getHeigth());
				hor2.set2(e1, e2, false, false);

				ver2.set(x1, y2, x1, y1);
				ver2.set2(e1, e2, true, true);

			}
			e1.setUpEnd(true);
			e1.setDownEnd(true);
			e2.setUpEnd(true);
			e2.setDownEnd(true);
			panel.getLines().add(hor1);
			panel.getLines().add(ver2);
			panel.getLines().add(hor2);
			panel.getLines().add(ver1);

		}
		else{
			JOptionPane.showMessageDialog(null, "Element is allready connected!");
		}
	}
	
	public void serial(Element e1, Element e2){
		int x1 = e1.getX() + e1.getWidth()/2, y1 = e1.getY(), x2 =  e2.getX() + e2.getWidth()/2, y2 = e2.getY();
		boolean ono = false,  ono3 = false;
		boolean down1 = e1.isDownEnd(), up1 = e1.isUpEnd(), down2 = e2.isDownEnd(), up2 = e2.isUpEnd();
		boolean lup2 =false, lup1 = false;
		CustomLine hor = new CustomLine();
		CustomLine ver = new CustomLine();
		if(e1.getY() + e1.getHeigth()<e2.getY()){
			if( e2.isUpEnd() && e1.isDownEnd()){
				ono = true;
			}
			else if(e1.isDownEnd()){
				ono3 = true;
			}
			if( !e1.isDownEnd()){
				y1 = e1.getY()+e1.getHeigth();
				down1 = true;
				
			}
			else if(!e1.isUpEnd()){
				up1 = true;
				lup1 = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Element is allready connected on both ends");
				return;
			}
			if(!e2.isUpEnd()){
				up2 = true;
				lup2 = true;
			}
			else if(!e2.isDownEnd()){
				y2 = e2.getY()+e2.getHeigth();
				down2 = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Element is allready connected on both ends");
				return;
			}
			
		}
		else{
			ono3 = e1.isUpEnd();
			ono = e1.isUpEnd() && e2.isDownEnd();			
			if( !e2.isDownEnd()){
				y2 = e2.getY()+e2.getHeigth();
				down2 = true;
			}
			else if(!e2.isUpEnd()){
				up2 = true;
				lup2 = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Element is allready connected on both ends");
				return;
			}
			if(!e1.isUpEnd()){
				up1 = true;
				lup1 = true;
			}
			else if(!e1.isDownEnd()){
				y1 = e1.getY()+e1.getHeigth();
				down1 = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Element is allready connected on both ends");
				return;
			}
		}
		e1.setDownEnd(down1);
		e1.setUpEnd(up1);
		e2.setDownEnd(down2);
		e2.setUpEnd(up2);
		if(ono){
			CustomLine third = new CustomLine((x1+x2)/2,y1,(x1+x2)/2,y2);
			third.set2(e1, e2, lup1, lup2);
			hor.set(x1, y1, (x1+x2)/2,y1);
			ver.set(x2,y2,(x1+x2)/2,y2);
			panel.getLines().add(third);
		}
		else if(ono3 ){
			hor.set(x1,y1,x2,y1);
			ver.set(x2,y1,x2,y2);
		}
		else{
			hor.set(x1,y1,x1,y2);
			ver.set(x1,y2,x2,y2);
		}	
		hor.set2(e1, e2, lup1, lup2);
		ver.set2(e1, e2, lup1, lup2);
		System.out.println(hor.getE1().isSelect());
		panel.getLines().add(hor);
		panel.getLines().add(ver);
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
	
	public boolean checkPositionMove(Element e){
		for(int i = 0; i < panel.getElements().size(); i++){
			if(panel.getElements().get(i).getX() == e.getX() && panel.getElements().get(i).getY() == e.getY()) {
				continue;
			}else if(panel.getElements().get(i).rect.contains(e.getX(), e.getY())){
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
			panel.removeMouseListener(mouseListener2);
    		panel.removeMouseMotionListener(mouseMotionLis);
    		
			setState(new SelectElement(Editor.this));
    	}else if(event.getActionCommand() == "moveElement") {
    		setState(new MoveElement(Editor.this));
    		activeState.doAction();
    	}
    	else{
    		panel.removeMouseListener(mouseListener2);
    		panel.removeMouseMotionListener(mouseMotionLis);
    		deselectAll();
    		setState(new AddElement(Editor.this));
    		
    		
    	}
		this.addMouseListener(mouseListener);
	}
	public void deselectAll(){
		for(Element e: panel.getElements()){
			e.setSelect(false);
		}
		selectedElements = 0;
	}
}
