package views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.ColorChooserUI;


import controllers.MenuController;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MainMenu extends JPanel{
//	private MainFrame gameFrame;
	
	public MainMenu(ActionListener listener) {
		setBackground(Color.BLACK);
		
		JLabel lblSnake = new JLabel("SNAKE");
		lblSnake.setForeground(UIManager.getColor("text"));
		lblSnake.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(listener);
		btnPlay.setBackground(new Color(0, 255, 0));
		btnPlay.setActionCommand("PLAY");
		btnPlay.setForeground(Color.BLACK);
		btnPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPlay.setFocusPainted(false);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(listener);
		btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnExit.setActionCommand("EXIT");
		btnExit.setBackground(Color.RED);
		btnExit.setForeground(Color.BLACK);
		btnExit.setFocusPainted(false);
	
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addComponent(lblSnake, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(111))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addComponent(lblSnake, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPlay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(99))
		);
		setLayout(groupLayout);
		
//		this.gameFrame = gameFrame;
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		switch(e.getActionCommand()) {
//			case "PLAY":
//				System.out.println("PLAY");
////				gameFrame.startGame();
//				gameFrame.snakeSelection();
//			break;
//			case "EXIT":
//				System.out.println("EXIT");
//				System.exit(0);
//			break;
//			
//			default:
//			break;
//		}
//	}

}
