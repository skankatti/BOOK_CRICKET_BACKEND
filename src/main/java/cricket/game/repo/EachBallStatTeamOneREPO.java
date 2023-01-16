package cricket.game.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import cricket.game.entity.EachBallStatTeamOne;

@Service
public interface EachBallStatTeamOneREPO extends JpaRepository<EachBallStatTeamOne, Integer> {

	@Transactional
	@Modifying
	@Query(value = "INSERT into each_ball_stat_teamone  (id, ball_count,batsman_name,total_score, current_ball_run,"
			+ "commentary,batsman_runs,overs,run_rate) VALUES (:eachHitCount,:ballCount,:playerName,:totalScore,:currentBallRun,"
			+ ":commentary,:batsmanRun,:overs,:runRate)", nativeQuery = true)

	void addDetails(int eachHitCount, int ballCount, String playerName, int totalScore, int currentBallRun,
			String commentary, int batsmanRun,float overs, String runRate);
	@Transactional
	@Modifying
	@Query(value = "truncate table each_ball_stat_teamone", nativeQuery = true)
	void truncateEachBallStatTeamone();

	@Query(value = "SELECT * from each_ball_stat_teamone where id=:previousBall", nativeQuery = true)
	public EachBallStatTeamOne previousBallStat(int previousBall);
}
