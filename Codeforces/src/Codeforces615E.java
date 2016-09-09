import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces615E {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			long n = Long.parseLong(f.readLine());
			if(n == 0)
				System.out.println(0 + " " + 0);
			else if(n == 1)
				System.out.println(1 + " " + 2);
			else if(n == 2)
				System.out.println(-1 + " " + 2);
			else if(n == 3)
				System.out.println(-2 + " " + 0);
			else if(n == 4)
				System.out.println(-1 + " " + -2);
			else if(n == 5)
				System.out.println(1 + " " + -2);
			else if(n == 6)
				System.out.println(2 + " " + 0);
			else
			{
				f.close();
				long r = (long) Math.sqrt(n/3);
				while(3*r*(r + 1) < n)
					r++;
				//System.out.println(r);
				n -= 3*(r - 1)*(r);
				if(n == 6*r)
					System.out.println(2*r + " " + 0);
				else
				{
					//System.out.println(n);
					long x = 0;
					long y = 0;
					if(n/r == 0)
					{
						x = 2*r;
						y = 0;
						x -= n%r;
						y += 2*(n%r);
					}
					else if(n/r == 1)
					{
						x = r;
						y = 2*r;
						x -= 2*(n%r);
					}
					else if(n/r == 2)
					{
						x = -r;
						y = 2*r;
						x -= (n%r);
						y -= 2*(n%r);
					}
					else if(n/r == 3)
					{
						x = -2*r;
						y = 0;
						x += (n%r);
						y -= 2*(n%r);
					}
					else if(n/r == 4)
					{
						x = -r;
						y = -2*r;
						x += 2*(n%r);
					}
					else
					{
						x = r;
						y = -2*r;
						x += (n%r);
						y += 2*(n%r);
					}
					System.out.println(x + " " + y);
				}
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
