package question8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class question8 {

	public ArrayList<Integer> getNumbers(String filename) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		FileReader fr = null;
//		BufferedReader fileInput = new BufferedReader(fr);
		BufferedReader fileInput = null;

		try {
			fr = new FileReader(filename);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assert fr != null;
		fileInput = new BufferedReader(fr);

		try {
			String inLine = fileInput.readLine();
			int countedChars = 0;
			while (inLine != null) {
				try {
					Integer myInt = Integer.parseInt(inLine);
					ar.add(myInt);
					inLine = fileInput.readLine();
				}
				catch (NullPointerException e) {
					e.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fr.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return ar;
	}
}
