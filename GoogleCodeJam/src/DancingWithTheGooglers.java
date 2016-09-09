import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DancingWithTheGooglers {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("dancing.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				int count = 0; //scores at least 3p - 2
				int couldBeSurprising = 0; //scores >= max(0, 3p - 4)
				int threshold = Math.max(p, 3*p - 4);
				for(int j = 0; j < n; j++)
				{
					int score = Integer.parseInt(st.nextToken());
					if(score >= 3*p - 2)
						count++;
					else if(score >= threshold)
						couldBeSurprising++;
				}
				count += Math.min(couldBeSurprising, s);
				fout.write("Case #" + i + ": " + count + "\n");
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
