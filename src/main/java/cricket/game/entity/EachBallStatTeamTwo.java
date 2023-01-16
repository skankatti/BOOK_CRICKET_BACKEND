package cricket.game.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name="each_ball_stat_teamtwo")
public class EachBallStatTeamTwo {
	
	@Id
	private int id;

	private int ballCount;

	private int currentBallRun;

	private int totalScore;

	private String batsmanName;

	private int batsmanRuns;

	private String bowlerName;

	private String commentary;
	
private float overs;
	
	private String runRate;
	

	public float getOvers() {
		return overs;
	}

	public void setOvers(float overs) {
		this.overs = overs;
	}

	public String getRunRate() {
		return runRate;
	}

	public void setRunRate(String runRate) {
		this.runRate = runRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void setBallCount(int ballCount) {
		this.ballCount = ballCount;
	}

	public int getCurrentBallRun() {
		return currentBallRun;
	}

	public void setCurrentBallRun(int currentBallRun) {
		this.currentBallRun = currentBallRun;
	}

	public String getBatsmanName() {
		return batsmanName;
	}

	public void setBatsmanName(String batsmanName) {
		this.batsmanName = batsmanName;
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}
	
	

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
	public int getBatsmanRuns() {
		return batsmanRuns;
	}

	public void setBatsmanRuns(int batsmanRuns) {
		this.batsmanRuns = batsmanRuns;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}


	


}
