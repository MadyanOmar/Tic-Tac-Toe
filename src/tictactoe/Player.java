package tictactoe;

import java.util.Date;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import tictactoe.MiniMaxAI.Board;

public class Player
{
	public static Board[][] state;
	int width;
	int height;
	static int ctr;
	
	public Player()
	{
		ctr=0;
		width = 100;
		height= 100;
	}
	
	public static void InitializeBoard(int board_size) {
		state = new Board[board_size][board_size];
		for(int i=0; i<state.length; i++) {
			for(int j=0; j<state.length; j++) {
				state[i][j] = Board.NONE;
			}
		}
	}
	
	public ImageView putO(double x, double y)
	{
		int dx = (int) (x/width);
		int dy = (int) (y/height);
		if(state[dx][dy] == Board.NONE)
		{
			Image oimg = new Image("/O.png");
			ImageView oimgv = new ImageView(oimg);
			oimgv.setLayoutX(dx * width + 25);
			oimgv.setLayoutY(dy * height + 25);
			state[dx][dy] = Board.O;
			return oimgv;	
		}
		return null;
	}
	
	public ImageView putX(double x, double y)
	{
		int dx = (int) (x/width);
		int dy = (int) (y/height);
		if(state[dx][dy] == Board.NONE)
		{
			Image ximg = new Image("/X.png");
			ImageView ximgv = new ImageView(ximg);
			ximgv.setLayoutX(dx * width + 25);
			ximgv.setLayoutY(dy * width + 25);
			state[dx][dy] = Board.X;
			return ximgv;	
		}
		return null;
	}
	
	public boolean CheckWin(Stage openstage, Board player, boolean gameMode)
	{
		boolean result;
		result = Win(player);
		if(result==true)
		{
			Game.endDate = new Date();
			Result.displayResult(openstage,player, gameMode);
		}
		return result;
	}
	
	public boolean CheckDraw(Stage openstage, boolean gameMode)
	{
		boolean result;
		result = checkDraw(state);
		if(result==true)
		{
			Game.endDate = new Date();
			Result.displayResult(openstage,Board.NONE, gameMode);
		}
		return result;
	}
	
	protected boolean Win(Board player) {
		//Check column win
		for(int i=0; i<3; i++) {
			boolean col_win = true;
			for(int j=0; j<3; j++) {
				col_win = col_win && state[i][j] == player;
			}
			if(col_win) {
				return true;
			}
		}
		
		//Check row win
		for(int i=0; i<3; i++) {
			boolean col_win = true;
			for(int j=0; j<3; j++) {
				col_win = col_win && state[j][i] == player;
			}
			if(col_win) {
				return true;
			}
		}
		
		//Check Diagonal Win
		boolean diagonal1_win = true;
		boolean diagonal2_win = true;
		for(int i=0; i<3; i++) {
			diagonal1_win = diagonal1_win && state[i][i] == player;
			diagonal2_win = diagonal2_win && state[i][2-i] == player;
		}
		
		if(diagonal1_win || diagonal2_win) {
			return true;
		}
		
		//Otherwise return false;
		return false;
	}
	
	protected boolean checkDraw(Board[][] state) {
		return !Win(Board.X) && !Win(Board.O) && isFilled(state);
	}
	
	protected boolean isFilled(Board[][] state) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(state[i][j] == Board.NONE) {
					return false;
				}
			}
		}
		return true;
	}
}


