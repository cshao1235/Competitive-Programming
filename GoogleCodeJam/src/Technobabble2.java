import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Technobabble2 {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("technobabble.out");
			for(int i = 1; i <= t; i++)
			{
				int n = Integer.parseInt(f.readLine());
				String[][] words = new String[n][2];
				HashMap<String, Integer> first = new HashMap<String, Integer>();
				HashMap<String, Integer> second = new HashMap<String, Integer>();
				for(int j = 0; j < n; j++)
				{
					StringTokenizer st = new StringTokenizer(f.readLine());
					words[j][0] = st.nextToken();
					words[j][1] = st.nextToken();
					if(!first.containsKey(words[j][0]))
						first.put(words[j][0], 0);
					first.put(words[j][0], first.get(words[j][0]) + 1);
					if(!second.containsKey(words[j][1]))
						second.put(words[j][1], 0);
					second.put(words[j][1], second.get(words[j][1]) + 1);
				}
				int duplicates = 0;
				boolean[] duplicated = new boolean[n];
				int index = 0;
				while(index != n)
				{
					if(!duplicated[index])
					{
						if(first.get(words[index][0]) > 1 && second.get(words[index][1]) > 1)
						{
							first.put(words[index][0], first.get(words[index][0]) - 1);
							second.put(words[index][1], second.get(words[index][1]) - 1);
							duplicated[index] = true;
							index = -1;
						}
					}
					index++;
				}
				for(int j = 0; j < n; j++)
				{
					if(first.get(words[j][0]) > 1 && second.get(words[j][1]) > 1)
					{
						duplicates++;
						first.put(words[j][0], first.get(words[j][0]) - 1);
						second.put(words[j][1], second.get(words[j][1]) - 1);
					}
				}
				System.out.println("Case #" + i + ": " + duplicates);
				fout.write("Case #" + i + ": " + duplicates + "\n");
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
