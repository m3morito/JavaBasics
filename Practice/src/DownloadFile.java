import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class DownloadFile {

	public static void main(String[] args) {
		
		String url = "https://softuni.bg";
		String fileName = "content.html";
		
		try {
			DownloadFileFromInternet(url, fileName);
			System.out.println("Downloaded file: " + fileName);
		} catch (IOException ioex) {
			System.out.println("Error: cannot download " + url);
		}

	}

	private static void DownloadFileFromInternet(String url, String fileName) 
			throws IOException {
		URL urlObject = new URL(url);
		try (
				InputStream inputStream = urlObject.openStream();
				OutputStream outputStream = new FileOutputStream(fileName);				
		) {
			copyStream(inputStream, outputStream);
		}
	}

	private static void copyStream(InputStream inputStream,
			OutputStream outputStream) throws IOException {
		byte[] buf = new byte[4096]; //4 KB buffer size
		while (true) {
			int bytesRead = inputStream.read(buf);
			if (bytesRead == -1) {
				break;
			}
			outputStream.write(buf, 0, bytesRead);
		}					
	}
				
}

	


