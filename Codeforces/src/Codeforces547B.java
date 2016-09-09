import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces547B {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());
			f.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
