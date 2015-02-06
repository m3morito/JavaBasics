import java.util.ArrayList;
import java.util.Scanner;


public class _03_LongestOddEvenSequence {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//parse the input string
		String[] input = scan.nextLine().split("[^-0-9]+");
		
		//store the numbers in an integer array
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals("") == false) {
				nums.add(Integer.parseInt(input[i]));
			}
		}
		
		//the minimal count of numbers is 1
		if (nums.size() == 1) {
			System.out.println(1);
			return;
		}
		
		//check sequences starting with an odd number
		int maxLengthOdd = 1;
		int currentLength = 1;
		int odd = 1;
		
		for (int i = 0; i < nums.size() - 1; i++) {
			//get the first 2 numbers
			int num1 = nums.get(i);
			int num2 = nums.get(i + 1);
			
			if (odd == 1) {
				//check if the first one is odd (or zero) and the second is even
				if ((num1 % 2 != 0 || num1 == 0) && num2 % 2 == 0) {
					//if so, increase the current length
					currentLength++;
					odd *= -1;
					if (currentLength > maxLengthOdd) {
						//store the current length as the maximum if it is greater
						maxLengthOdd = currentLength;
					}
				} else {
					//reset the current length if the condition is not met
					currentLength = 1;
				}
			} else if (odd == -1) {
				//do the same if the first number is even and the second is odd
				if (num1 % 2 == 0 && (num2 % 2 != 0 || num2 == 0)) {
					currentLength++;
					odd *= -1;
					if (currentLength > maxLengthOdd) {
						maxLengthOdd = currentLength;
					}
				} else {
					currentLength = 1;
				}
			}	
		}
		//check sequences starting with an even number
		int maxLengthEven = 1;
		currentLength = 1;
		int even = 1;
		
		for (int i = 0; i < nums.size() - 1; i++) {
			//get the first 2 numbers
			int num1 = nums.get(i);
			int num2 = nums.get(i + 1);
			
			if (even == 1) {
				//check if the first one is even and the second is odd (or zero)
				if (num1 % 2 == 0 && (num2 % 2 != 0 || num2 == 0)) {
					//if so, increase the current length
					currentLength++;
					even *= -1;
					if (currentLength > maxLengthEven) {
						//store the current length as the maximum if it is greater
						maxLengthEven = currentLength;
					}
				} else {
					//reset the current length if the condition is not met
					currentLength = 1;
				}
			} else if (even == -1) {
				//do the same if the first number is odd and the second is even
				if ((num1 % 2 != 0 || num1 == 0) && num2 % 2 == 0) {
					currentLength++;
					even *= -1;
					if (currentLength > maxLengthEven) {
						maxLengthEven = currentLength;
					}
				} else {
					currentLength = 1;
				}
			}
		}
		
		//print the result
		if (maxLengthEven > maxLengthOdd) {
			System.out.println(maxLengthEven);
		} else {
			System.out.println(maxLengthOdd);
		}				
	}

}
