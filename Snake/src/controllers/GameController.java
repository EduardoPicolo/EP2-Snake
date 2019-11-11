package controllers;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import models.ClassicSnake;
import models.FruitSpawner;
import models.FruitSprite;
import models.KittySnake;
import models.BarrierCreator;
import models.SnakeSprite;
import models.StarSnake;
import util.Difficulties;
import util.Directions;
import util.Snakes;
import views.GameOverPanel;
import views.GamePanel;

public class GameController implements Runnable, KeyListener{
	private static int DELAY = 100;
	private static boolean running;
	private static boolean paused;
	
	private int score;
	private SnakeSprite snake;
	private List<FruitSprite> fruits;
	private FruitSpawner fruitSpawner;
	private BarrierCreator barrierCreator;
	private static List<Rectangle> occupiedPositions;
	private List<Rectangle> barrier;
	private Directions direction;
	private Difficulties difficulty;
	private GamePanel gamePanel;
	private GameOverPanel gameOverPanel;
	private Thread loop;
	
	public GameController(GamePanel panel, GameOverPanel gameOverPanel) {
		this.gamePanel = panel;
		this.gameOverPanel = gameOverPanel;
		gamePanel.addKeyListener(this);
		snake = new ClassicSnake();
		fruits = new ArrayList<FruitSprite>();
		barrierCreator = new BarrierCreator();
		barrier = new ArrayList<Rectangle>();
		occupiedPositions = new ArrayList<Rectangle>();
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
	}
	
	public void initGame(Snakes chosenSnake) {
		loop.interrupt();
		running = true;
		paused = false;
		score = 0;
		direction = null;
		barrierCreator.clearBarrier();
		barrier.clear();
		occupiedPositions.clear();
		switch(chosenSnake) {
			case CLASSIC:
				snake = new ClassicSnake();
				break;
			case STAR:
				snake = new StarSnake();
				break;
			case KITTY:
				snake = new KittySnake();
				break;
			default:
				snake = new ClassicSnake();
				break;
		}
		setupDifficulty();
		
		fruitSpawner = new FruitSpawner();
		loop = new Thread(this);
		
		new Thread(fruitSpawner).start();
		loop.start();
	}
	public void setupDifficulty() {
		switch(difficulty) {
			case EASY:
				DELAY = 100;
				break;
			case NORMAL: 
				DELAY = 85;
				barrierCreator.createHalfBarrier();
				break;
			case HARD:
				DELAY = 65;
				barrierCreator.createFullBarrier();
				break;
			default:
				DELAY = 100;
				break;
		}
		for(Rectangle r : barrierCreator.getBarrier()) {
			occupiedPositions.add(r);
			barrier.add(r);
		}
	}
	
	public void checkBarrierCollision() {
		for(Rectangle r : barrier) {
			if(snake.getBounds().get(0).intersects(r)) {
				setGameOver();
			}
		}
	}
	
	public void checkAteFruit() {
		for(int i=0; i<fruits.size() ; i++) {
    		if(snake.getHeadPosition().equals(fruits.get(i).getPosition())) {
    			fruits.get(i).skill(snake);
    			score += snake.getScoreMultiplier() * fruits.get(i).getScoreValue();
    			occupiedPositions.remove(fruits.get(i).getBounds());
    			fruits.remove(i);
    		}
    	}
	}
	

	@Override
	public void run() {
		fruits = fruitSpawner.getFruits();
		gamePanel.setSnake(snake);
		gamePanel.setFruits(fruits);
		gamePanel.setBarrier(barrier);
		gamePanel.setHeaderDifficulty(difficulty.toString());
		
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
			if(sleep < 0) sleep = 0;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			snake.setDirection(direction);
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
				}
			break;
			case KeyEvent.VK_LEFT:
				if(direction != Directions.RIGHT) {
					direction = Directions.LEFT;
				}
			break;
			case KeyEvent.VK_UP:
				if(direction != Directions.DOWN) {
					direction = Directions.UP;
				}
			break;
			case KeyEvent.VK_DOWN:
				if(direction != Directions.UP) {
					direction = Directions.DOWN;
				}
			break;
			case KeyEvent.VK_P:
				if(paused) {
					System.out.println("RUN");
					loop.resume();
					paused = false;
					gamePanel.removePause();
				}
				else {
					System.out.println("PAUSE");
					loop.suspend();
					paused = true;
					gamePanel.setPause();
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
	public static boolean isPause() {
		return paused;
	}
	public static void setGameOver() {
		running = false;
	}
	public void setDifficulty(Difficulties dif) {
		this.difficulty = dif;
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
