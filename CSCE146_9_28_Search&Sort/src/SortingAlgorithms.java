/**
 * Written by Ayla Nickerson aylan@email.sc.edu
 * Sep 28, 2017
 * 9:34:47 PM
 */

/**
 * @author aylanickerson
 *
 */
public class SortingAlgorithms {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void bubbleSort(int[] a) {
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i = 0; i < a.length-1; i++) {
				if(a[i] > a[i+1]) {//Out of order
					//Swapped
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
	}
}
