import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.io.IOException;

class Uncompress {
	public static String infile = "java__compress.bin";

	public static String outfilename = "java.txt";

	public static void dcompressFile() throws IOException {
		System.out.println("Compressed file : " + infile);
		System.out.println("Dcompressed file : " + outfilename);
		InflaterInputStream inflInstream = new InflaterInputStream(
				new FileInputStream(infile), new Inflater());
		FileOutputStream outstream = new FileOutputStream(outfilename);
		boolean completed = false;
		try {

			byte b[] = new byte[1024];
			while (true) {
				int l = inflInstream.read(b, 0, 1024);
				if (l == -1) {
					break;
				}
				outstream.write(b, 0, l);
			}
			completed = true;
			inflInstream.close();
			outstream.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
}

public class Uncompress_data {
	public static void main(String[] args) throws IOException {
		Uncompress.dcompressFile();
	}
}
