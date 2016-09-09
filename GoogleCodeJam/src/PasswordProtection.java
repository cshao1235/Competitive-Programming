import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PasswordProtection {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("password.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				double[] probabilities = new double[a];
				st = new StringTokenizer(f.readLine());
				for(int j = 0; j < a; j++)
					probabilities[j] = Double.parseDouble(st.nextToken());
				//Case 1: continue typing
				//	succeed w/ prob p1p2...pa
				//	otherwise fail
				//	expected value is p1p2...pa(b - a) + (1 - p1p2...pa)(b - a + 1 + b) + 1
				//	= (1 - p1p2...pa)(b + 1) + b - a + 1
				//Case 2: press enter and resubmit
				//	expected value is b + 2
				//Case 3: press backspace n times
				//	expected value is (1 - p1p2p3...p(a - n))(b + 1) + b - a + 1 + 2n
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
