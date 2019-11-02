package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import models.ClassicSnake;
import models.FruitSprite;
import models.KittySnake;
import models.SnakeSprite;
import models.StarSnake;
import views.GamePanel;
import views.SnakeSelection;

public class GameController implements Runnable, KeyListener{
	private final int DELAY = 100;
	private static boolean running;
	private static int score;
	
	private SnakeSprite snake;
	private static List<FruitSprite> fruits;
	private FruitSpawner fruitSpawner;
	
	private GamePanel gamePanel;
	private Thread loop;
	
	public GameController() {
		gamePanel = new GamePanel();
		fruits = new ArrayList<>();
		snake = new SnakeSprite();
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
		gamePanel.addKeyListener(this);
	}
	
	public void initGame() {
		running = true;
		score = 0;
		
		switch(SnakeSelection.selectedSnake) {
			case 1:
				snake = new ClassicSnake();
				break;
			case 2:
				snake = new StarSnake();
				break;
			case 3:
				snake = new KittySnake();
				break;
		}
		
		gamePanel.setSnake(snake);
		gamePanel.setFruits(fruits);
		gamePanel.setScore(score);
		new Thread(fruitSpawner).start();
		loop.start();
	}

	@Override
	public void run() {
		long startTime, endTime, sleep;
		while(running) {
			startTime = System.nanoTime();
			
			snake.move();
			snake.checkCollision();
			snake.checkFruitCollision(fruits);
			gamePanel.repaint();
			
			endTime = System.nanoTime() - startTime;
			sleep = DELAY - endTime/1000000;
			if(sleep < 0) {
				sleep = 50;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		snake.setDirection(e);
//		System.out.println(KeyEvent.getKeyText( e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isRunning() {
		return running;
	}
	public static void setGameOver() {
		running = false;
	}
	
	public static void setScore(int value) {
		score = value;
	}
	
	public static void setFruits(List<FruitSprite> fruitList) {
		fruits = fruitList;
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}

}
