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
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.MenuController;

@SuppressWarnings("serial")
public class MainMenu extends JPanel{
//	private MainFrame gameFrame;
	
	public MainMenu(ActionListener listener) {
		setBackground(Color.DARK_GRAY);
		
		JLabel lblSnake = new JLabel("SNAKE");
		lblSnake.setForeground(Color.BLACK);
		lblSnake.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(listener);
		btnPlay.setActionCommand("PLAY");
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(listener);
		btnExit.setActionCommand("EXIT");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSnake, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
							.addGap(110))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblSnake, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(112)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPlay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
