import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Distant {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("distant.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			boolean[][] pastures = new boolean[n][n];
			for(int i = 0; i < n; i++)
			{
				String s = f.readLine();
				for(int j = 0; j < n; j++)
				{
					if(s.charAt(j) == '(')
						pastures[i][j] = true;
				}
			}
			f.close();
			int[][] graph = new int[n*n][n*n];
			for(int i = 0; i < n*n; i++)
			{
				for(int j = 0; j < n*n; j++)
				{
					if(i != j)
						graph[i][j] = Integer.MAX_VALUE/2;
				}
			}
			for(int i = 0; i < n*n; i++)
			{
				int x = i/n;
				int y = i%n;
				if(y > 0)
				{
					if(pastures[x][y] == pastures[x][y - 1])
						graph[i][i - 1] = a;
					else
						graph[i][i - 1] = b;
				}
				if(y < n - 1)
				{
					if(pastures[x][y] == pastures[x][y + 1])
						graph[i][i + 1] = a;
					else
						graph[i][i + 1] = b;
				}
				if(x > 0)
				{
					if(pastures[x][y] == pastures[x - 1][y])
						graph[i][i - n] = a;
					else
						graph[i][i - n] = b;
				}
				if(x < n - 1)
				{
					if(pastures[x][y] == pastures[x + 1][y])
						graph[i][i + n] = a;
					else
						graph[i][i + n] = b;
				}
			}
			int[][] shortestPaths = new int[n*n][n*n];
			for(int i = 0; i < n*n; i++)
			{
				for(int j = 0; j < n*n; j++)
					shortestPaths[i][j] = graph[i][j];
			}
			for(int k = 0; k < n*n; k++)
			{
				for(int i = 0; i < n*n; i++)
				{
					for(int j = 0; j < n*n; j++)
					{
						if(shortestPaths[i][j] > shortestPaths[i][k] + shortestPaths[k][j])
							shortestPaths[i][j] = shortestPaths[i][k] + shortestPaths[k][j];
					}
				}
			}
			int max = 0;
			for(int i = 0; i < n*n; i++)
			{
				for(int j = 0; j < n*n; j++)
				{
					if(i == j)
						continue;
					if(shortestPaths[i][j] > max)
						max = shortestPaths[i][j];
				}
			}
			FileWriter fout = new FileWriter("distant.out");
			fout.write(max + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
