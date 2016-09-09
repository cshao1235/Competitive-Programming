import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Fuel {
	static class ArrayComparator implements Comparator<long[]>
	{
		public int compare(long[] o1, long[] o2)
		{
			if(o1[0] > o2[0])
				return 1;
			return -1;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("paint.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			long[][] stations = new long[n][2];
			for(int i = 0; i < n; i++)
			{
				int pos = Integer.parseInt(st.nextToken());
				int price = Integer.parseInt(st.nextToken());
				stations[i][0] = pos;
				stations[i][1] = price;
			}
			f.close();
			Arrays.sort(stations, new ArrayComparator());
			FileWriter fout = new FileWriter("paint.out");
			fout.write("");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
