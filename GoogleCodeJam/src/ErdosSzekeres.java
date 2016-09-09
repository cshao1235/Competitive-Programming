import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ErdosSzekeres {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			FileWriter fout = new FileWriter("erdosszekeres.out");
			int t = Integer.parseInt(f.readLine());
			for(int num = 1; num <= t; num++)
			{
				int n = Integer.parseInt(f.readLine());
				int[] a = new int[n];
				int[] b = new int[n];
				boolean[] placed = new boolean[n];
				int[] x = new int[n];
				int[] d = new int[n];
				StringTokenizer st = new StringTokenizer(f.readLine());
				for(int i = 0; i < n; i++)
					a[i] = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(f.readLine());
				for(int i = 0; i < n; i++)
					b[i] = Integer.parseInt(st.nextToken());
				for(int i = 0; i < n - 1; i++)
				{
					placed[i] = true;
					x[i] = b[i] + d[i];
					boolean sub = (a[i + 1] > 1);
					for(int j = i + 1; j < n; j++)
					{
						if(a[j] > 1)
						{
							if(sub)
								a[j]--;
							d[j]++;
						}
					}
					//System.out.println(i + " " + Arrays.toString(a));
				}
				x[n - 1] = b[n - 1] + d[n - 1];
				StringBuffer s = new StringBuffer();
				for(int i = 0; i < n; i++)
					s.append(x[i] + " ");
				String output = s.toString().trim();
				System.out.println("Case #" + num + ": " + output);
				fout.write("Case #" + num + ": " + output + "\n");
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
