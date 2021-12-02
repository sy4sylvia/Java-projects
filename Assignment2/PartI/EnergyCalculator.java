import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.Scanner;

public class EnergyCalculator {
	public static double calculateEnergyIncrease(double m, double v0, double v1) {
		 double E = m / 2 * v1 * v1 - m / 2 * v0 * v0;
		 return E;
	}
	
	public static void main(String[] args) {

		double Energy = calculateEnergyIncrease(50,10,20);
		System.out.println("Energy increase from 10 m/s to 20 m/s of an object of mass 50 kg is: " + Energy + " J");

	}
}
