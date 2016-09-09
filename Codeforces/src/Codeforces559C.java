import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces559C {
	private static final long MOD = (long) Math.pow(10, 9) + 7;
	private static final int MAX = 100000;
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[][] black = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(f.readLine());
				black[i][0] = Integer.parseInt(st.nextToken()) - 1;
				black[i][1] = Integer.parseInt(st.nextToken()) - 1;
			}
			long[][] numWays = new long[MAX][2];
			numWays[0][0] = 1;
			for(int i = 1; i < h + w - 1; i++)
			{
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
