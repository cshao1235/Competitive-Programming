import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Codeforces416C {
	static class ArrayComparator implements Comparator<int[]>
	{
		public int compare(int[] o1, int[] o2)
		{
			if(o1[0] != o2[0])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		}
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[][] orders = new int[n][3];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				orders[i][0] = Integer.parseInt(st.nextToken());
				orders[i][1] = Integer.parseInt(st.nextToken());
				orders[i][2] = i + 1;
			}
			Arrays.sort(orders, new ArrayComparator());
			boolean[] seated = new boolean[n];
			int k = Integer.parseInt(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			int[][] tables = new int[k][3];
			for(int i = 0; i < k; i++)
			{
				tables[i][0] = Integer.parseInt(st.nextToken());
				int min = 0;
				int max = n;
				int med = 0;
				boolean found = false;
				while(min < max)
				{
					med = (min + max)/2;
					if(orders[med][0] <= tables[i][0])
					{
						tables[i][1] = orders[med][1];
						tables[i][2] = orders[med][2];
						found = true;
						min = med + 1;
					}
					else
						max = med - 1;
				}
				if(found)
					seated[tables[i][2]] = true;
			}
			//Arrays.sort(tables, new ArrayComparator());
			f.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
