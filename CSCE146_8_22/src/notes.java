import java.util.*;
public class notes {
	public static final int BOARD_SIZE=10;
	enum Spaces{Empty, Player, Goal, Walked_Path};
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int numberOfMoves=0;
		int pX=0;
		int pY=0;
		Random r= new Random();
		int gX=r.nextInt(BOARD_SIZE); //picks from 0 to final int-1 so 0-9
		int gY=r.nextInt(BOARD_SIZE);
		Scanner keyboard=new Scanner(System.in);
		Spaces[][] board=new Spaces[BOARD_SIZE][BOARD_SIZE];
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				board[i][j]=Spaces.Empty;
			}
		}
		board[pX][pY]=Spaces.Player;
		board[gX][gY]=Spaces.Goal;
		System.out.println("Hey you, how goes it?\nLets play the MARCO POLOS!");
		boolean gameOver=false;
		while(gameOver==false)//loops through game
		{
			//draw the board
			for(int i=0; i<board.length;i++)
			{
				for(int j=0; j<board[i].length;j++)
				{
					switch(board[i][j])
					{
					case Empty:
						System.out.print("_");
						break;
					case Player:
						System.out.print("X");
						break;
					case Goal:
						System.out.print("_");
						break;
					case Walked_Path:
						System.out.print("#");
						break;
					default:
						System.out.print("?");
						
					}
				}
				System.out.println();
			}
			int test=keyboard.nextInt();
			for(int i=0;i<board.length;i++)
			{
				for(int j=0;j<board[i].length;j++)
				{
					if(test==1)
					{
						board[pX][pY]=board[pX][pY+1];
						//Spaces.Player=board[pX][pY];
						//update player space and number of moves
					}
				}
			}
		}
	}

}
