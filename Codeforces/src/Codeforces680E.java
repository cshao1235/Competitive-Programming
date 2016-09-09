import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Codeforces680E {
	private static int[][] colorGrid;
	private static int n;
	private static int[] componentSize;
	static class Pair {
		int r;
		int c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public ArrayList<Pair> neighbors() {
			ArrayList<Pair> output = new ArrayList<Pair>();
			if(r > 0)
				output.add(new Pair(r - 1, c));
			if(r < n - 1)
				output.add(new Pair(r + 1, c));
			if(c > 0)
				output.add(new Pair(r, c - 1));
			if(c < n - 1)
				output.add(new Pair(r, c + 1));
			return output;
		}
	}
	public static void bfs(boolean[][] grid) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!grid[i][j])
					colorGrid[i][j] = -1;
			}
		}
		int color = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(colorGrid[i][j] != 0)
					continue;
				Pair p = new Pair(i, j);
				colorGrid[i][j] = color;
				componentSize[color]++;
				q.offer(p);
				while(!q.isEmpty()) {
					Pair next = q.poll();
					ArrayList<Pair> neighbors = next.neighbors();
					for(int k = 0; k < neighbors.size(); k++) {
						Pair neighbor = neighbors.get(k);
						if(colorGrid[neighbor.r][neighbor.c] == 0) {
							q.offer(neighbor);
							componentSize[color]++;
							colorGrid[neighbor.r][neighbor.c] = color;
						}
					}
				}
				color++;
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			boolean[][] grid = new boolean[n][n];
			componentSize = new int[(n*n/2) + 10];
			colorGrid = new int[n][n];
			for(int i = 0; i < n; i++) {
				String s = f.readLine();
				for(int j = 0; j < n; j++) {
					if(s.charAt(j) == '.')
						grid[i][j] = true;
				}
			}
			bfs(grid);
			//System.out.println("A");
			int max = 0;
			int maxI = 0;
			int maxJ = 0;
			for(int i = 0; i <= n - k; i++) {
				for(int j = 0; j <= n - k; j++) {
					HashSet<Integer> adjacentComponents = new HashSet<Integer>();
					//boolean[] adjacentComponents = new boolean[componentSize.length];
					int newComponentSize = 0;
					int up = i - 1;
					int left = j - 1;
					int right = j + k;
					int down = i + k;
					if(up >= 0) {
						for(int c = j; c < right; c++) {
							if(colorGrid[up][c] > 0) {
								adjacentComponents.add(colorGrid[up][c]);
							}
						}
					}
					if(down < n) {
						for(int c = j; c < right; c++) {
							if(colorGrid[down][c] > 0) {
								//adjacentComponents[colorGrid[down][c]] = true;
								adjacentComponents.add(colorGrid[down][c]);
							}
						}
					}
					if(left >= 0) {
						for(int r = i; r < down; r++) {
							if(colorGrid[r][left] > 0) {
								//adjacentComponents[colorGrid[r][left]] = true;
								adjacentComponents.add(colorGrid[r][left]);
							}
						}
					}
					if(right < n) {
						for(int r = i; r < down; r++) {
							if(colorGrid[r][right] > 0) {
								//adjacentComponents[colorGrid[r][right]] = true;
								adjacentComponents.add(colorGrid[r][right]);
							}
						}
					}
					/*for(int l = 0; l < adjacentComponents.length; l++) {
						if(adjacentComponents[l]) {
							newComponentSize += componentSize[l];
						}
					}*/
					Iterator<Integer> it = adjacentComponents.iterator();
					while(it.hasNext()) {
						newComponentSize += componentSize[it.next()];
					}
					//System.out.println(i + " " + j + " " + newComponentSize);
					for(int r = i; r < down; r++) {
						for(int c = j; c < right; c++) {
							int clr = colorGrid[r][c];
							if(clr == -1)
								newComponentSize++;
							else if(!adjacentComponents.contains(clr))
								newComponentSize++;
							//else if(!adjacentComponents[clr])
						}
					}
					if(newComponentSize > max) {
						max = newComponentSize;
						//maxI = i;
						//maxJ = j;
						/*System.out.println(maxI + " " + maxJ + " A");
						for(int l = 0; l < adjacentComponents.length; l++) {
							if(adjacentComponents[l]) {
								System.out.print(l + " ");
							}
						}
						System.out.println();*/
					}
				}
				//System.out.println(i);
			}
			//for(int i = 0; i < n; i++)
			//	System.out.println(Arrays.toString(colorGrid[i]));
			//System.out.println(max + " " + maxI + " " + maxJ);
			System.out.println(max);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
