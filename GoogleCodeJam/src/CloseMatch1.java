import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CloseMatch1 {
	public static int[] maximize(String c, String j)
	{
		return new int[2];
	}
	public static int[] minimize(String c, String j)
	{
		if(c.length() == 0)
			return new int[2];
		if(c.charAt(0) == '?' && j.charAt(0) == '?')
		{
			String c1 = "0" + c.substring(1);
			String j1 = "0" + j.substring(1);
		}
		return new int[2];
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("closematch1.out");
			for(int i = 1; i <= t; i++)
			{
				/*StringTokenizer st = new StringTokenizer(f.readLine());
				String c = st.nextToken();
				String j = st.nextToken();
				int[] scores = solve(c.length(), c, j);
				String[] output = new String[2];
				output[0] = pad(scores[0], c.length());
				output[1] = pad(scores[1], c.length());
				System.out.println("Case #" + i + ": " + output[0] + " " + output[1]);
				fout.write("Case #" + i + ": " + output[0] + " " + output[1] + "\n");*/
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
