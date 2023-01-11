package cricket.game.data;

import org.springframework.stereotype.Service;

@Service
public class ScoreCardData {

	int ballCount, randomRun, totalScore, wicketCount,totalWicket, batsManId, batsManRun, bowlerId, eachHitCount, target,
			inningType, remainingScore,totalmatchPlayed,teamoneWinCount,teamtwoWinCount,series,batsmanBallCount,ballCountForOver;
	float oversCompleted,totalOvers, remainingBall,remainingOvers;

	String commentary, playerName,bowlerName, playingTeamName, teamOneName,teamTwoName, result, tossResult, 
	reqRunRate, currentRunRate, batsmanRunRate,wicketType, tournamentResult;
	boolean isLegal;
	public int getBallCount() {
		return ballCount;
	}
	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}
	public int getRandomRun() {
		return randomRun;
	}
	public void setRandomRun(int randomRun) {
		this.randomRun = randomRun;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getWicketCount() {
		return wicketCount;
	}
	public void setWicketCount(int wicketCount) {
		this.wicketCount = wicketCount;
	}
	public int getBatsManId() {
		return batsManId;
	}
	public void setBatsManId(int batsManId) {
		this.batsManId = batsManId;
	}
	public int getBatsManRun() {
		return batsManRun;
	}
	public void setBatsManRun(int batsManRun) {
		this.batsManRun = batsManRun;
	}
	public int getBowlerId() {
		return bowlerId;
	}
	public void setBowlerId(int ballerId) {
		this.bowlerId = ballerId;
	}
	public int getEachHitCount() {
		return eachHitCount;
	}
	public void setEachHitCount(int eachBallCount) {
		this.eachHitCount = eachBallCount;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getInningType() {
		return inningType;
	}
	public void setInningType(int inningType) {
		this.inningType = inningType;
	}
	public float getRemainingBall() {
		return remainingBall;
	}
	public void setRemainingBall(float remainingBall) {
		this.remainingBall = remainingBall;
	}
	public int getRemainingScore() {
		return remainingScore;
	}
	public void setRemainingScore(int remainingScore) {
		this.remainingScore = remainingScore;
	}
	public int getTotalmatchPlayed() {
		return totalmatchPlayed;
	}
	public void setTotalmatchPlayed(int totalmatchPlayed) {
		this.totalmatchPlayed = totalmatchPlayed;
	}
	public int getTeamoneWinCount() {
		return teamoneWinCount;
	}
	public void setTeamoneWinCount(int teamoneWinCount) {
		this.teamoneWinCount = teamoneWinCount;
	}
	public int getTeamtwoWinCount() {
		return teamtwoWinCount;
	}
	public void setTeamtwoWinCount(int teamtwoWinCount) {
		this.teamtwoWinCount = teamtwoWinCount;
	}
	
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String comcommentary) {
		this.commentary = comcommentary;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayingTeamName() {
		return playingTeamName;
	}
	public void setplayingTeamName(String teamName) {
		this.playingTeamName = teamName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTossResult() {
		return tossResult;
	}
	public void setTossResult(String tossResult) {
		this.tossResult = tossResult;
	}
	public String getReqRunRate() {
		return reqRunRate;
	}
	public void setReqRunRate(String reqRunRate) {
		this.reqRunRate = reqRunRate;
	}
	public String getCurrentRunRate() {
		return currentRunRate;
	}
	public void setCurrentRunRate(String currentRunRate) {
		this.currentRunRate = currentRunRate;
	}
	public String getBatsmanRunRate() {
		return batsmanRunRate;
	}
	public void setBatsmanRunRate(String batsmanRunRate) {
		this.batsmanRunRate = batsmanRunRate;
	}
	public String getWicketType() {
		return wicketType;
	}
	public void setWicketType(String wicketType) {
		this.wicketType = wicketType;
	}
	public boolean isLegal() {
		return isLegal;
	}
	public void setLegal(boolean isLegal) {
		this.isLegal = isLegal;
	}
	public float getTotalOvers() {
		return totalOvers;
	}
	public void setTotalOvers(float totalOvers) {
		this.totalOvers = totalOvers;
	}
	public int getTotalWicket() {
		return totalWicket;
	}
	public void setTotalWicket(int totalWicket) {
		this.totalWicket = totalWicket;
	}
	public float getOversCompleted() {
		return oversCompleted;
	}
	public String getTeamOneName() {
		return teamOneName;
	}
	public void setTeamOneName(String teamOneName) {
		this.teamOneName = teamOneName;
	}
	public String getTeamTwoName() {
		return teamTwoName;
	}
	public void setTeamTwoName(String teamTwoName) {
		this.teamTwoName = teamTwoName;
	}
	public void setOversCompleted(float oversCompleted) {
		this.oversCompleted = oversCompleted;
	}
	public float getRemainingOvers() {
		return remainingOvers;
	}
	public void setRemainingOvers(float remainingOvers) {
		this.remainingOvers = remainingOvers;
	}
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public int getBatsmanBallCount() {
		return batsmanBallCount;
	}
	public void setBatsmanBallCount(int batsmanBallCount) {
		this.batsmanBallCount = batsmanBallCount;
	}
	public int getBallCountForOver() {
		return ballCountForOver;
	}
	public void setBallCountForOver(int ballCountForOver) {
		this.ballCountForOver = ballCountForOver;
	}
	public String getBowlerName() {
		return bowlerName;
	}
	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	public String getTournamentResult() {
		return tournamentResult;
	}
	public void setTournamentResult(String tournamentResult) {
		this.tournamentResult = tournamentResult;
	}

	
	

	
}
