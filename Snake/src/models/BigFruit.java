package models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BigFruit extends FruitSprite {
	public BigFruit() {
		super();
	}
	
	@Override
	public void skill(SnakeSprite snake) {
		scoreValue = 2;
		snake.increaseBody();
	}
	
	@Override
	protected void loadImage() {
		try {
			image = ImageIO.read(new File("./src/assets/BigFruit13px.png"));
		} catch (IOException e) {
			System.out.println("Failed to load BigFruit Image");
			e.printStackTrace();
		}
	}
}
