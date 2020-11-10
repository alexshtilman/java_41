package telran.game.service;

import java.util.Random;

public class GameService extends Thread {
	int number;
	int nRuns;
	int [] winner;
	public GameService(int number, int nRuns, int [] winner) {
		super();
		this.number = number;
		this.nRuns = nRuns;
		this.winner = winner;
	}
	@Override
	public void run() {
		for(int i = 0; i< nRuns; i++) {
			System.out.println(number);
			try {
				sleep(getRandomInt(2,5));
			} catch (InterruptedException e) {
				//we don't care about interruption...
			}
		}
		//TODO this is not thread safe! but the task was to make this mistake 
		if (winner[0]==-1) {
			winner[0] = number;
		}
	}
	public int getRandomInt(int min, int max) {
		return  new Random().nextInt(max - min) + min;
	}
}
