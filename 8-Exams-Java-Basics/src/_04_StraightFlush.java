import java.util.ArrayList;
import java.util.Scanner;

public class _04_StraightFlush {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String[] hand = scan.nextLine().trim().replaceAll(",", "")
				.split("\\s+");

		boolean validSolution = false;

		for (int a = 0; a < hand.length; a++) {
			for (int b = a + 1; b < hand.length; b++) {
				for (int c = b + 1; c < hand.length; c++) {
					for (int d = c + 1; d < hand.length; d++) {
						for (int e = d + 1; e < hand.length; e++) {
							String card1 = hand[a];
							String card2 = hand[b];
							String card3 = hand[c];
							String card4 = hand[d];
							String card5 = hand[e];

							boolean sameSuit = checkSameSuits(card1, card2,
									card3, card4, card5);
			
							if (sameSuit) {
								boolean consequtive = checkConsequtive(card1,
										card2, card3, card4, card5);
								if (consequtive) {
									validSolution = true;
									ArrayList<String> result = new ArrayList<String>();
									result.add(card1);
									result.add(card2);
									result.add(card3);
									result.add(card4);
									result.add(card5);
									
									result = sortCards(result);
									
									System.out.println(result);
									
								}
							}

						}
					}
				}
			}
		}
		
		if (validSolution == false) {
			System.out.println("No Straight Flushes");
		}

	}

	private static ArrayList<String> sortCards(ArrayList<String> list) {
		
		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };

		ArrayList<String> sortedCards = new ArrayList<String>();
		
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				String face = list.get(j).substring(0, list.get(j).length() - 1);
				
				if (cards[i].equals(face)) {
					sortedCards.add(list.get(j));
				}
			}
		}
		return sortedCards;
	}

	private static boolean checkConsequtive(String card1, String card2,
			String card3, String card4, String card5) {

		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };

		String face1 = returnCardFace(card1);
		String face2 = returnCardFace(card2);
		String face3 = returnCardFace(card3);
		String face4 = returnCardFace(card4);
		String face5 = returnCardFace(card5);
		
		String[] faces = {face1, face2, face3, face4, face5};

		ArrayList<String> sortedFaces = new ArrayList<String>();
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < faces.length; j++) {
				if (faces[j].equals(cards[i])) {
					sortedFaces.add(faces[j]);
				}
			}
		}
			
		int index = 0;
		
		for (int i = 0; i < cards.length - 4; i++) {
			if (cards[i].equals(sortedFaces.get(0))) {
				index = i;
				break;
			}
		}
		
		boolean consequtive = false;
		
		for (int i = 0; i < sortedFaces.size(); i++) {
			if (sortedFaces.get(i).equals(cards[index])) {
				consequtive = true;
			} else {
				consequtive = false;
				break;
			}
			index++;
		}
		
		return consequtive;
	}

	private static String returnCardFace(String card) {
		String face = card.substring(0, card.length() - 1);
		return face;
	}

	private static boolean checkSameSuits(String card1, String card2,
			String card3, String card4, String card5) {
		String suit1 = returnCardSuit(card1);
		String suit2 = returnCardSuit(card2);
		String suit3 = returnCardSuit(card3);
		String suit4 = returnCardSuit(card4);
		String suit5 = returnCardSuit(card5);

		boolean sameSuit = suit1.equals(suit2) && suit1.equals(suit3)
				&& suit1.equals(suit4) && suit1.equals(suit5);

		return sameSuit;
	}

	private static String returnCardSuit(String card) {
		String suit = card.substring(card.length() - 1, card.length());
		return suit;
	}

}
