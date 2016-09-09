import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces553B {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			long k = Long.parseLong(st.nextToken()) - 1;
			f.close();
			StringBuffer permutation = new StringBuffer("");
			long[] fibonacci = new long[n + 1];
			fibonacci[1] = 1;
			for(int i = 2; i <= n; i++)
				fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			int current = 1;
			int counter = n;
			while(counter > 0)
			{
				if(k < fibonacci[counter])
				{
					permutation.append(current + " ");
					current++;
					counter--;
				}
				else
				{
					permutation.append((current + 1) + " " + current + " ");
					k -= fibonacci[counter];
					current += 2;
					counter -= 2;
				}
				//System.out.println(permutation.toString().trim());
			}
			System.out.println(permutation.toString().trim());
			//System.out.println(Arrays.toString(binary));
			//System.out.println(Arrays.toString(groups));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
