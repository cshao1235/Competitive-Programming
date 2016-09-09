import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces615D {
	private static long MOD = ((long) Math.pow(10, 9)) + 7;
	public static long fastExp(long n, long exp, long mod)
	{
		long result = 1;
		String s = Long.toBinaryString(exp);
		for(int i = 0; i < s.length(); i++)
		{
			result = (result * result)%mod;
			if(s.charAt(i) == '1')
				result = (result * n)%mod;
		}
		return result;
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int m = Integer.parseInt(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			int[] primeDivisors = new int[m];
			for(int i = 0; i < m; i++)
				primeDivisors[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(primeDivisors);
			//int counter = 0;
			int primeCounter = 0;
			long n = 1;
			long exp = 1;
			int[] primePowers = new int[m];
			for(int i = 0; i < m; i++)
			{
				primePowers[primeCounter]++;
				if((i != (m - 1)) && (primeDivisors[i + 1] != primeDivisors[i]))
					primeCounter++;
			}
			boolean perfectSquare = true;
			for(int i = 0; i <= primeCounter; i++)
			{
				if(primePowers[i] % 2 == 1)
				{
					perfectSquare = false;
					break;
				}
			}
			if(perfectSquare)
			{
				for(int i = 0; i < m; i += 2)
					n = (n * primeDivisors[i])%MOD;
				for(int i = 0; i <= primeCounter; i++)
					exp = (exp * (primePowers[i] + 1)) % (MOD - 1);
			}
			else
			{
				for(int i = 0; i < m; i++)
					n = (n * primeDivisors[i])%MOD;
				boolean divided = false;
				for(int i = 0; i <= primeCounter; i++)
				{
					if(!divided && (primePowers[i]%2 == 1))
					{
						exp = (exp * ((primePowers[i] + 1)/2)) % (MOD - 1);
						divided = true;
					}
					else
						exp = (exp * (primePowers[i] + 1)) % (MOD - 1);
				}
			}
			//System.out.println(primeCounter);
			//System.out.println(primePowers[0] + " " + primePowers[1]);
			//System.out.println(n + " " + exp);
			System.out.println(fastExp(n, exp, MOD));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
