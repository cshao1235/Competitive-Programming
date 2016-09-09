import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces586B {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[][] horizontal = new int[2][n - 1];
			int[] vertical = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n - 1; i++)
				horizontal[0][i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n - 1; i++)
				horizontal[1][i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				vertical[i] = Integer.parseInt(st.nextToken());
			int[] bottomDistance = new int[n];
			bottomDistance[n - 1] = 0;
			for(int i = n - 2; i >= 0; i--)
				bottomDistance[i] = bottomDistance[i + 1] + horizontal[1][i];
			int[] topDistance = new int[n];
			topDistance[0] = 0;
			for(int i = 1; i < n; i++)
				topDistance[i] = topDistance[i - 1] + horizontal[0][i - 1];
			int[] totalDistance = new int[n];
			for(int i = 0; i < n; i++)
				totalDistance[i] = topDistance[i] + vertical[i] + bottomDistance[i];
			Arrays.sort(totalDistance);
			int minTrip = totalDistance[0] + totalDistance[1];
			//System.out.println(Arrays.toString(horizontal[0]));
			//System.out.println(Arrays.toString(horizontal[1]));
			//System.out.println(Arrays.toString(bottomDistance));
			//System.out.println(Arrays.toString(topDistance));
			//System.out.println(Arrays.toString(totalDistance));
			System.out.println(minTrip);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
