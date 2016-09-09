import java.io.*;
import java.util.*;

public class Codeforces687B {
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	public static ArrayList<Integer> sieve(int limit) {
		boolean[] good = new boolean[limit + 1];
		for(int i = 2; i <= limit; i++)
			good[i] = true;
		for(int i = 2; i <= Math.sqrt(limit); i++) {
			for(int j = i; i*j <= limit; j++) {
				good[i*j] = false;
			}
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = 2; i <= limit; i++) {
			if(good[i])
				primes.add(i);
		}
		return primes;
	}
	public static int[] primeFactorize(ArrayList<Integer> primes, int k) {
		int[] powers = new int[primes.size()];
		for(int i = 0; i < primes.size(); i++)
			powers[i] = 1;
		for(int i = 0; i < primes.size(); i++) {
			if(k == 1)
				break;
			int p = primes.get(i);
			while(k%p == 0) {
				powers[i] *= p;
				k /= p;
			}
		}
		return powers;
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			boolean good = true;
			int[] primeF = primeFactorize(sieve(k), k);
			for(int i = 0; i < primeF.length; i++) {
				boolean good1 = false;
				for(int j = 0; j < n; j++) {
					if(a[j]%primeF[i] == 0) {
						good1 = true;
						break;
					}
				}
				good = good1;
				if(!good)
					break;
			}
			if(good)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
