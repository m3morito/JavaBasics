import java.util.Scanner;


public class _2_GenerateThreeLetterWords {

	public static void main(String[] args) {
	
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		char[] characters = new char[input.length()];
		
		for (int i = 0; i < characters.length; i++) {
			characters[i] = input.charAt(i);
		}
		
		for (int a = 0; a < characters.length; a++) {
			for (int b = 0; b < characters.length; b++) {
				for (int c = 0; c < characters.length; c++) {
					String word = "" + characters[a] + characters[b] + characters[c];
					System.out.print(word + " ");
				}
			}
		}

	}

}
