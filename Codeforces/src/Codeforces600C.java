import java.io.*;
import java.util.Arrays;

public class Codeforces600C {

	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			//PrintWriter pw = new PrintWriter(System.out);
			String s = f.readLine();
			int[] amount = new int[26];
			for(int i = 0; i < s.length(); i++)
				amount[s.charAt(i) - 'a']++;
			/*for(int i = 0; i < amount.length; i++)
			{
				if(amount[i]%2 == 1)
				{
					for(int j = amount.length - 1; j > i; j--)
					{
						if(amount[j]%2 == 1)
						{
							amount[i]++;
							amount[j]--;
							break;
						}
					}
				}
			}*/
			int head = 0;
			int tail = 25;
			while(head < tail)
			{
				if(amount[head]%2 == 0)
					head++;
				else if(amount[tail]%2 == 0)
					tail--;
				else
				{
					amount[head]++;
					amount[tail]--;
					head++;
					tail--;
				}
			}
			//System.out.println("A");
			//System.out.println(Arrays.toString(amount));
			//StringBuffer output = new StringBuffer();
			char[] output = new char[s.length()];
			if(s.length()%2 == 1)
			{
				for(int i = 0; i < amount.length; i++)
				{
					if(amount[i]%2 == 1)
					{
						output[s.length()/2] = (char) (i + 'a');
						amount[i]--;
						break;
					}
				}
			}
			//System.out.println(Arrays.toString(amount));
			int counter = 0;
			for(int i = 0; i < amount.length; i++)
			{
				char added = (char) (i + 'a');
				for(int j = 0; j < amount[i]/2; j++)
				{
					output[counter] = added;
					output[s.length() - 1 - counter] = added;
					counter++;
				}
			}
			for(int i = 0; i < s.length(); i++)
				System.out.print(output[i]);
			System.out.println();
			/*int counter = amount.length - 1;
			while(counter >= 0)
			{
				//System.out.println(counter);
				if(amount[counter] == 0)
					counter--;
				else
				{
					char added = (char) (counter + 'a');
					output = added + output + added;
					amount[counter] -= 2;
				}
			}*/
			//pw.println(output);
			//pw.flush();
			//pw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
