import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class RedTape {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("redtape.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				double[] probs = new double[n];
				st = new StringTokenizer(f.readLine());
				for(int j = 0; j < n; j++)
					probs[j] = Double.parseDouble(st.nextToken());
				double[][][] dp = new double[n + 1][k + 1][k + 1];
				//dp[a][b][c] is max prob of getting b yes votes from committee of c chosen from first a members
				for(int j = 0; j < n; j++)
					dp[j][0][0] = 1.0;
				for(int a = 1; a <= n; a++) {
					double pYes = probs[a - 1];
					for(int c = 1; c <= Math.min(a, k); c++) {
						dp[a][0][c] = Math.max(dp[a - 1][0][c], (1.0 - pYes)*dp[a - 1][0][c - 1]);
						for(int b = 1; b <= c; b++) {
							double m = Math.max(dp[a - 1][b][c], pYes*dp[a - 1][b - 1][c - 1] + (1.0 - pYes)*dp[a - 1][b][c - 1]);
							dp[a][b][c] = m;
						}
					}
				}
				System.out.println(dp[1][0][1] + " " + dp[1][1][1]);
				System.out.println(dp[3][0][2] + " " + dp[3][1][2] + " " + dp[3][2][2]);
				double output = dp[n][k/2][k];
				DecimalFormat df = new DecimalFormat("0.000000000000");
				String s = df.format(output);
				fout.write("Case #" + i + ": " + s + "\n");
				System.out.println("Case #" + i + ": " + s);
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
