import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces429B {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] a = new int[n][m];
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(f.readLine());
				for(int j = 0; j < m; j++)
					a[i][j] = Integer.parseInt(st.nextToken());
			}
			f.close();
			long[][][] dp = new long[n][m][4];
			
			dp[0][0][0] = a[0][0];
			for(int i = 1; i < n; i++)
				dp[i][0][0] = dp[i-1][0][0] + a[i][0];
			for(int j = 1; j < m; j++)
				dp[0][j][0] = dp[0][j-1][0] + a[0][j];
			for(int i = 1; i < n; i++)
			{
				for(int j = 1; j < m; j++)
					dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i][j-1][0]) + a[i][j];
			}
			
			dp[n-1][0][1] = a[n-1][0];
			for(int i = n - 2; i >= 0; i--)
				dp[i][0][1] = dp[i + 1][0][1] + a[i][0];
			for(int j = 1; j < m; j++)
				dp[n-1][j][1] = dp[n-1][j-1][1] + a[n-1][j];
			for(int i = n - 2; i >= 0; i--)
			{
				for(int j = 1; j < m; j++)
					dp[i][j][1] = Math.max(dp[i+1][j][1], dp[i][j-1][1]) + a[i][j];
			}
			
			dp[0][m-1][2] = a[0][m-1];
			for(int i = 1; i < n; i++)
				dp[i][m-1][2] = dp[i-1][m-1][2] + a[i][m-1];
			for(int j = m - 2; j >= 0; j--)
				dp[0][j][2] = dp[0][j+1][2] + a[0][j];
			for(int i = 1; i < n; i++)
			{
				for(int j = m - 2; j >= 0; j--)
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i][j+1][2]) + a[i][j];
			}
			
			dp[n-1][m-1][3] = a[n-1][m-1];
			for(int i = n-2; i >= 0; i--)
				dp[i][m-1][3] = dp[i+1][m-1][3] + a[i][m-1];
			for(int j = m-2; j >= 0; j--)
				dp[n-1][j][3] = dp[n-1][j+1][3] + a[n-1][j];
			for(int i = n-2; i >= 0; i--)
			{
				for(int j = m-2; j >= 0; j--)
					dp[i][j][3] = Math.max(dp[i+1][j][3], dp[i][j+1][3]) + a[i][j];
			}
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
					System.out.print(dp[i][j][0] + ", ");
				System.out.println();
			}
			System.out.println();
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
					System.out.print(dp[i][j][1] + ", ");
				System.out.println();
			}
			System.out.println();
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
					System.out.print(dp[i][j][2] + ", ");
				System.out.println();
			}
			System.out.println();
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
					System.out.print(dp[i][j][3] + ", ");
				System.out.println();
			}
			System.out.println();
			
			long maxWorkout = 0;
			int x = 0;
			int y = 0;
			for(int i = 1; i < n - 1; i++)
			{
				for(int j = 1; j < m - 1; j++)
				{
					long workout = dp[i][j][0] + dp[i][j][1] + dp[i][j][2] + dp[i][j][3] - 4*a[i][j];
					if(workout > maxWorkout)
					{
						maxWorkout = workout;
						x = i;
						y = j;
					}
				}
			}
			System.out.println(maxWorkout + " " + x + " " + y);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
