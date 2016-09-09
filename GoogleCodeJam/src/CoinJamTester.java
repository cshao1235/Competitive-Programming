import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinJamTester {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("coinjam.out"));
			f.readLine();
			boolean bad = false;
			for(int i = 0; i < 500; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				String s = st.nextToken();
				for(int b = 2; b <= 10; b++)
				{
					int divisor = Integer.parseInt(st.nextToken());
					int num = 0;
					for(int j = 0; j < s.length(); j++)
						num = ((b*num) + (s.charAt(j) - '0'))%(divisor);
					if(num != 0)
						bad = true;
					System.out.println("Line " + i + ", base " + b + ": " + num);
				}
			}
			System.out.println(bad);
			f.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
