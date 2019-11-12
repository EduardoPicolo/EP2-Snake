package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class GameInfo extends JPanel {

	public GameInfo(ActionListener listener) {
		setPreferredSize(new Dimension(Display.getFrameWidth(), Display.getFrameHeight()));
		setBackground(Color.BLACK);
		setLayout(null);
		
		JPanel snakesPanel = new JPanel();
		snakesPanel.setForeground(Color.GREEN);
		snakesPanel.setBackground(Color.BLACK);
		snakesPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "SNAKES", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GREEN));
		snakesPanel.setBounds(5, 17, 365, 146);
		add(snakesPanel);
		snakesPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 23, 338, 23);
		snakesPanel.add(panel);
		panel.setLayout(new GridLayout(0, 3, 70, 0));
		
		JLabel lblClassic = new JLabel("CLASSIC");
		panel.add(lblClassic);
		lblClassic.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblClassic.setHorizontalAlignment(SwingConstants.CENTER);
		lblClassic.setForeground(Color.WHITE);
		lblClassic.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblStar = new JLabel("STAR");
		panel.add(lblStar);
		lblStar.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblStar.setForeground(Color.WHITE);
		lblStar.setHorizontalAlignment(SwingConstants.CENTER);
		lblStar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblKitty = new JLabel("KITTY");
		lblKitty.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblKitty);
		lblKitty.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblKitty.setForeground(Color.WHITE);
		lblKitty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel snakeInfoPanel = new JPanel();
		snakeInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), Color.DARK_GRAY, new Color(0, 0, 0), new Color(64, 64, 64)));
		snakeInfoPanel.setBackground(Color.BLACK);
		snakeInfoPanel.setBounds(10, 50, 338, 84);
		snakesPanel.add(snakeInfoPanel);
		snakeInfoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfo = new JLabel("SELECT A SNAKE TO LEARN MORE");
		lblInfo.setForeground(Color.GRAY);
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setAlignmentX(CENTER_ALIGNMENT);
		snakeInfoPanel.add(lblInfo);
		
		lblKitty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("KITTY INFO");
				lblInfo.setForeground(Color.WHITE);
				lblInfo.setText("<html>>Score Multiplier: <FONT COLOR=YELLOW>1</FONT><br/>"
						+ ">Self Collision: <FONT COLOR=YELLOW>NO</FONT><br/>"
						+ ">Wall Collision: <FONT COLOR=YELLOW>NO</FONT></html>");
			}
		});
		lblStar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("STAR INFO");
				lblInfo.setForeground(Color.WHITE);
				lblInfo.setText("<html>>Score Multiplier: <FONT COLOR=YELLOW>2</FONT><br/>"
						+ ">Self Collision: <FONT COLOR=YELLOW>YES</FONT><br/>"
						+ ">Wall Collision: <FONT COLOR=YELLOW>YES</FONT></html>");
			}
		});
		lblClassic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("CLASSIC INFO");
				lblInfo.setForeground(Color.WHITE);
				lblInfo.setText("<html>>Score Multiplier: <FONT COLOR=YELLOW>1</FONT><br/>"
						+ ">Self Collision: <FONT COLOR=YELLOW>YES</FONT><br/>"
						+ ">Wall Collision: <FONT COLOR=YELLOW>YES</FONT></html>");
			}
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.setActionCommand("BACK");
		btnBack.addActionListener(listener);
		btnBack.setForeground(Color.BLACK);
		btnBack.setBounds(137, 340, 95, 25);
		add(btnBack);
		
		JPanel fruitsPanel = new JPanel();
		fruitsPanel.setBackground(Color.BLACK);
		fruitsPanel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "FRUITS", TitledBorder.CENTER, TitledBorder.TOP, null, Color.YELLOW));
		fruitsPanel.setBounds(5, 180, 365, 146);
		add(fruitsPanel);
		fruitsPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(5, 17, 343, 23);
		fruitsPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 29, 0));
		
		JPanel fruitsInfoPanel = new JPanel();
		fruitsInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), Color.DARK_GRAY, new Color(0, 0, 0), new Color(64, 64, 64)));
		fruitsInfoPanel.setBackground(Color.BLACK);
		fruitsInfoPanel.setBounds(12, 50, 338, 84);
		fruitsPanel.add(fruitsInfoPanel);
		fruitsInfoPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFruitInfo = new JLabel("SELECT A FRUIT TO LEARN MORE");
		lblFruitInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFruitInfo.setForeground(Color.GRAY);
		lblFruitInfo.setAlignmentX(0.5f);
		fruitsInfoPanel.add(lblFruitInfo, BorderLayout.CENTER);
		
		JLabel lblSimple = new JLabel("SIMPLE");
		panel_1.add(lblSimple);
		lblSimple.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblSimple.setForeground(Color.WHITE);
		lblSimple.setHorizontalAlignment(SwingConstants.CENTER);
		lblSimple.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSimple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("BIG INFO");
				lblFruitInfo.setForeground(Color.WHITE);
				lblFruitInfo.setText("<html>>Score Value: <FONT COLOR=YELLOW>1</FONT><br/>"
						+ ">Life Time: <FONT COLOR=YELLOW> Until it's eaten</FONT> <br/>"
						+ ">Special Effect: <FONT COLOR=YELLOW> Increases snake's body by 1</FONT></html>");
			}
		});
		
		JLabel lblBig = new JLabel("BIG");
		panel_1.add(lblBig);
		lblBig.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblBig.setForeground(Color.WHITE);
		lblBig.setHorizontalAlignment(SwingConstants.CENTER);
		lblBig.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblBig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("BIG INFO");
				lblFruitInfo.setForeground(Color.WHITE);
				lblFruitInfo.setText("<html>>Score Value: <FONT COLOR=YELLOW>2</FONT><br/>"
						+ ">Life Time: <FONT COLOR=YELLOW>10 seconds</FONT> <br/>"
						+ ">Special Effect: <FONT COLOR=YELLOW> Gives double the score amount of a Simple Fruit and increases snake's body by 1;</FONT></html>");
			}
		});
		
		JLabel lblDecrease = new JLabel("DECREASE");
		panel_1.add(lblDecrease);
		lblDecrease.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblDecrease.setForeground(Color.WHITE);
		lblDecrease.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecrease.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblDecrease.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("BIG INFO");
				lblFruitInfo.setForeground(Color.WHITE);
				lblFruitInfo.setText("<html>>Score Value: <FONT COLOR=YELLOW>0</FONT><br/>"
						+ ">Life Time: <FONT COLOR=YELLOW>10 seconds</FONT> <br/>"
						+ ">Special Effect: <FONT COLOR=YELLOW> Decreases snake's body to 1</FONT></html>");
			}
		});
		
		JLabel lblBomb = new JLabel("BOMB");
		panel_1.add(lblBomb);
		lblBomb.setFont(new Font("DialogInput", Font.BOLD, 14));
		lblBomb.setForeground(Color.WHITE);
		lblBomb.setHorizontalAlignment(SwingConstants.CENTER);
		lblBomb.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblBomb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("BIG INFO");
				lblFruitInfo.setForeground(Color.WHITE);
				lblFruitInfo.setText("<html>>Score Value: <FONT COLOR=YELLOW>0</FONT><br/>"
						+ ">Life Time: <FONT COLOR=YELLOW>10 seconds</FONT> <br/>"
						+ ">Special Effect: <FONT COLOR=YELLOW> Kills the snake</FONT></html>");
			}
		});

	}
}
