import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces455A {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			long[] a = new long[100001];
			for(int i = 0; i < n; i++)
				a[Integer.parseInt(st.nextToken())]++;
			f.close();
			long[] dp = new long[100001];
			dp[1] = a[1];
			dp[2] = 2*a[2];
			//dp[3] = Math.max(3*a[3] + dp[1], dp[2]);
			for(int i = 3; i <= 100000; i++)
				dp[i] = Math.max(Math.max(i*a[i] + dp[i - 2], dp[i - 1]), i*a[i] + dp[i - 3]);
			System.out.println(dp[100000]);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
