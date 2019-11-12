package models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import controllers.GameEngine;

public class BombFruit extends FruitSprite {
	public BombFruit() {
		super();
		scoreValue = 0;
	}
	
	@Override
	public void skill(SnakeSprite snake) {
		GameEngine.setGameOver();
	}
	
	@Override
	protected void loadImage() {
		try {
			image = ImageIO.read(new File("./src/assets/Bomb13px.png"));
		} catch (IOException e) {
			System.out.println("Failed to load BombFruit Image");
			e.printStackTrace();
		}
	}
}
