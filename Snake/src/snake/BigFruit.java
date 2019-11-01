package snake;

public class BigFruit extends FruitSprite {
	public BigFruit() {
		super();
	}
	
	@Override
	public void specialEffect() {
		scoreValue = 2;
	}
}
