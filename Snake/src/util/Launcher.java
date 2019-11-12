package util;

import java.awt.EventQueue;

import views.Display;

public class Launcher {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new Display();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
