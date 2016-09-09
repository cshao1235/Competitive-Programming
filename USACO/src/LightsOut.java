import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class LightsOut {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("lightsout.in"));
			int n = Integer.parseInt(f.readLine());
			int[][] points = new int[n][2];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			boolean[][][] dp = new boolean[n][n][n];
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
