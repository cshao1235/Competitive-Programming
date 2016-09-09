import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Feast {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("feast.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			boolean[][] dp = new boolean[t + 1][2];
			dp[0][0] = true;
			int max = 0;
			for(int i = 0; i <= t; i++)
			{
				if(dp[i][0])
				{
					if(i + a <= t)
						dp[i + a][0] = true;
					if(i + b <= t)
						dp[i + b][0] = true;
					dp[i/2][1] = true;
					if(i > max)
						max = i;
				}
			}
			for(int i = 0; i <= t; i++)
			{
				if(dp[i][1])
				{
					if(i + a <= t)
						dp[i + a][1] = true;
					if(i + b <= t)
						dp[i + b][1] = true;
					if(i > max)
						max = i;
				}
			}
			
			FileWriter fout = new FileWriter("feast.out");
			fout.write(max + "\n");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
