
public class NestedLoops {

	public static void main(String[] args) {
		
		//calculate the number of combinations in TOTO 5 / 35
		int count = 0;
		
		for (int i1 = 1; i1 <= 31; i1++) {
			for (int i2 = i1 + 1; i2 <= 32; i2++) {
				for (int i3 = i2 + 1; i3 <= 33; i3++) {
					for (int i4 = i3 + 1; i4 <= 34; i4++) {
						for (int i5 = i4 + 1; i5 <= 35; i5++) {
							count++;
						}
					}
				}
			}
		}
		
		System.out.println(count);

	}

}
