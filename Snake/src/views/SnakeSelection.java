package views;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SnakeSelection extends JPanel{
	private JRadioButton btnClassicSnake;
	private JRadioButton btnStar;
	private JRadioButton btnKitty;
	private JRadioButton btnEasy;
	private JRadioButton btnNormal;
	private JRadioButton btnHard;
	private JButton btnConfirm;
	private ButtonGroup snakes;
	private ButtonGroup difficulties;
	private JPanel radioPanel;
	
	public SnakeSelection(ActionListener listener) {
		setPreferredSize(new Dimension(Display.getFrameWidth(), Display.getFrameHeight()));
		setBackground(Color.BLACK);
		
		snakes = new ButtonGroup();
		difficulties = new ButtonGroup();
		radioPanel = new JPanel();
		radioPanel.setBounds(49, 5, 279, 304);
		radioPanel.setBackground(Color.BLACK);
		
		btnClassicSnake = new JRadioButton("CLASSIC");
		btnClassicSnake.setBackground(Color.BLACK);
		btnClassicSnake.setForeground(Color.WHITE);
		btnClassicSnake.setHorizontalAlignment(SwingConstants.LEFT);
		btnClassicSnake.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClassicSnake.setFocusPainted(false);
		btnClassicSnake.setToolTipText("Classic snake");
		btnClassicSnake.setActionCommand("CLASSIC");
		btnClassicSnake.addActionListener(listener);
		
		snakes.add(btnClassicSnake);
		radioPanel.setLayout(new GridLayout(2, 3, 15, 180));
		radioPanel.add(btnClassicSnake);
		
		btnKitty = new JRadioButton("KITTY");
		btnKitty.setHorizontalAlignment(SwingConstants.RIGHT);
		btnKitty.setBackground(Color.BLACK);
		btnKitty.setForeground(Color.WHITE);
		btnKitty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnKitty.setFocusPainted(false);
		btnKitty.setActionCommand("KITTY");
		btnKitty.addActionListener(listener);
		
		btnStar = new JRadioButton("STAR");
		btnStar.setForeground(Color.WHITE);
		btnStar.setBackground(Color.BLACK);
		btnStar.setHorizontalAlignment(SwingConstants.CENTER);
		btnStar.setToolTipText("Star snake");
		btnStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStar.setFocusPainted(false);
		btnStar.setActionCommand("STAR");
		btnStar.addActionListener(listener);
		btnStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStar.setToolTipText("Kitty snake");
		snakes.add(btnStar);
		radioPanel.add(btnStar);
		snakes.add(btnKitty);
		radioPanel.add(btnKitty);
		
		btnHard = new JRadioButton("HARD");
		btnHard.setHorizontalAlignment(SwingConstants.RIGHT);
		btnHard.setBackground(Color.BLACK);
		btnHard.setForeground(Color.WHITE);
		btnHard.setFocusPainted(false);
		btnHard.setActionCommand("HARD");
		btnHard.addActionListener(listener);
		
		btnEasy = new JRadioButton("EASY");
		btnEasy.setHorizontalAlignment(SwingConstants.LEFT);
		btnEasy.setBackground(Color.BLACK);
		btnEasy.setForeground(Color.WHITE);
		btnEasy.setFocusPainted(false);
		btnEasy.setActionCommand("EASY");
		btnEasy.addActionListener(listener);
		btnEasy.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		difficulties.add(btnEasy);
		radioPanel.add(btnEasy);
		
		btnNormal = new JRadioButton("NORMAL");
		btnNormal.setHorizontalAlignment(SwingConstants.CENTER);
		btnNormal.setBackground(Color.BLACK);
		btnNormal.setForeground(Color.WHITE);
		btnNormal.setFocusPainted(false);
		btnNormal.setActionCommand("NORMAL");
		btnNormal.addActionListener(listener);
		btnNormal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		difficulties.add(btnNormal);
		radioPanel.add(btnNormal);
		btnHard.setCursor(new Cursor(Cursor.HAND_CURSOR));
		difficulties.add(btnHard);
		radioPanel.add(btnHard);
		
		btnConfirm = new JButton("CONFIRM");
		btnConfirm.setBounds(143, 340, 96, 25);
		btnConfirm.setVerticalAlignment(SwingConstants.BOTTOM);
		btnConfirm.setAlignmentX(0.5f);
		btnConfirm.setActionCommand("CONFIRM");
		btnConfirm.addActionListener(listener);
		btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConfirm.setBackground(new Color(0, 255, 0));
		btnConfirm.setForeground(Color.black);
		btnConfirm.setEnabled(false);
		
		setLayout(null);
		add(radioPanel);
		add(btnConfirm);
	}
	
	public void clearSelections() {
		snakes.clearSelection();
		difficulties.clearSelection();
		btnConfirm.setEnabled(false);
	}
	public void enableButton() {
		btnConfirm.setEnabled(true);
	}
	
}
