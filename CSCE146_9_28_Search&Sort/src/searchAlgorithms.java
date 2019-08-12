/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 28, 2017
 * 9:34:04 PM
 */

/**
 * @author aylanickerson
 *
 */
public class searchAlgorithms {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6,7,8,9};
	}
	public static boolean linSearchIter(int[] a, int value) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == value)
				return true;
		}
		return false;
	}
	public static boolean binSearchRecur(int[] a, int value, int minIndex, int maxIndex) {
		int midIndex = (maxIndex + minIndex)/2;
		if(minIndex > maxIndex) {
			return false;
		}
		if(a[midIndex] == value)
			return true;
		else {
			if(value > a[midIndex]) {
				return binSearchRecur(a,value, midIndex+1, maxIndex);
			}
			else {
				return binSearchRecur(a, value, minIndex, midIndex - 1);
			}
		}
	}
}
