
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Editor extends JFrame {
    private MenuBar menu;	
    private ToolBar toolb;	

	
	public Editor() {
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
	    JPanel panel = new JPanel();   
        panel.setBackground(Color.white);
        this.add(panel);
	    
		setVisible(true);

	}
	
	
	public boolean confirm(String message, String title) {
		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this, message, title, 
										JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	}
	
	
	public boolean confirm(String message) {
		return confirm(message, null);
	}
	
	
}
