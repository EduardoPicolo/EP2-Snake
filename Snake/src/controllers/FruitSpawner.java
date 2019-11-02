package controllers;

import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import models.BigFruit;
import models.BombFruit;
import models.DecreaseFruit;
import models.FruitSprite;
import models.SimpleFruit;

public class FruitSpawner implements Runnable{
	private final int SPECIAL_FRUIT_TIME = 10000;
	
	private LinkedList<FruitSprite> fruits;
	private Timer specialTimer;
	private Random random;
	
	public FruitSpawner() {
		fruits = new LinkedList<>();
		specialTimer = new Timer();
		random = new Random();
		
		fruits.addFirst(new SimpleFruit());
//		GamePanel.setFruits(fruits);
		GameController.setFruits(fruits);
	}
	
	@Override
	public void run() {
		specialTimer.scheduleAtFixedRate(new TimerTask(){
			public void run() {
				if(fruits.size() > 1) {
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
				}
//				GamePanel.setFruits(fruits);
//				Game.setFruits(fruits);
			}
		}, 15000, SPECIAL_FRUIT_TIME);
		
		while(GameController.isRunning()) {
			
			if(!(fruits.stream().anyMatch(x -> x instanceof SimpleFruit))) {
				fruits.addFirst(new SimpleFruit());
//				GamePanel.setFruits(fruits);
//				Game.setFruits(fruits);
			}
			
			try {
				Thread.sleep(500);
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
	
}