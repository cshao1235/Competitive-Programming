import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("high_security_output.txt"));
			BufferedReader f1 = new BufferedReader(new FileReader("high_security_output_1.txt"));
			FileWriter fout = new FileWriter("compare.txt");
			for(int num = 1; num <= 200; num++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				st.nextToken();
				st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(f1.readLine());
				st.nextToken();
				st.nextToken();
				int b = Integer.parseInt(st.nextToken());
				fout.write("Case #" + num + ": " + (a - b) + "\n");
				System.out.println("Case #" + num + ": " + (a - b));
			}
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
