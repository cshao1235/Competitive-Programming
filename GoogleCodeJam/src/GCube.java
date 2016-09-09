import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GCube {
	static class SegmentTree
	{
		private double[] array;
		private double[] segmentTree;
		public SegmentTree(double[] array)
		{
			this.array = array;
			int height = (int) Math.ceil(Math.log(array.length)/Math.log(2));
			int maxSize = (int) Math.pow(2, height + 1) - 1;
			segmentTree = new double[maxSize];
			constructTree(array, 0, array.length - 1, 0);
		}
		private double constructTree(double[] array, int start, int end, int current)
		{
			if(start == end)
			{
				segmentTree[current] = array[start];
				return array[start];
			}
			int med = (start + end)/2;
			segmentTree[current] = constructTree(array, start, med, 2*current + 1) + constructTree(array, med + 1, end, 2*current + 2);
			return segmentTree[current];
		}
		private double getSum(int startIndex, int endIndex, int qStartIndex, int qEndIndex, int current)
		{
			if(qStartIndex <= startIndex && qEndIndex >= endIndex)
				return segmentTree[current];
			if(qStartIndex > endIndex || qEndIndex < startIndex)
				return 0;
			int med = (startIndex + endIndex)/2;
			return getSum(startIndex, med, qStartIndex, qEndIndex, 2*current + 1) + getSum(med + 1, endIndex, qStartIndex, qEndIndex, 2*current + 2);
		}
		public double getSum(int qStartIndex, int qEndIndex)
		{
			return getSum(0, array.length - 1, qStartIndex, qEndIndex, 0);
		}
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(f.readLine());
			FileWriter fout = new FileWriter("gcube.out");
			for(int i = 1; i <= t; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				double[] array = new double[n];
				st = new StringTokenizer(f.readLine());
				for(int j = 0; j < n; j++)
					array[j] = Math.log(Double.parseDouble(st.nextToken()));
				//System.out.println(Arrays.toString(array));
				SegmentTree segTree = new SegmentTree(array);
				fout.write("Case #" + i + ":\n");
				for(int j = 0; j < m; j++)
				{
					st = new StringTokenizer(f.readLine());
					int l = Integer.parseInt(st.nextToken());
					int r = Integer.parseInt(st.nextToken());
					int dim = r - l + 1;
					double logV = segTree.getSum(l, r);
					//System.out.println(logV);
					double side = Math.exp(logV/dim);
					fout.write(String.format("%.12f", side) + "\n");
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
