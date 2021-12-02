import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {
	
    private List<Integer> list;
    private String inFile;
 
    public ListOfNumbers () {
        list = new ArrayList<Integer>();
    }
    

    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;	
    }
    
    public void readList() throws IOException {
		FileReader f = new FileReader("numberfile.txt");
		BufferedReader in = new BufferedReader(f);
		String l = in.readLine();
		while (l != null) {
            list.add(Integer.parseInt(l));
            l = in.readLine();
		}
		f.close();
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("outFile.txt"));
            for (int i = 0; i < list.size(); i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    //modify so that it will compile
    public static void cat(String fileName) throws IOException {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
//            return;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
        listOfNumbers.readList();
        listOfNumbers.writeList();
    }

}
