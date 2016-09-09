import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Polynesiaglot {
	private static final long MOD = (long) Math.pow(10, 9) + 7;
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("polynesiaglot.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int c = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				long[][] dp = new long[l + 1][2];
				dp[1][0] = v;
				dp[1][1] = 0;
				for(int j = 2; j <= l; j++)
				{
					dp[j][0] = (v*(dp[j - 1][0] + dp[j - 1][1]))%MOD;
					dp[j][1] = (c*dp[j - 1][0])%MOD;
				}
				long output = (dp[l][0] + dp[l][1])%MOD;
				System.out.println("Case #" + i + ": " + output);
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
