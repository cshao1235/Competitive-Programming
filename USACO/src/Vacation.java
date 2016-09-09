import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Vacation {
	private static final long MAX = 1000000000L;
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("vacation.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			long[][] graph = new long[n][n];
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(i != j)
						graph[i][j] = MAX;
				}
			}
			for(int i = 0; i < m; i++)
			{
				st = new StringTokenizer(f.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());
				graph[u][v] = d;
			}
			for(int a = 0; a < n; a++)
			{
				for(int i = 0; i < n; i++)
				{
					for(int j = 0; j < n; j++)
					{
						if(graph[i][j] > graph[i][a] + graph[a][j])
							graph[i][j] = graph[i][a] + graph[a][j];
					}
				}
			}
			FileWriter fout = new FileWriter("vacation.out");
			long sum = 0;
			long numPossible = 0;
			for(int i = 0; i < q; i++)
			{
				st = new StringTokenizer(f.readLine());
				int to = Integer.parseInt(st.nextToken()) - 1;
				int from = Integer.parseInt(st.nextToken()) - 1;
				long minCost = MAX*10;
				for(int j = 0; j < k; j++)
				{
					if(graph[to][j] + graph[j][from] < minCost)
						minCost = graph[to][j] + graph[j][from];
				}
				if(minCost < MAX)
				{
					numPossible++;
					sum += minCost;
				}
			}
			fout.write(numPossible + "\n");
			fout.write(sum + "");
			f.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
