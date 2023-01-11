package cricket.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cricket.game.data.ScoreCardData;
import cricket.game.entity.EachBallStatTeamOne;
import cricket.game.entity.EachBallStatTeamTwo;
import cricket.game.entity.FinalScoreCardTeamOne;
import cricket.game.entity.FinalScoreCardTeamTwo;
import cricket.game.repo.EachBallStatTeamOneREPO;
import cricket.game.repo.EachBallStatTeamTwoREPO;
import cricket.game.repo.FinalScoreCardTeamOneREPO;
import cricket.game.repo.FinalScoreCardTeamTwoREPO;
import cricket.game.service.InningSERV;
import cricket.game.service.RunrateSERV;
import cricket.game.service.TeamListSERV;

@RestController
@CrossOrigin("*")
@RequestMapping("/book-cricket")
public class GamePlayCTRL {

	@Autowired
	InningSERV inningSERV;

	@Autowired
	RunrateSERV runrateSERV;

	@Autowired
	TeamListSERV teamListSERV;

	@Autowired
	ScoreCardData scoreCardData;

	@Autowired
	EachBallStatTeamOneREPO eachBallStatTeamOneREPO;

	@Autowired
	EachBallStatTeamTwoREPO eachBallStatTeamTwoREPO;

	@Autowired
	FinalScoreCardTeamOneREPO finalScoreCardTeamOneREPO;

	@Autowired
	FinalScoreCardTeamTwoREPO finalScoreCardTeamTwoREPO;

	@PostMapping("/setOverswicketsTeamNames")
	public ResponseEntity<String> setOversWicketsTeams(@RequestParam float tovatlOver, @RequestParam int totalWickets,
			@RequestParam String teamOne, @RequestParam String teamTwo, @RequestParam int series) {
		return new ResponseEntity<String>(
				inningSERV.setOversWicketsTeams(tovatlOver, totalWickets, teamOne, teamTwo, series), HttpStatus.OK);

	}

	@GetMapping("/next-match")
	public ResponseEntity<ScoreCardData> nextMatch() {
		eachBallStatTeamOneREPO.truncateEachBallStatTeamone();
		eachBallStatTeamTwoREPO.truncateEachBallStatTeamtwo();
		finalScoreCardTeamOneREPO.truncateFinalCardTeamone();
		finalScoreCardTeamTwoREPO.truncateFinalCardTeamtwo();
		return new ResponseEntity<>(inningSERV.playNextMatch(), HttpStatus.OK);
	}

	@GetMapping("/inning")
	public ResponseEntity<ScoreCardData> inning() {

		if (scoreCardData.getOversCompleted() < scoreCardData.getTotalOvers()
				&& scoreCardData.getWicketCount() < scoreCardData.getTotalWicket() && scoreCardData.getInningType() == 1
				&& scoreCardData.getTotalmatchPlayed() < scoreCardData.getSeries()) {
			inningSERV.inning();
			return new ResponseEntity<ScoreCardData>(scoreCardData, HttpStatus.OK);

		} else if (scoreCardData.getOversCompleted() < scoreCardData.getTarget()
				&& scoreCardData.getWicketCount() < scoreCardData.getTotalWicket()
				&& scoreCardData.getTotalScore() <= scoreCardData.getTarget()
				&& scoreCardData.getTotalmatchPlayed() < scoreCardData.getSeries()
				&& scoreCardData.getResult() == null) {
			inningSERV.inning();

			// Conditions to check and set Result if team has won or loose
			if (scoreCardData.getTotalScore() < scoreCardData.getTarget() - 1
					&& scoreCardData.getOversCompleted() == scoreCardData.getTotalOvers()
					|| scoreCardData.getWicketCount() == scoreCardData.getTotalWicket()) {
				scoreCardData.setResult(scoreCardData.getTossResult());

			}

			else if (scoreCardData.getTotalScore() == scoreCardData.getTarget() - 1
					&& scoreCardData.getOversCompleted() >= scoreCardData.getTotalOvers()
					|| scoreCardData.getWicketCount() == scoreCardData.getTotalWicket()) {
				scoreCardData.setResult("Its A Tie");

			}

			else if (scoreCardData.getTotalScore() >= scoreCardData.getTarget()) {
				scoreCardData.setResult(scoreCardData.getPlayingTeamName());
				finalScoreCardTeamTwoREPO.addToFinalScoreCardTeamTwo(scoreCardData.getEachHitCount(),
						scoreCardData.getBatsmanBallCount(), scoreCardData.getPlayerName(), null,
						scoreCardData.getCommentary(), scoreCardData.getBowlerName(), scoreCardData.getBatsManRun());
			}

			// setting the Result is any of the team wins the match
			if (scoreCardData.getResult() != null) {
				if (scoreCardData.getResult().equalsIgnoreCase(scoreCardData.getTeamOneName())) {
					scoreCardData.setTeamoneWinCount(scoreCardData.getTeamoneWinCount() + 1);
				} else if (scoreCardData.getResult().equalsIgnoreCase(scoreCardData.getTeamTwoName())) {
					scoreCardData.setTeamtwoWinCount(scoreCardData.getTeamtwoWinCount() + 1);
				}
				scoreCardData.setTotalmatchPlayed(scoreCardData.getTotalmatchPlayed() + 1);
			}

			// Checking and setting the Tournament Result
			if (scoreCardData.getTotalmatchPlayed() == scoreCardData.getSeries()) {
				if (scoreCardData.getTeamoneWinCount() > scoreCardData.getTeamtwoWinCount()) {
					scoreCardData.setTournamentResult(scoreCardData.getTeamOneName());
				} else if (scoreCardData.getTeamtwoWinCount() > scoreCardData.getTeamoneWinCount()) {
					scoreCardData.setTournamentResult(scoreCardData.getTeamTwoName());
				}
			}

			return new ResponseEntity<ScoreCardData>(scoreCardData, HttpStatus.OK);

		}
		return new ResponseEntity<ScoreCardData>(scoreCardData, HttpStatus.OK);

	}

