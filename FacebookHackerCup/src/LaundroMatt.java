import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LaundroMatt {
	public static long maxFinished(long time, long[] w)
	{
		long output = 0;
		for(int i = 0; i < w.length; i++)
			output += time/w[i];
		return output;
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			FileWriter fout = new FileWriter("laundro_matt_output_1.txt");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				long l = Long.parseLong(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				long m = Long.parseLong(st.nextToken());
				long d = Long.parseLong(st.nextToken());
				long[] w = new long[n];
				st = new StringTokenizer(f.readLine());
				for(int i = 0; i < n; i++)
					w[i] = Long.parseLong(st.nextToken());
				long min = 0;
				long max = (long) Math.pow(10, 14);
				long med = (min + max)/2;
				while(min < max)
				{
					med = (min + max)/2;
					long a = maxFinished(med, w);
					if(a >= l)
						max = med;
					else
						min = med + 1;
				}
				long[] startDryTimes = new long[(int) l + n];
				for(int i = 0; i < l + n; i++)
					startDryTimes[i] = Long.MAX_VALUE - (long) Math.pow(10, 13);
				int sCounter = 0;
				for(int i = 0; i < n; i++)
				{
					for(int j = 1; j <= min/w[i]; j++)
					{
						startDryTimes[sCounter] = w[i]*j;
						sCounter++;
					}
				}
				Arrays.sort(startDryTimes);
				//System.out.println(Arrays.toString(startDryTimes));
				long[] endDryTimes = new long[(int) l];
				int currentlyUsed = 0;
				sCounter = 0;
				int endHead = 0;
				//int endTail = 0;
				long currentTime = 0;
				for(int i = 0; i < l; i++)
				{
					currentTime = Math.max(currentTime, startDryTimes[i]);
					while(endHead != i && endDryTimes[endHead] <= currentTime)
					{
						endHead++;
						currentlyUsed--;
					}
					if(currentlyUsed == m)
					{
						currentTime = endDryTimes[endHead];
						endHead++;
						currentlyUsed--;
					}
					endDryTimes[i] = currentTime + d;
					currentlyUsed++;
				}
				//System.out.println(min + " " + maxFinished(min, w));
				//System.out.println(endDryTimes[(int) l - 1]);
				long output = endDryTimes[(int) l - 1];
				System.out.println("Case #" + num + ": " + output);
				fout.write("Case #" + num + ": " + output + "\n");
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
