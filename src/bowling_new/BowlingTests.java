package bowling_new;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingTests {
	
		Bowling bowling = new Bowling();

	@Test
	  public void Spare() {
		bowling.resetFrames();
		for (int i = 0; i < 21; i++) {
			bowling.roll(5);
		}
		assertEquals(bowling.getScore(), 150);
	  }
	
	@Test
	  public void Strike() {
		bowling.resetFrames();
		for (int i = 0; i < 12; i++) {
			bowling.roll(10);
		}
		assertEquals(bowling.getScore(), 300);
	  }
	
	@Test
	  public void exampleGame() {
		bowling.resetFrames();
			bowling.roll(9);
			bowling.roll(1);
			bowling.roll(10);
			bowling.roll(3);
			bowling.roll(7);
			bowling.roll(8);
			bowling.roll(2);
			bowling.roll(8);
			bowling.roll(2);
			bowling.roll(7);
			bowling.roll(3);
			bowling.roll(8);
			bowling.roll(2);
			bowling.roll(10);
			bowling.roll(10);
			bowling.roll(9);
			bowling.roll(1);
			bowling.roll(6);
		assertEquals(bowling.getScore(), 196);
	  }
}
