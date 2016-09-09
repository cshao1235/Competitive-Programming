import java.io.*;
import java.util.StringTokenizer;

public class Codeforces668A {
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[][] original = new int[n][m];
			int[][][] changes = new int[n][m][2];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					changes[i][j][0] = i;
					changes[i][j][1] = j;
				}
			}
			for(int i = 0; i < q; i++) {
				st = new StringTokenizer(f.readLine());
				int t = Integer.parseInt(st.nextToken());
				if(t == 1) {
					int r = Integer.parseInt(st.nextToken()) - 1;
					for(int j = 0; j < m; j++)
						changes[r][j][1] = (changes[r][j][1] + 1)%m;
				}
				else if(t == 2) {
					int c = Integer.parseInt(st.nextToken()) - 1;
					for(int j = 0; j < n; j++)
						changes[j][c][0] = (changes[j][c][0] + 1)%m;
				}
				else {
					int r = Integer.parseInt(st.nextToken()) - 1;
					int c = Integer.parseInt(st.nextToken()) - 1;
					int x = Integer.parseInt(st.nextToken());
					original[changes[r][c][0]][changes[r][c][1]] = x;
				}
			}
			for(int i = 0; i < n; i++) {
				StringBuffer s = new StringBuffer();
				for(int j = 0; j < m; j++) {
					s.append(original[i][j] + " ");
				}
				System.out.println(s.toString().trim());
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
