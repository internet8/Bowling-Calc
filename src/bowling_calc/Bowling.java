package bowling_calc;

public class Bowling {
	
//int rolls[] = new int[22];
//int rolls[] = {0, 7, 1, 3, 9, 1, 7, 3, 7, 2, 10, 0, 4, 0, 8, 0, 10, 0, 7, 0, 0};
int rolls[] = {10, 0, 10, 0, 10, 0, 10, 0, 9, 0, 9, 1, 10, 0, 8, 2, 10, 0, 10, 0, 8, 2, 0};
int turn = 1;

public void resetRolls () {
	for (int i = 0; i < 22; i++) {
		rolls[i] = -1;
	}
}

public void recordRoll (int pins) {
	rolls[turn-1] = pins;
	if (pins == 10 && turn % 2 == 1) {
		rolls[turn] = 0;
		turn ++;
	}
	turn ++;
}

public int strike (int turn) {
	int result = 0;
	int throw1 = rolls[turn+2];
	int throw2 = rolls[turn+3];
	
	if (throw1 == 10) {
		result = strike(throw2+1);
	} else if (throw1+throw2 == 10) {
		result = spare(throw2+1);
	} else if (throw1 != -1 && throw2 != -1) {
		result = throw1+throw2+10;
	}
	
	return result;
}

public int spare (int turn) {
	int result = 0;
	int nextThrow = rolls[turn+2];
	
	if (nextThrow == 10) {
		result = strike(nextThrow+2);
	} else if (nextThrow != -1) {
		result = nextThrow+10;
	}
	
	return result;
}

public int calcScore () {
	int finalScore = 0;
	
	for (int i = 0; i < 22; i+=2) {
		int score = 0;
		int throw1 = rolls[i];
		int throw2 = rolls[i+1];
		
		if (throw1 == 10) {
			score = strike(i);
		} else if (throw1+throw2 == 10) {
			score = spare(i);
		} else {
			if (throw1 != -1) {
				score += throw1;
			} 
			if (throw2 != -1) {
				score += throw2;
			}
		}
		finalScore += score;
		System.out.println(finalScore);
	}
	
	return finalScore;
}

}
