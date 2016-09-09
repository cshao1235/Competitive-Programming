import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces626B {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			String s = f.readLine();
			int[] colors = new int[3];
			for(int i = 0; i < n; i++)
			{
				if(s.charAt(i) == 'B')
					colors[0]++;
				else if(s.charAt(i) == 'G')
					colors[1]++;
				else
					colors[2]++;
			}
			if(colors[0] > 0 && colors[1] > 0 && colors[2] > 0)
				System.out.println("BGR");
			else
			{
				if(colors[0] > 1 && colors[1] > 1)
					System.out.println("BGR");
				else if(colors[0] > 1 && colors[2] > 1)
					System.out.println("BGR");
				else if(colors[1] > 1 && colors[2] > 1)
					System.out.println("BGR");
				else if(colors[0] > 1)
				{
					if(colors[1] == 1 || colors[2] == 1)
						System.out.println("GR");
					else
						System.out.println("B");
				}
				else if(colors[1] > 1)
				{
					if(colors[0] == 1 || colors[2] == 1)
						System.out.println("BR");
					else
						System.out.println("G");
				}
				else if(colors[2] > 1)
				{
					if(colors[0] == 1 || colors[1] == 1)
						System.out.println("BG");
					else
						System.out.println("R");
				}
				else if(colors[0] == 1)
				{
					if(colors[1] == 1)
						System.out.println("R");
					else if(colors[2] == 1)
						System.out.println("G");
					else
						System.out.println("B");
				}
				else if(colors[1] == 1)
				{
					if(colors[2] == 1)
						System.out.println("B");
					else
						System.out.println("G");
				}
				else if(colors[2] == 1)
				{
					System.out.println("R");
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
