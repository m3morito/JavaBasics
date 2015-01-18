import java.util.Scanner;


public class _06_CountSpecifiedWord {

       public static void main(String[] args) {
             
             @SuppressWarnings("resource")
             Scanner scan = new Scanner(System.in);  
             
             String input = scan.nextLine();
             input = input.toLowerCase();
             
             String word = scan.nextLine();
             word = word.toLowerCase();
             
             String[] words = input.split("[ .!?,;'-]+");
             
             int wordCount = 0;
             
             for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(word)) {
                           wordCount++;
                    }
             }      
             
             System.out.println(wordCount);          
       }
}
