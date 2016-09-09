import java.io.*;
import java.util.StringTokenizer;

public class Codeforces587A {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int limit = (int) Math.pow(10, 6)*2;
			int[] w = new int[limit + 1];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				w[Integer.parseInt(st.nextToken())]++;
			f.close();
			int sum = 0;
			for(int i = 0; i < limit - 1; i++)
			{
				sum += w[i]%2;
				w[i + 1] += w[i]/2;
			}
			System.out.println(sum);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
