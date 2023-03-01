package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Intro 
{
	public static void display()
	{
		Stage stage = new Stage();
		Pane pane = new Pane();
		Scene scene = new Scene(pane,490,290);
		Image background = new Image("/GUI.png");
		Image icon = new Image("/fileicon.png");
		ImageView bgiv = new ImageView(background);
		Button exit = new Button("Exit");
		Button single = new Button("Single-Player");
		Button multi = new Button("Multi-Player");
		Button rules = new Button("Rules");
		exit.setLayoutX(210);
		single.setLayoutX(210);
		single.setLayoutY(120);
		multi.setLayoutX(210);
		multi.setLayoutY(160);
		exit.setLayoutY(240);
		single.setMinWidth(80);
		exit.setMinWidth(80);
		rules.setMinWidth(80);
		rules.setLayoutX(210);
		rules.setLayoutY(200);
		
		exit.setOnMouseClicked(e->{
			stage.close();
		});
		
		single.setOnMouseClicked(e->{
			stage.close();
			Game.display(false);
		});
		
		multi.setOnMouseClicked(e->{
			stage.close();
			Game.display(true);
		});
		
		rules.setOnMouseClicked(e->{
			stage.close();
			Rules.display();
		});
		
		pane.getChildren().add(bgiv);
		pane.getChildren().add(single);
		pane.getChildren().add(multi);
		pane.getChildren().add(exit);
		pane.getChildren().add(rules);
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
