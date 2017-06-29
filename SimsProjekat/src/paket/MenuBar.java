package paket;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
		
		
		file.add(newFile);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		add(file);
		newFile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	// drawing area
        	    JPanel panel = new JPanel();   
                panel.setBackground(Color.white);
                editor.add(panel);
                editor.setVisible(true);
            }
		});
	}
};
