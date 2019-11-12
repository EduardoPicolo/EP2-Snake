package views;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class MainMenu extends JPanel{
	private JLabel lblTitle;
	private JButton btnPlay;
	private JButton btnExit;
	private JButton btnHelp;
	
	public MainMenu(ActionListener listener) {
		setPreferredSize(new Dimension(377, 377));
		setBackground(Color.BLACK);
		
		btnPlay = new JButton("PLAY");
		btnPlay.setHorizontalAlignment(SwingConstants.CENTER);
		btnPlay.setAlignmentX(CENTER_ALIGNMENT);
		btnPlay.addActionListener(listener);
		
		lblTitle = new JLabel("SNAKE");
		lblTitle.setBackground(Color.GREEN);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);
		lblTitle.setForeground(Color.GREEN);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		btnPlay.setBackground(new Color(0, 255, 0));
		btnPlay.setActionCommand("PLAY");
		btnPlay.setForeground(Color.BLACK);
		btnPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPlay.setFocusPainted(false);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(listener);
		
		btnHelp = new JButton("HELP");
		btnHelp.addActionListener(listener);
		btnHelp.setActionCommand("HELP");
		btnHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHelp.setBackground(Color.WHITE);
		btnHelp.setForeground(Color.BLACK);
		btnHelp.setFocusPainted(false);
		btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnExit.setActionCommand("EXIT");
		btnExit.setBackground(Color.RED);
		btnExit.setForeground(Color.BLACK);
		btnExit.setFocusPainted(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(158)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(143))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(132, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnHelp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPlay, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
					.addGap(126))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addGap(174)
					.addComponent(btnPlay)
					.addGap(18)
					.addComponent(btnHelp)
					.addGap(18)
					.addComponent(btnExit)
					.addGap(56))
		);
		setLayout(groupLayout);
	}
}
