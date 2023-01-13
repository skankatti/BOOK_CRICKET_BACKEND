package cricket.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan("cricket.game")
@SpringBootApplication
public class CricketGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketGameApplication.class, args);
	}

}
