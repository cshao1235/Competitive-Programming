import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mroute {
	static class Edge
	{
		int to;
		int from;
		int latency;
		int capacity;
		public Edge(int i, int j, int l, int c)
		{
			to = i;
			from = j;
			latency = l;
			capacity = c;
		}
		public String toString()
		{
			return to + "->" + from + " " + latency + " " + capacity;
		}
	}
	static class EdgeComparator implements Comparator<Edge>
	{
		public int compare(Edge e1, Edge e2)
		{
			return e1.capacity - e2.capacity;
		}
	}
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
	/*public static int indexOfMinDistance(int[] distances, boolean[] included)
	{
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int i = 0; i < included.length; i++)
		{
			if(!included[i] && distances[i] < min)
			{
				min = distances[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public static int[] dijkstra(int[][] graph, int source, int v)
	{
		int[] distances = new int[v];
		boolean[] included = new boolean[v];
		for(int i = 0; i < v; i++)
			distances[i] = Integer.MAX_VALUE - 1;
		distances[source] = 0;
		for(int numVertices = 1; numVertices <= v; numVertices++)
		{
			int index = indexOfMinDistance(distances, included);
			included[index] = true;
			for(int i = 0; i < v; i++)
			{
				if(!included[i] && graph[index][i] != 0 && distances[index] != Integer.MAX_VALUE - 1 && distances[index] + graph[index][i] < distances[i])
				{
					distances[i] = distances[index] + graph[index][i];
				}
			}
		}
		return distances;
	}*/
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("mroute.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			int[][] graph = new int[n][n];
			Edge[] edges = new Edge[m];
			for(int k = 0; k < m; k++)
			{
				st = new StringTokenizer(f.readLine());
				int i = Integer.parseInt(st.nextToken()) - 1;
				int j = Integer.parseInt(st.nextToken()) - 1;
				int l = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				edges[k] = new Edge(i, j, l, c);
				graph[i][j] = l;
				graph[j][i] = l;
			}
			f.close();
			Arrays.sort(edges, new EdgeComparator());
			System.out.println(Arrays.toString(edges));
			double minTime = Integer.MAX_VALUE;
			for(int k = 0; k < m; k++)
			{
				int minLatency = dijkstra(graph, 0, n)[n-1][0];
				//System.out.println(minLatency);
				Edge e = edges[k];
				if(minLatency == Integer.MAX_VALUE - 1)
					break;
				double newTime = (double) minLatency + x/e.capacity;
				if(newTime < minTime)
					minTime = newTime;
				graph[e.to][e.from] = 0;
				graph[e.from][e.to] = 0;
			}
			FileWriter fout = new FileWriter("mroute.out");
			fout.write((int) minTime + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
