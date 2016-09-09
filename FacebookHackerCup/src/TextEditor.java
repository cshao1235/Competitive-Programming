import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TextEditor {
	private static final int MAX = 100000000;
	static class Node
	{
		String key;
		ArrayList<Node> children;
		public Node(String key)
		{
			this.key = key;
			children = new ArrayList<Node>();
		}
		public void addChild(Node child)
		{
			for(int i = 0; i < children.size(); i++)
			{
				Node n = children.get(i);
				if(n.key.length() == 0)
					continue;
				String prefix = commonPrefix(n.key, child.key);
				if(prefix.length() == n.key.length())
				{
					child.key = child.key.substring(prefix.length());
					if(n.children.size() == 0)
						n.children.add(new Node(""));
					n.addChild(child);
					return;
				}
				else if(prefix.length() != 0)
				{
					n.key = n.key.substring(prefix.length());
					child.key = child.key.substring(prefix.length());
					Node p = new Node(prefix);
					p.children.add(n);
					p.children.add(child);
					children.remove(i);
					children.add(p);
					return;
				}
			}
			children.add(child);
		}
		public int[] cost(int k) //
		{
			if(children.size() == 0)
			{
				int[] output = new int[k + 1];
				for(int i = 2; i <= k; i++)
					output[i] = MAX;
				output[1] = key.length();
				return output;
			}
			else
			{
				int[][] dp = new int[children.size() + 1][k + 1];
				for(int i = 0; i <= children.size(); i++)
				{
					for(int j = 0; j <= k; j++)
						dp[i][j] = MAX;
				}
				dp[0][0] = 0;
				for(int i = 1; i <= children.size(); i++)
				{
					int[] a = children.get(i - 1).cost(k);
					for(int j = 0; j <= k; j++)
					{
						for(int l = 0; l <= k - j; l++)
						{
							int sum = dp[i - 1][j] + a[l];
							if(sum < dp[i][j + l])
								dp[i][j + l] = sum;
						}
					}
				}
				for(int j = 1; j <= k; j++)
					dp[children.size()][j] += key.length();
				//System.out.println(key + " " + Arrays.toString(dp[children.size()]));
				return dp[children.size()];
			}
		}
		public void print()
		{
			System.out.println(key + ": " + children.toString());
			for(int i = 0; i < children.size(); i++)
				children.get(i).print();
		}
		public String toString()
		{
			return key;
		}
	}
	public static String commonPrefix(String s1, String s2)
	{
		int counter = 0;
		int min = Math.min(s1.length(), s2.length());
		while(counter < min)
		{
			if(s1.charAt(counter) != s2.charAt(counter))
				return s1.substring(0, counter);
			counter++;
		}
		return s1.substring(0, min);
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("text_editor.txt"));
			FileWriter fout = new FileWriter("text_editor_output.txt");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				String[] words = new String[n];
				Node root = new Node("");
				for(int i = 0; i < n; i++)
				{
					words[i] = f.readLine();
					root.addChild(new Node(words[i]));
				}
				int[] cost = root.cost(k);
				int output = 2*cost[k] + k;
				System.out.println("Case #" + num + ": " + output);
				fout.write("Case #" + num + ": " + output + "\n");
			}
			fout.close();
			f.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
