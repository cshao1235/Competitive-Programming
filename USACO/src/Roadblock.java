import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Roadblock {
	static class Pair implements Comparable<Pair>
	{
		int index;
		int distance;
		public Pair(int i, int d)
		{
			index = i;
			distance = d;
		}
		@Override
		public int compareTo(Pair o)
		{
			return distance - o.distance;
		}
	}
	private static PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
	public static int indexOfMinDistance(int[][] distances, boolean[] included)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < included.length; i++)
		{
			if(!included[i] && distances[i][0] < min)
			{
				min = distances[i][0];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public static int[][] dijkstra(int[][] graph, int source, int v)
	{
		int[][] distances = new int[v][2];
		boolean[] included = new boolean[v];
		for(int i = 0; i < v; i++)
			distances[i][0] = Integer.MAX_VALUE - 1;
		queue.add(new Pair(source, 0));
		distances[source][0] = 0;
		long a = System.currentTimeMillis();
		while(!queue.isEmpty())
		{
			int index = queue.remove().index;
			included[index] = true;
			for(int i = 0; i < v; i++)
			{
				if(!included[i] && graph[index][i] != 0 && distances[index][0] != Integer.MAX_VALUE - 1)
				{
					if(distances[index][0] + graph[index][i] < distances[i][0])
					{
						distances[i][0] = distances[index][0] + graph[index][i];
						distances[i][1] = index;
						queue.add(new Pair(i, distances[i][0]));
					}
				}
			}
		}
		long b = System.currentTimeMillis();
		System.out.println(b - a);
		return distances;
	}
	/*public static int indexOfMinDistance(int[][] distances, boolean[] included)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < included.length; i++)
		{
			if(!included[i] && distances[i][0] < min)
			{
				min = distances[i][0];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public static int[][] dijkstra(int[][] graph, int source, int v)
	{
		int[][] distances = new int[v][2];
		boolean[] included = new boolean[v];
		for(int i = 0; i < v; i++)
			distances[i][0] = Integer.MAX_VALUE - 1;
		distances[source][0] = 0;
		long a = System.currentTimeMillis();
		for(int numVertices = 1; numVertices <= v; numVertices++)
		{
			int index = indexOfMinDistance(distances, included);
			included[index] = true;
			for(int i = 0; i < v; i++)
			{
				if(!included[i] && graph[index][i] != 0 && distances[index][0] != Integer.MAX_VALUE - 1 && distances[index][0] + graph[index][i] < distances[i][0])
				{
					distances[i][0] = distances[index][0] + graph[index][i];
					distances[i][1] = index;
				}
			}
		}
		long b = System.currentTimeMillis();
		System.out.println(b - a);
		return distances;
	}*/
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("rblock.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] graph = new int[n][n];
			for(int i = 0; i < m; i++)
			{
				st = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int l = Integer.parseInt(st.nextToken());
				graph[a][b] = l;
				graph[b][a] = l;
			}
			f.close();
			int[][] originalDijkstra = dijkstra(graph, 0, n);
			int originalShortestPath = originalDijkstra[n-1][0];
			int maxDifference = 0;
			int start = n-1;
			while(start != 0)
			{
				int newStart = originalDijkstra[start][1];
				int[][] graph1 = new int[n][n];
				for(int i = 0; i < n; i++)
				{
					for(int j = 0; j < n; j++)
						graph1[i][j] = graph[i][j];
				}
				graph1[newStart][start] = graph1[newStart][start]*2;
				graph1[start][newStart] = graph1[start][newStart]*2;
				int[][] newDijkstra = dijkstra(graph1, 0, n);
				int newShortestPath = newDijkstra[n-1][0];
				//for(int i = 0; i < n; i++)
				//		System.out.println(newDijkstra[i][0] + " " + newDijkstra[i][1]);
				//System.out.println();
				if(newShortestPath - originalShortestPath > maxDifference)
					maxDifference = newShortestPath - originalShortestPath;
				start = newStart;
			}
			//for(int i = 0; i < n; i++)
			//	System.out.println(originalDijkstra[i][0] + " " + originalDijkstra[i][1]);
			FileWriter fout = new FileWriter("rblock.out");
			fout.write(maxDifference + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
