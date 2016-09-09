import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces368B {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken()) - 1;
			int[] dp = new int[n];
			boolean[] contained = new boolean[100000];
			dp[n - 1] = 1;
			contained[a[n - 1]] = true;
			for(int i = n - 2; i >= 0; i--)
			{
				if(contained[a[i]])
					dp[i] = dp[i + 1];
				else
				{
					contained[a[i]] = true;
					dp[i] = dp[i + 1] + 1;
				}
			}
			for(int i = 0; i < m; i++)
			{
				int query = Integer.parseInt(f.readLine()) - 1;
				System.out.println(dp[query]);
			}
			f.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
