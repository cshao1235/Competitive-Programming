import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DanceAroundTheClock {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("aroundtheclock.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int d = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken()) - 1;
				int n = Integer.parseInt(st.nextToken());
				int originalLeft;
				int originalRight;
				//even dancers end up at position (i + N)%D
				//odd dancers end up at position (i - N)%D
				if(k%2 == 1)
				{
					int finalPosition = ((k - n)%d + d)%d;
					int finalLeft = (finalPosition + 1)%d;
					int finalRight = (finalPosition - 1 + d)%d;
					originalLeft = (((finalLeft - n)%d) + d)%d;
					originalRight = (((finalRight - n)%d) + d)%d;
				}
				else
				{
					int finalPosition = (k + n)%d;
					int finalLeft = (finalPosition + 1)%d;
					int finalRight = (finalPosition - 1 + d)%d;
					originalLeft = (finalLeft + n)%d;
					originalRight = (finalRight + n)%d;
				}
				originalLeft++;
				originalRight++;
				System.out.println("Case #" + i + ": " + originalLeft + " " + originalRight);
				fout.write("Case #" + i + ": " + originalLeft + " " + originalRight + "\n");
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
