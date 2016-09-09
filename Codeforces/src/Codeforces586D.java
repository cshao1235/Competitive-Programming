import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces586D {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			for(int i = 0; i < t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				boolean[][] isTrain = new boolean[3][n + 3];
				boolean[][] reachable = new boolean[3][n + 3];
				for(int j = 0; j < 3; j++)
				{
					String s = f.readLine();
					for(int l = 0; l < n; l++)
					{
						if(s.charAt(l) == 's')
							reachable[j][l] = true;
						else if(s.charAt(l) != '.')
							isTrain[j][l] = true;
					}
				}
				for(int j = 0; j < n; j+=3)
				{
					if(reachable[0][j])
					{
						if(!isTrain[0][j + 1])
						{
							if(!isTrain[0][j + 2] && !isTrain[0][j + 3])
								reachable[0][j + 3] = true;
							if(!isTrain[1][j + 1] && !isTrain[1][j + 2] && !isTrain[1][j + 3])
								reachable[1][j + 3] = true;
						}
					}
					if(reachable[1][j])
					{
						if(!isTrain[1][j + 1])
						{
							if(!isTrain[1][j + 2] && !isTrain[1][j + 3])
								reachable[1][j + 3] = true;
							if(!isTrain[0][j + 1] && !isTrain[0][j + 2] && !isTrain[0][j + 3])
								reachable[0][j + 3] = true;
							if(!isTrain[2][j + 1] && !isTrain[2][j + 2] && !isTrain[2][j + 3])
								reachable[2][j + 3] = true;
						}
					}
					if(reachable[2][j])
					{
						if(!isTrain[2][j + 1])
						{
							if(!isTrain[2][j + 2] && !isTrain[2][j + 3])
								reachable[2][j + 3] = true;
							if(!isTrain[1][j + 1] && !isTrain[1][j + 2] && !isTrain[1][j + 3])
								reachable[1][j + 3] = true;
						}
					}
				}
				boolean possible = false;
				for(int j = n; j <= n + 2; j++)
				{
					for(int l = 0; l < 3; l++)
					{
						if(reachable[l][j])
						{
							possible = true;
							break;
						}
					}
				}
				if(possible)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
