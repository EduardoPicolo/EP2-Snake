package views;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.PanelController;

import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SnakeSelection extends JPanel implements ActionListener {
	private static final int CLASSIC = 1;
	private static final int STAR = 2;
	private static final int KITTY = 3;
	public static int selectedSnake;
	
	private PanelController gameFrame;
	
	public SnakeSelection(PanelController gameFrame) {
		super(new BorderLayout());
		
		JRadioButton btnClassicSnake = new JRadioButton("Classic");
		btnClassicSnake.setHorizontalAlignment(SwingConstants.LEFT);
		btnClassicSnake.setActionCommand("CLASSIC");
		btnClassicSnake.addActionListener(this);
		btnClassicSnake.setSelected(true);
		selectedSnake = CLASSIC;
		btnClassicSnake.setToolTipText("Classic snake");
		
		JRadioButton btnStar = new JRadioButton("Star");
		btnStar.setHorizontalAlignment(SwingConstants.CENTER);
		btnStar.setToolTipText("Star snake");
		btnStar.setActionCommand("STAR");
		btnStar.addActionListener(this);
				
		JRadioButton btnKitty = new JRadioButton("Kitty");
		btnKitty.setHorizontalAlignment(SwingConstants.RIGHT);
		btnStar.setToolTipText("Kitty snake");
		btnKitty.setActionCommand("KITTY");
		btnKitty.addActionListener(this);
		
		ButtonGroup group = new ButtonGroup();
		group.add(btnClassicSnake);
		group.add(btnStar);
		group.add(btnKitty);
		
		GridLayout gl_radioPanel = new GridLayout(1, 0);
		gl_radioPanel.setHgap(20);
		JPanel radioPanel = new JPanel(gl_radioPanel);
		
		radioPanel.add(btnClassicSnake);
		radioPanel.add(btnStar);
		radioPanel.add(btnKitty);
		
		
		add(radioPanel, BorderLayout.CENTER);
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setActionCommand("CONFIRM");
		btnConfirm.addActionListener(this);
		add(btnConfirm, BorderLayout.PAGE_END);
		
		this.gameFrame = gameFrame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "CLASSIC":
				System.out.println("CLASSIC");
				selectedSnake = CLASSIC;
			break;
			
			case "STAR":
				System.out.println("STAR");
				selectedSnake = STAR;
			break;
			
			case "KITTY":
				System.out.println("KITTY");
				selectedSnake = KITTY;
			break;
			
			case "CONFIRM":
				System.out.println("CONFIRM: "+selectedSnake);
				gameFrame.startGame();
			break;
			default:
				break;
		}
		
	}
	
}
