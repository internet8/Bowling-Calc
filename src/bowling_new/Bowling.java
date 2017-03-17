package bowling_new;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
	private static List<Frame> frames = new ArrayList<Frame>();
	private boolean isFrameCompleted = true;

	public static void main(String args[]) {
		Bowling bowling = new Bowling();
		for (int i = 0; i < 21; i++) {
			bowling.roll(5);
		}
		bowling.printGame();
		System.out.println(bowling.getScore());
	}

	public void roll(Integer value) {
		if (frames.size() == 10) {
			isFrameCompleted = false;
		}
		if (isFrameCompleted) {
			Frame frame = new Frame();
			frame.addRoll(value);
			if (value == 10) {
				isFrameCompleted = true;
			} else {
				isFrameCompleted = false;
			}
			frames.add(frame);
		} else {
			addRollToLastFrame(value);
			isFrameCompleted = true;
		}
	}

	private void addRollToLastFrame(Integer value) {
		frames.get(frames.size() - 1).addRoll(value);
	}

	public int getScore() {
		int score = 0;
		for (int i = 0; i < frames.size(); i++) {
			score += frames.get(i).getSum();
			if (frames.get(i).getRoll(1) == 10 && i == 8) {
				score += (frames.get(i + 1).getRoll(1) + frames.get(i + 1).getRoll(2));
			} else if (frames.get(i).getRoll(1) == 10 && frames.get(i).countRolls() != 3) {
				if (frames.get(i + 1).getRoll(1) == 10) {
					score += (frames.get(i + 1).getRoll(1) + frames.get(i + 2).getRoll(1));
				} else {
					score += frames.get(i + 1).getSum();
				}
			} else if (frames.get(i).getSum() == 10) {
				score += frames.get(i + 1).getRoll(1);
			}
		}
		return score;
	}

	public void printGame() {
		for (Frame frame : frames) {
			System.out.println(frame);
		}
	}
	
	public void resetFrames() {
		frames.clear();
	}
}
