package cricket.game.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Service

@Entity
@Table(name="final_tournament_result")
public class FinalTournamentResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String teamone;
	
	private String teamtwo;
	
	private int teamoneWinCount;
	
	private int teamtwoWinCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamone() {
		return teamone;
	}

	public void setTeamone(String teamone) {
		this.teamone = teamone;
	}

	public String getTeamtwo() {
		return teamtwo;
	}

	public void setTeamtwo(String teamtwo) {
		this.teamtwo = teamtwo;
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
	
	
	
	

}