	@GetMapping("/end-of-first-inning")
	public ResponseEntity<ScoreCardData> endOfFirstInnings() {
		inningSERV.endOfFirstInning();
		return new ResponseEntity<ScoreCardData>(scoreCardData, HttpStatus.OK);
	}

	@GetMapping("/toss")
	public ResponseEntity<ScoreCardData> toss() {
		inningSERV.toss();
		return new ResponseEntity<ScoreCardData>(scoreCardData, HttpStatus.OK);
	}

	@GetMapping("/new-match")
	public ResponseEntity<ScoreCardData> newMatch() {
		eachBallStatTeamOneREPO.truncateEachBallStatTeamone();
		eachBallStatTeamTwoREPO.truncateEachBallStatTeamtwo();
		finalScoreCardTeamOneREPO.truncateFinalCardTeamone();
		finalScoreCardTeamTwoREPO.truncateFinalCardTeamtwo();
		inningSERV.startNewMatch();

		return new ResponseEntity<ScoreCardData>(scoreCardData, HttpStatus.OK);
	}

	@GetMapping("/previous-ball")
	public ResponseEntity<?> previousBallStatus() {
		if (scoreCardData.getInningType() == 1) {
			return new ResponseEntity<>(eachBallStatTeamOneREPO.previousBallStat(scoreCardData.getEachHitCount() - 1),
					HttpStatus.OK);
		} else if (scoreCardData.getInningType() == 2) {
			return new ResponseEntity<>(eachBallStatTeamTwoREPO.previousBallStat(scoreCardData.getEachHitCount() - 1),
					HttpStatus.OK);
		}
		return null;
	}

	@GetMapping("/getAll-eachball-stat-teamone")
	public ResponseEntity<?> eachballStatTeamoneEntity() {
		return new ResponseEntity<>(inningSERV.eachBallStatTeamOneEntity(), HttpStatus.OK);
	}
	
	
	@GetMapping("/getAll-eachball-stat-teamtwo")
	public ResponseEntity<?> eachballStatTeamtwoEntity() {
		return new ResponseEntity<>(inningSERV.eachBallStatTeamTwoEntity(), HttpStatus.OK);
	}
	
	@GetMapping("/getAll-finalscorecard-teamone")
	public ResponseEntity<?> finalScorecardTeamoneEntity() {
		return new ResponseEntity<>(inningSERV.finalScoreCardTeamOneEnity(), HttpStatus.OK);
	}
	
	@GetMapping("/getAll-finalscorecard-teamtwo")
	public ResponseEntity<?> finalScorecardTeamtwoEntity() {
		return new ResponseEntity<>(inningSERV.finalScoreCardTeamTwoEnity(), HttpStatus.OK);
	}

}

//checking demo





//hadgjhAGDJHgda
