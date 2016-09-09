import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces623B {
	public static long gcd(long a, long b)
	{
		if(b == 0)
			return a;
		return gcd(b%a, a);
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[] numbers = new int[n];
			long[][][] dp = new long[n][2][9];
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			f.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
