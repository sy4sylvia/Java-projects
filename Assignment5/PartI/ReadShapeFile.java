import java.io.*;
import java.util.ArrayList;
import shapes.*;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 *
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) throws IOException, ShapeException {

		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */


		if (shapeName.equals("Circle")) return new Circle();
		else if (shapeName.equals("Rectangle")) return new Rectangle();
		else if (shapeName.equals("Square"))  return new Square();
		else {
			throw new ShapeException("unavailable shapes");
		}
	}

	public static void main(String[] args) throws IOException {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
//		File f = new File("shapes.txt");

		FileReader fr = new FileReader("shapes.txt");
		BufferedReader in = new BufferedReader(fr);
		String inString = in.readLine();
		/* create a loop to read the file line-by-line */


		while (inString != null) {
			try {
				GeometricObject shape = createShape(inString);
				shapeList.add(shape);
				System.out.println(inString);

			}
			catch (ShapeException | IOException e) {
				System.err.println("Cannot create shape: " + inString);
			}
			inString = in.readLine();
		}
		fr.close();

		System.out.println(shapeList);
	}
}
