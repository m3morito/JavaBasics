import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Nuts {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		//parse the number of lines of input
		int n = scan.nextInt();
		scan.nextLine();

		//initialize a map for the data
		//TREE MAP - ordered by keys, LINKEDHASHMAP - ordered by order of appearance!
		Map<String, LinkedHashMap<String, Integer>> companies = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			//parse and split each input line into variables
			String[] input = scan.nextLine().trim().split("\\s+");

			String company = input[0];
			String nutType = input[1];
			int amount = Integer.parseInt(input[2].substring(0,
					input[2].length() - 2));
			
			//insert the values into the map
			if (companies.containsKey(company) == false) {
				LinkedHashMap<String, Integer> data = new LinkedHashMap<>();
				data.put(nutType, amount);
				companies.put(company, data);
			} else {
				LinkedHashMap<String, Integer> data = companies.get(company);
				if (data.containsKey(nutType)) {
					amount += data.get(nutType);
				}
				data.put(nutType, amount);
				companies.put(company, data);
			}
		}
		//print the result in the required format
		for (String company : companies.keySet()) {
			System.out.print(company + ": ");
			
			LinkedHashMap<String, Integer> data = companies.get(company);
			int count = data.size();
			
			for (String nut : data.keySet()) {
				System.out.print(nut + "-" + data.get(nut) + "kg");
				count--;
				if (count > 0) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}

}
