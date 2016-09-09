import java.io.*;
import java.util.StringTokenizer;

public class Codeforces225C {
	private static final int INF = (int) Math.pow(10, 9);
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			boolean[][] grid = new boolean[n][m];
			for(int i = 0; i < n; i++)
			{
				String s = f.readLine();
				for(int j = 0; j < m; j++)
				{
					if(s.charAt(j) == '#')
						grid[i][j] = true;
				}
			}
			int[][] changes = new int[m][2]; //0 to change to all '.', 1 to change to all '#'
			for(int j = 0; j < m; j++)
			{
				int count = 0;
				for(int i = 0; i < n; i++)
				{
					if(grid[i][j])
						count++;
				}
				changes[j][0] = count;
				changes[j][1] = n - count;
			}
			int[][] prefix = new int[m + 1][2];
			prefix[1][0] = changes[0][0];
			prefix[1][1] = changes[0][1];
			for(int j = 2; j <= m; j++)
			{
				prefix[j][0] = prefix[j - 1][0] + changes[j - 1][0];
				prefix[j][1] = prefix[j - 1][1] + changes[j - 1][1];
			}
			int[][] minChanges = new int[m + 1][2]; //0 is min changes and end in '.', 1 is min changes and end in '#'
			for(int j = 1; j <= m; j++)
			{
				minChanges[j][0] = INF;
				minChanges[j][1] = INF;
			}
			for(int j = 1; j <= m; j++)
			{
				for(int k = Math.max(0, j - y); k <= j - x; k++)
				{
					minChanges[j][0] = Math.min(minChanges[j][0], minChanges[k][1] + prefix[j][0] - prefix[k][0]);
					minChanges[j][1] = Math.min(minChanges[j][1], minChanges[k][0] + prefix[j][1] - prefix[k][1]);
				}
			}
			int output = Math.min(minChanges[m][0], minChanges[m][1]);
			System.out.println(output);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
