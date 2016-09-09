import java.io.*;
import java.util.StringTokenizer;

public class Codeforces680B {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()) - 1;
			st = new StringTokenizer(f.readLine());
			int[] t = new int[n];
			for(int i = 0; i < n; i++)
				t[i] = Integer.parseInt(st.nextToken());
			int sum = t[a];
			for(int i = 0; i < n; i++)
			{
				if(i == a)
					continue;
				int d = a - i;
				if(a + d >= 0 && a + d < n) {
					int numCriminals = t[i] + t[a + d];
					if(numCriminals%2 == 0)
						sum += t[i];
				}
				else {
					sum += t[i];
				}
			}
			System.out.println(sum);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
