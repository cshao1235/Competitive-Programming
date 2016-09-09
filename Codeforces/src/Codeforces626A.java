import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces626A {
	public static int index(char c)
	{
		if(c == 'U')
			return 0;
		if(c == 'D')
			return 1;
		if(c == 'R')
			return 2;
		return 3;
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			String s = f.readLine();
			int[][] commands = new int[n + 1][4];
			//commands[0][index(s.charAt(0))] = 1;
			for(int i = 1; i <= n; i++)
			{
				int index = index(s.charAt(i - 1));
				for(int j = 0; j < 4; j++)
				{
					if(j == index)
						commands[i][j] = commands[i - 1][j] + 1;
					else
						commands[i][j] = commands[i - 1][j];
				}
			}
			int count = 0;
			for(int i = 0; i <= n; i++)
			{
				for(int j = i + 1; j <= n; j++)
				{
					int up = commands[j][0] - commands[i][0];
					int down = commands[j][1] - commands[i][1];
					int right = commands[j][2] - commands[i][2];
					int left = commands[j][3] - commands[i][3];
					if((up == down) && (right == left))
						count++;
				}
			}
			System.out.println(count);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
