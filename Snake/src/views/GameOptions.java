package views;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;

@SuppressWarnings("serial")
public class GameOptions extends JPanel{
	private JRadioButton btnClassicSnake;
	private JRadioButton btnStar;
	private JRadioButton btnKitty;
	private JRadioButton btnEasy;
	private JRadioButton btnNormal;
	private JRadioButton btnHard;
	private JRadioButton btnInsane;
	private JButton btnConfirm;
	private ButtonGroup snakes;
	private ButtonGroup difficulties;
	private JPanel radioPanel;
	private JLabel lblTitle;
	private JLabel lblDifficulties;
	private JPanel panel;
	private JLabel lblSnakeimage;
	private BufferedImage classicSnake;
	private BufferedImage starSnake;
	private BufferedImage kittySnake;
	
	public GameOptions(ActionListener listener) {
		setPreferredSize(new Dimension(Display.getFrameWidth(), Display.getFrameHeight()));
		setBackground(Color.BLACK);
		
		try {
			classicSnake = ImageIO.read(new File("./src/assets/96x100.jpeg"));
			starSnake = ImageIO.read(new File("./src/assets/explosion13px.png"));
			kittySnake = ImageIO.read(new File("./src/assets/96x100.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		snakes = new ButtonGroup();
		difficulties = new ButtonGroup();
		radioPanel = new JPanel();
		radioPanel.setBounds(12, 43, 353, 41);
		radioPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), null));
		radioPanel.setBackground(Color.BLACK);
		radioPanel.setLayout(new GridLayout(0, 3, 20, 180));
		
		btnKitty = new JRadioButton("KITTY", new ImageIcon("./src/assets/YellowCircle15px.png"));
		btnKitty.setSelectedIcon(new ImageIcon("./src/assets/SelectedIcon15px.png"));
		btnKitty.setHorizontalAlignment(SwingConstants.RIGHT);
		btnKitty.setBackground(Color.BLACK);
		btnKitty.setForeground(Color.WHITE);
		btnKitty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnKitty.setToolTipText("Kitty snake");
		btnKitty.setFocusPainted(false);
		btnKitty.setActionCommand("KITTY");
		btnKitty.addActionListener(listener);
		
		btnStar = new JRadioButton("STAR", new ImageIcon("./src/assets/YellowCircle15px.png"));
		btnStar.setSelectedIcon(new ImageIcon("./src/assets/SelectedIcon15px.png"));
		btnStar.setForeground(Color.WHITE);
		btnStar.setBackground(Color.BLACK);
		btnStar.setHorizontalAlignment(SwingConstants.CENTER);
		btnStar.setToolTipText("Star snake");
		btnStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnStar.setFocusPainted(false);
		btnStar.setActionCommand("STAR");
		btnStar.addActionListener(listener);
		
		btnClassicSnake = new JRadioButton("CLASSIC", new ImageIcon("./src/assets/YellowCircle15px.png"));
		btnClassicSnake.setSelectedIcon(new ImageIcon("./src/assets/SelectedIcon15px.png"));
		btnClassicSnake.setBackground(Color.BLACK);
		btnClassicSnake.setForeground(Color.WHITE);
		btnClassicSnake.setHorizontalAlignment(SwingConstants.LEFT);
		btnClassicSnake.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClassicSnake.setFocusPainted(false);
		btnClassicSnake.setToolTipText("Classic snake");
		btnClassicSnake.setActionCommand("CLASSIC");
		btnClassicSnake.addActionListener(listener);
		
		snakes.add(btnClassicSnake);
		radioPanel.add(btnClassicSnake);
		snakes.add(btnStar);
		radioPanel.add(btnStar);
		snakes.add(btnKitty);
		radioPanel.add(btnKitty);
		
		btnConfirm = new JButton("CONFIRM");
		btnConfirm.setBounds(144, 327, 96, 25);
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
		
		JPanel difficultiesPanel = new JPanel();
		difficultiesPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 0), null));
		difficultiesPanel.setBackground(new Color(0, 0, 0));
		difficultiesPanel.setBounds(12, 259, 353, 41);
		add(difficultiesPanel);
		difficultiesPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnEasy = new JRadioButton("EASY", new ImageIcon("./src/assets/YellowCircle15px.png"));
		btnEasy.setSelectedIcon(new ImageIcon("./src/assets/SelectedIcon15px.png"));
		difficultiesPanel.add(btnEasy);
		btnEasy.setHorizontalAlignment(SwingConstants.LEFT);
		btnEasy.setBackground(Color.BLACK);
		btnEasy.setForeground(Color.WHITE);
		btnEasy.setFocusPainted(false);
		btnEasy.setActionCommand("EASY");
		btnEasy.addActionListener(listener);
		btnEasy.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		difficulties.add(btnEasy);
		
		btnNormal = new JRadioButton("NORMAL", new ImageIcon("./src/assets/YellowCircle15px.png"));
		btnNormal.setSelectedIcon(new ImageIcon("./src/assets/SelectedIcon15px.png"));
		difficultiesPanel.add(btnNormal);
		btnNormal.setHorizontalAlignment(SwingConstants.CENTER);
		btnNormal.setBackground(Color.BLACK);
		btnNormal.setForeground(Color.WHITE);
		btnNormal.setFocusPainted(false);
		btnNormal.setActionCommand("NORMAL");
		btnNormal.addActionListener(listener);
		btnNormal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		difficulties.add(btnNormal);
		
		btnHard = new JRadioButton("HARD", new ImageIcon("./src/assets/YellowCircle15px.png"));
		btnHard.setSelectedIcon(new ImageIcon("./src/assets/SelectedIcon15px.png"));
		btnHard.setHorizontalAlignment(SwingConstants.CENTER);
		difficultiesPanel.add(btnHard);
		btnHard.setBackground(Color.BLACK);
		btnHard.setForeground(Color.WHITE);
		btnHard.setFocusPainted(false);
		btnHard.setActionCommand("HARD");
		btnHard.addActionListener(listener);
		btnHard.setCursor(new Cursor(Cursor.HAND_CURSOR));
		difficulties.add(btnHard);
		
		btnInsane = new JRadioButton("INSANE", new ImageIcon("./src/assets/YellowCircle15px.png"));
		btnInsane.setSelectedIcon(new ImageIcon("./src/assets/SelectedIcon15px.png"));
		btnInsane.setHorizontalAlignment(SwingConstants.RIGHT);
		difficultiesPanel.add(btnInsane);
		btnInsane.setBackground(Color.BLACK);
		btnInsane.setForeground(Color.WHITE);
		btnInsane.setFocusPainted(false);
		btnInsane.setActionCommand("INSANE");
		btnInsane.addActionListener(listener);
		btnInsane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		difficulties.add(btnInsane);
		
		lblTitle = new JLabel("Choose your Snake");
		lblTitle.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblTitle.setForeground(new Color(255, 255, 0));
		lblTitle.setBackground(new Color(0, 0, 0));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 12, 353, 19);
		add(lblTitle);
		
		lblDifficulties = new JLabel("Select Difficulty");
		lblDifficulties.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblDifficulties.setForeground(new Color(255, 255, 0));
		lblDifficulties.setBackground(new Color(0, 0, 0));
		lblDifficulties.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulties.setBounds(12, 232, 353, 19);
		add(lblDifficulties);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.YELLOW));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(144, 108, 96, 100);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblSnakeimage = new JLabel("?");
		lblSnakeimage.setFont(new Font("DialogInput", Font.BOLD, 45));
		lblSnakeimage.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSnakeimage);
		
	}
	
	public void setLblImage() {
		lblSnakeimage.setText("");
		switch(snakes.getSelection().getActionCommand()) {
			case "CLASSIC":
				lblSnakeimage.setIcon(new ImageIcon(classicSnake));
			break;
			case "STAR":
				lblSnakeimage.setIcon(new ImageIcon(starSnake));
			break;
			case "KITTY":
				lblSnakeimage.setIcon(new ImageIcon(kittySnake));
			break;
			default:
				break;
		}
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
