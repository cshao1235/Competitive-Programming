import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Crazy {
	static class Edge
	{
		long x1;
		long y1;
		long x2;
		long y2;
		public Edge(long x1, long y1, long x2, long y2)
		{
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		public long crossProduct(long x, long y) //<x2 - x1, y2 - y1> x <x - x1, y - y1>
		{
			return (y - y1)*(x2 - x1) - (x - x1)*(y2 - y1);
		}
		public String toString()
		{
			return "(" + x1 + ", " + y1 + ")->(" + x2 + ", " + y2 + ")";
		}
	}
	public static boolean sameRegions(ArrayList<Integer> a1, ArrayList<Integer> a2)
	{
		if(a1.size() != a2.size())
			return false;
		for(int i = 0; i < a1.size(); i++)
		{
			if(a1.get(i) != a2.get(i))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("crazy.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ArrayList<Edge> edges = new ArrayList<Edge>();
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(f.readLine());
				long x1 = Long.parseLong(st.nextToken());
				long y1 = Long.parseLong(st.nextToken());
				long x2 = Long.parseLong(st.nextToken());
				long y2 = Long.parseLong(st.nextToken());
				Edge e = new Edge(x1, y1, x2, y2);
				edges.add(e);
			}
			boolean[] alreadyLocated = new boolean[n];
			ArrayList<ArrayList<Edge>> cycles = new ArrayList<ArrayList<Edge>>();
			for(int i = 0; i < n; i++)
			{
				if(alreadyLocated[i])
					continue;
				Edge e = edges.get(i);
				alreadyLocated[i] = true;
				ArrayList<Edge> a = new ArrayList<Edge>();
				a.add(e);
				long headX = e.x1;
				long headY = e.y1;
				long tailX = e.x2;
				long tailY = e.y2;
				boolean cycleCompleted = false;
				while(!cycleCompleted)
				{
					for(int j = 0; j < n; j++)
					{
						if(alreadyLocated[j])
							continue;
						Edge e1 = edges.get(j);
						if(tailX == e1.x1 && tailY == e1.y1)
						{
							a.add(e1);
							alreadyLocated[j] = true;
							if(!(e1.x2 == headX && e1.y2 == headY))
							{
								tailX = e1.x2;
								tailY = e1.y2;
							}
							else
							{
								cycleCompleted = true;
								break;
							}
						}
						else if(tailX == e1.x2 && tailY == e1.y2)
						{
							a.add(new Edge(e1.x2, e1.y2, e1.x1, e1.y1));
							alreadyLocated[j] = true;
							if(!(e1.x1 == headX && e1.y1 == headY))
							{
								tailX = e1.x1;
								tailY = e1.y1;
							}
							else
							{
								cycleCompleted = true;
								break;
							}
						}
						else if(headX == e1.x2 && headY == e1.y2)
						{
							a.add(e1);
							alreadyLocated[j] = true;
							headX = e1.x1;
							headY = e1.y1;
							//break;
						}
						else if(headX == e1.x1 && headY == e1.y1)
						{
							a.add(new Edge(e1.x2, e1.y2, e1.x1, e1.y1));
							alreadyLocated[j] = true;
							headX = e1.x2;
							headY = e1.y2;
							//break;
						}
					}
				}
				cycles.add(a);
			}
			System.out.println(cycles.toString());
			ArrayList<ArrayList<Integer>> pointsInRegions = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < c; i++)
			{
				pointsInRegions.add(new ArrayList<Integer>());
				st = new StringTokenizer(f.readLine());
				long x = Long.parseLong(st.nextToken());
				long y = Long.parseLong(st.nextToken());
				for(int j = 0; j < cycles.size(); j++)
				{
					ArrayList<Edge> a = cycles.get(j);
					int intersections = 0;
					for(int k = 0; k < a.size(); k++)
					{
						Edge e1 = a.get(k);
						if(e1.y1 < y && e1.y2 > y)
						{
							if(e1.x1 * (e1.y2 - e1.y1) + (e1.x2 - e1.x1)*(y - e1.y1) < x * (e1.y2 - e1.y1))
								intersections++;
						}
						else if(e1.y1 > y && e1.y2 < y)
						{
							if(e1.x2 * (e1.y1 - e1.y2) + (e1.x1 - e1.x2)*(y - e1.y2) < x * (e1.y1 - e1.y2))
								intersections++;
						}
						else if(e1.y1 == y && e1.y2 == y && e1.x2 <= x)
							continue;
						else if(e1.y2 == y && e1.x2 <= x)
							intersections++;
					}
					if(intersections%2 == 1)
					{
						ArrayList<Integer> p1 = pointsInRegions.get(i);
						p1.add(j);
						pointsInRegions.set(i, p1);
					}
					/*boolean inRegion = true;
					boolean isPositive = false;
					Edge e1 = a.get(0);
					if(e1.crossProduct(x, y) >= 0)
						isPositive = true;
					for(int k = 1; k < a.size(); k++)
					{
						long b = a.get(k).crossProduct(x, y);
						if((isPositive && b < 0) || (!isPositive && b >= 0))
						{
							System.out.println("(" + x + ", " + y + "), " + a.get(k).toString());
							inRegion = false;
							break;
						}
					}
					if(inRegion)
					{
						ArrayList<Integer> p1 = pointsInRegions.get(i);
						p1.add(j);
						pointsInRegions.set(i, p1);
					}*/
				}
			}
			f.close();
			System.out.println(pointsInRegions.toString());
			int max = 0;
			boolean[] alreadyDetermined = new boolean[c];
			for(int i = 0; i < c; i++)
			{
				if(alreadyDetermined[i])
					continue;
				int count = 1;
				alreadyDetermined[i] = true;
				for(int j = i + 1; j < c; j++)
				{
					if(alreadyDetermined[j])
						continue;
					else if(sameRegions(pointsInRegions.get(i), pointsInRegions.get(j)))
					{
						count++;
						alreadyDetermined[j] = true;
					}
				}
				if(count > max)
					max = count;
			}
			FileWriter fout = new FileWriter("crazy.out");
			fout.write(max + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
