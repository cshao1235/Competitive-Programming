import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Trapped {
	static class ArrayComparator implements Comparator<int[]>
	{
		public int compare(int[] o1, int[] o2)
		{
			return o1[1] - o2[1];
		}
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("trapped.in"));
			int n = Integer.parseInt(f.readLine());
			int[][] bales = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				bales[i][0] = Integer.parseInt(st.nextToken());
				bales[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(bales, new ArrayComparator());
			int sum = 0;
			for(int i = 0; i < n-1; i++)
			{
				int head = i;
				int tail = i+1;
				boolean good = false;
				while(head >= 0 && tail < n)
				{
					good = false;
					int d = bales[tail][1] - bales[head][1];
					if(bales[head][0] < d)
					{
						good = true;
						head--;
					}
					if(bales[tail][0] < d)
					{
						good = true;
						tail++;
					}
					if(!good)
						break;
				}
				if(!good)
					sum += bales[i+1][1] - bales[i][1];
			}
			System.out.println(sum);
			FileWriter fout = new FileWriter("trapped.out");
			fout.write(sum+"");
			fout.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
