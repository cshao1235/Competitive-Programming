import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodyJam {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("codyjam.out");
			for(int i = 1; i <= t; i++)
			{
				int n = Integer.parseInt(f.readLine());
				StringTokenizer st = new StringTokenizer(f.readLine());
				StringBuffer output = new StringBuffer("");
				long[] prices = new long[2*n];
				for(int j = 0; j < 2*n; j++)
					prices[j] = Long.parseLong(st.nextToken());
				//Arrays.sort(prices);
				boolean[] alreadyUsed = new boolean[2*n];
				for(int j = 0; j < 2*n; j++)
				{
					if(alreadyUsed[j])
						continue;
					alreadyUsed[j] = true;
					output.append(prices[j] + " ");
					long regularPrice = prices[j]/3*4;
					int index = Arrays.binarySearch(prices, regularPrice);
					if(index < 0)
					{
						System.out.println(prices[j] + " " + regularPrice + " " + index);
						System.out.println(Arrays.toString(prices));
						//System.out.println(Arrays.toString(alreadyUsed));
					}
					while(prices[index] == regularPrice)
						index--;
					index++;
					while(alreadyUsed[index])
						index++;
					alreadyUsed[index] = true;
				}
				System.out.println("Case #" + i + ": " + output.toString().trim());
				fout.write("Case #" + i + ": " + output.toString().trim() + "\n");
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
