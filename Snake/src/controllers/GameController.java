package controllers;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import models.ClassicSnake;
import models.FruitSpawner;
import models.FruitSprite;
import models.KittySnake;
import models.SnakeSprite;
import models.StarSnake;
import util.Directions;
import views.GameOverPanel;
import views.GamePanel;

public class GameController implements Runnable, KeyListener{
	private final int DELAY = 90;
	private static boolean running;
	private int score;
	
	private SnakeSprite snake;
	private List<FruitSprite> fruits;
	private FruitSpawner fruitSpawner;
	private static List<Point> occupiedPositions;
	private Directions direction;
	
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;

	private Thread loop;
	
	public GameController(GamePanel panel, GameOverPanel gameOverPanel) {
		this.gamePanel = panel;
		this.gameOverPanel = gameOverPanel;
		gamePanel.addKeyListener(this);
		fruits = new ArrayList<FruitSprite>();
		occupiedPositions = new ArrayList<Point>();
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
		snake = new ClassicSnake();
	}
	
	public void initGame(int selectedSnake) {
		running = true;
		score = 0;
		direction = null;
		gamePanel.updateScore(score);
		
		switch(selectedSnake) {
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
		
//		occupiedPositions = snake.getSnakeBody();
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
		
		new Thread(fruitSpawner).start();
		loop.start();
	}
	
	public void checkAteFruit() {
		for(int i=0; i<fruits.size() ; i++) {
    		if(snake.getHeadPosition().equals(fruits.get(i).getPosition())) {
//    		if(snake.getBounds().get(0).intersects(fruits.get(i).getBounds())) {
    			fruits.get(i).specialEffect(snake);
    			score += snake.getScoreMultiplier() * fruits.get(i).getScoreValue();
    			gamePanel.updateScore(score);
    			occupiedPositions.remove(fruits.get(i).getPosition());
    			fruits.remove(i);
    		}
    	}
	}

	@Override
	public void run() {
		this.fruits = fruitSpawner.getFruits();
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
			sleep = DELAY - endTime/1000000L;
			if(sleep < 0) {
				sleep = 1;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gamePanel.add(gameOverPanel, BorderLayout.CENTER);
		gamePanel.validate();
		gamePanel.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				if(direction != Directions.LEFT) {
					direction = Directions.RIGHT;
					snake.setDirection(direction);
				}
			break;
			case KeyEvent.VK_LEFT:
				if(direction != Directions.RIGHT) {
					direction = Directions.LEFT;
					snake.setDirection(direction);
				}
			break;
			case KeyEvent.VK_UP:
				if(direction != Directions.DOWN) {
					direction = Directions.UP;
					snake.setDirection(direction);
				}
			break;
			case KeyEvent.VK_DOWN:
				if(direction != Directions.UP) {
					direction = Directions.DOWN;
					snake.setDirection(direction);
				}
			break;
			default:
				break;
		}
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
	
	public static List<Point> getOccupiedPositions(){
		return occupiedPositions;
	}
	public static void addOccupiedPosition(Point p) {
		occupiedPositions.add(p);
	}
	public static void removeOccupiedPosition(Point p) {
		occupiedPositions.remove(p);
	}
	
	public void setScore(int value) {
		this.score = value;
	}
		
	public GamePanel getGamePanel() {
		return gamePanel;
	}

}
