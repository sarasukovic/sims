package paket;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
				editor.panel.repaint();
                editor.getPanel().setBackground(Color.white);
                editor.add(editor.getPanel());
                editor.setVisible(true);
            }
		});
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Open file from disk");
				XStream xstream = new XStream(new DomDriver());
				FileReader fileReader = null;
				try {
					fileReader = new FileReader("saveFile.xml");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Panel p = (Panel)xstream.fromXML(fileReader);
				editor.panel = p;
				editor.panel.repaint();
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Save file");
				XStream xstream = new XStream(new DomDriver());
				//xstream.alias("editor", Editor.class);
				try {
					xstream.toXML(editor.getPanel(), new FileWriter("saveFile.xml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		saveAs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ARG0) {
				System.out.println("Save as");
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
