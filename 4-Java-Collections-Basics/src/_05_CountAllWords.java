import java.util.Scanner;


public class _05_CountAllWords {

       public static void main(String[] args) {
             
             @SuppressWarnings("resource")
             Scanner scan = new Scanner(System.in);
             String input = scan.nextLine();
             
             String[] words = input.split("[ .,!?';-]+");
             
             System.out.println(words.length);
       }
}
