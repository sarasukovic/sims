

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



public class ToolBar extends JPanel {
	
	public JButton capacitor = new JButton(new ImageIcon("capacitor.png"));
	public JButton currentSrc = new JButton(new ImageIcon("currentSrc.png"));
	public JButton ground= new JButton(new ImageIcon("ground.png"));
	public JButton inductor = new JButton(new ImageIcon("inductor.png"));
	public JButton resistor = new JButton(new ImageIcon("resistor.png"));
	public JButton voltageSrc = new JButton(new ImageIcon("voltageSrc.png"));
	protected List<JButton> buttons = new ArrayList<JButton>();

	protected Canvas newCanvas = new Canvas();
	protected Canvas strokeColor = new Canvas();
	
	protected Editor editor;
	
	private JButton addImageButton(JButton b) {
		Dimension d = new Dimension(36, 36);
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
		
		GridBagLayout l = new GridBagLayout();
		
		setLayout(l);
		
		
		JPanel panel = new JPanel();
		
		add(panel);
		
		panel = new JPanel();
		panel.add(addImageButton(capacitor));
		panel.add(addImageButton(currentSrc));
		panel.add(addImageButton(ground));
		panel.add(addImageButton(inductor));
		panel.add(addImageButton(resistor));
		panel.add(addImageButton(voltageSrc));
		add(panel);
		
		
	
		
		
	}

	
}
