package cricket.game.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class TeamListSERV {
	// Code for Adding Team 1 Players
	public void addPlayersTeam1(String playerName) {
		ArrayList<String> team1 = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			System.out.print("Enter Name ");
			team1.add(playerName);
		}

	}

	// Default List of Team 1 Players
	public ArrayList<String> teamOneList() {
		ArrayList<String> team1Default = new ArrayList<>();
		team1Default.add("Arjun S");
		team1Default.add("Akshay K");
		team1Default.add("Deepak L");
		team1Default.add("Shashank K");
		team1Default.add("Pooja P");
		team1Default.add("Shreya K");
		team1Default.add("Balasaheb R");
		team1Default.add("Mrunali D");
		team1Default.add("Yogesh P");
		team1Default.add("Rushikesh S");
		return team1Default;
	}

	int index = 0;

	public String team1Default(int index) {
		String names = teamOneList().get(index);
		return names;

	}

	// Code for Adding Team 1 Players
	public void addPlayersTeam2(String playerName) {
		ArrayList<String> team2 = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			System.out.print("Enter Name ");
			team2.add(playerName);
		}
	}

//		 Default List of Team 2 Players
	public ArrayList<String> teamTwoList() {
		ArrayList<String> team2Default = new ArrayList<>();
		team2Default.add("Kaustubh M");
		team2Default.add("Neha B");
		team2Default.add("Pooja M");
		team2Default.add("Rahul T");
		team2Default.add("Manisha A ");
		team2Default.add("Piyush C");
		team2Default.add("Nikita B");
		team2Default.add("Abdul M");
		team2Default.add("Kshitija K");
		team2Default.add("Sayed R");
		return team2Default;
	}

	public String team2Default(int index) {
		String names = teamTwoList().get(index);
		return names;

	}
}
