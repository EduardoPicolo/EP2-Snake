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

@SuppressWarnings("serial")
public class GameHeader extends JPanel {
	private JLabel lblScore;

	public GameHeader() {
		setBackground(Color.YELLOW);
		setPreferredSize(new Dimension(MainFrame.getFrameWidth(), 26));
		setLayout(new BorderLayout(0, 0));
		
		lblScore = new JLabel("Score: ");
		lblScore.setAlignmentX(0.5f);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.BLACK);
	    lblScore.setFont(new Font("Dialog", Font.BOLD, 13));
//	    System.out.println(lblScore.getFont().createGlyphVector(lblScore.getFontMetrics(getFont()).getFontRenderContext(),lblScore.getText()).getVisualBounds().getHeight());
	    add(lblScore);

	}
	
	public void updateLabel(int score) {
		lblScore.setText("Score: "+score);
	}

}
