import java.io.*;
import java.util.StringTokenizer;

public class Codeforces321A {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String s = f.readLine();
			int[][] positions = new int[s.length() + 1][2];
			for(int i = 0; i < s.length(); i++)
			{
				positions[i + 1][0] = positions[i][0];
				positions[i + 1][1] = positions[i][1];
				if(s.charAt(i) == 'U')
					positions[i + 1][1]++;
				else if(s.charAt(i) == 'D')
					positions[i + 1][1]--;
				else if(s.charAt(i) == 'L')
					positions[i + 1][0]--;
				else
					positions[i + 1][0]++;
			}
			int dx = positions[s.length()][0];
			int dy = positions[s.length()][1];
			boolean good = false;
			//System.out.println(dx + " " + dy);
			if(dx == 0 && dy == 0)
			{
				for(int i = 0; i < s.length(); i++)
				{
					if(a == positions[i][0] && b == positions[i][1])
					{
						good = true;
						break;
					}
				}
			}
			else if(dx == 0 && dy != 0)
			{
				for(int i = 0; i < s.length(); i++)
				{
					int totaldy = b - positions[i][1];
					if(a == positions[i][0] && totaldy % dy == 0 && totaldy/dy >= 0)
					{
						good = true;
						break;
					}
				}
			}
			else if(dx != 0 && dy == 0)
			{
				for(int i = 0; i < s.length(); i++)
				{
					int totaldx = a - positions[i][0];
					if(b == positions[i][1] && totaldx % dx == 0 && totaldx/dx >= 0)
					{
						good = true;
						break;
					}
				}
			}
			else {
				for(int i = 0; i < s.length(); i++)
				{
					int totaldx = a - positions[i][0];
					int totaldy = b - positions[i][1];
					if(totaldx % dx == 0 && totaldx/dx >= 0)
					{
						if(totaldy % dy == 0 && totaldy/dy == totaldx/dx)
						{
							good = true;
							break;
						}
					}
				}
			}
			if(good)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
