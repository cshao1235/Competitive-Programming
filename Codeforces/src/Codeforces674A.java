import java.io.*;
import java.util.StringTokenizer;

public class Codeforces674A {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			StringTokenizer st = new StringTokenizer(f.readLine());
			int[] t = new int[n];
			for(int i = 0; i < n; i++)
				t[i] = Integer.parseInt(st.nextToken()) - 1;
			int[] intervals = new int[n];
			for(int left = 0; left < n; left++) {
				int[] colorCount = new int[n];
				int dominantColor = t[left];
				int dominantColorCount = 0;
				for(int right = left; right < n; right++) {
					int newColor = t[right];
					colorCount[newColor]++;
					if(colorCount[newColor] > dominantColorCount) {
						dominantColor = newColor;
						dominantColorCount = colorCount[newColor];
					}
					else if(colorCount[newColor] == dominantColorCount && newColor < dominantColor) {
						dominantColor = newColor;
					}
					intervals[dominantColor]++;
				}
			}
			StringBuffer s = new StringBuffer();
			for(int i = 0; i < n; i++) {
				s.append(intervals[i] + " ");
			}
			String output = s.toString().trim();
			System.out.println(output);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
