import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpeakingInTongues {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			char[] translate = new char[26];
			translate['y' - 'a'] = 'a';
			translate['o' - 'a'] = 'e';
			translate['q' - 'a'] = 'z';
			translate['a' - 'a'] = 'y';
			translate['e' - 'a'] = 'o';
			translate['z' - 'a'] = 'q';
			String s1 = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
			String t1 = "our language is impossible to understand";
			String s2 = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
			String t2 = "there are twenty six factorial possibilities";
			String s3 = "de kr kd eoya kw aej tysr re ujdr lkgc jv";
			String t3 = "so it is okay if you want to just give up";
			for(int i = 0; i < s1.length(); i++)
			{
				if(s1.charAt(i) != ' ')
					translate[s1.charAt(i) - 'a'] = t1.charAt(i);
			}
			for(int i = 0; i < s2.length(); i++)
			{
				if(s2.charAt(i) != ' ')
					translate[s2.charAt(i) - 'a'] = t2.charAt(i);
			}
			for(int i = 0; i < s3.length(); i++)
			{
				if(s3.charAt(i) != ' ')
					translate[s3.charAt(i) - 'a'] = t3.charAt(i);
			}
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("tongues.out");
			for(int i = 1; i <= t; i++)
			{
				StringBuffer output = new StringBuffer("");
				String s = f.readLine();
				for(int j = 0; j < s.length(); j++)
				{
					if(s.charAt(j) != ' ')
						output.append(translate[s.charAt(j) - 'a']);
					else
						output.append(' ');
				}
				fout.write("Case #" + i + ": " + output.toString() + "\n");
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
