import java.util.Scanner;


public class _02_SumCards {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		
		String[] cards = new String[input.length];
		for (int i = 0; i < cards.length; i++) {		
			//get the string without card suit
			String card = input[i].substring(0, input[i].length() - 1);			
			//store the card face in the array
			cards[i] = card;		
		}
		
		int sum = 0;
		int prevValue = -1;
		int equalCount = 0;
		
		for (int i = 0; i < cards.length; i++) {
			
			int value = ReturnCardValue(cards[i]);
			
			if (value == prevValue) {
				equalCount++;
			} else {
				equalCount = 1;
			}
			
			sum += value;		
			if (equalCount == 2) {
				sum += 2 * value;
			}
			
			if (equalCount > 2) {
				sum += value;
			}
			
			prevValue = value;
			
		}
		System.out.println(sum);	
	}
	//a method which returns the card value
	private static int ReturnCardValue(String card) {
		
		int value = 0;		
		switch (card) {
			case "2": value = 2; break;
			case "3": value = 3; break;
			case "4": value = 4; break;
			case "5": value = 5; break;
			case "6": value = 6; break;
			case "7": value = 7; break;
			case "8": value = 8; break;
			case "9": value = 9; break;
			case "10": value = 10; break;
			case "J": value = 12; break;
			case "Q": value = 13; break;
			case "K": value = 14; break;
			case "A": value = 15; break;	
		}
		return value;
	}

}
