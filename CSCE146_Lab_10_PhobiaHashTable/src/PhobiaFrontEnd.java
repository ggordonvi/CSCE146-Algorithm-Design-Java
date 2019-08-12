import java.util.*;

public class PhobiaFrontEnd {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		PhobiaHashTable test = new PhobiaHashTable();
		System.out.println("Welcome to the fear hash table!");
		
		boolean run = true;
		while(run)
		{
			System.out.println("\nEnter:");
			System.out.println("  1. To add a fear");
			System.out.println("  2. To remove a fear");
			System.out.println("  3. To look up a fear");
			System.out.println("  4. Print all fears");
			System.out.println("  5. Quit");
			
			Integer x = Integer.parseInt(scan.nextLine());
			
			switch(x)
			{
				case 1:
				{
					System.out.println("What is the fear's name?");
					String phobia = scan.nextLine();
					System.out.println("Describe the fear");
					String description = scan.nextLine();
					test.add(phobia, description);
					break;
				}
				case 2:
				{
					System.out.println("What is the fear's name?");
					String phobia = scan.nextLine();
					System.out.println("Describe the fear");
					String description = scan.nextLine();
					test.remove(phobia, description);
					break;
				}
				case 3:
				{
					System.out.println("What is the fear's name?");
					String phobia = scan.nextLine();
					System.out.println(test.lookUp(phobia));
					break;
				}
				case 4:
				{
					test.printHashTable();
					break;
				}
				case 5:
				{
					run = false;
					break;
				}
				default:
					System.out.println("Enter a number 1-5");
					break;
			}
		}
	}
}
