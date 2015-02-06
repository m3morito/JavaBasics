import java.util.Scanner;


public class _01_VideoDurations {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		//duration in minutes
		int duration = 0;
		
		while (true) {
			String command = scan.nextLine();
			//leave the infinite loop if the command is End
			if (command.equals("End")) {
				break;
			}
			//add the hours and minutes to the duration
			String[] input = command.split(":");
			duration += (60 * Integer.parseInt(input[0])) + 
					Integer.parseInt(input[1]);
		}
		//calculate the result in hours and minutes
		int hours = duration / 60;
		int minutes = duration % 60;
		
		//print the result in the required format
		System.out.printf("%s:%s", hours, minutes < 10 ? "0" + minutes : minutes);
	}

}