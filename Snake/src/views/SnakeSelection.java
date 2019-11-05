package views;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SnakeSelection extends JPanel{
	
	public SnakeSelection(ActionListener listener) {
		super(new BorderLayout());
		
		JRadioButton btnClassicSnake = new JRadioButton("Classic");
		btnClassicSnake.setHorizontalAlignment(SwingConstants.LEFT);
		btnClassicSnake.setActionCommand("CLASSIC");
		btnClassicSnake.addActionListener(listener);
		btnClassicSnake.setSelected(true);
		btnClassicSnake.setToolTipText("Classic snake");
		
		JRadioButton btnStar = new JRadioButton("Star");
		btnStar.setHorizontalAlignment(SwingConstants.CENTER);
		btnStar.setToolTipText("Star snake");
		btnStar.setActionCommand("STAR");
		btnStar.addActionListener(listener);
				
		JRadioButton btnKitty = new JRadioButton("Kitty");
		btnKitty.setHorizontalAlignment(SwingConstants.RIGHT);
		btnStar.setToolTipText("Kitty snake");
		btnKitty.setActionCommand("KITTY");
		btnKitty.addActionListener(listener);
		
		ButtonGroup group = new ButtonGroup();
		group.add(btnClassicSnake);
		group.add(btnStar);
		group.add(btnKitty);
		
		GridLayout gl_radioPanel = new GridLayout(1, 0);
		gl_radioPanel.setHgap(20);
		JPanel radioPanel = new JPanel(gl_radioPanel);
		
		radioPanel.add(btnClassicSnake);
		radioPanel.add(btnStar);
		radioPanel.add(btnKitty);
		
		
		add(radioPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setActionCommand("CONFIRM");
		btnConfirm.addActionListener(listener);
		add(btnConfirm, BorderLayout.PAGE_END);		
	}
	
}
