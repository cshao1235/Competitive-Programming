import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Haybales {
	static class MinSegmentTree
	{
		private int length;
		private int[] segmentTree;
		public MinSegmentTree(int[] a)
		{
			length = a.length;
			int height = (int) Math.ceil(Math.log(length)/Math.log(2));
			int maxSize = (int) Math.pow(2, height + 1) - 1;
			segmentTree = new int[maxSize];
			constructTree(0, length - 1, 0, a);
		}
		private int constructTree(int start, int end, int current, int[] array)
		{
			if(start == end)
			{
				segmentTree[current] = array[start];
				return array[start];
			}
			int med = (start + end)/2;
			segmentTree[current] = Math.min(constructTree(start, med, 2*current + 1, array), constructTree(med + 1, end, 2*current + 2, array));
			return segmentTree[current];
		}
		private int getMin(int start, int end, int qStart, int qEnd, int current)
		{
			if(qStart <= start && qEnd >= end)
				return segmentTree[current];
			else if(qStart > end || qEnd < start)
				return Integer.MAX_VALUE;
			int med = (start + end)/2;
			return Math.min(getMin(start, med, qStart, qEnd, 2*current + 1), getMin(med + 1, end, qStart, qEnd, 2*current + 2));
		}
		public int getMin(int qStart, int qEnd)
		{
			return getMin(0, length - 1, qStart, qEnd, 0);
		}
		private int update(int start, int end, int qStart, int qEnd, int diff, int current)
		{
			if(start == end && qStart <= start && qEnd >= end)
			{
				segmentTree[current] += diff*(end - start + 1);
				return segmentTree[current];
			}
			else if(qStart > end || qEnd < start)
				return segmentTree[current];
			int med = (start + end)/2;
			int min = Math.min(update(start, med, qStart, qEnd, diff, 2*current + 1), update(med + 1, end, qStart, qEnd, diff, 2*current + 2));
			segmentTree[current] = min;
			return min;
		}
		public void update(int qStart, int qEnd, int diff)
		{
			update(0, length - 1, qStart, qEnd, diff, 0);
		}
	}
	static class SumSegmentTree
	{
		private int length;
		private int[] segmentTree;
		public SumSegmentTree(int[] a)
		{
			length = a.length;
			int height = (int) Math.ceil(Math.log(length)/Math.log(2));
			int maxSize = (int) Math.pow(2, height + 1) - 1;
			segmentTree = new int[maxSize];
			constructTree(0, length - 1, 0, a);
		}
		private int constructTree(int start, int end, int current, int[] array)
		{
			if(start == end)
			{
				segmentTree[current] = array[start];
				return array[start];
			}
			int med = (start + end)/2;
			segmentTree[current] = constructTree(start, med, 2*current + 1, array) + constructTree(med + 1, end, 2*current + 2, array);
			return segmentTree[current];
		}
		private int getSum(int start, int end, int qStart, int qEnd, int current)
		{
			if(qStart <= start && qEnd >= end)
				return segmentTree[current];
			else if(qStart > end || qEnd < start)
				return 0;
			int med = (start + end)/2;
			return getSum(start, med, qStart, qEnd, 2*current + 1) + getSum(med + 1, end, qStart, qEnd, 2*current + 2);
		}
		public int getSum(int qStart, int qEnd)
		{
			return getSum(0, length - 1, qStart, qEnd, 0);
		}
		private int update(int start, int end, int qStart, int qEnd, int diff, int current)
		{
			if(start == end && qStart <= start && qEnd >= end)
			{
				segmentTree[current] += diff*(end - start + 1);
				return diff*(end - start + 1);
			}
			else if(qStart > end || qEnd < start)
				return 0;
			int med = (start + end)/2;
			int add = update(start, med, qStart, qEnd, diff, 2*current + 1) + update(med + 1, end, qStart, qEnd, diff, 2*current + 2);
			segmentTree[current] += add;
			return add;
		}
		public void update(int qStart, int qEnd, int diff)
		{
			update(0, length - 1, qStart, qEnd, diff, 0);
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
			FileWriter fout = new FileWriter("haybales.out");
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			st = new StringTokenizer(f.readLine());
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(st.nextToken());
			SumSegmentTree sumSegTree = new SumSegmentTree(a);
			MinSegmentTree minSegTree = new MinSegmentTree(a);
			for(int i = 0; i < q; i++)
			{
				st = new StringTokenizer(f.readLine());
				String direction = st.nextToken();
				if(direction.equals("M"))
				{
					int qStart = Integer.parseInt(st.nextToken()) - 1;
					int qEnd = Integer.parseInt(st.nextToken()) - 1;
					fout.write(minSegTree.getMin(qStart, qEnd) + "\n");
				}
				else if(direction.equals("S"))
				{
					int qStart = Integer.parseInt(st.nextToken()) - 1;
					int qEnd = Integer.parseInt(st.nextToken()) - 1;
					fout.write(sumSegTree.getSum(qStart, qEnd) + "\n");
				}
				else
				{
					int qStart = Integer.parseInt(st.nextToken()) - 1;
					int qEnd = Integer.parseInt(st.nextToken()) - 1;
					int diff = Integer.parseInt(st.nextToken());
					minSegTree.update(qStart, qEnd, diff);
					sumSegTree.update(qStart, qEnd, diff);
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
