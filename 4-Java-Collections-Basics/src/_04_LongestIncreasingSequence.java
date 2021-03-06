import java.util.Scanner;


public class _04_LongestIncreasingSequence {

       public static void main(String[] args) {
             
             @SuppressWarnings("resource")
             Scanner scan = new Scanner(System.in);
             
             String input = scan.nextLine();
             String[] stringArray = input.split(" ");
             int[] integers = new int[stringArray.length];
             
             for (int i = 0; i < integers.length; i++) {
                    integers[i] = Integer.parseInt(stringArray[i]);
             }
             
             int currentLength = 0;
             int maxLength = 0;
             int index = 0;
             
             for (int i = 0; i < integers.length; i++) {
                    
                    System.out.print(integers[i] + " ");
                    currentLength++;
                    
                    if (currentLength > maxLength) {
                           maxLength = currentLength;
                           index = i;
                    }
                    
                    if ((i < integers.length - 1) && (integers[i] < integers[i + 1]) == false) {
                           System.out.println();
                           currentLength = 0;
                    }
             }
             
             System.out.println();
             System.out.print("Longest: ");
             
             for (int i = index - maxLength + 1; i <= index; i++) {
                    System.out.print(integers[i] + " ");
             }
       }
}
