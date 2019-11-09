package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class GameHeader extends JPanel {
	private JLabel lblScore;
	private JLabel lblTime;

	public GameHeader() {
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(MainFrame.getFrameWidth(), 26));
	    
	    lblScore = new JLabel("Score: ");
	    lblScore.setHorizontalAlignment(SwingConstants.LEFT);
	    lblScore.setAlignmentX(0.2f);
	    lblScore.setForeground(Color.BLACK);
	    lblScore.setFont(new Font("Dialog", Font.BOLD, 13));
	    
	    lblTime = new JLabel("Time: ");
	    lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
	    lblTime.setFont(new Font("Dialog", Font.BOLD, 13));
	    lblTime.setForeground(Color.BLACK);
	    GroupLayout groupLayout = new GroupLayout(this);
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(25)
	    			.addComponent(lblScore)
	    			.addGap(158)
	    			.addComponent(lblTime)
	    			.addGap(97))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(4)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblScore)
	    				.addComponent(lblTime)))
	    );
	    setLayout(groupLayout);

	}
	
	public void updateLabel(int score, long time) {
		lblScore.setText("Score: "+score);
		float seconds = (System.currentTimeMillis()-time)/1000F;
		lblTime.setText("Time: "+seconds+"s");
		
	}

}
