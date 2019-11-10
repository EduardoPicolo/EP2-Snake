package views;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class GameOverPanel extends JPanel{
	private JLabel lblGameOver;
	private JButton btnRestart;
	private JButton btnChangeSnake;
	private JButton btnMenu;

	public GameOverPanel(ActionListener listener) {
		setPreferredSize(new Dimension(MainFrame.getFrameWidth(), MainFrame.getFrameHeight()));
		setBackground(Color.RED);
		
		lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setForeground(Color.BLACK);
		lblGameOver.setFont(new Font("Lato", Font.BOLD, 25));
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGameOver.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		btnRestart = new JButton("RESTART");
		btnRestart.setActionCommand("RESTART");
		btnRestart.addActionListener(listener);
		btnRestart.setBackground(Color.WHITE);
		btnRestart.setForeground(Color.BLACK);
		btnRestart.setFocusPainted(false);
		btnRestart.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnMenu = new JButton("MENU");
		btnMenu.setActionCommand("MENU");
		btnMenu.addActionListener(listener);
		btnMenu.setBackground(Color.white);
		btnMenu.setForeground(Color.BLACK);
		btnMenu.setFocusPainted(false);
		btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnChangeSnake = new JButton("CHANGE SNAKE");
		btnChangeSnake.setActionCommand("CHANGE");
		btnChangeSnake.addActionListener(listener);
		btnChangeSnake.setBackground(Color.WHITE);
		btnChangeSnake.setForeground(Color.BLACK);
		btnChangeSnake.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnChangeSnake.setFocusPainted(false);
		
//		JButton btnChangeSnake = new JButton("CHANGE SNAKE");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblGameOver, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnChangeSnake)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(lblGameOver, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRestart)
						.addComponent(btnMenu)
						.addComponent(btnChangeSnake))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
}
