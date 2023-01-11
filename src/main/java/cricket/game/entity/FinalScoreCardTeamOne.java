package cricket.game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Service
@Entity
@Table(name="final_scorecard_teamone")
public class FinalScoreCardTeamOne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String playerName;
	
	private int playerRuns;

	private int ballPlayed;
	
	private String bowlerName;
	
	private String runRate;
	
	private String commentary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getBallPlayed() {
		return ballPlayed;
	}

	public void setBallPlayed(int ballPlayed) {
		this.ballPlayed = ballPlayed;
	}

	public String getRunRate() {
		return runRate;
	}

	public void setRunRate(String runRate) {
		this.runRate = runRate;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String wicketType) {
		this.commentary = wicketType;
	}

	public String getBowlerName() {
		return bowlerName;
	}

	public void setBowlerName(String bowlerName) {
		this.bowlerName = bowlerName;
	}

	public int getPlayerRuns() {
		return playerRuns;
	}

	public void setPlayerRuns(int playerRuns) {
		this.playerRuns = playerRuns;
	}
}
