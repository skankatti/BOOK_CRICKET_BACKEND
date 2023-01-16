package cricket.game.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cricket.game.entity.FinalScoreCardTeamOne;
@Service
public interface FinalScoreCardTeamOneREPO extends JpaRepository<FinalScoreCardTeamOne, Integer> {

	@Transactional
	@Modifying
	@Query(value = "INSERT into final_scorecard_teamone  (id,ball_played,player_name,run_rate,"
			+ "bowler_name,player_runs,commentary) VALUES (:id,:ballPlayed,:playerName,:runRate,"
			+ ":bowlerName,:playerRun,:commentary)", nativeQuery = true)

	void addToFinalScoreCardTeamOne(int id,int ballPlayed, String playerName, String runRate, String commentary,
	
			String bowlerName, int playerRun);
	

	@Transactional
	@Modifying
	@Query(value = "truncate table final_scorecard_teamone", nativeQuery = true)
	void truncateFinalCardTeamone();
	
	
	
}
