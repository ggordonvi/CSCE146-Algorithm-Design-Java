
public class IntLinkedListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedLists iList=new LinkedLists();
		for(int i=0;i<10;i++)
			iList.insert(i);
		System.out.println(iList.getCurrent());
		
		for(int i=0;i<5;i++)
		{
			iList.gotoNext();
			System.out.println(iList.getCurrent());
		}
	}

}
