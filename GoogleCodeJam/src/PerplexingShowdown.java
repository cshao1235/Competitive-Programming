import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PerplexingShowdown {
	public static String alphabetical(int n, int r, int p, int s, char[] order) {
		if(n == 1 && (r == 2 || p == 2 || s == 2))
			return "IMPOSSIBLE";
		if(n == 2 && (r == 0 || p == 0 || s == 0))
			return "IMPOSSIBLE";
		String str = "";
		if(n == 1) {
			if(r == 1 && p == 1) {
				if(order[0] == 'R')
					str = "RP";
				else
					str = "PR";
			}
			else if(r == 1 && s == 1) {
				if(order[0] == 'S')
					str = "SR";
				else
					str = "RS";
			}
			else {
				if(order[0] == 'S')
					str = "SP";
				else
					str = "PS";
			}
		}
		else {
			if(r == 2) {
				if(order[0] == 'P')
					str = "PRRS";
				else if(order[0] == 'R')
					str = "RSRP";
				else
					str = "SRPR";
			}
			else if(p == 2) {
				if(order[0] == 'P')
					str = "PRPS";
				else if(order[0] == 'R')
					str = "RPSP";
				else
					str = "SPPR";
			}
			else {
				if(order[0] == 'P')
					str = "PSRS";
				else if(order[0] == 'R')
					str = "RSSP";
				else
					str = "SPSR";
			}
		}
		return str;
	}
	public static String result(int n, int r, int p, int s, char[] order) {
		if(n == 1 || n == 2)
			return alphabetical(n, r, p, s, order);
		int a = ((int) Math.pow(2, n - 2));
		if(p < a || r < a || s < a)
			return "IMPOSSIBLE";
		char[] newOrder = new char[3];
		newOrder[0] = order[2];
		newOrder[1] = order[0];
		newOrder[2] = order[1];
		//System.out.println(Arrays.toString(newOrder));
		String str = result(n - 2, s - a, r - a, p - a, newOrder);
		if(str.equals("IMPOSSIBLE"))
			return "IMPOSSIBLE";
		StringBuffer output = new StringBuffer();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'R')
				output.append(alphabetical(2, 1, 1, 2, order));
			else if(str.charAt(i) == 'S')
				output.append(alphabetical(2, 1, 2, 1, order));
			else
				output.append(alphabetical(2, 2, 1, 1, order));
		}
		return output.toString();
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("perplexingshowdown.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				char[] order = {'P', 'R', 'S'};
				String output = result(n, r, p, s, order);
				fout.write("Case #" + i + ": " + output + "\n");
				System.out.println("Case #" + i + ": " + output);
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
