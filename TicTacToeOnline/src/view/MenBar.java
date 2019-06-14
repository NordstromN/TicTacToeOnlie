package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import model.TicTacToeModelInterface;

public class MenBar extends MenuBar {
	
	private TicTacToeModelInterface model;
	protected Menu game, settings;
	protected MenuItem newGame, endGame, changeCol;
	
	//create the constructor for the menuBar and the below items 
	
	public MenBar() {
		
	game = new Menu("Game");
	
	//Adding the Sub-Items to the Menu 
	newGame = new MenuItem("New Game");
	endGame = new MenuItem("End Application");
	//closebox method
	endGame.setOnAction((ActionEvent e) -> closeBox());
	//new game method
	newGame.setOnAction((ActionEvent e) -> model.setBoard());
	//add the items
	game.getItems().addAll(newGame, endGame);
	
	//add the second Menu and sub-item
	settings = new Menu("Settings");
	changeCol = new MenuItem("Change Colour");
	settings.getItems().add(changeCol);
	this.getMenus().addAll(game, settings);
	}


	//Closing method including a display
	public void closeBox() {
		Platform.exit();
	}
	
}
