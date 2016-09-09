import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boomerang {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("boomerang_constellations.txt"));
			FileWriter fout = new FileWriter("boomerang_constellations_output.txt");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				int n = Integer.parseInt(f.readLine());
				int[][] points = new int[n][2];
				for(int i = 0; i < n; i++)
				{
					StringTokenizer st = new StringTokenizer(f.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					points[i][0] = x;
					points[i][1] = y;
				}
				long count = 0;
				for(int i = 0; i < n; i++)
				{
					int px = points[i][0];
					int py = points[i][1];
					long[] distances = new long[n];
					for(int j = 0; j < n; j++)
					{
						long dx = px - points[j][0];
						long dy = py - points[j][1];
						distances[j] = dx*dx + dy*dy;
					}
					Arrays.sort(distances);
					int same = 1;
					for(int j = 0; j < n - 1; j++)
					{
						if(distances[j] != distances[j + 1])
						{
							count += (same*(same - 1))/2;
							same = 1;
						}
						else
							same++;
					}
					count += (same*(same - 1))/2;
				}
				fout.write("Case #" + num + ": " + count + "\n");
				System.out.println("Case #" + num + ": " + count);
			}
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
