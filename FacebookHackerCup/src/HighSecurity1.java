import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighSecurity1 {
	public static void update(int r, int c, boolean[][] floor, boolean[][] original, int n)
	{
		floor[(r + 1)%2][c] = true;
		floor[r][c] = true;
		int left = c - 1;
		while(left >= 0 && !original[r][left])
		{
			floor[r][left] = true;
			left--;
		}
		int right = c + 1;
		while(right < n && !original[r][right])
		{
			floor[r][right] = true;
			right++;
		}
	}
	public static boolean filled(int n, boolean[][] floor)
	{
		for(int i = 0; i < n; i++)
		{
			if(!floor[0][i])
				return false;
			if(!floor[1][i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("test.txt"));
			FileWriter fout = new FileWriter("high_security_output_1.txt");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				int n = Integer.parseInt(f.readLine());
				boolean[][] floor = new boolean[2][n];
				String s1 = f.readLine();
				String s2 = f.readLine();
				int minCount = 10000;
				for(int i = 0; i < n; i++)
				{
					if(s1.charAt(i) == 'X')
						floor[0][i] = true;
					if(s2.charAt(i) == 'X')
						floor[1][i] = true;
				}
				int limit = 1 << (2*n);
				for(int i = 0; i < limit; i++)
				{
					boolean[][] floor1 = new boolean[2][n];
					for(int j = 0; j < n; j++)
					{
						floor1[0][j] = floor[0][j];
						floor1[1][j] = floor[1][j];
					}
					int count = 0;
					for(int j = 0; j < 2*n; j++)
					{
						if(!floor[j/n][j%n] && ((i >>> j) & 1) == 1)
						{
							count++;
							update(j/n, j%n, floor1, floor, n);
						}
					}
					if(count < minCount && filled(n, floor1))
						minCount = count;
				}
				fout.write("Case #" + num + ": " + minCount + "\n");
				System.out.println("Case #" + num + ": " + minCount);
			}
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
