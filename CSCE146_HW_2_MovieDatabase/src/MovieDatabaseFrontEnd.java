import java.util.Scanner;

public class MovieDatabaseFrontEnd {
	
	public static void main (String[] args)
	{
		MovieDatabase movies = new MovieDatabase();
		Scanner input = new Scanner(System.in);
		
		boolean keepGoing = true;
		while (keepGoing == true)
		{
			System.out.println("Enter 1: Add a Movie\n"
					+ "Enter 2: Remove a Movie by its Title\n"
					+ "Enter 3: Search for a Title\n"
					+ "Enter 4: Search for movies by Director\n"
					+ "Enter 5: Search for movies of a given Year\n"
					+ "Enter 6: Search for movies of a certain Rating\n"
					+ "Enter 7: Print out all movies\n"
					+ "Enter 8: Print to a database file\n"
					+ "Enter 9: Load a database file\n"
					+ "Enter 0: Quit");
			int choice = input.nextInt();
			switch (choice)
			{
			//Add a movie
			case 1:
				input.nextLine();
				System.out.println("Enter the Name:");
				String name = input.nextLine();
				System.out.println("Enter the Year:");
				int year = input.nextInt();
				System.out.println("Enter the Rating:");
				int rating = input.nextInt();
				input.nextLine();
				System.out.println("Enter the Director:");
				String director = input.nextLine();
				System.out.println("Enter the Box Office Gross:");
				double boxOfficeGross = input.nextDouble();
				//Add new movie based on user input
				movies.addMovie(new Movie(name,year,rating,director,boxOfficeGross));
				break;
			//Remove a movie by its title
			case 2:
				input.nextLine();
				System.out.println("Enter title of the movie you would like to remove:");
				String title = input.nextLine();
				movies.removeTitle(title);
				break;
			//Search for a title
			case 3:
				input.nextLine();
				System.out.println("Enter the title of the movie your looking for:");
				title = input.nextLine();
				movies.searchForTitle(title);
				break;	
			//Search for movies by director
			case 4:
				input.nextLine();
				System.out.println("Enter the director your looking for:");
				director = input.nextLine();
				movies.searchForDirector(director);
				break;	
			//Search for movies of a given year
			case 5:
				System.out.println("Enter the year of the movie your looking for:");
				year = input.nextInt();
				movies.searchForYear(year);
				break;
			//Search for movies of a certain rating
			case 6:
				System.out.println("Enter the rating of movies your interesed in:");
				rating = input.nextInt();
				movies.searchForRating(rating);
				break;	
			//Print out all movies
			case 7:
				movies.printOutAll();
				break;				
			//Print to a database file	
			case 8:
				input.nextLine();
				System.out.println("Enter the file name to print a database file");
				String fileName = input.nextLine();
				movies.printDatabaseFile(fileName, true);
				break;
			//Load a database file
			case 9:
				input.nextLine();
				System.out.println("Enter the file name to load the database file");
				fileName = input.nextLine();
				movies.loadDatabaseFile(fileName);
				break;
			//Quit	
			case 0:
				keepGoing = false;
				break;
			default:
				System.out.println("Enter 1-9, or 0 to quit.");
			}
		}
		
	}

}
