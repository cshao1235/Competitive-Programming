import java.io.*;
import java.util.StringTokenizer;

public class Codeforces668B {
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int oddDiff = 0;
			int evenDiff = 0;
			for(int i = 0; i < q; i++) {
				st = new StringTokenizer(f.readLine());
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) {
					int x = Integer.parseInt(st.nextToken());
					oddDiff = (oddDiff + x + n)%n;
					evenDiff = (evenDiff + x + n)%n;
				}
				else {
					if(oddDiff%2 == 0) {
						oddDiff = (oddDiff + 1)%n;
						evenDiff = (evenDiff - 1 + n)%n;
					}
					else {
						oddDiff = (oddDiff - 1 + n)%n;
						evenDiff = (evenDiff + 1)%n;
					}
				}
			}
			int[] girls = new int[n];
			for(int i = 1; i <= n; i++) {
				if(i%2 == 1)
					girls[(i + oddDiff)%n] = i;
				else
					girls[(i + evenDiff)%n] = i;
			}
			StringBuffer s = new StringBuffer();
			for(int i = 1; i < n; i++)
				s.append(girls[i] + " ");
			s.append(girls[0]);
			System.out.println(s.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
