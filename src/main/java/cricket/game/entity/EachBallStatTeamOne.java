package cricket.game.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;


@Service
@Entity
@Table(name = "each_ball_stat_teamone")
public class EachBallStatTeamOne {

	@Id
	private int id;

	private int ballCount;

	private int currentBallRun;

	private int totalScore;

	private String batsmanName;

	private int batsmanRuns;

	private String bowlerName;

	private String commentary;

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
//class ends here