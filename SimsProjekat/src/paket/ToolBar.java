package paket;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import images.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;



public class ToolBar extends JToolBar {
	public JButton capacitor = new JButton(new ImageIcon("src/images/capacitor.png"));
	public JButton currentSrc = new JButton(new ImageIcon("src/images/currentSrc.png"));
	public JButton ground= new JButton(new ImageIcon("src/images/ground.png"));
	public JButton inductor = new JButton(new ImageIcon("src/images/inductor.png"));
	public JButton resistor = new JButton(new ImageIcon("src/images/resistor.png"));
	public JButton voltageSrc = new JButton(new ImageIcon("src/images/voltageSrc.png"));
	public JCheckBox ser = new JCheckBox("Serial link");
	public JCheckBox par = new JCheckBox("Parallel link");
	public JButton deleteB = new JButton(new ImageIcon("src/images/delete.jpg"));
	public JButton deleteC = new JButton(new ImageIcon("src/images/cut.jpg"));
	public JButton moveB = new JButton(new ImageIcon("src/images/move.jpg"));
	public JButton select = new JButton(new ImageIcon("src/images/select.jpg"));
	public JButton addParams = new JButton(new ImageIcon("src/images/addP.jpg"));
	public JButton connect = new JButton(new ImageIcon("src/images/line.jpg"));
	
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
	
	public ToolBar(Editor editor) {
		this.editor = editor;
		setOrientation(HORIZONTAL);
		setFloatable(false);
		
		capacitor.setToolTipText("Capacitor");
		currentSrc.setToolTipText("Current source");
		ground.setToolTipText("Ground");
		inductor.setToolTipText("Inductor");
		resistor.setToolTipText("Resistor");
		voltageSrc.setToolTipText("Voltage source");
		select.setToolTipText("Select element (elements) ");
		deleteB.setToolTipText("Delete selected element (elements) ");
		deleteC.setToolTipText("Cuts connections between selected elements");
		moveB.setToolTipText("Move element");
		addParams.setToolTipText("Add parameters for selected element");
		connect.setToolTipText("Draw line between 2 selected elements");
		
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
		add(addImageButton(deleteC));
		addSeparator();
		add(addImageButton(moveB));
		addSeparator();
		add(addImageButton(select));
		addSeparator();
		add(addImageButton(addParams));
		addSeparator();
		add(addImageButton(connect));
		addSeparator();
	}	
}
