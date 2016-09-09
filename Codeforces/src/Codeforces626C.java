import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces626C {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int highest2 = 2*n;
			int highest3 = 3*m;
			int overlaps = Math.min(highest2, highest3)/6;
			while(overlaps > 0)
			{
				if(highest2 <= highest3)
				{
					if(highest2 % 6 != 4)
						overlaps--;
					highest2 += 2;
				}
				else
				{
					overlaps--;
					highest3 += 3;
				}
			}
			System.out.println(Math.max(highest2, highest3));
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
