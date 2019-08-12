import java.io.*;
import java.util.Scanner;

public class MovieDatabase {
	
	GenLinkedList<Movie> movies;
	private static final String DELIM = "\t";
	
	public MovieDatabase ()
	{
		movies = new GenLinkedList<Movie>();
	}
	
	//Add a movie
	public void addMovie (Movie newMovie)
	{
		movies.insert(newMovie);
	}
	
	//Remove by title
	public void removeTitle (String aTitle)
	{
		movies.resetCurrent();
		while (movies.hasMore())
		{
			//Grab the current movie
			Movie aMovie = movies.getCurrent();
			//If movies name is equal to users input title then delete current
			if(aMovie.getName().equalsIgnoreCase(aTitle))
			{
				System.out.println("Removed " + aTitle + " from the database!");
				movies.deleteCurrent();
				System.out.println();
			}
			//otherwise continue through list
			movies.goToNext();
		}
	}
	
	//Search for by title
	public void searchForTitle (String aTitle) 
	{
		movies.resetCurrent();
		while (movies.hasMore())
		{
			//Grab the current movie
			Movie aMovie = movies.getCurrent();
			//If movies name is equal to users input title then print description
			if(aMovie.getName().equalsIgnoreCase(aTitle))
			{
				System.out.println("Movie found! Heres the info...");
				System.out.println(aMovie.getName() +DELIM+
						aMovie.getYear() +DELIM+
						aMovie.getRating() +DELIM+
						aMovie.getDirector() +DELIM+
						aMovie.getBoxOfficeGross());
			}
			//otherwise continue through list
			movies.goToNext();
		}
	}
	
	//Search for by director
	public void searchForDirector (String aDirector)
	{
		movies.resetCurrent();
		while (movies.hasMore())
		{
			//Grab the current movie
			Movie aMovie = movies.getCurrent();
			//If movies name is equal to users input title then print description
			if(aMovie.getDirector().equalsIgnoreCase(aDirector))
			{
				System.out.println("Director found! Heres the info...");
				System.out.println(aMovie.getName() +DELIM+
						aMovie.getYear() +DELIM+
						aMovie.getRating() +DELIM+
						aMovie.getDirector() +DELIM+
						aMovie.getBoxOfficeGross());
			}
			//otherwise continue through list
			movies.goToNext();
		}
		
	}
	
	//Search for by year
	public void searchForYear (int aYear)
	{
		movies.resetCurrent();
		while (movies.hasMore())
		{
			//Grab the current movie
			Movie aMovie = movies.getCurrent();
			//If movies name is equal to users input title then print description
			if(aMovie.getYear() == aYear)
			{
				System.out.println("Year Found! Heres the info...");
				System.out.println(aMovie.getName() +DELIM+
						aMovie.getYear() +DELIM+
						aMovie.getRating() +DELIM+
						aMovie.getDirector() +DELIM+
						aMovie.getBoxOfficeGross());
			}
			//otherwise continue through list
			movies.goToNext();
		}
		
	}
	
	//Search for by rating
	public void searchForRating (int aRating)
	{
		movies.resetCurrent();
		while (movies.hasMore())
		{
			//Grab the current movie
			Movie aMovie = movies.getCurrent();
			//If movies name is equal to users input title then print description
			if(aMovie.getRating() == aRating)
			{
				System.out.println("Movie Found! Heres the info...");
				System.out.println(aMovie.getName() +DELIM+
						aMovie.getYear() +DELIM+
						aMovie.getRating() +DELIM+
						aMovie.getDirector() +DELIM+
						aMovie.getBoxOfficeGross());
			}
			//otherwise continue through list
			movies.goToNext();
		}
		
	}
	
	//Print out all movies to console
	public void printOutAll ()
	{
		System.out.println();
		movies.resetCurrent();
		while(movies.hasMore())
		{
			Movie aMovie = movies.getCurrent();
			System.out.println(aMovie.getName() +DELIM+
									aMovie.getYear() +DELIM+
									aMovie.getRating() +DELIM+
									aMovie.getDirector() +DELIM+
									aMovie.getBoxOfficeGross());
			movies.goToNext();
		}
		System.out.println();
	}
	
	//Print to a database file
	public void printDatabaseFile (String aFilename, boolean append)
	{
		if (movies == null || aFilename == null)
		{
			System.out.println("Help");
			return;
		}
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aFilename, append));
			movies.resetCurrent();
			while(movies.hasMore())
			{
				Movie aMovie = movies.getCurrent();
				fileWriter.println(aMovie.getName() +DELIM+
									aMovie.getYear() +DELIM+
									aMovie.getRating() +DELIM+
									aMovie.getDirector() +DELIM+
									aMovie.getBoxOfficeGross());
				movies.goToNext();
			}
			fileWriter.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	//Read (load) from a database file
	public void loadDatabaseFile (String aFilename)
	{
		if(aFilename == null)
			return;
		movies = new GenLinkedList<Movie>();
		try
		{
			Scanner fileScanner = new Scanner(new File(aFilename));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				//Split string based on DELIM
				String[] splitStrings = fileLine.split(DELIM);
				//if not 4 attributes, continue goes back to while loop
				if(splitStrings.length != 5)
					continue;
				String name = splitStrings[0];
				int year = Integer.parseInt(splitStrings[1]);
				int rating = Integer.parseInt(splitStrings[2]);
				String director = splitStrings[3];
				double boxOfficeGross = Double.parseDouble(splitStrings[4]);
				Movie aMovie = new Movie(name,year,rating,director,boxOfficeGross);
				movies.insert(aMovie);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
