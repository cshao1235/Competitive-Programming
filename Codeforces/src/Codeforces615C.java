import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces615C {
	/*public static int[] kmp(String s1, String s2) //searching for s1 in s2
	{
		int[] output = {-1, -1};
		
	}*/
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			String s = f.readLine();
			StringBuffer s1 = new StringBuffer("");
			for(int i = s.length() - 1; i >= 0; i--)
				s1.append(s.charAt(i));
			String sReverse = s1.toString();
			String t = f.readLine();
			int[][] dp = new int[t.length() + 1][4];
			for(int i = 1; i <= t.length(); i++)
				dp[i][0] = 3000;
			for(int i = 0; i < t.length(); i++)
			{
				for(int j = i + 1; j <= t.length(); j++)
				{
					if(s.contains(t.substring(i, j)) && dp[j][0] > (dp[i][0] + 1))
					{
						dp[j][0] = dp[i][0] + 1;
					}
				}
			}
			f.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
