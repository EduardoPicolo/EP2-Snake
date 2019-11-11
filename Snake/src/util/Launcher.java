package util;

import java.awt.EventQueue;

import models.Menu;
import views.Display;

public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display display = new Display();
//					display.getMenuController().m
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
