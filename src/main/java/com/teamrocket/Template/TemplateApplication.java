package com.teamrocket.Template;

import com.teamrocket.Template.utility.TicTacToe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.makeBoard();
		game.start();
	}

}
