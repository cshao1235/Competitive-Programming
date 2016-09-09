import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces586A {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			int[] times = new int[n];
			for(int i = 0; i < n; i++)
				times[i] = Integer.parseInt(st.nextToken());
			f.close();
			int stay = 0;
			for(int i = 0; i < n; i++)
			{
				if(times[i] == 0)
					continue;
				else
				{
					stay++;
					if(i > 0 && times[i - 1] == 1)
						continue;
					else if(i > 1 && times[i - 2] == 1)
						stay++;
				}
			}
			System.out.println(stay);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}
