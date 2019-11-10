package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class GameHeader extends JPanel {
	private JLabel lblScore;
	private JLabel lblTime;
	private JLabel lblDifficulty;

	public GameHeader() {
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(Display.getFrameWidth(), 26));
	    setLayout(new GridLayout(0, 3, 0, 0));
	    
	    lblTime = new JLabel("Time: ");
	    lblTime.setHorizontalAlignment(SwingConstants.LEFT);
	    lblTime.setFont(new Font("Dialog", Font.BOLD, 13));
	    lblTime.setForeground(Color.BLACK);
	    add(lblTime);
	    
	    lblScore = new JLabel("Score: ");
	    lblScore.setHorizontalAlignment(SwingConstants.CENTER);
	    lblScore.setForeground(Color.BLACK);
	    lblScore.setFont(new Font("Dialog", Font.BOLD, 13));
	    add(lblScore);
	    
	    lblDifficulty = new JLabel("Difficulty");
	    lblDifficulty.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblDifficulty.setForeground(Color.BLACK);
	    lblDifficulty.setFont(new Font("Dialog", Font.BOLD, 13));
	    
	    add(lblDifficulty);

	}
	
	public void updateHeader(int score, long time) {
		lblScore.setText("Score: "+score);
		float seconds = (System.currentTimeMillis()-time)/1000F;
		lblTime.setText("Time: "+seconds+"s");
	}
	
	public void setLblDifficulty(String difficulty) {
		lblDifficulty.setText(difficulty);
	}
	
}
