import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yachtzee {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("yachtzee.txt"));
			FileWriter fout = new FileWriter("yachtzee_output.txt");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				long a = Long.parseLong(st.nextToken());
				long b = Long.parseLong(st.nextToken());
				long[] c = new long[n + 1];
				long sum = 0;
				double ev = 0.0;
				st = new StringTokenizer(f.readLine());
				for(int i = 1; i <= n; i++)
				{
					sum += Long.parseLong(st.nextToken());
					c[i] = sum;
				}
				//if(num == 40)
				//	System.out.println(Arrays.toString(c));
				long aResidue = a%sum;
				long bResidue = b%sum;
				if(bResidue == 0)
					bResidue += sum;
				long[] intervals = new long[n];
				int startInterval = 0;
				int endInterval = 0;
				for(int i = 0; i < n; i++)
				{
					if(c[i] <= aResidue && c[i + 1] > aResidue)
					{
						startInterval = i;
						break;
					}
				}
				for(int i = 0; i < n; i++)
				{
					if(c[i] < bResidue && c[i + 1] >= bResidue)
					{
						endInterval = i;
						break;
					}
				}
				if((startInterval != endInterval) || (aResidue > bResidue))
				{
					ev += ((double) c[startInterval + 1] - aResidue)/(b - a)*(0.5)*(c[startInterval + 1] + aResidue - 2*c[startInterval]);
					ev += ((double) bResidue - c[endInterval])/(b - a)*(0.5)*(bResidue - c[endInterval]);
					int counter = (startInterval + 1)%n;
					while(counter != endInterval)
					{
						intervals[counter] += c[(counter + 1)%n] - c[counter];
						counter = (counter + 1)%n;
					}
				}
				else
				{
					//System.out.println("ASDF");
					ev += ((double) bResidue - aResidue)*(0.5)*(bResidue + aResidue - 2*c[startInterval])/(b - a);
				}
				//System.out.println(ev);
				for(int i = 0; i < n; i++)
				{
					intervals[i] += (c[i + 1] - c[i])*((b - bResidue - a + aResidue)/sum);
				}
				//System.out.println(ev);
				//System.out.println(Arrays.toString(c));
				//System.out.println(Arrays.toString(intervals));
				for(int i = 0; i < n; i++)
				{
					ev += ((double) intervals[i])*(0.5)*(c[i + 1] - c[i])/(b - a);
				}
				DecimalFormat df = new DecimalFormat("#########0.000000000");
				System.out.println("Case #" + num + ": " + df.format(ev));
				fout.write("Case #" + num + ": " + df.format(ev) + "\n");
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
