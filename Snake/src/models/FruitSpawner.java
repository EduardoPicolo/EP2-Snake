package models;

import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import controllers.GameController;
import util.Difficulties;

public class FruitSpawner implements Runnable{
	private final int SPECIAL_FRUIT_TIME = 10000;
	
	private LinkedList<FruitSprite> fruits;
	private Difficulties difficulty;
	private Timer specialTimer;
	private Random random;
	
	public FruitSpawner(Difficulties difficulty) {
		fruits = new LinkedList<>();
		specialTimer = new Timer();
		random = new Random();
		this.difficulty = difficulty;
		fruits.addFirst(new SimpleFruit());
		GameController.addOccupiedPosition(fruits.getFirst().getBounds());
	}
	
	
	@Override
	public void run() {
		specialTimer.scheduleAtFixedRate(new TimerTask(){
			public void run() {
				if(fruits.size() > 1) {
					GameController.removeOccupiedPosition(fruits.getLast().getBounds());
					fruits.removeLast();
				}
				else {
					switch(random.nextInt(3)) {
						case 0:
							fruits.addLast(new BigFruit());
						break;
						case 1: 
							fruits.addLast(new BombFruit());
						break;
						case 2:
							fruits.addLast(new DecreaseFruit());
						break;				
						default:
							break;
					}
					GameController.addOccupiedPosition(fruits.getLast().getBounds());
				}
			}
		}, 15000, SPECIAL_FRUIT_TIME);
		
		while(GameController.isRunning()) {
			
			if(!(fruits.stream().anyMatch(x -> x instanceof SimpleFruit))) {
				fruits.addFirst(new SimpleFruit());
				GameController.addOccupiedPosition(fruits.getFirst().getBounds());
			}
			
			if(difficulty.equals(Difficulties.INSANE)) {
				fruits.addLast(new BombFruit());
				GameController.addOccupiedPosition(fruits.getLast().getBounds());
			}
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		specialTimer.cancel();
	}
	
	public LinkedList<FruitSprite> getFruits() {
		return fruits;
	}
	public void setDifficulty(Difficulties d) {
		this.difficulty = d;
	}
	
}
