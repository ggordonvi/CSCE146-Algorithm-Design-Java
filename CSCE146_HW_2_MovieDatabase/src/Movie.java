
public class Movie {
	
	private String name;
	private int year;
	private int rating;
	private String director;
	private double boxOfficeGross;
	
	public Movie ()
	{
		name = "nameless";
		year = 0;
		rating = 0;
		director = "directorless";
		boxOfficeGross = 0.0;
	}
	
	public Movie (String aName, int aYear, int aRating, 
						String aDirector, double aBoxOfficeGross)
	{
		name = aName;
		year = aYear;
		rating = aRating;
		director = aDirector;
		boxOfficeGross = aBoxOfficeGross;
	}
	
	//Getters
	public String getName ()
	{
		return name;
	}
	public int getYear ()
	{
		return year;
	}
	public int getRating ()
	{
		return rating;
	}
	public String getDirector ()
	{
		return director;
	}
	public double getBoxOfficeGross ()
	{
		return boxOfficeGross;
	}
	
	
	public String toString ()
	{
		return "Movie Name = " + name + ", Year = " + year +
				", Rating = " + rating + ", Director = " + director +
				", Box Office Gross = " + boxOfficeGross;
	}

}
