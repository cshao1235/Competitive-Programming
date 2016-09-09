import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodingContestCreation {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("coding_contest_creation.txt"));
			FileWriter fout = new FileWriter("coding_contest_creation_output.txt");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				int n = Integer.parseInt(f.readLine());
				StringTokenizer st = new StringTokenizer(f.readLine());
				int[] difficulties = new int[n + 1];
				for(int i = 1; i <= n; i++)
					difficulties[i] = Integer.parseInt(st.nextToken());
				int[] dp = new int[n + 1];
				for(int i = 1; i <= n; i++)
				{
					dp[i] = dp[i - 1] + 3;
					if(i >= 2)
					{
						int diff1 = difficulties[i] - difficulties[i - 1];
						if(diff1 > 0 && diff1 <= 30)
							dp[i] = Math.min(dp[i], dp[i - 2] + 2);
					}
					if(i >= 3)
					{
						int diff1 = difficulties[i] - difficulties[i - 1];
						int diff2 = difficulties[i - 1] - difficulties[i - 2];
						if(diff1 > 0 && diff2 > 0)
						{
							if((diff1 <= 10 && diff2 <= 20) || (diff1 <= 20 && diff2 <= 10))
								dp[i] = Math.min(dp[i], dp[i - 3] + 1);
						}
					}
					if(i >= 4)
					{
						int diff1 = difficulties[i] - difficulties[i - 1];
						int diff2 = difficulties[i - 1] - difficulties[i - 2];
						int diff3 = difficulties[i - 2] - difficulties[i - 3];
						if(diff1 > 0 && diff2 > 0 && diff3 > 0)
						{
							if(diff1 <= 10 && diff2 <= 10 && diff3 <= 10)
								dp[i] = Math.min(dp[i], dp[i - 4]);
						}
					}
				}
				//System.out.println(Arrays.toString(dp));
				System.out.println("Case #" + num + ": " + dp[n]);
				fout.write("Case #" + num + ": " + dp[n] + "\n");
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
