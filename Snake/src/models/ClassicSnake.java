package models;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ClassicSnake extends SnakeSprite {
	public ClassicSnake() {
		super();
		score_multiplier = 1;
		setDimensions();
	}
	
	@Override
    protected void loadImages() {
		try {
			head_image = ImageIO.read(new File("./src/assets/GreenHead13px.png"));
			body_image = ImageIO.read(new File("./src/assets/GreenBody13px.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
