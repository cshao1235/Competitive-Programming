import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PriceIsCorrect {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("the_price_is_correct.txt"));
			FileWriter fout = new FileWriter("the_price_is_correct_output.out");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				long p = Long.parseLong(st.nextToken());
				long[] boxes = new long[n];
				st = new StringTokenizer(f.readLine());
				for(int i = 0; i < n; i++)
					boxes[i] = Long.parseLong(st.nextToken());
				long count = 0;
				int head = 0;
				int tail = 0;
				long sum = 0;
				while(head < n)
				{
					while(tail < n && sum + boxes[tail] <= p)
					{
						sum += boxes[tail];
						tail++;
					}
					count += tail - head;
					sum -= boxes[head];
					head++;
				}
				fout.write("Case #" + num + ": " + count + "\n");
			}
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
