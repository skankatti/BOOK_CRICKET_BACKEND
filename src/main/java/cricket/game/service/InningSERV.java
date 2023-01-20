package cricket.game.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import cricket.game.Exception.InputException;
import cricket.game.data.ScoreCardData;
import cricket.game.entity.EachBallStatTeamOne;
import cricket.game.entity.EachBallStatTeamTwo;
import cricket.game.entity.FinalScoreCardTeamOne;
import cricket.game.entity.FinalScoreCardTeamTwo;
import cricket.game.repo.EachBallStatTeamOneREPO;
import cricket.game.repo.EachBallStatTeamTwoREPO;
import cricket.game.repo.FinalScoreCardTeamOneREPO;
import cricket.game.repo.FinalScoreCardTeamTwoREPO;

/*
 * This class acts as a Service class  to communicate with database 
 */
@Service
public class InningSERV {

	@Autowired
	public ScoreCardData scoreCardData;

	@Autowired
	OvercountSERV overcountSERV;

	@Autowired
	RandomRunGenSERV randomRunGenSERV;

	@Autowired
	RunrateSERV runrateSERV;

	@Autowired
	TeamListSERV teamListSERV;

	@Autowired
	EachBallStatTeamOneREPO eachBallStatTeamOneREPO;

	@Autowired
	EachBallStatTeamTwoREPO eachBallStatTeamTwoREPO;

	@Autowired
	FinalScoreCardTeamOneREPO finalScoreCardTeamOneREPO;

	@Autowired
	FinalScoreCardTeamTwoREPO finalScoreCardTeamTwoREPO;

	@Autowired
	FinalScoreCardTeamOne finalScoreCardTeamOne;

	@Autowired
	FinalScoreCardTeamTwo finalScoreCardTeamTwo;

	// Reseting All the Values to Start New Match
	public ScoreCardData startNewMatch() {
		playNextMatch();
		scoreCardData.setTarget(0);
		scoreCardData.setTotalmatchPlayed(0);
		scoreCardData.setTeamoneWinCount(0);
		scoreCardData.setTeamtwoWinCount(0);
		scoreCardData.setInningType(0);
		scoreCardData.setTarget(0);
		scoreCardData.setTotalWicket(0);
		scoreCardData.setRemainingScore(0);
		scoreCardData.setBallCountForOver(0);
		scoreCardData.setBatsmanBallCount(0);
		scoreCardData.setBowlerId(0);
		scoreCardData.setResult(null);
		scoreCardData.setSeries(0);
		scoreCardData.setTeamOneName(null);
		scoreCardData.setTeamTwoName(null);

		return scoreCardData;

	}

