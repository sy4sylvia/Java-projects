package question1;

import java.io.*;
import java.util.ArrayList;

public abstract class Dog {

	public abstract double getAverageWeight();
	
	public static void main(String[] args) {
		ArrayList<Dog> dogList = new ArrayList<>();

		//read the file and put Dog objects in the list
		FileReader fr = null;
		BufferedReader in = null;

		try {
			fr = new FileReader("dogs.txt");
		}
		catch (FileNotFoundException fne) {
			fne.printStackTrace();
		}

		assert fr != null;
		in = new BufferedReader(fr);

		int numLines = 0;

		try {
			String linea = in.readLine();
			while (linea != null) {
				if (linea.trim() != "") {
					System.out.println(linea);
					//read the file and displays by printing out.
					if (linea.equals("Chihuahua")) dogList.add(new Chihuahua());
					else if (linea.equals("Yorkshire")) dogList.add(new Yorkshire());
					else if (linea.equals("Labrador")) dogList.add(new Labrador());
					numLines++;
				}
				linea = in.readLine();
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			fr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		double sumWeight = 0, numOfDogs = 0;
		for (Dog d : dogList) {
			sumWeight += d.getAverageWeight();
			numOfDogs++;
		}

		//calculation of ave of ave weights of Dog in dogs.txt
		double aveOfave = sumWeight / numOfDogs;

		System.out.println("average of average weights is " + aveOfave);


	}
}
