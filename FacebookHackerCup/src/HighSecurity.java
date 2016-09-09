import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HighSecurity {
	public static void update(int r, int c, boolean[][] floor, int n)
	{
		floor[(r + 1)%2][c] = true;
		floor[r][c] = true;
		int left = c - 1;
		while(left >= 0 && !floor[r][left])
		{
			floor[r][left] = true;
			left--;
		}
		int right = c + 1;
		while(right < n && !floor[r][right])
		{
			floor[r][right] = true;
			right++;
		}
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("high_security.txt"));
			FileWriter fout = new FileWriter("high_security_output.txt");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				int n = Integer.parseInt(f.readLine());
				boolean[][] floor = new boolean[2][n];
				String s1 = f.readLine();
				String s2 = f.readLine();
				int count = 0;
				for(int i = 0; i < n; i++)
				{
					if(s1.charAt(i) == 'X')
						floor[0][i] = true;
					if(s2.charAt(i) == 'X')
						floor[1][i] = true;
				}
				if(n == 1)
				{
					if(floor[0][0] && floor[1][0])
						count = 0;
					else
						count = 1;
				}
				else
				{
					if(!floor[0][0] && floor[0][1] && !floor[1][0])
					{
						count++;
						update(1, 0, floor, n);
					}
					if(!floor[1][0] && floor[1][1] && !floor[0][0])
					{
						count++;
						update(0, 0, floor, n);
					}
					if(!floor[0][n - 1] && floor[0][n - 2] && !floor[1][n - 1])
					{
						count++;
						update(1, n - 1, floor, n);
					}
					if(!floor[1][n - 1] && floor[1][n - 2] && !floor[0][n - 1])
					{
						count++;
						update(0, n - 1, floor, n);
					}
					for(int i = 1; i < n - 1; i++)
					{
						if(!floor[0][i] && floor[0][i + 1] && floor[0][i - 1] && !floor[1][i])
						{
							count++;
							update(1, i, floor, n);
						}
						if(!floor[1][i] && floor[1][i + 1] && floor[1][i - 1] && !floor[0][i])
						{
							count++;
							update(0, i, floor, n);
						}
					}
					for(int i = 0; i < n; i++)
					{
						if(!floor[0][i])
						{
							count++;
							update(0, i, floor, n);
						}
						if(!floor[1][i])
						{
							count++;
							update(1, i, floor, n);
						}
					}
				}
				fout.write("Case #" + num + ": " + count + "\n");
				System.out.println("Case #" + num + ": " + count);
			}
			fout.close();
			f.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
