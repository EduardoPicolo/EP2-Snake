package models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DecreaseFruit extends FruitSprite {
	public DecreaseFruit() {
		super();
	}
	
	@Override
	public void skill(SnakeSprite snake) {
		scoreValue = 0;
		snake.getSnakeBody().subList(1, snake.getBodySize()).clear();
	}
	
	@Override
	protected void loadImage() {
		try {
			image = ImageIO.read(new File("./src/assets/DecreaseFruit13px.png"));
		} catch (IOException e) {
			System.out.println("Failed to load DecreaseFruit Image");
			e.printStackTrace();
		}
	}
}
