import java.io.*;
import java.util.StringTokenizer;

public class Codeforces678D {
	private static final long MOD = (long) Math.pow(10, 9) + 7;
	public static long[][] matrixMult(int a, int b, int c, long[][] m1, long[][] m2) {
		long[][] output = new long[a][c];
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < c; j++) {
				for(int k = 0; k < b; k++) {
					output[i][j] = (output[i][j] + m1[i][k]*m2[k][j])%MOD;
				}
			}
		}
		return output;
	}
	public static long[][] matrixExponent(int n, long[][] m, long exp) {
		String s = Long.toBinaryString(exp);
		long[][] output = {{1, 0},
		                   {0, 1}};
		for(int i = 0; i < s.length(); i++) {
			output = matrixMult(n, n, n, output, output);
			if(s.charAt(i) == '1')
				output = matrixMult(n, n, n, output, m);
		}
		return output;
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long n = Long.parseLong(st.nextToken());
			long x = Long.parseLong(st.nextToken());
			long[][] matrix = new long[2][2];
			matrix[0][0] = a;
			matrix[0][1] = b;
			matrix[1][0] = 0;
			matrix[1][1] = 1;
			long[][] matrixExp = matrixExponent(2, matrix, n);
			long[][] vector = new long[2][1];
			vector[0][0] = x;
			vector[1][0] = 1;
			long output = matrixMult(2, 2, 1, matrixExp, vector)[0][0];
			System.out.println(output);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
