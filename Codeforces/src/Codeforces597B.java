import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Codeforces597B {
	static class ArrayComparator implements Comparator<int[]> {
		public int compare(int[] o1, int[] o2)
		{
			return o1[1] - o2[1];
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[][] orders = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				orders[i][0] = Integer.parseInt(st.nextToken());
				orders[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(orders, new ArrayComparator());
			int num = 0;
			int currentTime = -1;
			for(int i = 0; i < n; i++)
			{
				if(orders[i][0] > currentTime)
				{
					currentTime = orders[i][1];
					num++;
				}
			}
			System.out.println(num);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
