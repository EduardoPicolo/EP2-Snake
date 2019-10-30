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
		btnRestart.setActionCommand("restart");
		btnRestart.addActionListener(this);
		btnRestart.setAlignmentX(0.5f);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(61)
					.addComponent(lblGameOver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(56))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(144)
					.addComponent(btnRestart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(lblGameOver, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
					.addGap(69)
					.addComponent(btnRestart, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		this.gameFrame = gameFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("restart")) {
			System.out.println("RESTART");
			gameFrame.startGame();
		}
	}
	

}
