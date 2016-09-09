import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces540D {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			double[][][][] probabilities = new double[101][101][101][3];
			for(int i = 1; i <= 100; i++)
			{
				probabilities[i][0][0][0] = 1.0;
				probabilities[0][i][0][1] = 1.0;
				probabilities[0][0][i][2] = 1.0;
			}
			for(int i = 1; i <= 100; i++)
			{
				for(int j = 1; j <= 100; j++)
				{
					probabilities[i][j][0][0] = 1.0;
					probabilities[0][i][j][1] = 1.0;
					probabilities[j][0][i][2] = 1.0;
				}
			}
			for(int i = 1; i <= 100; i++)
			{
				for(int j = 1; j <= 100; j++)
				{
					for(int k = 1; k <= 100; k++)
					{
						//probabilities[i][j][k] = (r*(r - 1) + s*(s - 1) + p*(p - 1))probabilitiies[i][j][k]/(i + j + k)/(i + j + k - 1)
						// + 
						for(int l = 0; l < 3; l++)
						{
							int sum = i + j + k;
							double denominator = 0.5*(sum*(sum - 1) - i*(i - 1) - j*(j - 1) - k*(k - 1));
							probabilities[i][j][k][l] += (probabilities[i-1][j][k][l]*i*k + probabilities[i][j - 1][k][l]*j*i + 
									probabilities[i][j][k - 1][l]*k*j)/denominator;
						}
					}
				}
			}
			System.out.println(probabilities[r][s][p][0] + " " + probabilities[r][s][p][1] + " " + probabilities[r][s][p][2]);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
