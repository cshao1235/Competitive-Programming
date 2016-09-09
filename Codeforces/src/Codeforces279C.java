import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces279C {
	public static void main(String[] args)
	{
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());
			int[][] peaks = new int[2][n]; //0 is first peak to the right, 1 is the first peak to the left
			int currentRightPeak = n - 1;
			int currentRight = a[n - 1];
			peaks[0][n - 1] = currentRightPeak;
			for(int i = n - 2; i >= 0; i--)
			{
				if(a[i] > currentRight)
					currentRightPeak = i;
				currentRight = a[i];
				peaks[0][i] = currentRightPeak;
			}
			int currentLeftPeak = 0;
			int currentLeft = a[0];
			peaks[1][0] = currentLeftPeak;
			for(int i = 1; i < n; i++)
			{
				if(a[i] > currentLeft)
					currentLeftPeak = i;
				currentLeft = a[i];
				peaks[1][i] = currentLeftPeak;
			}
			//System.out.println(Arrays.toString(peaks[0]));
			//System.out.println(Arrays.toString(peaks[1]));
			for(int j = 0; j < m; j++)
			{
				st = new StringTokenizer(f.readLine());
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				if(peaks[0][l] >= peaks[1][r])
					System.out.println("Yes");
				else
					System.out.println("No");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
