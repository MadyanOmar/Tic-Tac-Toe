package tictactoe;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Start extends Application {

	public void start(Stage stage) throws IOException
	{		
		Intro.display();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
