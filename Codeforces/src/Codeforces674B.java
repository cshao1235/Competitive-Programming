import java.io.*;
import java.util.StringTokenizer;

public class Codeforces674B {
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(n == 4 || k < n + 1) {
				System.out.println(-1);
			}
			else {
				StringBuffer s = new StringBuffer();
				for(int i = 1; i <= n; i++) {
					if(i == a || i == b || i == c || i == d)
						continue;
					s.append(i + " ");
				}
				String v = a + " " + c + " " + s.toString() + d + " " + b;
				String u = c + " " + a + " " + s.toString() + b + " " + d;
				System.out.println(v);
				System.out.println(u);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
