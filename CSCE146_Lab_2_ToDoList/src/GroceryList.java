
public class GroceryList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ToDoList iList = new ToDoList();
		
		System.out.println("To Do List Tester!");
		
		System.out.println("Adding Five Tasks To Do");
		iList.insert("Buy Ground Beef");
		iList.insert("Buy Cheese");
		iList.insert("Buy Taco Shells");
		iList.insert("Make Tacos");
		iList.insert("Eat Tacos");
		
		System.out.println("");	
		System.out.println("Printing List...");
		iList.printList();
		
		System.out.println("I forgot to get salsa. Let me add that after step 2.");
		iList.goToNext();
		iList.insertAfterCurrent("Buy Salsa");
		
		System.out.println("");		
		System.out.println("Printing List...");
		iList.printList();
		
		System.out.println("On second thought I'm in a spicy mood so let's change salsa to hot sauce.");
		iList.goToNext();
		iList.insertAfterCurrent("Buy Hot Sauce");
		iList.deleteCurrent();
		
		System.out.println("");	
		System.out.println("Printing List...");
		iList.printList();
		
		System.out.println("Do people put guacamole on tacos? I'll add it after step 3.");
		iList.insertAfterCurrent("Buy Guacamole");
		
		System.out.println("");	
		System.out.println("Printing List...");
		iList.printList();
		
		System.out.println("On second thought I don't think they do let me take that out.");
		iList.goToNext();
		iList.deleteCurrent();
		
		System.out.println("");	
		System.out.println("Printing List...");
		iList.printList();
		System.out.println("Now I have tested the perfect taco related list!");		
		
	}

}
