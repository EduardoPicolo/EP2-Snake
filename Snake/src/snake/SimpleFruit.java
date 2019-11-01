package snake;

public class SimpleFruit extends FruitSprite{
	public SimpleFruit() {
		super();
	}
	
	@Override
	public void specialEffect() {
		scoreValue = 1;
	}
}
