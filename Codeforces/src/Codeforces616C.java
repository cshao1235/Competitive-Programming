import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces616C {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean[][] grid = new boolean[n][m];
			for(int i = 0; i < n; i++)
			{
				String s = f.readLine();
				for(int j = 0; j < m; j++)
				{
					if(s.charAt(i) == '.')
						grid[i][j] = true;
				}
			}
			f.close();
			int[][] connected = new int[n][m];
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
