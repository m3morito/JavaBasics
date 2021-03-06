import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;


public class _11_MostFrequentWord {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		input = input.toLowerCase();
		
		String[] words = input.split("[ ]*\\W+");	
		Arrays.sort(words);
		
		TreeMap<String, Integer> wordList = new TreeMap<>();
		
		int count = 0;
		int maxCount = 0;
		for (int i = 0; i < words.length; i++) {
			
			if (wordList.containsKey(words[i]) == false) {
				count = 0;
			}
			count++;
			wordList.put(words[i], count);	
			
			if (count > maxCount) {
				maxCount = count;
			}
		}
				
		for (String name: wordList.keySet()){

            String key = name.toString();
            int value = wordList.get(name); 
 
            if (value == maxCount) {
            	System.out.println(key + " -> " + value + " times");  
			}           
		} 		
	}

}
