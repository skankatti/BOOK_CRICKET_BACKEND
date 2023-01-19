package cricket.game.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomRunGenSERV {
	
	int total;
	int x;
	
	public int runGenerator() {
		Random random = new Random();
		//if(ball>-1)
			 //total=Math.abs(ThreadLocalRandom.current().nextInt());
			// x= total%10;
				total= Math.abs (random.nextInt());
			x= total%10;
			if(x>7) {
				x=x-3;
			}
			return x;
	}
	public  String ShowComentry(int run)
	{
		
		String ans ="";
		
		 switch(x) {
		 case 0: ans = ShowComZero();
		 return ans;
		 case 1: return "One run";
		 
		 case 2: 
		 return "Two Runs";
	
		 case 3:  return "Three Runs";

		 case 4: ans = ShowComFour();
			 return ans;

		 case 5: return "Leg by One run";
		
		 case 6: ans =  ShowComSix();
			 return ans ;
		 case 7: ans =  ShowComSeven();
		 return ans ;
		 }

		return ans;
	}
	public String ShowComZero(){
		String[] arr = { "LBW", "Clean bowled", "Catch out" };
		Random random = new Random();

		// randomly selects an index from the arr
		int select = random.nextInt(arr.length);

		// prints out the value at the randomly selected index
		// System.out.println("Random String selected: " + arr[select]);

		return arr[select];
	}
	public String ShowComFour(){
		String [] arr = {"Four Runs", "Great four", "Super four", "Splendid shot for four"};
	    Random random = new Random();
	    int select = random.nextInt(arr.length); 

		return arr[select];
	}
	public String ShowComSeven(){
	    String [] arr = {"Oh it's wide", "Oh it's no ball"};
	    Random random = new Random();
    int select = random.nextInt(arr.length); 
    return arr[select];
	}
	
	public String ShowComSix(){
		String [] arr = {"Six Runs", "What a Splendid Six", "Super Six", " What a long six!"};
	    Random random = new Random();
	    int select = random.nextInt(arr.length); 

		return arr[select];
	}
	
	public String ShowComFive(){
	    String [] arr = {"Leg by One run"};
	    Random random = new Random();
	    	int select = random.nextInt(arr.length); 

	    return arr[select];
	}
	
		public boolean IsLegal1(int run) {			
			
			if(x==7){
				return false;
			}
			else return true;			

		
		}

}
