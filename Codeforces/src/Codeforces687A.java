import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Codeforces687A {
	public static int[] bfs(int n, ArrayList<ArrayList<Integer>> graph) {
		int[] colors = new int[n + 1];
		for(int i = 0; i < n; i++)
			colors[i] = -1;
		for(int i = 0; i < n; i++) {
			if(colors[i] != -1)
				continue;
			colors[i] = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(i);
			while(!q.isEmpty()) {
				int v = q.poll();
				ArrayList<Integer> neighbors = graph.get(v);
				for(int j = 0; j < neighbors.size(); j++) {
					int next = neighbors.get(j);
					if(colors[next] == -1) {
						colors[next] = 1 - colors[v];
						q.offer(next);
					}
					else if(colors[next] == colors[v]) {
						colors[n] = -1;
						return colors;
					}
				}
			}
		}
		return colors;
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < n; i++)
				graph.add(new ArrayList<Integer>());
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(f.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				graph.get(to).add(from);
				graph.get(from).add(to);
			}
			int[] colors = bfs(n, graph);
			if(colors[n] == -1)
				System.out.println("-1");
			else {
				int color0 = 0;
				int color1 = 0;
				StringBuffer c0 = new StringBuffer("");
				StringBuffer c1 = new StringBuffer("");
				for(int i = 0; i < n; i++) {
					if(colors[i] == 0) {
						color0++;
						c0.append((i + 1) + " ");
					}
					else {
						color1++;
						c1.append((i + 1) + " ");
					}
				}
				System.out.println(color0);
				System.out.println(c0.toString().trim());
				System.out.println(color1);
				System.out.println(c1.toString().trim());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
