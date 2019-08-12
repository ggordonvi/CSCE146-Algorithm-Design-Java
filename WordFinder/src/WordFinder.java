import java.io.FileNotFoundException;

import java.io.FileReader;

import java.util.Scanner;

public class WordFinder

{

     private static String[] dictionary = new String[25144];

     private static int LengthOfDict = 0;

     // this method, takes file name and reads the data from the

     //file to an array.

     public static void readFile(String filename) throws FileNotFoundException

     {

          FileReader file = new FileReader(filename);

          Scanner scan = new Scanner(file);

          while (scan.hasNext())

          {

               dictionary[LengthOfDict++] = scan.next().toLowerCase();

          }

          scan.close();

     }

     // This method checks whether the word is present in the file or not.

     // and returns boolean value.

     public static boolean isWord(String word)

     {

          if (word.length() < 2)

               return false;

          for (int i = 0; i < LengthOfDict; i++)

          {

               if (word.toLowerCase().equals(dictionary[i]))

               {

                     return true;

               }

          }

          return false;

     }

     // this method prints all the words present in the file.

     public static void WordsFound(char board[][], boolean visited[][], int i,

          int j, String str)

     {

          visited[i][j] = true;

          if (str.length() == 5)

          {

               return;

          }

          str = str + board[i][j];

          // If the word is present in dictionary, then print it

          if (isWord(str))

               System.out.println("Found Word: " + str);

          int M = board.length;

          int N = board[0].length;

          // search the word in the 5by 5 matrix.

          for (int row = i - 1; row <= i + 1 && row<M; row++)

          {

               for (int col = j - 1; col <= j + 1 && col<N; col++)

               {

                     if (row >= 0 && col >= 0 && !visited[row][col])

                          // call the method WordsFound.

                          WordsFound(board, visited, row, col, str);

               }

          }

          if (str != null && str.length() > 0) {

               str = str.substring(0, str.length() - 1);

          }

          visited[i][j] = false;

     }

     // Prints all words present in dictionary.

     public static void Search(char board[][])

     {

          int M = board.length;

          int N = board[0].length;

          // Mark all characters as not visited

          boolean visited[][] = new boolean[M][N];

          // Initialize current string

          String str = "";

          // Consider every character and look for all words

          // starting with this character

          for (int i = 0; i<M; i++)

          {

               for (int j = 0; j<N; j++)

               {

                   System.out.println("Starting " + i + " " +j);

                     WordsFound(board, visited, i, j, str);

               }

          }

     }

     // Driver program to test above function

     public static void main(String[] args) throws FileNotFoundException

     {

          readFile("dict.txt");

          char board[][] = { { 'R','A','H', 'J', 'M' },

          { 'Y','U','W', 'W', 'K' },

          { 'R','X','N', 'F', 'M' },

          { 'Q','G','E', 'E', 'B' },

          { 'E','O','A', 'P', 'E' } };

          Search(board);

     }

}