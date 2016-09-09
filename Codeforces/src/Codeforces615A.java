import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces615A {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean[] flipped = new boolean[m];
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(f.readLine());
				int x = Integer.parseInt(st.nextToken());
				for(int j = 0; j < x; j++)
				{
					int y = Integer.parseInt(st.nextToken()) - 1;
					flipped[y] = true;
				}
			}
			boolean good = true;
			for(int i = 0; i < m; i++)
			{
				if(!flipped[i])
				{
					good = false;
					break;
				}
			}
			if(good)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
