package models;

import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StarSnake extends SnakeSprite {
	public StarSnake() {
		super();
		score_multiplier = 2;
		setDimensions();
	}
	
	@Override
    protected void loadImages() {
        try {
			head_image = ImageIO.read(new File("./src/assets/StarHead13px.png"));
			body_image = ImageIO.read(new File("./src/assets/StarBody13px.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	@Override
	public void increaseBody() {
		body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
		body.addLast(new Point((int)body.getLast().getX(), (int)body.getLast().getY()));
	}
}
