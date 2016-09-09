import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoogolString {
	public static boolean isZero(long n, long k)
	{
		long length = (long) Math.pow(2, n - 1);
		if(k == length)
			return true;
		if(k < length)
			return isZero(n - 1, k);
		long distance = k - length;
		return !isZero(n - 1, length - distance);
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("googolstring.out");
			for(int i = 1; i <= t; i++)
			{
				long k = Long.parseLong(f.readLine());
				long n = (long) (Math.log(k + 1)/Math.log(2)) + 1;
				int output = 1;
				if(isZero(n, k))
					output = 0;
				fout.write("Case #" + i + ": " + output + "\n");
			}
			f.close();
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
