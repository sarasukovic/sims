import javax.swing.*;

public class MenuBar extends JMenuBar {

	protected Editor parent;
	
	
	
	public MenuBar(final Editor parent) {
		this.parent = parent;
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
	}
	
	
}
