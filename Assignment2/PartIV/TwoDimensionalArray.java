import java.util.Arrays;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		System.arraycopy(arrayOne, 0, twoDimArray[0], 0, 5);
		System.arraycopy(arrayTwo, 0, twoDimArray[1], 0, 5);
		System.out.println("The twoDimArray is:");

		for(int i = 0; i < 2; i++) {
			for(int k = 0; k < 5; k++) System.out.print(twoDimArray[i][k] + " ");
			System.out.println();
		}
		/* copy arrayOne and arrayTwo into twoDimArray */
        /* print out the first list of 5 numbers in twoDimArray
         * on one line, and the second list of 5 numbers in twoDimArray
         * on the next line
         */
        
        /* the solution should use nested loops: one loop to loop over
         * each array in twoDimArray, and one loop to loop over each element
         * in that array
         */
//
//		System.out.println("twoDimArray is " +
//							Arrays.deepToString(twoDimArray));
	}
}
