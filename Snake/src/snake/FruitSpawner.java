package snake;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class FruitSpawner implements Runnable{
	private final int SPECIAL_FRUIT_TIME = 10000;
	private LinkedList<FruitSprite> fruits;
	private Timer specialTimer;
	
	public FruitSpawner() {
		fruits = new LinkedList<>();
		specialTimer = new Timer();
		
		fruits.addFirst(new SimpleFruit());
		GamePanel.setFruits(fruits);
	}
	
	@Override
	public void run() {
		specialTimer.scheduleAtFixedRate(new TimerTask(){
			public void run() {
				if(fruits.size() > 1) {
					fruits.removeLast();
				}
				else {
//					fruits.add(new FruitSprite());
					fruits.addLast(new BombFruit());
				}
				GamePanel.setFruits(fruits);
			}
		}, 5000, SPECIAL_FRUIT_TIME);
		
		while(GamePanel.getInGame()) {
			
			if(!(fruits.stream().anyMatch(x -> x instanceof SimpleFruit))) {
				fruits.addFirst(new SimpleFruit());
				GamePanel.setFruits(fruits);
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
	
}
