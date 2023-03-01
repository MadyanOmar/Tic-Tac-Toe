package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Rules 
{
	public static void display()
	{
		Stage stage = new Stage();
		Pane pane = new Pane();
		Scene scene = new Scene(pane,490,290);
		Image background = new Image("/background.jpg");
		Image icon = new Image("/fileicon.png");
		ImageView bgiv = new ImageView(background);
		Image back = new Image("/back.png");
		ImageView backiv = new ImageView(back);
		Text t1 = new Text("Rules:");
		Text t2 = new Text("1. To win you must form a line or diagonal");
		Text t3 = new Text("2. This is a 2-player game");
		Text t4 = new Text("3. X goes first");
		Text t5 = new Text("4. We support X and not O");
		t5.setFill(Color.WHITE);
		t5.setFont(Font.font("Actor", FontWeight.BOLD, 24));
		t5.setX(10);
		t5.setY(250);
		t4.setFill(Color.WHITE);
		t4.setFont(Font.font("Actor", FontWeight.BOLD, 24));
		t4.setX(10);
		t4.setY(190);
		t3.setFill(Color.WHITE);
		t3.setFont(Font.font("Actor", FontWeight.BOLD, 24));
		t3.setX(10);
		t3.setY(130);
		t2.setFill(Color.WHITE);
		t2.setFont(Font.font("Actor", FontWeight.BOLD, 24));
		t2.setX(10);
		t2.setY(70);
		t1.setFill(Color.WHITE);
		t1.setFont(Font.font("Actor", FontWeight.EXTRA_BOLD, 28));
		t1.setX(210);
		t1.setY(30);
		backiv.setX(10);
		backiv.setY(250);
		
		backiv.setOnMouseClicked(e->{
			stage.close();
			Intro.display();
		});
		
		pane.getChildren().add(bgiv);
		pane.getChildren().add(backiv);
		pane.getChildren().add(t1);
		pane.getChildren().add(t2);
		pane.getChildren().add(t3);
		pane.getChildren().add(t4);
		pane.getChildren().add(t5);
		stage.getIcons().add(icon);
		stage.setResizable(false);
		stage.setTitle("Tic tac toe");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
}
