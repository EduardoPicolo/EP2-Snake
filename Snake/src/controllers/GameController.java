package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import models.ClassicSnake;
import models.FruitSprite;
import models.KittySnake;
import models.MainFrame;
import models.SimpleFruit;
import models.SnakeSprite;
import models.StarSnake;
import views.GamePanel;
import views.SnakeSelection;

public class GameController implements Runnable, KeyListener{
	private final int DELAY = 100;
	private static boolean running;
	private int score;
	
	private SnakeSprite snake;
	private static List<FruitSprite> fruits;
	private FruitSpawner fruitSpawner;
	
	private GamePanel gamePanel;
	private Thread loop;
	
	public GameController(GamePanel gamePanel) {
		this.gamePanel = gamePanel; 
		gamePanel.addKeyListener(this);
		fruits = new ArrayList<>();
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
		snake = new ClassicSnake();  //Initialize any snake to avoid possible compilation error
	}
	
	public void initGame() {
		running = true;
		score = 0;
		gamePanel.updateScore(score);
		
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

		loop = new Thread(this);
		fruitSpawner = new FruitSpawner();
		
		new Thread(fruitSpawner).start();
		loop.start();
	}
	
	public void checkAteFruit() {
		for(int i=0; i<fruits.size() ; i++) {
    		if(snake.getSnakeBody().getFirst().equals(fruits.get(i).getPosition())) {
//    		if(this.getBounds().get(0).intersects(fruits.get(i).getBounds())) {
    			fruits.get(i).isCollision();
    			fruits.get(i).specialEffect();
    			snake.increaseBody();
    			score += snake.getScoreMultiplier() * fruits.get(i).getScoreValue();
    			gamePanel.updateScore(score);
    			fruits.remove(i);
    		}
    	}
	}

	@Override
	public void run() {
		gamePanel.setSnake(snake);
		gamePanel.setFruits(fruits);
		
		long startTime, endTime, sleep;
		
		while(running) {
			startTime = System.nanoTime();
			
			snake.move();
			snake.checkCollision();
			checkAteFruit();
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
	
	public void setScore(int value) {
		this.score = value;
	}
	
	public static void setFruits(List<FruitSprite> fruitList) {
		fruits = fruitList;
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}

}
