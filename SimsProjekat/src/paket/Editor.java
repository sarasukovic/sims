package paket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Editor extends JFrame {
	public final int element_size = 20;
	public final int line_size = 20;
    private MenuBar menu;	
    private ToolBar toolb;	
    private Panel panel;
    private int x;
    private int y;
	private GroupOfElements group;
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
		menu = new MenuBar(this);
		toolb = new ToolBar(this);
		setJMenuBar(menu);		
	    this.add(toolb,BorderLayout.NORTH);
	    
	    
	    // drawing area
	    panel = new Panel(); 
        panel.setBackground(Color.white);
        
        toolb.ground.addActionListener(new ActionListener() {
        	Element e1;
            @Override
            public void actionPerformed(ActionEvent e) {
            	addMouseListener(new MouseAdapter() {
            	    @Override
            	    public void mouseClicked(MouseEvent e) {
            	    	e1 = new Element("ground.png");
            	        System.out.println(("x : " +  e.getX()) + "" + ("y: " + e.getY()));
	            		group.setHeigth(e1.getHeigth());
	         	    	group.setWidth(e1.getWidth());
	         	    	
	         	    	e1.setX((int)panel.getMousePosition().getX());
	         	    	e1.setY((int)panel.getMousePosition().getY());
	         	    	
	         	    	group.getElements().add(e1);
	            	    panel.getElements().add(e1);
	            	    panel.repaint();
		        	    
	         	    	updateGroupSize(e1);    
            	    }
            	});
            	
	            }
        });
        
        toolb.capacitor.addActionListener(new ActionListener() {
        	Element e1;
        	
 	    	
            @Override
            public void actionPerformed(ActionEvent e) {
            	addMouseListener(new MouseAdapter() {
            	    @Override
            	    public void mouseClicked(MouseEvent e) {
            	    	e1 = new Element("capacitor.png");
	            		group.setHeigth(e1.getHeigth());
	         	    	group.setWidth(e1.getWidth());
	         	    	System.out.println(("x : " +  e.getX()) + "" + ("y: " + e.getY()));
	         	    	e1.setX((int)panel.getMousePosition().getX());
	         	    	e1.setY((int)panel.getMousePosition().getY());
	         	    	
	         	    	group.getElements().add(e1);
	            	    panel.getElements().add(e1);
	            	    panel.repaint();
		        	    
	         	    	updateGroupSize(e1);
            	    }
            	});
            }
        });
        
        toolb.voltageSrc.addActionListener(new ActionListener() {
        	Element e1;
        	
 	    	
            @Override
            public void actionPerformed(ActionEvent e) {
            	addMouseListener(new MouseAdapter() {
            	    @Override
            	    public void mouseClicked(MouseEvent e) {
            	    	e1 = new Element("voltageSrc.png");
	            		group.setHeigth(e1.getHeigth());
	         	    	group.setWidth(e1.getWidth());
	         	    	System.out.println(("x : " +  e.getX()) + "" + ("y: " + e.getY()));
	         	    	e1.setX((int)panel.getMousePosition().getX());
	         	    	e1.setY((int)panel.getMousePosition().getY());
	         	    	
	         	    	group.getElements().add(e1);
	            	    panel.getElements().add(e1);
	            	    panel.repaint();
		        	    
	         	    	updateGroupSize(e1);
            	    }
            	});
            }
        });
        

        toolb.currentSrc.addActionListener(new ActionListener() {
        	Element e1;
            @Override
            public void actionPerformed(ActionEvent e) {
            	addMouseListener(new MouseAdapter() {
            	    @Override
            	    public void mouseClicked(MouseEvent e) {
            	    	e1 = new Element("currentSrc.png");
	            		group.setHeigth(e1.getHeigth());
	         	    	group.setWidth(e1.getWidth());
	         	    	System.out.println(("x : " +  e.getX()) + "" + ("y: " + e.getY()));
	         	    	e1.setX((int)panel.getMousePosition().getX());
	         	    	e1.setY((int)panel.getMousePosition().getY());
	         	    	
	         	    	group.getElements().add(e1);
	            	    panel.getElements().add(e1);
	            	    panel.repaint();
		        	    
	         	    	updateGroupSize(e1);
            	    }
            	});
            	
	            }
        });
        
        toolb.inductor.addActionListener(new ActionListener() {
        	Element e1;
            @Override
            public void actionPerformed(ActionEvent e) {
            	addMouseListener(new MouseAdapter() {
            	    @Override
            	    public void mouseClicked(MouseEvent e) {
            	    	e1 = new Element("inductor.png");
	            		group.setHeigth(e1.getHeigth());
	         	    	group.setWidth(e1.getWidth());
	         	    	System.out.println(("x : " +  e.getX()) + "" + ("y: " + e.getY()));
	         	    	e1.setX((int)panel.getMousePosition().getX());
	         	    	e1.setY((int)panel.getMousePosition().getY());
	         	    	
	         	    	group.getElements().add(e1);
	            	    panel.getElements().add(e1);
	            	    panel.repaint();
		        	    
	         	    	updateGroupSize(e1);
            	    }
            	});
            	
	            }
        });
        
        toolb.resistor.addActionListener(new ActionListener() {
        	Element e1;
            @Override
            public void actionPerformed(ActionEvent e) {
            	addMouseListener(new MouseAdapter() {
            	    @Override
            	    public void mouseClicked(MouseEvent e) {
            	    	e1 = new Element("resistor.png");
	            		group.setHeigth(e1.getHeigth());
	         	    	group.setWidth(e1.getWidth());
	         	    	System.out.println(("x : " +  e.getX()) + "" + ("y: " + e.getY()));
	         	    	e1.setX((int)panel.getMousePosition().getX());
	         	    	e1.setY((int)panel.getMousePosition().getY());
	         	    	
	         	    	group.getElements().add(e1);
	            	    panel.getElements().add(e1);
	            	    panel.repaint();
		        	    
	         	    	updateGroupSize(e1);
	         	    	//updateGroupSize(e1);
            	    }
            	});
            	
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
	
	
}
