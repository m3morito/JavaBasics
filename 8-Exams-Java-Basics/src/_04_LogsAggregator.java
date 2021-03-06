import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class _04_LogsAggregator {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		//read the number of lines
		int n = scan.nextInt();
		scan.nextLine();
		
		//initialize a map for storing the log data
		Map<String, TreeMap<String, Integer>> log = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			//parse the n lines of input and split them into variables
			String[] input = scan.nextLine().trim().split("\\s+");
			String ipAddress = input[0];
			String user = input[1];
			int duration = Integer.parseInt(input[2]);
			
			//add the data to the log
			if (log.containsKey(user) == false) {
				//new user
				TreeMap<String, Integer> data = new TreeMap<>();
				data.put(ipAddress, duration);
				log.put(user, data);
			} else {
				//existing user
				TreeMap<String, Integer> data = log.get(user);
				//check if there have been connections from the same IP
				if (data.containsKey(ipAddress)) {
					//if so, add the duration to the duration for that IP
					duration += data.get(ipAddress);
				} 
				data.put(ipAddress, duration);
				log.put(user, data);
			}
		}
		//print the result
		for (String user : log.keySet()) {
			System.out.print(user + ": ");
			
			int duration = 0;
			TreeMap<String, Integer> data = log.get(user);
			
			for (String ipAddress : data.keySet()) {
				duration += data.get(ipAddress).intValue();
			}
			System.out.print(duration + " [");
			
			int count = data.size();
			
			for (String ipAddress : data.keySet()) {
				System.out.print(ipAddress);
				count--;
				if (count > 0) {
					System.out.print(", ");
				} else {
					System.out.print("]");
				}
			}
			System.out.println();
		}		
	}

}
