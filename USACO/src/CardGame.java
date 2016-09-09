/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
*/
import java.io.*;
import java.util.Arrays;

public class CardGame {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("cardgame.in"));
			int n = Integer.parseInt(f.readLine());
			boolean[] allCards = new boolean[2*n];
			int[] elsie1 = new int[n/2];
			int[] elsie2 = new int[n/2];
			int[] bessie1 = new int[n/2];
			int[] bessie2 = new int[n/2];
			for(int i = 0; i < n/2; i++)
			{
				int c = Integer.parseInt(f.readLine()) - 1;
				allCards[c] = true;
				elsie1[i] = c;
			}
			for(int i = 0; i < n/2; i++)
			{
				int c = Integer.parseInt(f.readLine()) - 1;
				allCards[c] = true;
				elsie2[i] = c;
			}
			Arrays.sort(elsie1);
			Arrays.sort(elsie2);
			//System.out.println(Arrays.toString(elsie1));
			//System.out.println(Arrays.toString(elsie2));
			int bCounter = 0;
			for(int i = 0; i < 2*n; i++)
			{
				if(!allCards[i])
				{
					if(bCounter < n/2)
						bessie2[bCounter] = i;
					else
						bessie1[bCounter - n/2] = i;
					bCounter++;
				}
			}
			//System.out.println(Arrays.toString(bessie1));
			//System.out.println(Arrays.toString(bessie2));
			f.close();
			int points = 0;
			int eCounter1 = 0;
			int bCounter1 = 0;
			while(eCounter1 < n/2 && bCounter1 < n/2)
			{
				if(bessie1[bCounter1] > elsie1[eCounter1])
				{
					points++;
					//System.out.println(bessie1[bCounter1] + " " + elsie1[eCounter1]);
					eCounter1++;
				}
				bCounter1++;
			}
			eCounter1 = n/2 - 1;
			bCounter1 = n/2 - 1;
			while(eCounter1 >= 0 && bCounter1 >= 0)
			{
				if(bessie2[bCounter1] < elsie2[eCounter1])
				{
					points++;
					//System.out.println(bessie2[bCounter1] + " " + elsie2[eCounter1]);
					eCounter1--;
				}
				bCounter1--;
			}
			FileWriter fout = new FileWriter("cardgame.out");
			fout.write(points + "\n");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
