import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces606C {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken()) - 1;
			f.close();
			//boolean[] found = new boolean[n];
			int[] dp = new int[n];
			int max = 0;
			for(int i = 0; i < n; i++)
			{
				if(a[i] > 0 && dp[a[i] - 1] > 0)
					dp[a[i]] = dp[a[i] - 1] + 1;
				else
					dp[a[i]] = 1;
				if(dp[a[i]] > max)
					max = dp[a[i]];
			}
			System.out.println(n - max);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
