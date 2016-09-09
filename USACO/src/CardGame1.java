import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class CardGame1 {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("cardgame.in"));
			int n = Integer.parseInt(f.readLine());
			boolean[] allCards = new boolean[2*n];
			int[] elsie = new int[n];
			int[] elsie1 = new int[n];
			int[] bessie = new int[n];
			for(int i = 0; i < n; i++)
			{
				int c = Integer.parseInt(f.readLine()) - 1;
				allCards[c] = true;
				elsie[i] = c;
				elsie1[i] = c;
			}
			Arrays.sort(elsie1);
			//System.out.println(Arrays.toString(elsie1));
			//System.out.println(Arrays.toString(elsie2));
			int bCounter = 0;
			for(int i = 0; i < 2*n; i++)
			{
				if(!allCards[i])
				{
					bessie[bCounter] = i;
					bCounter++;
				}
			}	
			//System.out.println(Arrays.toString(bessie1));
			//System.out.println(Arrays.toString(bessie2));
			f.close();
			//int[] dp = new int[2*n + 1];
			int points = 0;
			int eCounter1 = 0;
			int bCounter1 = 0;
			while(eCounter1 < n && bCounter1 < n)
			{
				if(elsie1[eCounter1] < bessie[bCounter1])
				{
					points++;
					eCounter1++;
				}
				bCounter1++;
			}
			//dp[2*n] = points;
			int points1 = 0;
			eCounter1 = n - 1;
			bCounter1 = n - 1;
			while(eCounter1 >= n && bCounter1 >= n)
			{
				if(elsie1[eCounter1] > bessie[bCounter1])
				{
					points1++;
					eCounter1--;
				}
				bCounter1--;
			}
			int max = Math.max(points, points1);
			for(int i = n - 1; i >= 1; i--)
			{
				int[] e = new int[i];
				int[] b = new int[n - i];
				
			}
			FileWriter fout = new FileWriter("cardgame.out");
			fout.write(max + "\n");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
