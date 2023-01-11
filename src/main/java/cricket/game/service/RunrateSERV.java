package cricket.game.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

@Service
public class RunrateSERV {
	
	DecimalFormat decfor = new DecimalFormat("0.00");

	String currentRunRate(float score, int ballCount) {
		float runRatee = ((score / ballCount) * 6);
		String runRate = decfor.format(runRatee);
		return runRate;
	}

	public String requiredRunRate(int target, float maxOver, int currentScore, float oversBowled) {
		float remainingOvers = maxOver - oversBowled;
		float remainingRuns = target - currentScore;

		float rRunRate = remainingRuns / remainingOvers;
		String reqRunRate = decfor.format(rRunRate);
		return reqRunRate;
	}

}
