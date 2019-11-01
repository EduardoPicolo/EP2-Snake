package snake;

public class DecreaseFruit extends FruitSprite {
	public DecreaseFruit() {
		super();
	}
	
	@Override
	public void specialEffect() {
		scoreValue = 0;
	}
}
