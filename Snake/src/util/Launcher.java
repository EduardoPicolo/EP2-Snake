package util;

import java.awt.EventQueue;

import models.Menus;

public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Menus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