	// Code For Game Play of First Inning and Second Inning
	public ScoreCardData inning() {

		if (scoreCardData.getInningType() == 1) {

			scoreCardData.setplayingTeamName(scoreCardData.getTossResult());

			// Setting BatsmanName
			if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamOneName())) {
				scoreCardData.setPlayerName(teamListSERV.team1Default(scoreCardData.getBatsManId()));
			} else if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamTwoName())) {
				scoreCardData.setPlayerName(teamListSERV.team2Default(scoreCardData.getBatsManId()));
			}

			// Setting BowlerName
			if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamOneName())) {
				scoreCardData.setBowlerName(teamListSERV.team2Default(scoreCardData.getBatsManId()));
			} else if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamTwoName())) {
				scoreCardData.setBowlerName(teamListSERV.team1Default(scoreCardData.getBowlerId()));
			}

			// Changing The Data for 2nd Inning Game Play
		} else if (scoreCardData.getInningType() == 2) {

			if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamOneName())) {
				scoreCardData.setplayingTeamName(scoreCardData.getTeamTwoName());
				scoreCardData.setPlayerName(teamListSERV.team2Default(scoreCardData.getBatsManId()));
			} else if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamTwoName())) {
				scoreCardData.setplayingTeamName(scoreCardData.getTeamOneName());
				scoreCardData.setPlayerName(teamListSERV.team1Default(scoreCardData.getBatsManId()));
			}

			// Setting BowlerName
			if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamOneName())) {
				scoreCardData.setBowlerName(teamListSERV.team1Default(scoreCardData.getBowlerId()));
			} else if (scoreCardData.getTossResult().equalsIgnoreCase(scoreCardData.getTeamTwoName())) {
				scoreCardData.setBowlerName(teamListSERV.team2Default(scoreCardData.getBowlerId()));
			}
		}

		// Calling function from RandomRunGen Class to generate Random Run
		scoreCardData.setRandomRun(randomRunGenSERV.runGenerator());

		// Calling function from RandomRunGen Class to set Legal or nonLegal Ball
		scoreCardData.setLegal(randomRunGenSERV.IsLegal1(scoreCardData.getRandomRun()));

		// Setting Target if Available
		scoreCardData.setTarget(scoreCardData.getTarget());

		// this will execute if the ball is Legal
		if (scoreCardData.isLegal()) {

			scoreCardData.setEachHitCount(scoreCardData.getEachHitCount() + 1);
			scoreCardData.setBallCount(scoreCardData.getBallCount() + 1);
			scoreCardData.setBallCountForOver(scoreCardData.getBallCountForOver() + 1);

			// this will add into database for the following condition in FinalScoreCard for
			// team one and two as per condition
			if (scoreCardData.getRandomRun() == 0
					|| scoreCardData.getBallCount() == scoreCardData.getTotalOvers() * 6) {

				scoreCardData.setCommentary(randomRunGenSERV.ShowComentry(scoreCardData.getRandomRun()));
				scoreCardData.setBatsManRun(scoreCardData.getBatsManRun() + scoreCardData.getRandomRun());
				scoreCardData.setBatsmanBallCount(scoreCardData.getBatsmanBallCount() + 1);

				//inserting data to finalScoreCard 
				addToFinalScoreCard(scoreCardData.getInningType(), scoreCardData.getOversCompleted(),
						scoreCardData.getRandomRun());
				scoreCardData.setBatsmanBallCount(scoreCardData.getBatsmanBallCount() - 1);

			}

			if (scoreCardData.getRandomRun() == 0) {

				scoreCardData.setWicketCount(scoreCardData.getWicketCount() + 1);
				scoreCardData.setBatsManId(scoreCardData.getBatsManId() + 1);
				scoreCardData.setBatsmanBallCount(scoreCardData.getBatsmanBallCount() + 1);

				scoreCardData.setBatsManRun(0);
				scoreCardData.setBatsmanBallCount(0);
				scoreCardData.setBatsmanBallCount(0);
				scoreCardData.setTotalScore(scoreCardData.getTotalScore() + scoreCardData.getRandomRun());
				// calling

			} else if (scoreCardData.getRandomRun() == 4) {

				scoreCardData.setBatsManRun(scoreCardData.getBatsManRun() + scoreCardData.getRandomRun());
				scoreCardData.setBatsmanBallCount(scoreCardData.getBatsmanBallCount() + 1);
				scoreCardData.setTotalScore(scoreCardData.getTotalScore() + scoreCardData.getRandomRun());
				scoreCardData.setCommentary(randomRunGenSERV.ShowComentry(scoreCardData.getRandomRun())); // calling

			} else if (scoreCardData.getRandomRun() == 6) {

				scoreCardData.setBatsManRun(scoreCardData.getBatsManRun() + scoreCardData.getRandomRun());
				scoreCardData.setBatsmanBallCount(scoreCardData.getBatsmanBallCount() + 1);
				scoreCardData.setTotalScore(scoreCardData.getTotalScore() + scoreCardData.getRandomRun());
				scoreCardData.setCommentary(randomRunGenSERV.ShowComentry(scoreCardData.getRandomRun())); // calling

			} else if (scoreCardData.getRandomRun() == 5) {
				scoreCardData.setTotalScore(scoreCardData.getTotalScore() + 1);
				scoreCardData.setBatsmanBallCount(scoreCardData.getBatsmanBallCount() + 1);
				scoreCardData.setCommentary(randomRunGenSERV.ShowComentry(scoreCardData.getRandomRun())); // calling

			}

			else {
				scoreCardData.setBatsmanBallCount(scoreCardData.getBatsmanBallCount() + 1);
				scoreCardData.setTotalScore(scoreCardData.getTotalScore() + scoreCardData.getRandomRun());
				scoreCardData.setBatsManRun(scoreCardData.getBatsManRun() + scoreCardData.getRandomRun());
				scoreCardData.setCommentary(randomRunGenSERV.ShowComentry(scoreCardData.getRandomRun())); // calling

			}

		}

		// this will execute if the ball is not Legal
		else {
			scoreCardData.setEachHitCount(scoreCardData.getEachHitCount() + 1);
			scoreCardData.setTotalScore(scoreCardData.getTotalScore() + 1);
			scoreCardData.setCommentary(randomRunGenSERV.ShowComentry(scoreCardData.getRandomRun())); // calling

		}

		// changing bowler name after each over
		if (scoreCardData.getBallCountForOver() == 6) {
			scoreCardData.setBallCountForOver(0);
			scoreCardData.setBowlerId(scoreCardData.getBowlerId() + 1);
		}

		// calling CurrentRunRate function from RunRate Class
		scoreCardData.setCurrentRunRate(
				runrateSERV.currentRunRate(scoreCardData.getTotalScore(), scoreCardData.getBallCount()));

		// calling tOver function from OverCount Class to Calculate total Overs
		scoreCardData.setOversCompleted(overcountSERV.tOver(scoreCardData.getBallCount()));

		if (scoreCardData.getInningType() == 1) {

			// inserting data of each ball status to EachBallstat Table for team one
			eachBallStatTeamOneREPO.addDetails(scoreCardData.getEachHitCount(), scoreCardData.getBallCount(),
					scoreCardData.getPlayerName(), scoreCardData.getTotalScore(), scoreCardData.getRandomRun(),
					scoreCardData.getCommentary(), scoreCardData.getBatsManRun(),scoreCardData.getOversCompleted()
					,scoreCardData.getCurrentRunRate());//

		} else if (scoreCardData.getInningType() == 2) {
			// Code for Required RunRate for 2nd inning batting
			scoreCardData.setRemainingScore(scoreCardData.getTarget() - scoreCardData.getTotalScore());
			scoreCardData.setReqRunRate(runrateSERV.requiredRunRate(scoreCardData.getTarget(),
					scoreCardData.getTotalOvers(), scoreCardData.getTotalScore(), scoreCardData.getOversCompleted()));

			scoreCardData.setRemainingBall(scoreCardData.getOversCompleted() * 6 - (1));

			// inserting data of each ball status to EachBallstat Table for team 2
			eachBallStatTeamTwoREPO.addDetails(scoreCardData.getEachHitCount(), scoreCardData.getBallCount(),
					scoreCardData.getPlayerName(), scoreCardData.getTotalScore(), scoreCardData.getRandomRun(),
					scoreCardData.getCommentary(), scoreCardData.getBatsManRun(),scoreCardData.getOversCompleted()
					,scoreCardData.getCurrentRunRate());//

		}

		return scoreCardData;
	}

	public ScoreCardData endOfFirstInning() {
		scoreCardData.setTarget(scoreCardData.getTotalScore() + 1);
		scoreCardData.setRemainingBall(scoreCardData.getTotalOvers() * 6.0f);
		scoreCardData.setBallCount(0);
		scoreCardData.setWicketCount(0);
		scoreCardData.setTotalScore(0);
		scoreCardData.setOversCompleted(0);
		scoreCardData.setBatsManId(0);
		scoreCardData.setBowlerId(0);
		scoreCardData.setBatsmanBallCount(0);
		scoreCardData.setBatsManRun(0);
		scoreCardData.setEachHitCount(0);
		scoreCardData.setInningType(2);

		return scoreCardData;

	}

	public ScoreCardData playNextMatch() {

		scoreCardData.setInningType(1);
		scoreCardData.setBallCount(0);
		scoreCardData.setRandomRun(0);
		scoreCardData.setTotalScore(0);
		scoreCardData.setTotalWicket(scoreCardData.getTotalWicket());
		scoreCardData.setBatsManId(0);
		scoreCardData.setBatsManRun(0);
		scoreCardData.setBallCountForOver(0);
		scoreCardData.setBatsmanBallCount(0);
		scoreCardData.setBowlerId(0);
		scoreCardData.setEachHitCount(0);
		scoreCardData.setTarget(0);
		scoreCardData.setWicketCount(0);
		scoreCardData.setRemainingScore(0);
		scoreCardData.setOversCompleted(0);
		scoreCardData.setRemainingBall(0);
		scoreCardData.setRemainingOvers(0);
		scoreCardData.setResult(null);
		scoreCardData.setTossResult(null);
		scoreCardData.setReqRunRate(null);
		scoreCardData.setCurrentRunRate(null);
		scoreCardData.setBatsmanRunRate(null);
		scoreCardData.setplayingTeamName(null);
		scoreCardData.setPlayerName(null);
		scoreCardData.setBowlerName(null);

		return scoreCardData;

	}

	public List<String> setOversWicketsTeams(float tovatlOver, int totalWickets, String teamOne, String teamTwo, int series) {
		if (teamOne == null || teamTwo == null || series < 1 || tovatlOver <= 0 || totalWickets <= 0) {
			throw new InputException("invalid Input", HttpStatus.BAD_REQUEST);
		}

		scoreCardData.setTotalOvers(tovatlOver);
		scoreCardData.setTotalWicket(totalWickets);
		scoreCardData.setTeamOneName(teamOne);
		scoreCardData.setTeamTwoName(teamTwo);
		scoreCardData.setSeries(series);
		scoreCardData.setInningType(1);
		
		List<String> teamNames= new ArrayList<String>();
		
		teamNames.add(scoreCardData.getTeamOneName());
		teamNames.add(scoreCardData.getTeamTwoName());
		
		return teamNames;

	}

	public String toss() {
		String[] arr = { scoreCardData.getTeamOneName(), scoreCardData.getTeamTwoName() };
		Random random = new Random();
		int select = random.nextInt(arr.length);
		scoreCardData.setTossResult(arr[select]);

		return scoreCardData.getTossResult();

	}

