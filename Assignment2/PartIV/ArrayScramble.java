
public class ArrayScramble {

	public static void main(String[] args) {
		int[] intArray = new int[50];

		System.out.println("original array:");
		/* initialize the source Array */
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = (int)(Math.random()*100);
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
		
		// scramble here

		System.out.println("new arrangement:");
		for (int i = 0; i < intArray.length; i++) {
			int index = (int)(Math.random() * 50);
			if (index != i) intArray[i] = intArray[index];
			System.out.print(intArray[i] + " ");
		}

		System.out.println();
	}
}
