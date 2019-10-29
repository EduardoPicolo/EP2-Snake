package snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FruitSpawner implements Runnable{
	private static final int AVERAGE_FRUITS_DISPLAY = 4;
	private List<FruitSprite> fruits;
	private Random randomInt;
	
	public FruitSpawner() {
		fruits = new ArrayList<>();
		randomInt = new Random();
		
		for(int i=0 ; i<randomInt.nextInt(AVERAGE_FRUITS_DISPLAY)+1; i++) {
			fruits.add(new FruitSprite());
		}
	}
		
	@Override
	public void run() {
		while(GamePanel.getInGame()) {
			
			if(fruits.size() < AVERAGE_FRUITS_DISPLAY) {
				for(int i=fruits.size(); i<randomInt.nextInt(AVERAGE_FRUITS_DISPLAY)+1 ; i++) {
					fruits.add(new FruitSprite());
				}
			}
			
			GamePanel.setFruits(fruits);
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			if(fruits.size() > AVERAGE_FRUITS_DISPLAY) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fruits.remove(fruits.get(randomInt.nextInt(fruits.size())));
			}
		}
	}
	
}
