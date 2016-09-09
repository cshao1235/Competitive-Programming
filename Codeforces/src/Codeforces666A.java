import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Codeforces666A {
	/*private static HashSet<String> h = new HashSet<String>();
	public static void solve(String s, int current, int last)
	{
		String lastRemoved = s.substring(current, last);
		if(current - 2 > 4 && !s.substring(current - 2, current).equals(lastRemoved))
		{
			h.add(s.substring(current - 2, current));
			solve(s, current - 2, current);
		}
		if(current - 3 > 4 && !s.substring(current - 3, current).equals(lastRemoved))
		{
			h.add(s.substring(current - 3, current));
			solve(s, current - 3, current);
		}
	}*/
	private static HashMap<String, Integer> h = new HashMap<String, Integer>();
	public static void add(String s, int current)
	{
		if(current - 2 > 4)
		{
			String added = s.substring(current - 2, current);
			if(!h.containsKey(added))
				h.put(added, 0);
			h.put(added, h.get(added) + 1);
			add(s, current - 2);
		}
		if(current - 3 > 4)
		{
			String added = s.substring(current - 3, current);
			if(!h.containsKey(added))
				h.put(added, 0);
			h.put(added, h.get(added) + 1);
			add(s, current - 3);
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			String s = f.readLine();
			add(s, s.length());
			/*solve(s, s.length(), s.length());
			System.out.println(h.size());
			String[] output = h.toArray(new String[0]);
			//System.out.println(output.length);
			Arrays.sort(output);
			for(int i = 0; i < output.length; i++)
				System.out.println(output[i]);*/
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
