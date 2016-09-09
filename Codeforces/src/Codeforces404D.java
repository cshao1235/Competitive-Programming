import java.io.*;

public class Codeforces404D {
	private static final long MOD = (long) Math.pow(10, 9) + 7;
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			String s = f.readLine();
			f.close();
			int[][] dp = new int[s.length()][3]; //0 if ends in 0, 1 if ends in *1, 2 if ends in 2*
			if(s.charAt(0) == '?')
				dp[0][2] = 1;
			else if(s.charAt(0) == '0')
				dp[0][0] = 1;
			else if(s.charAt(1) == '1')
				dp[0][1] = 1;
			else
			{
				for(int j = 0; j < 3; j++)
					dp[0][j] = 1;
			}
			for(int i = 1; i < s.length(); i++)
			{
				dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
				dp[i][1] = dp[i - 1][2];
				dp[i][2] = dp[i - 2][0] + dp[i - 2][2] + dp[i - 1][2];
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
