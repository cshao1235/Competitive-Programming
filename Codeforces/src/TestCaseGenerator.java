import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestCaseGenerator {

	public static void main(String[] args) {
		try {
			FileWriter fout = new FileWriter("test.txt");
			//fout.write(2000 + "\n");
			fout.write(300000 + " " + 300000 + "\n");
			for(int i = 1; i <= 300000; i++)
			{
				if(i%3 == 1)
					fout.write(1 + " " + (i%50 + 1) + "\n");
				else if(i%3 == 2)
					fout.write(2 + " " + (i%49 + 1) + "\n");
				else
					fout.write(3 + " " + (i/5 + 1) + "\n");
			}
			//fout.write("\n");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
