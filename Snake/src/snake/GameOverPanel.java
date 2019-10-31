package snake;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
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
public class GameOverPanel extends JPanel implements ActionListener{
	private SnakeGame gameFrame;

	public GameOverPanel(SnakeGame gameFrame) {
		setSize(250, 200);
		setBackground(Color.RED);
		
		JLabel lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setFont(new Font("Dialog", Font.BOLD, 20));
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGameOver.setAlignmentY(Component.CENTER_ALIGNMENT);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.setActionCommand("RESTART");
		btnRestart.addActionListener(this);
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.setActionCommand("MENU");
		btnMenu.addActionListener(this);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblGameOver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnRestart, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(lblGameOver, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRestart)
						.addComponent(btnMenu))
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		this.gameFrame = gameFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "MENU":
				System.out.println("MENU");
				gameFrame.mainMenu();
			break;
			case "RESTART":
				System.out.println("RESTART");
				gameFrame.startGame();
			break;
			default:
			break;
		}
	}
	
}
