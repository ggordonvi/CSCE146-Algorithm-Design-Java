import java.util.Arrays;
import java.util.Scanner;

public class HangmanDriver {
	
	private static void draw (int a)
	{
		//Row 1
		System.out.println("__________");
		//Row 2
		System.out.println("|   |");
		//Row 3 - head
		System.out.print("| ");	
		if(a >= 1)
		{
			System.out.print("  O");
		}
		System.out.println();
		//Row 4 - body & arms
		System.out.print("| ");
		if(a >= 4)
		{
			System.out.print(" \\|/");
		}
		else if(a >= 3)
		{
			System.out.print(" \\|");
		}
		else if(a == 2)
		{
			System.out.print("  |");
		}
		System.out.println();
		//Row 5 - body
		System.out.print("| ");
		if(a >= 2)
		{
			System.out.print("  |");
		}
		System.out.println();
		//Row 6 - legs
		System.out.print("| ");
		if(a == 5)
		{
			System.out.print(" /");
		}
		else if (a == 6)
		{
			System.out.print(" / \\");
		}
		System.out.println();
	}
	
	public static void main (String[] args)
	{
		Hangman game = new Hangman();
		//should it be surrounded in a try / catch block
		//if the class will call it in the method and 
		//still throw an exception?
		try
		{
			game.loadDictionary("dictionary.txt");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		//Set up input
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		//while loop needed to continue the game, call reset
		while (true)
		{
			game.resetGame();
			while(!game.isFound() && game.getNumIncorrectGuesses() < 6)
			{
				System.out.println("You have made " + game.getNumGuesses() + " guesses.");
				System.out.println(game.getDisguisedWord());
				draw(game.getNumIncorrectGuesses());
				System.out.println("Enter a letter...");
				char guess = input.next().charAt(0);
				game.makeGuess(guess);				
			}
			draw(game.getNumIncorrectGuesses());
			
			if (game.isFound())
			{
				System.out.println("Congraulations, you found the word!");
			}
			else
			{
				System.out.println("GAME OVER! You lose.");
				System.out.println("The word was " + game.getSecretWord());
			}
			System.out.println("Would you like to play again? (Yes/No)");
			String again = input.next();
			if (!again.equalsIgnoreCase("yes"))
			{
				break;
			}
		}
		
	}
}
