import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class _09_ListOfProducts {

	public static void main(String[] args) {

		Locale.setDefault(Locale.ROOT);

		BufferedReader reader = null;
		BufferedWriter writer = null;

		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			String currentRow = "";

			reader = new BufferedReader(new FileReader("Input.txt"));

			while ((currentRow = reader.readLine()) != null) {

				String[] row = currentRow.split(" ");
				String name = row[0];
				double price = Double.parseDouble(row[1]);

				Product newProduct = new Product(name, price);

				productList.add(newProduct);
			}
			reader.close();

			Collections.sort(productList);
			
			writer = new BufferedWriter(new FileWriter("Output.txt"));
			for (Product product : productList) {
				writer.write(product.getPrice() + " " + product.getName()
						+ "\r\n");
			}
			writer.close();

		} catch (IOException ex) {
			System.out.println("Error" + ex);

		}
	}
}