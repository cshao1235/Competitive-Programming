import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DataPacking {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("datapacking.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int[] discs = new int[n];
				st = new StringTokenizer(f.readLine());
				for(int j = 0; j < n; j++)
					discs[j] = Integer.parseInt(st.nextToken());
				Arrays.sort(discs);
				boolean[] alreadyUsed = new boolean[n];
				int numDiscs = 0;
				for(int j = n - 1; j >= 0; j--)
				{
					if(alreadyUsed[j])
						continue;
					for(int k = j - 1; k >= 0; k--)
					{
						if(!alreadyUsed[k] && discs[j] + discs[k] <= x)
						{
							alreadyUsed[k] = true;
							break;
						}
					}
					alreadyUsed[j] = true;
					numDiscs++;
				}
				System.out.println("Case #" + i + ": " + numDiscs);
				fout.write("Case #" + i + ": " + numDiscs + "\n");
			}
			f.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


	}

}
