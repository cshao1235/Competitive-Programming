import java.io.*;
import java.util.StringTokenizer;

public class Codeforces668C {
	public static double[] solve(double sum, double prod) {
		double[] output = new double[2];
		double discr = sum*sum - 4*prod;
		if(discr < 0)
			discr = 0;
		output[0] = (sum + Math.sqrt(discr))/2.0;
		output[1] = (sum - Math.sqrt(discr))/2.0;
		return output;
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			double[] maxProb = new double[n];
			double[] minProb = new double[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				maxProb[i] = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				minProb[i] = Double.parseDouble(st.nextToken());
			double[] sums = new double[n];
			double[][] probs = new double[n][2];
			for(int i = 0; i < n; i++)
				sums[i] = maxProb[i] + minProb[i];
			double s = 0;
			double s1 = 0;
			double s2 = 0;
			double p = 0;
			for(int i = 0; i < n; i++) {
				s += sums[i];
				p += maxProb[i];
				double[] output = solve(s, p);
				probs[i] = output;
				probs[i][0] -= s1;
				probs[i][1] -= s2;
				s1 += probs[i][0];
				s2 += probs[i][1];
			}
			for(int i = 0; i < n; i++)
				System.out.print(probs[i][0] + " ");
			System.out.println();
			for(int i = 0; i < n; i++)
				System.out.print(probs[i][1] + " ");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
