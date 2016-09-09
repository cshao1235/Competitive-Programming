import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces606B {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x0 = Integer.parseInt(st.nextToken()) - 1;
			int y0 = Integer.parseInt(st.nextToken()) - 1;
			int currentX = x0;
			int currentY = y0;
			//System.out.println(x + " " + y + " " + x0 + " " + y0 + " " + currentX + " " + currentY);
			String directions = f.readLine();
			//System.out.println(directions);
			f.close();
			int[] numCommands = new int[directions.length() + 1];
			boolean[][] visited = new boolean[x][y];
			int sum = 1;
			numCommands[0] = 1;
			visited[x0][y0] = true;
			for(int i = 1; i <= directions.length(); i++)
			{
				char command = directions.charAt(i - 1);
				if(command == 'U' && currentX > 0)
					currentX--;
				else if(command == 'D' && currentX < x - 1)
					currentX++;
				else if(command == 'L' && currentY > 0)
					currentY--;
				else if(command == 'R' && currentY < y - 1)
					currentY++;
				//System.out.println(currentX + " " + currentY);
				if(!visited[currentX][currentY])
				{
					visited[currentX][currentY] = true;
					numCommands[i] = 1;
					sum++;
				}
			}
			numCommands[directions.length()] += x*y - sum;
			StringBuffer s = new StringBuffer("1");
			for(int i = 1; i <= directions.length(); i++)
				s.append(" " + numCommands[i]);
			System.out.println(s.toString());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
