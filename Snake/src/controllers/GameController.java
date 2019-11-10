package controllers;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Rectangle;
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
	private static List<Rectangle> occupiedPositions;
	private List<Rectangle> obstacles;
	private Directions direction;
	
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;

	private Thread loop;
	
	public GameController(GamePanel panel, GameOverPanel gameOverPanel) {
		this.gamePanel = panel;
		this.gameOverPanel = gameOverPanel;
		gamePanel.addKeyListener(this);
		snake = new ClassicSnake();
		fruits = new ArrayList<FruitSprite>();
		occupiedPositions = new ArrayList<Rectangle>();
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
		obstacles = new ArrayList<Rectangle>();
	}
	
	public void initGame(int chosenSnake) {
		running = true;
		score = 0;
		direction = null;
		obstacles.add(new Rectangle(247, 143, 13, 39));
		obstacles.add(new Rectangle(208, 130, 52, 13));
		obstacles.add(new Rectangle(130, 208, 13, 39));
		obstacles.add(new Rectangle(130, 247, 52, 13));
		
		switch(chosenSnake) {
			case 1:
				snake = new ClassicSnake();
				break;
			case 2:
				snake = new StarSnake();
				break;
			case 3:
				snake = new KittySnake();
				break;
			default:
				snake = new ClassicSnake();
				break;
		}
		
		for(Rectangle r : obstacles) {
			occupiedPositions.add(r);
		}
		
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
		
		new Thread(fruitSpawner).start();
		loop.start();
	}
	
	public void checkAteFruit() {
		for(int i=0; i<fruits.size() ; i++) {
    		if(snake.getHeadPosition().equals(fruits.get(i).getPosition())) {
//    		if(snake.getBounds().get(0).intersects(fruits.get(i).getBounds())) {
    			fruits.get(i).skill(snake);
    			score += snake.getScoreMultiplier() * fruits.get(i).getScoreValue();
    			occupiedPositions.remove(fruits.get(i).getBounds());
    			fruits.remove(i);
    		}
    	}
	}
	
	public void checkBarrierCollision() {
		for(Rectangle r : obstacles) {
			if(snake.getBounds().get(0).intersects(r)) {
				setGameOver();
			}
		}
	}

	@Override
	public void run() {
		this.fruits = fruitSpawner.getFruits();
		gamePanel.setSnake(snake);
		gamePanel.setFruits(fruits);
		
		long loopStartTime, loopElapsedTime, sleep, startTime;
		startTime = System.currentTimeMillis();
		
		while(running) {
			loopStartTime = System.nanoTime();
			
			snake.move();
			if(snake.checkCollision())
				setGameOver();
			if(!(snake instanceof KittySnake)) {
				checkBarrierCollision();
			}
			checkAteFruit();
			gamePanel.updateHeader(score, startTime);
			gamePanel.repaint();
			
			loopElapsedTime = System.nanoTime() - loopStartTime;
			sleep = DELAY - loopElapsedTime/1000000L;
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
	
	public static List<Rectangle> getOccupiedPositions(){
		return occupiedPositions;
	}
	
	public static void addOccupiedPosition(Rectangle p) {
		occupiedPositions.add(p);
	}
	public static void removeOccupiedPosition(Rectangle p) {
		occupiedPositions.remove(p);
	}
	
}
