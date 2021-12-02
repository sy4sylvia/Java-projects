package PartI;
import java.util.ArrayList;
import java.util.Collection;


public class ResultPrinter {

	MathOperation op;

	public ResultPrinter(MathOperation op) {
		this.op = op;
	}

	public void go(double a, double b) { //void? //return double????
		MathOperation add = (double x, double y) -> (x + y);
		System.out.println("result is " + add.operation(a, b));


	}

	public static void go(double a, double b, MathOperation op) {
		MathOperation multiplication = (double x, double y) -> (x * y);
		System.out.println("result is " + multiplication.operation(a, b));
	}

	public static void go(Collection<Pair<Double,Double>> c, MathOperation op) {
		/* Some Loop  {

		  	System.out.println("result is " + ???);
		  }
		*/

		ArrayList<Pair<Double, Double>> l = (ArrayList<Pair<Double, Double>>) c;
		MathOperation division = (double x, double y) -> (x / y);

		for (int i = 0 ; i < l.size(); i++) {
			Pair<Double, Double> p = l.get(i);
			System.out.println("result is " + division.operation(p.getLeft(), p.getRight()));
		}
	}

	public static void main(String[] args) {

		MathOperation op = new MathOperation() {
			@Override
			public double operation(double a, double b) {
				return 0;
			}
		};

		ResultPrinter rp = new ResultPrinter(op);
		rp.go(3.0, 4.0);

		ResultPrinter.go(4.0, 2.0, op);

		ArrayList<Pair<Double,Double>> al = new ArrayList<Pair<Double,Double>>();
		Pair<Double, Double> p = new Pair<Double, Double>(3.0, 4.0);
		al.add(p);
		p = new Pair<Double, Double>(5.0, 6.0);
		al.add(p);
		p = new Pair<Double, Double>(7.0, 8.0);
		al.add(p);

		ResultPrinter.go(al, op);

	}
}
