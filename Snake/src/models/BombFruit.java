package models;

import javax.swing.ImageIcon;

import controllers.GameController;

public class BombFruit extends FruitSprite {
	public BombFruit() {
		super();
		scoreValue = 0;
	}
	
	@Override
	public void skill(SnakeSprite snake) {
		ImageIcon iia = new ImageIcon("./src/assets/explosion13px.png");
        image = iia.getImage();
		GameController.setGameOver();
	}
	
	@Override
	protected void loadImage() {
        ImageIcon iia = new ImageIcon("./src/assets/Bomb13px.png");
        image = iia.getImage();
	}
}
