import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
	static class Quaternion {
		public int sign;
		public String abs;
		public Quaternion(String abs, int sign)
		{
			this.abs = abs;
			this.sign = sign;
		}
		public Quaternion multiply(Quaternion other)
		{
			int nextSign = sign*(other.sign);
			if(abs.equals("1"))
				return new Quaternion(other.abs, nextSign);
			if((other.abs).equals("1"))
				return new Quaternion(abs, nextSign);
			if(abs.equals(other.abs))
				return new Quaternion("1", -1*nextSign);
			if(abs.equals("i") && (other.abs).equals("j"))
				return new Quaternion("k", nextSign);
			if(abs.equals("i") && (other.abs).equals("k"))
				return new Quaternion("j", -1*nextSign);
			if(abs.equals("j") && (other.abs).equals("i"))
				return new Quaternion("k", -1*nextSign);
			if(abs.equals("j") && (other.abs).equals("k"))
				return new Quaternion("i", nextSign);
			if(abs.equals("k") && (other.abs).equals("i"))
				return new Quaternion("j", nextSign);
			if(abs.equals("k") && (other.abs).equals("j"))
				return new Quaternion("i", -1*nextSign);
			return new Quaternion("j", 1);
		}
		public void change(String abs, int sign)
		{
			this.abs = abs;
			this.sign = sign;
		}
		public void change(Quaternion q)
		{
			this.abs = q.abs;
			this.sign = q.sign;
		}
		public boolean equals(Quaternion q)
		{
			return (abs.compareTo(q.abs) == 0) && (sign == q.sign);
		}
		public String toString()
		{
			return "(" + abs + "," + sign + ")";
		}
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("dijkstra.out");
			//System.out.println((new Quaternion("i", 1)).multiply(new Quaternion("j", 1)));
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int l = Integer.parseInt(st.nextToken());
				long x = Long.parseLong(st.nextToken());
				String s = f.readLine();
				Quaternion sProd = new Quaternion("1", 1);
				for(int j = 0; j < l; j++)
				{
					Quaternion next = new Quaternion(s.charAt(j) + "", 1);
					//System.out.println(sProd + " " + next);
					sProd.change(sProd.multiply(next));
					//System.out.println(sProd);
				}
				/*Quaternion[] prefix = new Quaternion[l];
				prefix[0] = new Quaternion(s.charAt(0) + "", 1);
				for(int j = 1; j < l; j++)
					prefix[j] = prefix[j - 1].multiply(new Quaternion(s.charAt(j) + "", 1));
				Quaternion[] suffix = new Quaternion[l];
				suffix[l - 1] = new Quaternion(s.charAt(l - 1) + "", 1);
				for(int j = l - 2; j >= 0; j--)
					suffix[j] = (new Quaternion(s.charAt(j) + "", 1)).multiply(suffix[j - 1]);*/
				//Quaternion sProd = prefix[l - 1];
				Quaternion fProd = new Quaternion("1", 1);
				for(int j = 0; j < x%4; j++)
					fProd.change(fProd.multiply(sProd));
				//System.out.println(sProd + " " + fProd);
				if(!fProd.equals(new Quaternion("1", -1)))
				{
					System.out.println("Case #" + i + ": NO");
					fout.write("Case #" + i + ": NO\n");
					continue;
				}
				else
				{
					int minPrefixLength = -1;
					Quaternion prefix = new Quaternion("1", 1);
					Quaternion dPrefix = new Quaternion("i", 1);
					for(int j = 0; j < 4*l; j++)
					{
						prefix.change(prefix.multiply(new Quaternion(s.charAt(j%l) + "", 1)));
						if(prefix.equals(dPrefix))
						{
							minPrefixLength = j + 1;
							break;
						}
					}
					//System.out.println(minPrefixLength);
					if(minPrefixLength == -1)
					{
						System.out.println("Case #" + i + ": NO");
						fout.write("Case #" + i + ": NO\n");
						continue;
					}
					int minSuffixLength = -1;
					Quaternion suffix = new Quaternion("1", 1);
					Quaternion dSuffix = new Quaternion("k", 1);
					for(int j = 4*l - 1; j >= 0; j--)
					{
						suffix.change((new Quaternion(s.charAt(j%l) + "", 1)).multiply(suffix));
						if(suffix.equals(dSuffix))
						{
							minSuffixLength = 4*l - j;
							break;
						}
					}
					//System.out.println(minSuffixLength);
					if(minSuffixLength == -1)
					{
						System.out.println("Case #" + i + ": NO");
						fout.write("Case #" + i + ": NO\n");
						continue;
					}
					if((long) (minPrefixLength + minSuffixLength) > x*l)
					{
						System.out.println("Case #" + i + ": NO");
						fout.write("Case #" + i + ": NO\n");
						continue;
					}
					else
					{
						System.out.println("Case #" + i + ": YES");
						fout.write("Case #" + i + ": YES\n");
						continue;
					}
					
				}
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
