import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestCaseGenerator {

	public static void main(String[] args) {
		try {
			int t = 50;
			FileWriter fout = new FileWriter("test.txt");
			fout.write(t + "\n");
			Random r = new Random();
			for(int i = 0; i < t; i++)
			{
				fout.write(1000000 + " " + 100000 + " " + 1000000000 + " " + 1000000000 + "\n");
				for(int j = 0; j < 100000; j++)
					fout.write(1000000000 + " ");
				fout.write("\n");
			}
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
