import java.io.*;
import java.util.*;

public class Codeforces698B {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken()) - 1;
			int root = -1;
			int numChanges = 0;
			for(int i = 0; i < n; i++) {
				if(a[i] == i)
					root = i;
			}
			if(root == -1) {
				boolean[] visited = new boolean[n];
				visited[0] = true;
				int current = 0;
				while(!visited[a[current]]) {
					visited[a[current]] = true;
					current = a[current];
				}
				a[current] = current;
				numChanges++;
				root = current;
			}
			int[] component = new int[n];
			component[root] = 1;
			int color = 1;
			for(int i = 0; i < n; i++) {
				if(component[i] == 0) {
					color++;
					int current = i;
					component[current] = color;
					while(component[a[current]] == 0) {
						component[a[current]] = color;
						current = a[current];
					}
					if(component[a[current]] == color) {
						a[current] = root;
						numChanges++;
					}
				}
			}
			System.out.println(numChanges);
			StringBuffer s = new StringBuffer("");
			for(int i = 0; i < n; i++) {
				s.append((a[i] + 1) + " ");
			}
			System.out.println(s.toString().trim());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
