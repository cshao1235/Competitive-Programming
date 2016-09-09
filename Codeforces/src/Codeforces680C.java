import java.io.*;
import java.util.StringTokenizer;

public class Codeforces680C {
	public static String output(int d, int n) {
		if(n%d == 0)
			return "yes";
		return "no";
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			//for(int n = 2; n <= 100; n++) {				
			int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 4, 9, 25, 49};
			int numYes = 0;
			for(int i = 0; i < primes.length; i++) {
				System.out.println(primes[i]);
				System.out.flush();
				//String s = output(primes[i], n);
				String s = f.readLine();
				if(s.equals("yes")) {
					numYes++;
				}
			}
			if(numYes == 0 || numYes == 1)
				System.out.println("prime");
			else
				System.out.println("composite");
			//}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
