import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces586C {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			long[][] children = new long[n][3];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				children[i][0] = Long.parseLong(st.nextToken());
				children[i][1] = Long.parseLong(st.nextToken());
				children[i][2] = Long.parseLong(st.nextToken());
			}
			f.close();
			//int counter = 0;
			//boolean[] ranAway = new boolean[n];
			long ranVolume = 0;
			int numTreated = 0;
			StringBuffer s = new StringBuffer("");
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
			{
				children[i][2] -= ranVolume;
				if(children[i][2] < 0)
				{
					ranVolume += children[i][1];
					continue;
				}
				else
				{
					numTreated++;
					s.append((i + 1) + " ");
					for(int j = 1; j <= Math.min(children[i][0], n - 1 - i); j++)
						children[i + j][2] -= children[i][0] - j + 1;
				}
			}
			String s1 = s.toString().trim();
			System.out.println(numTreated);
			System.out.println(s1);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}
