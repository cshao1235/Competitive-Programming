import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Paint {
	static class ArrayComparator implements Comparator<int[]>
	{
		public int compare(int[] o1, int[] o2)
		{
			return o1[0] - o2[0];
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("paint.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] positions = new int[2*n][2];
			int head = 0;
			int tail = 0;
			for(int i = 0; i < 2*n; i+=2)
			{
				st = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(st.nextToken());
				String direction = st.nextToken();
				if(direction.charAt(0) == 'R')
				{
					tail = head + a;
					positions[i][0] = head;
					positions[i][1] = 1;
					positions[i + 1][0] = tail;
					positions[i + 1][1] = -1;
				}
				else
				{
					tail = head - a;
					positions[i][0] = tail;
					positions[i][1] = 1;
					positions[i + 1][0] = head;
					positions[i + 1][1] = -1;
				}
				head = tail;
			}
			f.close();
			Arrays.sort(positions, new ArrayComparator());
			int counter = 0;
			int layerCounter = 1;
			//for(int i = 0; i < positions.length; i++)
			//	System.out.println(positions[i][0]);
			//int pos = positions[0][0];
			for(int i = 1; i < positions.length; i++)
			{
				if(layerCounter >= k)
				{
					counter += positions[i][0] - positions[i - 1][0];
					//System.out.println("[" + positions[i - 1][0] + ", " + positions[i][0] + "]");
				}
				layerCounter += positions[i][1];
			}
			//System.out.println(counter);
			FileWriter fout = new FileWriter("paint.out");
			fout.write(counter + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
