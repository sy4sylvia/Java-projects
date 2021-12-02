package question2;
import java.util.ArrayList;
import java.util.Arrays;

public class MyVector<Number> {

	private ArrayList<Number> ar;

	public MyVector(ArrayList<Number> ar) {
		this.ar = ar;
	}

	public Number dotProduct(MyVector<Number> v) throws IncompatibleVectorsException {
		Number result = null;
		if (this.ar.size() == v.ar.size()) {
			if (ar.get(0) instanceof Integer) {
				Integer res = 0;
				for (int i = 0; i < ar.size(); i++) {
					res += ((int)this.ar.get(i)) * ((int)v.ar.get(i));
				}
				result = (Number) res;
			}
			else if (ar.get(0) instanceof Double) {
				Double res = 0.0;
				for (int i = 0; i < ar.size(); i++) {
					res += ((double)this.ar.get(i)) * ((double)v.ar.get(i));
				}
				result = (Number) res;
			}
			else if (ar.get(0) instanceof Float) {
				Float res = 0f;
				for (int i = 0; i < ar.size(); i++) {
					res += ((float)this.ar.get(i)) * ((float)v.ar.get(i));
				}
				result = (Number) res;
			}
			else if (ar.get(0) instanceof Long) {
				Long res = 0l;
				for (int i = 0; i < ar.size(); i++) {
					res += ((long)this.ar.get(i)) * ((long)v.ar.get(i));
				}
				result = (Number) res;
			}
			return result;
		}
		else {
			throw new IncompatibleVectorsException("Two vectors have different dimensions.");
		}
	}


	public ArrayList<Number> vectorContents(Number[] vect) {
	    for (Number v :vect) ar.add(v);
	    return ar;
	}


	public static void main(String[] args) throws IncompatibleVectorsException {
		Integer[] vect1 = {1, 2, 3};
		ArrayList<Integer> ar1 = new ArrayList<Integer>(Arrays.asList(vect1));
		Integer[] vect2 = {4, 5, 6};
		ArrayList<Integer> ar2 = new ArrayList<Integer>(Arrays.asList(vect2));
		MyVector<Integer> mv1 = new MyVector<Integer>(ar1);
		MyVector<Integer> mv2 = new MyVector<Integer>(ar2);
		Integer mv3 = mv1.dotProduct(mv2);

		System.out.println("result of vec1 dotProduct vec2: " + mv3);

		Double[] vect3 = {1.1, 2.2, 3.3};
		ArrayList<Double> ar3 = new ArrayList<Double>(Arrays.asList(vect3));
		Double[] vect4 = {4.4, 5.5, 6.6};
		ArrayList<Double> ar4 = new ArrayList<Double>(Arrays.asList(vect4));
		MyVector<Double> mv4 = new MyVector<Double>(ar3);
		MyVector<Double> mv5 = new MyVector<Double>(ar4);
		Double mv6 = mv4.dotProduct(mv5);
		System.out.println("result of vec3 dotProduct vec4: " + mv6);


	}
}