//	(int id, int ballPlayed, String playerName, String runRate, String commentary,
//			String bowlerName, int playerRun);	

	public void addToFinalScoreCard(int inningType, float ballCount, int randomRun) {
		if (inningType == 1) {
			finalScoreCardTeamOneREPO.addToFinalScoreCardTeamOne(scoreCardData.getEachHitCount(),
					scoreCardData.getBatsmanBallCount(), scoreCardData.getPlayerName(), null,
					scoreCardData.getCommentary(), scoreCardData.getBowlerName(), scoreCardData.getBatsManRun());
		} else if (inningType == 2) {
			finalScoreCardTeamTwoREPO.addToFinalScoreCardTeamTwo(scoreCardData.getEachHitCount(),
					scoreCardData.getBatsmanBallCount(), scoreCardData.getPlayerName(), null,
					scoreCardData.getCommentary(), scoreCardData.getBowlerName(), scoreCardData.getBatsManRun());

		}
	}

	public List<EachBallStatTeamOne> eachBallStatTeamOneEntity() {
		List<EachBallStatTeamOne> eachBallStatTeamOneList = eachBallStatTeamOneREPO.findAll();
		return eachBallStatTeamOneList;
	}

	public List<EachBallStatTeamTwo> eachBallStatTeamTwoEntity() {
		List<EachBallStatTeamTwo> eachBallStatTeamTwoList = eachBallStatTeamTwoREPO.findAll();
		return eachBallStatTeamTwoList;
	}

	public List<FinalScoreCardTeamOne> finalScoreCardTeamOneEnity() {
		List<FinalScoreCardTeamOne> finalscorecardListOne = finalScoreCardTeamOneREPO.findAll();
		return finalscorecardListOne;
	}

	public List<FinalScoreCardTeamTwo> finalScoreCardTeamTwoEnity() {
		List<FinalScoreCardTeamTwo> finalscorecardListTwo = finalScoreCardTeamTwoREPO.findAll();
		return finalscorecardListTwo;
	}

}
