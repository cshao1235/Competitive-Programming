import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FortMoo {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("fortmoo.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			boolean[][] field = new boolean[n][m];
			for(int i = 0; i < n; i++)
			{
				String s = f.readLine();
				for(int j = 0; j < m; j++)
				{
					if(s.charAt(j) == 'X')
						field[i][j] = true;
				}
			}
			f.close();
			int[][][] distance = new int[n][m][4]; //0 is up, 1 is right, 2 is down, 3 is left
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
				{
					distance[i][j][0] = i;
					distance[i][j][2] = n - i - 1;
					distance[i][j][1] = m - j - 1;
					distance[i][j][3] = j;
				}
			}
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
				{
					if(field[i][j])
					{
						int counter = 1;
						while(i - counter >= 0 && !field[i - counter][j])
						{
							distance[i - counter][j][2] = counter - 1;
							counter++;
						}
						counter = 1;
						while(j + counter < m && !field[i][j + counter])
						{
							distance[i][j + counter][3] = counter - 1;
							counter++;
						}
						counter = 1;
						while(i + counter < n && !field[i + counter][j])
						{
							distance[i + counter][j][0] = counter - 1;
							counter++;
						}
						counter = 1;
						while(j - counter >= 0 && !field[i][j - counter])
						{
							distance[i][j - counter][1] = counter - 1;
							counter++;
						}
					}
				}
			}
			int maxArea = 0;
			/*for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
				{
					System.out.println(i + " " + j + " " + Arrays.toString(distance[i][j]));
				}
			}*/
			for(int x1 = 0; x1 < n; x1++)
			{
				for(int y1 = 0; y1 < m; y1++)
				{
					if(field[x1][y1])
						continue;
					for(int x2 = x1 + distance[x1][y1][2]; x2 >= x1; x2--)
					{
						for(int y2 = y1 + distance[x1][y1][1]; y2 >= y1; y2--)
						{
							if(field[x2][y2] || (x2 - x1 + 1)*(y2 - y1 + 1) <= maxArea)
								continue;
							if(distance[x2][y2][3] >= y2 - y1)
							{
								if(distance[x2][y2][0] >= x2 - x1)
								{
									int area = (x2 - x1 + 1)*(y2 - y1 + 1);
									if(area > maxArea)
									{
										maxArea = area;
										//System.out.println(x1 + " " + y1 + ", " + x2 + " " + y2);
									}
								}
							}
						}
					}
				}
			}
			FileWriter fout = new FileWriter("fortmoo.out");
			//System.out.println(maxArea);
			fout.write(maxArea + "\n");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
