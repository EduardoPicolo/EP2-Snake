package models;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BarrierCreator {
	private List<Rectangle> barrier;
	
	public BarrierCreator() {
		barrier = new ArrayList<Rectangle>();
	}

	public void createHalfBarrier() {
		barrier.add(new Rectangle(247, 143, 13, 39));
		barrier.add(new Rectangle(208, 130, 52, 13));
		barrier.add(new Rectangle(117, 221, 13, 39));
		barrier.add(new Rectangle(117, 260, 52, 13));		
	}
	
	public void createFullBarrier() {
		createHalfBarrier();
		barrier.add(new Rectangle( 117, 143, 13, 39 ));
		barrier.add(new Rectangle( 117, 130, 52, 13 ));
		barrier.add(new Rectangle( 247, 224, 13, 39 ));
		barrier.add(new Rectangle( 208, 260, 52, 13 ));
	}
	
	public List<Rectangle> getBarrier(){
		return barrier;
	}
}
