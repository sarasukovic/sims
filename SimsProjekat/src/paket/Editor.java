package paket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


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
        
        //akcija za ground dugme
        //za ostale je bukvalno copy - paste samo naziv ikone drugi
        //treba videti jel moze to nekako jednostavnije, da nemamo 6 istih stvari
        //tj. jel moze jedan listener za svu dugmad u toolbar-u
        //trebalo bi da moze al ja nisam skontala kako
        toolb.ground.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//ako nisu oba ili ni jedan selektovani ili ako jos nista nije iscrtano
            	if((!(toolb.ser.isSelected() && toolb.par.isSelected())
            			&& !(!toolb.ser.isSelected() && !toolb.par.isSelected())) 
            			|| panel.getElements().size() == 0){ //kraj if-a
	            	Element e1;
	            	//ako nema jos elemenata, grupu podesi po prvom
	         	     if(panel.getElements().size() == 0){
	         	    	e1 = new Element(0, 0,"ground.png");
	         	    	group.setHeigth(e1.getHeigth());
	         	    	group.setWidth(e1.getWidth());
	         	    	group.setX(e1.getX());
	         	    	group.setY(e1.getY());
	         	     }
	         	     else{
	         	    	//inace se izracunava koordinata novog elementa 
	         	    	//i podesava velicina grupe nakon njegovog dodavanja
	         	    	e1 = new Element("ground.png");
	         	    	e1.setX(newX(e1));
	         	    	e1.setY(newY(e1));
	         	    	updateGroupSize(e1);
	         	     }
	         	     //element dodajemo u grupu i u panelovu listu za crtanje
	         	     group.getElements().add(e1);
	        	     panel.getElements().add(e1);
	        	     //crtanje
	         	     panel.repaint();
	            }
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
	
	public int newX(Element e){
		//serijski
		if(toolb.ser.isSelected() && !toolb.par.isSelected()){
			//element treba spojiti desno od cele grupe
			//tj x koordinata je sirina grupe + linija (+ x koordinata grupe (default 0))			
			return group.getWidth()+ line_size + group.getX();
		}
		//paralelno
		else {
			//element se dodaje po sredini ispod
			//tj x koordinata je polovina sirine grupe (- pomeraj za pola sirine same slicice)
			//+ x kooordinara cele grupe (default 0))
			return group.getWidth()/2 - e.getWidth()/2 + group.getX();
		}
	

	}
	//kao za x samo sve obrnuto
	public int newY(Element e){
		if(toolb.par.isSelected() && !toolb.ser.isSelected()){
			return group.getHeigth()+ line_size + group.getY();
			
		}
		else {
			return group.getHeigth()/2 - e.getHeigth()/2 + group.getY();
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
