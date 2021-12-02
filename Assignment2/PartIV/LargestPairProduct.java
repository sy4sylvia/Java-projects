
public class LargestPairProduct {

	public static void main(String[] args) {

		int[] intArray = {17, 1, 3, 12, 39, 4, 76, 4, 31, 87};
		int product = Integer.MIN_VALUE;
		for (int i = 0; i < intArray.length; i++) {
			for (int k = i + 1; k < intArray.length; k++) {
				if(product < intArray[i] * intArray[k]) product = intArray[i] * intArray[k];
			}
		}
		System.out.println("Maximum product of all pairs in the array: " +
				product);
	}
}
