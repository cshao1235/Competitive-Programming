import java.io.*;
import java.util.*;

public class Codeforces704A {

	public static void main(String[] args) {
		try {
			long a = System.currentTimeMillis();
			BufferedReader f = new BufferedReader(new FileReader("test.txt"));
			//BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] lastSighted = new int[n];
			int[][] notifs = new int[q][2];
			for(int i = 0; i < n; i++) {
				lastSighted[i] = -1;
			}
			for(int i = 0; i < q; i++) {
				notifs[i][1] = -1;
			}
			int notifCounter = 0;
			int type3 = 0;
			int unread = 0;
			for(int i = 0; i < q; i++) {
				st = new StringTokenizer(f.readLine());
				int type = Integer.parseInt(st.nextToken());
				if(type == 1) {
					int x = Integer.parseInt(st.nextToken()) - 1;
					notifs[notifCounter][1] = lastSighted[x];
					notifs[notifCounter][0] = 1;
					lastSighted[x] = notifCounter;
					unread++;
					notifCounter++;
					System.out.println(unread);
				}
				else if(type == 2) {
					int x = Integer.parseInt(st.nextToken()) - 1;
					int current = lastSighted[x];
					if(current >= 0 && notifs[current][0] == 1) {
						notifs[current][0] = 0;
						unread--;
						current = notifs[current][1];
						while(current >= 0 && notifs[current][0] == 1) {
							current = notifs[current][1];
							unread--;
						}
					}
					System.out.println(unread);
				}
				else {
					int t = Integer.parseInt(st.nextToken());
					for(int j = type3; j < t; j++) {
						if(notifs[j][0] == 1) {
							notifs[j][0] = 0;
							unread--;
						}
					}
					if(t > type3)
						type3 = t;
					System.out.println(unread);
				}
			}
			long b = System.currentTimeMillis();
			System.out.println(b - a);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
