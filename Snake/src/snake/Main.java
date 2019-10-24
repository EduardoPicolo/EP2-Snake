package snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public static final int SCREEN_WIDTH = 300;
	public static final int SCREEN_HEIGHT = 300;
	
	public Main() {
//		GamePanel gamePanel = new GamePanel();
		
		setTitle("Snake");
//		setContentPane(gamePanel);
		add(new GamePanel());
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
		setLocationRelativeTo(null);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
