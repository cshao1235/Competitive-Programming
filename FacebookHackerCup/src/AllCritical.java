import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AllCritical {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("allcritical.in"));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("allcritical.out");
			for(int i = 1; i <= t; i++)
			{
				double p = Double.parseDouble(f.readLine());
				int max = 5000;
				double output = 0.0;
				for(int j = 0; j <= max; j++)
					output += 1.0 - Math.pow(1.0 - Math.pow(1.0 - p, j), 20);
				fout.write("Case #" + i + ": " + output + "\n");
			}
			f.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
