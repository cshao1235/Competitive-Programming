import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StandingOvation {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("standingovation.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int smax = Integer.parseInt(st.nextToken());
				int[] levels = new int[smax + 1];
				String s = st.nextToken();
				for(int j = 0; j <= smax; j++)
					levels[j] = s.charAt(j) - '0';
				int numAdded = 0;
				int numPeople = 0;
				for(int j = 0; j <= smax; j++)
				{
					if(numPeople < j)
					{
						numAdded += j - numPeople;
						numPeople = j;
					}
					numPeople += levels[j];
				}
				System.out.println("Case #" + i + ": " + numAdded);
				fout.write("Case #" + i + ": " + numAdded + "\n");
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
