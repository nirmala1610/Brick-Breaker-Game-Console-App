package com.kce.main;

import com.kce.service.BrickBreakerService;

public class Main {

	public static void main(String[] args) {
	
		BrickBreakerService breakerService = new BrickBreakerService();
		
		breakerService.initilizeBoard();
		breakerService.startGame();
	}

}
