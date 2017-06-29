package paket;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;



public class ToolBar extends JToolBar {
	public JButton capacitor = new JButton(new ImageIcon("capacitor.png"));
	public JButton currentSrc = new JButton(new ImageIcon("currentSrc.png"));
	public JButton ground= new JButton(new ImageIcon("ground.png"));
	public JButton inductor = new JButton(new ImageIcon("inductor.png"));
	public JButton resistor = new JButton(new ImageIcon("resistor.png"));
	public JButton voltageSrc = new JButton(new ImageIcon("voltageSrc.png"));
	protected List<JButton> buttons = new ArrayList<JButton>();

	/*protected Canvas newCanvas = new Canvas();
	protected Canvas strokeColor = new Canvas();*/
	
	protected Editor editor;
	
	private JButton addImageButton(JButton b) {
		Dimension d = new Dimension(30, 30);
		b.setPreferredSize(d);
		b.setMinimumSize(d);
		b.setMaximumSize(d);
		buttons.add(b);
		return b;
	}
	private void select(JButton button) {
		for(JButton b : buttons) {
			b.setSelected(false);
			b.setBackground(null);
		}
		button.setSelected(true);
		button.setBackground(Color.white);
	}
	
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
		JCheckBox ser = new JCheckBox("Serial link");
		add(ser);
		addSeparator();
		JCheckBox par = new JCheckBox("Parallel link");
		add(par);
		addSeparator();
	
		ser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Serial connection");
			}
		});
		
		par.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Parallel connection");
			}
		});
	}

	
}
