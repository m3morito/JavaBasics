import java.util.Locale;
import java.util.Scanner;


public class _03_PointsInsideFigure {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		double x = scan.nextDouble();
		double y = scan.nextDouble();
		
		boolean insideA = (x >= 12.5) && (x <= 17.5) && (y <= 13.5) && (y >= 8.5);
		boolean insideB = (x >= 20) && (x <= 22.5) && (y <= 13.5) && (y >= 8.5);
		boolean insideC = (x >= 12.5) && (x <= 22.5) && (y <= 8.5) && (y >= 6);
		
		boolean insideFigure = (insideA || insideB) || insideC;
		
		if (insideFigure) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
	}
}
