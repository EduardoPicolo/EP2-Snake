package models;

import javax.swing.ImageIcon;

import controllers.GameController;

public class BombFruit extends FruitSprite {
	public BombFruit() {
		super();
		scoreValue = 0;
	}
	
	@Override
	public void specialEffect(SnakeSprite snake) {
		scoreValue = 0;
		GameController.setGameOver();
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("./src/assets/BombFruit10px.png");
        fruit_image = iia.getImage();
	}
}
