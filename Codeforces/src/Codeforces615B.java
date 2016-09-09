import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Codeforces615B {
	static class ArrayComparator implements Comparator<int[]>
	{
		public int compare(int[] o1, int[] o2)
		{
			return o1[0] - o2[0];
		}
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] segments = new int[m][2];
			int[] numSpines = new int[n];
			for(int i = 0; i < m; i++)
			{
				st = new StringTokenizer(f.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;
				numSpines[u]++;
				numSpines[v]++;
				if(u > v)
				{
					segments[i][0] = v;
					segments[i][1] = u;
				}
				else
				{
					segments[i][0] = u;
					segments[i][1] = v;
				}
			}
			f.close();
			Arrays.sort(segments, new ArrayComparator());
			int[] maxLength = new int[n];
			for(int i = 0; i < m; i++)
			{
				if(maxLength[segments[i][1]] < maxLength[segments[i][0]] + 1)
					maxLength[segments[i][1]] = maxLength[segments[i][0]] + 1;
			}
			long maxBeauty = 0;
			for(int i = 0; i < n; i++)
			{
				long beauty = ((long) maxLength[i] + 1)*(numSpines[i]);
				if(beauty > maxBeauty)
					maxBeauty = beauty;
			}
			System.out.println(maxBeauty);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
