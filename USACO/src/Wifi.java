import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wifi {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("wifi.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] positions = new int[n];
			for(int i = 0; i < n; i++)
				positions[i] = Integer.parseInt(f.readLine());
			f.close();
			Arrays.sort(positions);
			double[] minCost = new double[n];
			minCost[0] = a;
			for(int i = 1; i < n; i++)
			{
				minCost[i] = a + b*((double) positions[i] - positions[0])/2.0;
				for(int j = 1; j <= i; j++)
				{
					double newCost = minCost[j - 1] + a + b*((double) positions[i] - positions[j])/2.0;
					if(newCost < minCost[i])
						minCost[i] = newCost;
				}
			}
			FileWriter fout = new FileWriter("wifi.out");
			System.out.println(minCost[n-1]);
			if(((long) (minCost[n-1]*2))%2 == 1)
				fout.write(minCost[n-1] + "");
			else
				fout.write(((long) minCost[n-1]) + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
