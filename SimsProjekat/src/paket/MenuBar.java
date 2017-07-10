package paket;
import java.awt.event.ActionEvent;
import electricalElements.*;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class MenuBar extends JMenuBar {

	protected Editor editor;
	protected File opened;
	
	
	public MenuBar(final Editor parent) {
		this.editor = parent;
		JMenu file = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save as");
		JMenuItem close = new JMenuItem("Close");
		
		file.add(newFile);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.add(close);
		add(file);
		
		newFile.addActionListener(new ActionListener(){
			
			@Override
            public void actionPerformed(ActionEvent arg0) {
            	// drawing area
				editor.panel.removeAll();
				editor.panel.getLines().clear();
				editor.panel.getElements().clear();
				editor.panel.repaint();
            }
		});
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editor.panel.removeAll();
				editor.panel.getElements().clear();
				XStream xstream = new XStream(new DomDriver());
				Panel p = new Panel();
				JFileChooser openFile = new JFileChooser();
                int code = openFile.showOpenDialog(editor);
                if(code == openFile.APPROVE_OPTION){
                
                	String path = openFile.getSelectedFile().getAbsolutePath();
                	try {
                		FileInputStream fis= new FileInputStream(path);
                		try{
                			xstream.fromXML(fis, p);
                		}catch(com.thoughtworks.xstream.io.StreamException e){
                			JOptionPane.showMessageDialog(null, "Error!\n File is not"
                           	+ " .xml ", "InfoBox: " + "Error message", JOptionPane.INFORMATION_MESSAGE);
                		}
                	} catch (FileNotFoundException e) {
                		e.printStackTrace();
                	}
				

                	for(Element elem: p.getElements()){ //kopira elemente
                		if(elem.getType().name() ==  Element.elementType.GROUND.name()){
                			Element eli = new Ground(elem);
                			editor.panel.getElements().add(eli);
                		}else if(elem.getType().name() == Element.elementType.CAPACITOR.name()){
                			Element eli = new Capacitor(elem);
                			editor.panel.getElements().add(eli);
                		}else if(elem.getType().name() == Element.elementType.CURRENTSRC.name()){
                			Element eli = new CurrentSource(elem);
                			editor.panel.getElements().add(eli);
                		}else if(elem.getType().name() == Element.elementType.INDUCTOR.name()){
                			Element eli = new Inductor(elem);
                			editor.panel.getElements().add(eli);
                		}else if(elem.getType().name() == Element.elementType.RESISTOR.name()){
                			Element eli = new Resistor(elem);
                			editor.panel.getElements().add(eli);
                		}else if(elem.getType().name() == Element.elementType.VOLTAGESRC.name()){
                			Element eli = new VoltageSource(elem);
                			editor.panel.getElements().add(eli);
                		}
                	}
                	editor.panel.revalidate();	
                	editor.panel.repaint();
                }
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			// save uvek cuva u folderu projekta sa imenom koje korisnik zeli
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String input = JOptionPane.showInputDialog("Enter file name:");
				if (input != null){
					XStream xstream = new XStream(new DomDriver());
					try {
						FileOutputStream fs = new FileOutputStream(input);
						xstream.toXML(editor.getPanel(), fs);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		saveAs.addActionListener(new ActionListener() {
			
			//save as
			@Override
			public void actionPerformed(ActionEvent ARG0) {
				XStream xstream = new XStream(new DomDriver());
				JFileChooser saveFile = new JFileChooser();
				int code = saveFile.showSaveDialog(editor);
				
                if(saveFile.getSelectedFile().getName().contains(".xml")){	
                	if(code == saveFile.APPROVE_OPTION){
                		String path = saveFile.getSelectedFile().getAbsolutePath();
                		try {
                			FileOutputStream fs = new FileOutputStream(path);               				xstream.toXML(editor.getPanel(), fs);
                		} catch (IOException e) {
                			e.printStackTrace();
                		}
                	}
                }else{
                	JOptionPane.showMessageDialog(null, "Error!\n File is not"
                  	+ " .xml ", "InfoBox: " + "Error message", JOptionPane.INFORMATION_MESSAGE);
                }
			}
		});
	
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(editor.confirm("Are you sure you want to close ?"))
					System.exit(0);
			}
		});
	}
};
