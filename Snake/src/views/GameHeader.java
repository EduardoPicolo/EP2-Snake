package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class GameHeader extends JPanel {
	private JLabel lblScore;

	public GameHeader() {
		setBackground(Color.YELLOW);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		setPreferredSize(new Dimension(MainFrame.getFrameWidth(), 20));
		flowLayout.setVgap(1);
		flowLayout.setHgap(0);
		
		lblScore = new JLabel("Score: ");
		lblScore.setForeground(Color.BLACK);
	    lblScore.setFont(new Font("Dialog", Font.BOLD, 13));
//	    System.out.println(lblScore.getFont().createGlyphVector(lblScore.getFontMetrics(getFont()).getFontRenderContext(),lblScore.getText()).getVisualBounds().getHeight());
	    add(lblScore);

	}
	
	public void updateLabel(int score) {
		lblScore.setText("Score: "+score);
	}

}