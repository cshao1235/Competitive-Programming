import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces448C {
	static class SegmentTree
	{
		int[] array;
		int[][] segmentTree;
		public SegmentTree(int[] array)
		{
			this.array = array;
			int h = (int) Math.ceil(Math.log(array.length)/Math.log(2));
			int maxSize = (int) Math.pow(2, h + 1) - 1;
			//System.out.println(maxSize);
			segmentTree = new int[maxSize][2];
			constructTree(0, array.length - 1, 0);
		}
		private int[] constructTree(int start, int end, int current)
		{
			if(start == end)
			{
				segmentTree[current][0] = array[start];
				segmentTree[current][1] = start;
				return segmentTree[current];
			}
			int med = (start + end)/2;
			int[] a1 = constructTree(start, med, 2*current + 1);
			int[] a2 = constructTree(med + 1, end, 2*current + 2);
			if(a1[0] <= a2[0])
			{
				segmentTree[current][0] = a1[0];
				segmentTree[current][1] = a1[1];
				return segmentTree[current];
			}
			else
			{
				segmentTree[current][0] = a2[0];
				segmentTree[current][1] = a2[1];
				return segmentTree[current];
			}
		}
		private int[] getMin(int startIndex, int endIndex, int qStartIndex, int qEndIndex, int current)
		{
			if(qStartIndex <= startIndex && qEndIndex >= endIndex)
				return segmentTree[current];
			if(startIndex > qEndIndex || endIndex < qStartIndex)
			{
				int[] output = {Integer.MAX_VALUE, 0};
				return output;
			}
			int med = (startIndex + endIndex)/2;
			int[] a1 = getMin(startIndex, med, qStartIndex, qEndIndex, 2*current + 1);
			int[] a2 = getMin(med + 1, endIndex, qStartIndex, qEndIndex, 2*current + 2);
			if(a1[0] <= a2[0])
				return a1;
			else
				return a2;
		}
		public int[] getMin(int qStartIndex, int qEndIndex)
		{
			if(qStartIndex < 0 || qEndIndex >= array.length || qStartIndex > qEndIndex)
			{
				int[] output = {Integer.MAX_VALUE, -1};
				return output;
			}
			return getMin(0, array.length - 1, qStartIndex, qEndIndex, 0);
		}
		public void print()
		{
			for(int i = 0; i < segmentTree.length; i++)
				System.out.println(Arrays.toString(segmentTree[i]));
		}
	}
	private static int minStrokes(int[] array, SegmentTree tree, int qStart, int qEnd, int height)
	{
		int[] min = tree.getMin(qStart, qEnd);
		if(min[1] == -1)
			return 0;
		int output = min[0] - height + minStrokes(array, tree, qStart, min[1] - 1, min[0]) + minStrokes(array, tree, min[1] + 1, qEnd, min[0]);
		if(output > qEnd - qStart + 1)
			output = qEnd - qStart + 1;
		//System.out.println(qStart + " " + qEnd + " " + min[0] + " " + min[1] + " " + output);
		return output;
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());
			SegmentTree tree = new SegmentTree(a);
			//tree.print();
			//System.out.println(tree.getMin(0, 4)[0] + " " + tree.getMin(0, 4)[1]);
			System.out.println(minStrokes(a, tree, 0, a.length - 1, 0));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
