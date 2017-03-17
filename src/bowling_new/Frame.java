package bowling_new;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	private List<Integer> frameValues = new ArrayList<Integer>();

	public Frame() {
	}
	
	public void addRoll(Integer value) {
		frameValues.add(value);
	}

	private synchronized final List<Integer> getFrame() {
		return frameValues;
	}

	private synchronized final void setFrame(List<Integer> frame) {
		this.frameValues = frame;
	}
	
	public Integer getSum() {
		int sum = 0;
		for (Integer roll : frameValues) {
			sum += roll;
		}
		return sum;
	}
	
	public Integer getRoll(int index) {
		return frameValues.get(index-1);
	}
	
	public int countRolls() {
		return frameValues.size();
	}

	@Override
	public String toString() {
		return "Frame [" + (frameValues != null ? "frameValues=" + frameValues : "") + "]";
	}
	
}