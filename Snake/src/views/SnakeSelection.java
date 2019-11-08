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
	
	public SnakeSelection(ActionListener listener) {
		
		setBackground(Color.BLACK);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		ButtonGroup group = new ButtonGroup();
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.BLACK);
		
		JRadioButton btnStar = new JRadioButton("Star");
		btnStar.setForeground(Color.WHITE);
		btnStar.setBackground(Color.BLACK);
		btnStar.setHorizontalAlignment(SwingConstants.CENTER);
		btnStar.setToolTipText("Star snake");
		btnStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStar.setFocusPainted(false);
		btnStar.setActionCommand("STAR");
		btnStar.addActionListener(listener);
		
		JRadioButton btnClassicSnake = new JRadioButton("Classic");
		btnClassicSnake.setBackground(Color.BLACK);
		btnClassicSnake.setForeground(Color.WHITE);
		btnClassicSnake.setHorizontalAlignment(SwingConstants.LEFT);
		btnClassicSnake.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClassicSnake.setFocusPainted(false);
		btnClassicSnake.setToolTipText("Classic snake");
		btnClassicSnake.setActionCommand("CLASSIC");
		btnClassicSnake.addActionListener(listener);
		
		JRadioButton btnKitty = new JRadioButton("Kitty");
		btnKitty.setBackground(Color.BLACK);
		btnKitty.setForeground(Color.WHITE);
		btnKitty.setHorizontalAlignment(SwingConstants.RIGHT);
		btnKitty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnKitty.setFocusPainted(false);
		btnKitty.setActionCommand("KITTY");
		btnKitty.addActionListener(listener);
		
		FlowLayout fl_radioPanel = new FlowLayout(FlowLayout.CENTER, 25, 10);
		radioPanel.setLayout(fl_radioPanel);
		btnClassicSnake.setSelected(true);
		btnStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStar.setToolTipText("Kitty snake");
		
		radioPanel.add(btnClassicSnake);
		radioPanel.add(btnStar);
		radioPanel.add(btnKitty);
		
		group.add(btnClassicSnake);
		group.add(btnStar);
		group.add(btnKitty);
		add(radioPanel);
		
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setAlignmentX(0.5f);
		btnConfirm.setActionCommand("CONFIRM");
		btnConfirm.addActionListener(listener);
		btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConfirm.setBackground(Color.CYAN);
		btnConfirm.setForeground(Color.black);
		add(btnConfirm);		
	}
	
}
