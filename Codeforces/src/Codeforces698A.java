import java.io.*;
import java.util.*;

public class Codeforces698A {
	private static final int MAX = 1000000;
	public static int min3(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			int[][] minDays = new int[n + 1][3];
			for(int i = 1; i <= n; i++) {
				minDays[i][0] = min3(minDays[i - 1][0] + 1, minDays[i - 1][1] + 1, minDays[i - 1][2] + 1);
				if(a[i - 1] == 1 || a[i - 1] == 3)
					minDays[i][1] = Math.min(minDays[i - 1][0], minDays[i - 1][2]);
				else
					minDays[i][1] = MAX;
				if(a[i - 1] == 2 || a[i - 1] == 3)
					minDays[i][2] = Math.min(minDays[i - 1][0], minDays[i - 1][1]);
				else
					minDays[i][2] = MAX;
			}
			System.out.println(min3(minDays[n][0], minDays[n][1], minDays[n][2]));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
