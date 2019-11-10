package views;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class SnakeSelection extends JPanel{
	private JRadioButton btnClassicSnake;
	private JRadioButton btnStar;
	private JRadioButton btnKitty;
	private JButton btnConfirm;
	private ButtonGroup group;
	private JPanel radioPanel;
	
	public SnakeSelection(ActionListener listener) {
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		group = new ButtonGroup();
		radioPanel = new JPanel();
		radioPanel.setBackground(Color.BLACK);
		
		btnClassicSnake = new JRadioButton("Classic");
		btnClassicSnake.setBackground(Color.BLACK);
		btnClassicSnake.setForeground(Color.WHITE);
		btnClassicSnake.setHorizontalAlignment(SwingConstants.LEFT);
		btnClassicSnake.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClassicSnake.setFocusPainted(false);
		btnClassicSnake.setToolTipText("Classic snake");
		btnClassicSnake.setActionCommand("CLASSIC");
		btnClassicSnake.addActionListener(listener);
		btnClassicSnake.setSelected(true);
		
		group.add(btnClassicSnake);
		
		btnStar = new JRadioButton("Star");
		btnStar.setForeground(Color.WHITE);
		btnStar.setBackground(Color.BLACK);
		btnStar.setHorizontalAlignment(SwingConstants.CENTER);
		btnStar.setToolTipText("Star snake");
		btnStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStar.setFocusPainted(false);
		btnStar.setActionCommand("STAR");
		btnStar.addActionListener(listener);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStar.setToolTipText("Kitty snake");
		group.add(btnStar);
		add(radioPanel);
		
		btnKitty = new JRadioButton("Kitty");
		btnKitty.setBackground(Color.BLACK);
		btnKitty.setForeground(Color.WHITE);
		btnKitty.setHorizontalAlignment(SwingConstants.RIGHT);
		btnKitty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnKitty.setFocusPainted(false);
		btnKitty.setActionCommand("KITTY");
		btnKitty.addActionListener(listener);
		group.add(btnKitty);
		
		GroupLayout gl_radioPanel = new GroupLayout(radioPanel);
		gl_radioPanel.setHorizontalGroup(
			gl_radioPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioPanel.createSequentialGroup()
					.addComponent(btnClassicSnake, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnStar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnKitty, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_radioPanel.setVerticalGroup(
			gl_radioPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioPanel.createSequentialGroup()
					.addGroup(gl_radioPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_radioPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_radioPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnKitty)
								.addComponent(btnStar)))
						.addGroup(gl_radioPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnClassicSnake)))
					.addContainerGap(204, Short.MAX_VALUE))
		);
		radioPanel.setLayout(gl_radioPanel);
		
		btnConfirm = new JButton("CONFIRM");	
		btnConfirm.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConfirm.setAlignmentX(0.5f);
		btnConfirm.setActionCommand("CONFIRM");
		btnConfirm.addActionListener(listener);
		btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConfirm.setBackground(new Color(0, 255, 0));
		btnConfirm.setForeground(Color.black);
		add(btnConfirm);		
	}
	
}
