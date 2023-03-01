package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Stats 
{
	public static int numberofmovesX;
	public static int numberofmovesO;
	private static int timeMatchEnded;
	public static int numberofGames=1;
	
	public static void displayStats(Stage prevStage)
	{
		numberofmovesX = Game.ctrX;
		numberofmovesO = Game.ctrO;
		timeMatchEnded = (int)((Game.endDate.getTime() - Game.startDate.getTime()) / 1000);
		Stage stage = new Stage();
		Pane pane = new Pane();
		Scene scene = new Scene(pane,330,310);
		Image background = new Image("/background.jpg");
		ImageView backgroundV = new ImageView(background);
		Image back = new Image("/back.png");
		ImageView backiv = new ImageView(back);
		Image icon = new Image("/fileicon.png");
		Text t1 = new Text("Game Stats");
		Text t2 = new Text("Number of Moves played: ");
		Text t3 = new Text("Moves played by player X: " + numberofmovesX + " moves");
		Text t4 = new Text("Moves played by player O: " + numberofmovesO + " moves");
		Text t5 = new Text("Number of games played: " + numberofGames);
		Rectangle r1 = new Rectangle(5,5,320,300);
		r1.setStrokeWidth(3);
		r1.setStroke(Color.CRIMSON);
		r1.setFill(Color.TRANSPARENT);
		Game.ctrX = 0;
		Game.ctrO = 0;
		Text t6 = new Text("Time taken to finish game: " + timeMatchEnded + " secs");
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Actor", FontWeight.EXTRA_BOLD, 28));
		t1.setX(90);
		t1.setY(30);
		t2.setFill(Color.WHITE);
		t2.setFont(Font.font("Actor", FontWeight.EXTRA_BOLD, 18));
		t2.setX(10);
		t2.setY(90);
		t3.setFill(Color.WHITE);
		t3.setFont(Font.font("Actor", FontWeight.EXTRA_BOLD, 18));
		t3.setX(10);
		t3.setY(120);
		t4.setFill(Color.WHITE);
		t4.setFont(Font.font("Actor", FontWeight.EXTRA_BOLD, 18));
		t4.setX(10);
		t4.setY(140);
		t5.setFill(Color.WHITE);
		t5.setFont(Font.font("Actor", FontWeight.EXTRA_BOLD, 18));
		t5.setX(10);
		t5.setY(180);
		t6.setFill(Color.WHITE);
		t6.setFont(Font.font("Actor", FontWeight.EXTRA_BOLD, 18));
		t6.setX(10);
		t6.setY(200);
		backiv.setX(10);
		backiv.setY(250);
		
		backiv.setOnMouseClicked(e->{
			stage.close();
			prevStage.show();
		});

		pane.getChildren().add(backgroundV);		
		pane.getChildren().add(t1);
		pane.getChildren().add(t2);
		pane.getChildren().add(t3);
		pane.getChildren().add(t4);
		pane.getChildren().add(t5);
		pane.getChildren().add(t6);
		pane.getChildren().add(r1);
		pane.getChildren().add(backiv);
		stage.getIcons().add(icon);
		stage.setTitle("Tic tac toe");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}
