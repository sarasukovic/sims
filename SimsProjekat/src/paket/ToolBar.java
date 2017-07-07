package paket;



import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;



public class ToolBar extends JToolBar {
	public JButton capacitor = new JButton(new ImageIcon("images/capacitor.png"));
	public JButton currentSrc = new JButton(new ImageIcon("images/currentSrc.png"));
	public JButton ground= new JButton(new ImageIcon("images/ground.png"));
	public JButton inductor = new JButton(new ImageIcon("images/inductor.png"));
	public JButton resistor = new JButton(new ImageIcon("images/resistor.png"));
	public JButton voltageSrc = new JButton(new ImageIcon("images/voltageSrc.png"));
	public JCheckBox ser = new JCheckBox("Serial link");
	public JCheckBox par = new JCheckBox("Parallel link");
	public JButton deleteB = new JButton(new ImageIcon("images/delete.jpg"));
	public JButton moveB = new JButton(new ImageIcon("images/move.jpg"));
	public JButton select = new JButton(new ImageIcon("images/select.jpg"));
	public JButton addParams = new JButton(new ImageIcon("images/addP.jpg"));
	public JButton line = new JButton(new ImageIcon("images/line.jpg"));
	
	protected List<JButton> buttons = new ArrayList<JButton>();
	
	public JButton getCapacitor() {
		return capacitor;
	}

	public void setCapacitor(JButton capacitor) {
		this.capacitor = capacitor;
	}

	protected Editor editor;
	
	private JButton addImageButton(JButton b) {
		Dimension d = new Dimension(30, 30);
		b.setPreferredSize(d);
		b.setMinimumSize(d);
		b.setMaximumSize(d);
		buttons.add(b);
		return b;
	}
	/*private void select(JButton button) {
		for(JButton b : buttons) {
			b.setSelected(false);
			b.setBackground(null);
		}
		button.setSelected(true);
		button.setBackground(Color.white);
	}*/
	
	
	
	public ToolBar(Editor editor) {
		this.editor = editor;
		setOrientation(HORIZONTAL);
		setFloatable(false);
		
		add(addImageButton(capacitor));
		addSeparator();
		add(addImageButton(currentSrc));
		addSeparator();
		add(addImageButton(ground));
		addSeparator();
		add(addImageButton(inductor));
		addSeparator();
		add(addImageButton(resistor));
		addSeparator();
		add(addImageButton(voltageSrc));
		addSeparator();
		add(ser);
		addSeparator();
		add(par);
		addSeparator();
		add(addImageButton(deleteB));
		addSeparator();
		add(addImageButton(moveB));
		addSeparator();
		add(addImageButton(select));
		addSeparator();
		add(addImageButton(addParams));
		addSeparator();
		add(addImageButton(line));
		addSeparator();
	}	
}
