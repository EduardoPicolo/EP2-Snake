package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GameController;
import controllers.MenuController;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	private static final int SCREEN_WIDTH = 300;
	private static final int SCREEN_HEIGHT = 300;
	
	private JComponent content;
		
	public MainFrame() {
		setTitle("Snake");
		setPreferredSize(new Dimension(MainFrame.SCREEN_WIDTH, MainFrame.SCREEN_HEIGHT));
		setBackground(Color.black);
		content = new JPanel();
		content.setOpaque(true);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBackground(Color.BLACK);
		setContentPane(content);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static int getFrameWidth() {
		return SCREEN_WIDTH;
	}
	
	public static int getFrameHeight() {
		return SCREEN_HEIGHT;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
					new MenuController();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
