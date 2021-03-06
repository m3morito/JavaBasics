import java.util.Locale;
import java.util.Scanner;


public class _08_CountOfEqualBitPairs {
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.ROOT);
		
		int num = scan.nextInt();
		
		String binary = Integer.toBinaryString(num);
		int length = binary.length();
		
		int pos = length - 1;
		int equalPairsCount = 0;
				
		while (pos >= 1) {
			int bit1 = (num >> pos) & 1;
			int bit2 = (num >> (pos - 1)) & 1;
			if (bit1 == bit2) {
				equalPairsCount++;
			}
			pos--;
		}
		
		System.out.println(equalPairsCount);
		
	}

}
