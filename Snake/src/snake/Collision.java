package snake;

public class Collision {
	
	public Collision() {
		
	}
	
	public boolean checkCollision(SnakeSprite snake) {
		
        for (int z = snake.getBodySize(); z > 0; z--) {

            if ((z > 4) && (snake.getPOS_X()[0] == snake.getPOS_X()[z]) && (snake.getPOS_Y()[0] == snake.getPOS_Y()[z])) {
//                inGame = false;
            	return false;
            }
        }

        if (snake.getPOS_Y()[0] >= Main.SCREEN_HEIGHT) {
//            inGame = false;
        	return false;
        }
        
        if (snake.getPOS_Y()[0] < 0) {
//            inGame = false;
        	return false;
        }

        if (snake.getPOS_X()[0] >= Main.SCREEN_WIDTH) {
//            inGame = false;
        	return false;
        }

        if (snake.getPOS_X()[0] < 0) {
//            inGame = false;
        	return false;
        }
        
//        if(!inGame) {
////            timer.stop();
//        	repaint();
//        	
//        }
        return true;
    }
	
//	public check

}
