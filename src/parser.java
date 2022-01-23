
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Parser {
	static File f = new File("btcData.csv");
	public static void convertToTxt() throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		bfr.readLine();
		String line = bfr.readLine();
		var close = new ArrayList<Double>(); 
		while(line != null) {
			String[] s = line.split(",");
			close.add(Double.parseDouble(s[4]));
		}
		double[] closePrices = new double[close.size()];
		for(int i = 0; i < close.size(); i++) {
			closePrices[i] = close.get(i);
		}

	}
}
