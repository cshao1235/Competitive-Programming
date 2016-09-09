import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Curling {
	static class Point
	{
		int x;
		int y;
		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public String toString()
		{
			return "(" + x + ", " + y + ")";
		}
	}
	private static Point basePoint;
	static class PointComparator implements Comparator<Point>
	{

		@Override
		public int compare(Point o1, Point o2) {
			int crossProduct = crossProduct(o1, basePoint, o2);
			if(crossProduct == 0)
				return squareDistance(o1, basePoint) - squareDistance(o2, basePoint);
			return -1*crossProduct;
		}
		
	}
	public static int squareDistance(Point p1, Point p2)
	{
		return (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
	}
	public static int crossProduct(Point p1, Point p2, Point p3) //cross product of p2p3, p1p2 is negative if p1p2p3 is counterclockwise
	{
		return (p3.y - p2.y) * (p2.x - p1.x) - (p3.x - p2.x) * (p2.y - p1.y);
	}
	public static Stack<Point> convexHull(Point[] points, int n)
	{
		int minY = points[0].y;
		int minIndex = 0;
		for(int i = 1; i < n; i++)
		{
			if((points[i].y < minY) || (points[i].y == minY && points[i].x < points[minIndex].x))
			{
				minY = points[i].y;
				minIndex = i;
			}
		}
		Point temp = points[0];
		points[0] = points[minIndex];
		points[minIndex] = temp;
		basePoint = points[0];
		Arrays.sort(points, new PointComparator());
		Stack<Point> stack = new Stack<Point>();
		stack.push(points[0]);
		stack.push(points[1]);
		stack.push(points[2]);
		for(int i = 3; i < n; i++)
		{
			while(crossProduct(stack.elementAt(1), stack.peek(), points[i]) > 0)
				stack.pop();
			stack.push(points[i]);
		}
		return stack;
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("curling.in"));
			int n = Integer.parseInt(f.readLine());
			Point[] pointsA = new Point[n];
			Point[] pointsB = new Point[n];
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pointsA[i] = new Point(x, y);
			}
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pointsB[i] = new Point(x, y);
			}
			f.close();
			
			/*System.out.println(convexHull(pointsA, n).toString());
			System.out.println(basePoint.toString());
			System.out.println(convexHull(pointsB, n).toString());*/
			/*FileWriter fout = new FileWriter("curling.out");
			fout.write(numPossible + "\n");
			fout.write(sum + "");
			f.close();
			fout.close();*/
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 

	}

}
