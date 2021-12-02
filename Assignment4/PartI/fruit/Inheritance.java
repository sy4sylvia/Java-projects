package fruit;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects

		Fruit f1 = new Fruit();
		System.out.println(f1.toString());

		Apple a1 = new Apple();
		System.out.println(a1.toString());

		Citrus c1 = new Citrus();
		System.out.println(c1.toString());

		System.out.println("Id of " + c1.toString() + " is: " +c1.getId());

		Lemon l1 = new Lemon(4, "hard", false);
		System.out.println(l1.toString());
		Lemon l2 = new Lemon(4, "hard", false);

		System.out.println(l2.equals(l1));

		Orange ooo = new Orange();
		System.out.println(ooo.toString());

	}

}
