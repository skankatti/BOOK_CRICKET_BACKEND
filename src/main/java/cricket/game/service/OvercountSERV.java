package cricket.game.service;

import org.springframework.stereotype.Service;

@Service
public class OvercountSERV {
	
	float numberOfOvers,remainingOvers;
	String round;
	String mod;

	public float tOver(int ball) {

		round = String.valueOf(Math.round(ball / 6));
		mod = String.valueOf(ball % 6);
		numberOfOvers = Float.valueOf(round + "." + mod);
		return numberOfOvers;
	}
	
	public float remainingOvers(float remainingBalls) {
		round = String.valueOf(Math.round(remainingBalls / 6));
		mod = String.valueOf(remainingBalls % 6);
		
		remainingOvers = Float.valueOf(round + "." + mod);
		return remainingOvers;
	}

}
