/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 26, 2017
 * 10:14:23 AM
 */

/**
 * @author aylanickerson
 *
 */
public class RecursionClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//Factorials to practice recursion woo hoo
	public static int factorial(int number)
	{
		if(number<0)//error checking
			return 0;
		if(number==0)
			return 1;
		else
			return number*factorial(number-1);
	}
	public static int gcd(int num1, int num2)
	{
		if(num2==0)
			return num1;
		else
			return gcd(num2,num1%num2);//recursive call
	}
	public static int fibbo (int number)
	{
		if(number<0)//error checking
			return 0;
		if(number==1 || number==2)
			return 1;
		else
			return fibbo(number-1)+fibbo(number-2);
	}
}
