import java.util.Locale;
import java.util.Scanner;


public class _04_SmallestOfTreeNumbers {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.ROOT);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		double c = scan.nextDouble();

		double smallest = 0;
		
		if (a <= b && a <= c) {
			smallest = a;
		} else if (b <= a && b <= c) {
			smallest = b;
		} else if (c <= a && c <= b) {
			smallest = c;
		}
		
		boolean isInteger = (smallest / (int)smallest) == 1;
		
		if (isInteger) {
			System.out.println((int)smallest);
		} else {
			System.out.println(smallest);
		}			
	}

}
