import java.io.*;
import java.util.StringTokenizer;

public class Codeforces680A {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int[] count = new int[101];
			int sum = 0;
			for(int i = 0; i < 5; i++) {
				int a = Integer.parseInt(st.nextToken());
				sum += a;
				count[a]++;
			}
			int max = 0;
			for(int i = 1; i <= 100; i++) {
				if(count[i] >= 3)
				{
					int n = 3*i;
					if(n > max)
						max = n;
				}
				else if(count[i] == 2)
				{
					int n = 2*i;
					if(n > max)
						max = n;
				}
			}
			System.out.println(sum - max);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
