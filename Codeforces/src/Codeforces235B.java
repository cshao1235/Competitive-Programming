import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces235B {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			double[] prob = new double[n];
			for(int i = 0; i < n; i++)
				prob[i] = Double.parseDouble(st.nextToken());
			f.close();
			double[] dp = new double[n];
			dp[0] = 0.0;
			for(int i = 1; i < n; i++)
			{
				dp[i] = (dp[i - 1] + prob[i - 1])*prob[i];
			}
			double sum = 0;
			for(int i = 0; i < n; i++)
				sum += 2*dp[i] + prob[i];
			System.out.println(sum);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
