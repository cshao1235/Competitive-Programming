import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces626D {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[] numbers = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(numbers);
			long[] differences = new long[5000];
			for(int i = 0; i < n; i++)
			{
				for(int j = i + 1; j < n; j++)
					differences[numbers[j] - numbers[i]]++;
			}
			double total = n*(n - 1)/2;
			long[] numGreater = new long[5001];
			for(int i = 4999; i >= 0; i--)
			{
				numGreater[i] = numGreater[i + 1] + differences[i];
			}
			long win = 0;
			for(int i = 0; i < 5000; i++)
			{
				for(int j = 0; j < 5000; j++)
				{
					if(i + j >= 5000)
						break;
					win += differences[i]*differences[j]*numGreater[i + j + 1];
				}
			}
			//System.out.println(win);
			double prob = ((double) win)/(total*total*total);
			DecimalFormat df = new DecimalFormat("0.0000000000");
			System.out.println(df.format(prob));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
