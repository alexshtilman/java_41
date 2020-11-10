package telran.game.controller;

import java.util.ArrayList;
import java.util.List;

import client.telran.view.*;
import telran.game.service.GameService;

public class GameClientAppl {

	public static void main(String[] args) {
		InputOutput io = new ConsoleInputOutput();
		Menu menu = new Menu("Menu", Item.of("Start a new race", GameClientAppl::startRace), Item.exit());
		menu.perform(io);
	}

	public static void startRace(InputOutput io) {
		int[] winner = { -1 };
		List<GameService> rides = new ArrayList<>();
			
		int numOfThreads = io.readInteger("number of threads",3,10);
		int distance = io.readInteger("number of threads",100,3500);
		
		for(int i=0;i<numOfThreads;i++) {
			rides.add(new GameService(i, distance, winner));
		}
		
		for (GameService ride : rides) {
			ride.start();
		}
		for (GameService ride : rides) {
			try {
				ride.join();
			} catch (InterruptedException e) {
				// we don't care about interruption...
			}
		}
		System.out.printf("Congratulations to thread %d (winner)\n", winner[0]);
	}
}
