package paket;
import java.awt.event.ActionEvent;
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
				editor.panel.getElements().clear();
                //editor.getPanel().setBackground(Color.white);
                //editor.setVisible(true);
				editor.panel.repaint();

                //editor.add(editor.getPanel());
                
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
                		xstream.fromXML(fis, p);
                	} catch (FileNotFoundException e) {
                		e.printStackTrace();
                	}
				

                	Element eli;
                	for(Element elem: p.getElements()){ //kopira elemente
                		eli = new Element(elem);
                		editor.panel.getElements().add(eli);
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
				System.out.println("Save file");
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
                	
                if(code == saveFile.APPROVE_OPTION){
               		String path = saveFile.getSelectedFile().getAbsolutePath();
               		try {
               			FileOutputStream fs = new FileOutputStream(path);
               			xstream.toXML(editor.getPanel(), fs);
               		} catch (IOException e) {
               			e.printStackTrace();
               		}
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
