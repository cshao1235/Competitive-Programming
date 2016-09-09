import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Clumsy {

	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("clumsy.in"));
			String s = f.readLine();
			f.close();
			int diff = 0;
			int changed = 0;
			for(int i = 0; i < s.length(); i++)
			{
				if(s.charAt(i) == '(')
					diff++;
				else
					diff--;
				if(diff < 0)
				{
					diff += 2;
					changed++;
				}
			}
			changed += diff/2;
			diff = 0;
			FileWriter fout = new FileWriter("clumsy.out");
			fout.write(changed + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
