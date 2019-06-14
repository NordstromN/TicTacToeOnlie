package archive_delete;
	
import controller.TicTacToeController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.TicTacToeModel;
import model.TicTacToeModelInterface;
import view.TicTacToeView;


public class TicTacToeMain extends Application {
	
	TicTacToeModelInterface model;
	TicTacToeView view;
	TicTacToeController controller;
	
	//Final Int für das Spielfeld
	public static final int BOARD = 3;
	
	//Spieler zuordnung
	public final static int PLAYER_X = 0;
	public final static int PLAYER_O = 1;
	
	
	//Create a stage so start method will be available from another class
	public static Stage primarySt = new Stage();
	
	public static void main(String[] args) {
		launch(args);
	}
	
			
	public void start(Stage primaryStage) throws Exception{
	//Now adding resp. creating and initializing the MVC components
	model = new TicTacToeModel();
	view = new TicTacToeView(primaryStage, model);
	controller = new TicTacToeController(model, view);
	
		
		
	}
	
	
}
