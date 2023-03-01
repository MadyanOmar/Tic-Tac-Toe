package tictactoe;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe.MiniMaxAI.Board;

public class Result {
	
	public static void displayResult(Stage openstage,Board result, boolean gameMode)
	{
		String imgpath = "/draw.png";
		int x_pos = 85;
		int y_pos = 60;
		if(result==Board.X){
			imgpath = "/win.png";
			x_pos = 65;
			y_pos = 60;
			
		}
		else if(result==Board.O) {
			imgpath = "/lose.png";
			x_pos = 55;
			y_pos = 60;
		}
		
		openstage.close();
		Stage stage = new Stage();
		Pane pane = new Pane();
		Scene scene = new Scene(pane,305,300);
		Image result = new Image(imgpath);
		Image background = new Image("/background.jpg");
		ImageView backgroundV = new ImageView(background);
		ImageView resultv = new ImageView(result);
		resultv.setLayoutX(x_pos);
		resultv.setLayoutY(y_pos);
		Image icon = new Image("/fileicon.png");
		Button exit = new Button("Exit");
		Button stats = new Button("View Stats");
		Button start = new Button("Play Again");
		FadeTransition ft = new FadeTransition(Duration.millis(1000), resultv);
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.setCycleCount(1);
		ft.setAutoReverse(true);
		ft.play(); 
		exit.setLayoutX(110);
		exit.setLayoutY(260);	
		exit.setMinWidth(90);
		stats.setLayoutX(110);
		stats.setLayoutY(210);	
		stats.setMinWidth(90);			
		start.setLayoutX(110);
		start.setLayoutY(160);
		start.setMinWidth(90);
		
		exit.setOnMouseClicked(e->{
			stage.close();
		});
		
		start.setOnMouseClicked(e->{
			stage.close();
			Stats.numberofGames++;
			Game.display(gameMode);
		});
		
		stats.setOnMouseClicked(e->{
			stage.close();
			Stats.displayStats(stage);
		});
		
		pane.getChildren().add(backgroundV);
		pane.getChildren().add(resultv);
		pane.getChildren().add(stats);
		pane.getChildren().add(start);
		pane.getChildren().add(exit);
		stage.getIcons().add(icon);
		stage.setTitle("Tic tac toe");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
