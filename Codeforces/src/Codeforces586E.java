import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Codeforces586E {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			ArrayList<Long> moves = new ArrayList<Long>();
			long x1 = x;
			long y1 = y;
			if(x > y)
				moves.add((long) 0);
			boolean possible = true;
			while(x1 != 1 && y1 != 1)
			{
				if(x1 == 0 && y1 != 1)
				{
					System.out.println("Impossible");
					possible = false;
					break;
				}
				else if(y1 == 0 && x1 != 1)
				{
					System.out.println("Impossible");
					possible = false;
					break;
				}
				if(x1 < y1)
				{
					moves.add(y1/x1);
					y1 = y1%x1;
				}
				else
				{
					moves.add(x1/y1);
					x1 = x1%y1;
				}
			}
			if(possible)
			{
				if(moves.size()%2 == 1)
					moves.add((long) 0);
				long[] fruits = new long[4];
				fruits[0] = 1;
				fruits[3] = 1;
				for(int i = moves.size() - 1; i >= 0; i--)
				{
					if(i%2 == 1)
					{
						
					}
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}
