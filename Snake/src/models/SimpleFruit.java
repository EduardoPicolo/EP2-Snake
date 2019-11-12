package models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SimpleFruit extends FruitSprite{
	public SimpleFruit() {
		super();
	}
	
	@Override
	public void skill(SnakeSprite snake) {
		scoreValue = 1;
		snake.increaseBody();
	}
	
	@Override
	protected void loadImage() {
		try {
			image = ImageIO.read(new File("./src/assets/SimpleFruit13px.png"));
		} catch (IOException e) {
			System.out.println("Failed to load SimpleFruit Image");
			e.printStackTrace();
		}
	}
}
