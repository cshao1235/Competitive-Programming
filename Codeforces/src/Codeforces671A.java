import java.io.*;
import java.util.StringTokenizer;

public class Codeforces671A {
	public static double distance(int[] place, int[] bottle)
	{
		int dx = place[0] - bottle[0];
		int dy = place[1] - bottle[1];
		return Math.sqrt(dx*dx + dy*dy);
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int[] a = new int[2];
			int[] b = new int[2];
			int[] t = new int[2];
			a[0] = Integer.parseInt(st.nextToken());
			a[1] = Integer.parseInt(st.nextToken());
			b[0] = Integer.parseInt(st.nextToken());
			b[1] = Integer.parseInt(st.nextToken());
			t[0] = Integer.parseInt(st.nextToken());
			t[1] = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(f.readLine());
			double sumTrashDistances = 0;
			double minDistance = Double.MAX_VALUE;
			for(int i = 0; i < n; i++)
			{
				int[] bottle = new int[2];
				st = new StringTokenizer(f.readLine());
				bottle[0] = Integer.parseInt(st.nextToken());
				bottle[1] = Integer.parseInt(st.nextToken());
				sumTrashDistances += distance(bottle, t);
				double aDistance = distance(bottle, a);
				double bDistance = distance(bottle, b);
				if(minDistance > aDistance)
					minDistance = aDistance;
				if(minDistance > bDistance)
					minDistance = bDistance;
			}
			System.out.println(minDistance + sumTrashDistances);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
