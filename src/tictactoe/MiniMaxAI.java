package tictactoe;


import javafx.scene.image.ImageView;

public class MiniMaxAI extends Player{
	
	int nextMoveX;
	int nextMoveY;

	
	public enum Board{
		X, O, NONE;
	}
	
	public MiniMaxAI() {
		super();
		this.nextMoveX = 0;
		this.nextMoveY = 0;
	}
	
	public ImageView putO()
	{
		SetBestMove();
		return super.putO(nextMoveX*width, nextMoveY*height);
	}
	
	private void SetBestMove() {
		//Get best position
		int best_score = Integer.MAX_VALUE;
		Position bestposition = null;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(state[i][j] == Board.NONE) {
					state[i][j] = Board.O;
					int current_score = MiniMax(state, 0, Board.X);
					state[i][j] = Board.NONE;
					if(current_score < best_score) {
						best_score = current_score;
						bestposition = new Position(i, j);
					}
				}
			}
		}
		
		//Set the next move to be played
		nextMoveX = bestposition.x;
		nextMoveY = bestposition.y;
	}
	
	private int MiniMax(Board[][] state, int depth, Board p) {		
		Integer score = gameOver(state);
		if(score != null) {
			return score;
		}
		
		//X player is the maximizing player
		if(p == Board.X) {
			int best_score = Integer.MIN_VALUE;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(state[i][j] == Board.NONE) {
						state[i][j] = Board.X;
						int current_score = MiniMax(state, depth+1, Board.O);
						state[i][j] = Board.NONE;
						best_score = Math.max(current_score, best_score);
					}
				}
			}
			return best_score;
		}
		//O Player is the minimizing player
		else {
			int best_score = Integer.MAX_VALUE;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(state[i][j] == Board.NONE) {
						state[i][j] = Board.O;
						int current_score = MiniMax(state, depth+1, Board.X);
						state[i][j] = Board.NONE;
						best_score = Math.min(current_score, best_score);
					}
				}
			}
			return best_score;
		}
	}
	
	private Integer gameOver(Board[][] state) {
		if(Win(Board.X)) {
			return 1;
		}
		else if(Win(Board.O)) {
			return -1;
		}
		else if(checkDraw(state)) {
			return 0;
		}
		return null;
	}
}

class Position{
	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
