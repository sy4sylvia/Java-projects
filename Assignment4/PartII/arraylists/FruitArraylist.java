package arraylists;
import java.util.ArrayList;

import fruit.*;

public class FruitArraylist {

	public static void main(String[] args) {
		
		// this ArrayList MUST be parameterized
		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist

		Apple nonRottenRedApple1 = new Apple("sweet", "crisp", "red", false);
		Apple rottenGreenApple1 = new Apple("tart", "soft", "green", true);
		Apple rottenGreenApple2 = new Apple("tart", "soft", "green", true);
		Lemon nonRottenLemon1 = new Lemon((int)(Math.random() * 100), "sour", false);
		Lemon nonRottenLemon2 = new Lemon((int)(Math.random() * 100), "sour", false);
		Lemon nonRottenLemon3 = new Lemon((int)(Math.random() * 100), "sour", false);
		Orange rottenOrange1 = new Orange("mandarin", "sweet", true);
		//Orange rottenOrange2 = rottenOrange1;
		Orange rottenOrange2 = new Orange("mandarin", "sweet", true);
		//create 8 fruit objects

		fruitArrayList.add(nonRottenRedApple1);
		fruitArrayList.add(rottenGreenApple1);
		fruitArrayList.add(rottenGreenApple2);
		fruitArrayList.add(nonRottenLemon1);
		fruitArrayList.add(nonRottenLemon2);
		fruitArrayList.add(nonRottenLemon3);
		fruitArrayList.add(rottenOrange1);
		fruitArrayList.add(rottenOrange2);
		//build up the ArrayList of fruit objects


		//following code: print out the average sourness of all the Lemon objects in the ArrayList
		int numOfLemon = 0;
		int[] indexOfLemon = new int[fruitArrayList.size()];
		for (int i = 0; i < fruitArrayList.size(); i++) {
			if (fruitArrayList.get(i) instanceof Lemon) {
				indexOfLemon[numOfLemon] = i;   //find the positions of lemons in the list
				numOfLemon++;   //count the total number of lemons
			}
		}
		int sumOfSourness = 0;
		for (int i = 0; i < numOfLemon; i++) {
			sumOfSourness += ((Lemon) fruitArrayList.get(indexOfLemon[i])).getSourness();
			//find lemons in the list using the array
			//then cast into Lemon and add up sourness of each lemon
		}
		int aveSourness = sumOfSourness / numOfLemon;
		System.out.println(aveSourness);

		System.out.println(); //to make the results more readable

		//following codes: remove matching objects

		//public boolean equals(Object obj) {
		//    if (obj == null) return false;
		//    if (obj == this) return true;
		//    if (!(obj instanceof ArrayTest)) return false;
		//    ArrayTest o = (ArrayTest) obj;
		//    return o.i == this.i;
		//}

		Apple ap = rottenGreenApple1;
		int[] matchingApples = new int[fruitArrayList.size()];
		int count = 0;
		for (int i = 0; i < fruitArrayList.size(); i++) {
			if (fruitArrayList.get(i) instanceof Apple) {
				if (fruitArrayList.get(i) == (ap)) {
					System.out.println(fruitArrayList.get(i).toString() + " is the same object as rottenGreenApple1.");
				}
				if (fruitArrayList.get(i).equals(ap)) {
					System.out.println(fruitArrayList.get(i).toString() + " has the same value as rottenGreenApple1.");
					matchingApples[count] = fruitArrayList.get(i).getId();
					count++;
				}
			}
		}

		ArrayList<Object> toRemove = new ArrayList<Object>();
		for(Fruit a: fruitArrayList){
			for (int i = 0; i < count; i++) {
				if (a.getId() == fruitArrayList.get(matchingApples[i]).getId()){
					toRemove.add(a);
				}
		    }
		}
		fruitArrayList.removeAll(toRemove);

		System.out.println(); //to make the results more readable

		//following codes: print out the remaining objects
		for (int i = 0; i < fruitArrayList.size(); i++) {
			System.out.println(fruitArrayList.get(i).toString());
		}
	}
}
