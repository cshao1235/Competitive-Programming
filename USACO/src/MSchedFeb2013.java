import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MSchedFeb2013 {
	static class Queue
	{
		private static final int QUEUE_SIZE = 50;
		private int[] queue;
		private int head;
		private int tail;
		public Queue()
		{
			queue = new int[QUEUE_SIZE];
			head = 0;
			tail = 0;
		}
		public boolean isEmpty()
		{
			return head == tail;
		}
		public void push(int value)
		{
			queue[tail] = value;
			tail = (tail + 1)%queue.length;
			if(size() > queue.length - 2)
			{
				int[] nQueue = new int[2*queue.length];
				//int counter = 0;
				for(int i = 0; i < queue.length; i++)
					nQueue[(i - head + queue.length)%queue.length] = queue[i];
				head = 0;
				tail = queue.length;
				queue = nQueue;
			}
		}
		public int pop()
		{
			int a = queue[head];
			head = (head + 1)%queue.length;
			return a;
		}
		public int size()
		{
			return (tail - head + queue.length)%queue.length;
		}
	}
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new FileReader("msched.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> constraints = new ArrayList<ArrayList<Integer>>();
			int[] times = new int[n];
			for(int i = 0; i < n; i++)
			{
				times[i] = Integer.parseInt(f.readLine());
				constraints.add(new ArrayList<Integer>());
			}
			boolean[] isRoot = new boolean[n];
			for(int i = 0; i < n; i++)
				isRoot[i] = true;
			for(int i = 0; i < m; i++)
			{
				st = new StringTokenizer(f.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				constraints.get(to).add(from);
				isRoot[from] = false;
			}
			f.close();
			long output = Long.MAX_VALUE;
			long[] minMilkTime = new long[n];
			for(int i = 0; i < n; i++)
				minMilkTime[i] = Long.MAX_VALUE;
			Queue q = new Queue();
			boolean[] alreadyProcessed = new boolean[n];
			for(int i = 0; i < n; i++)
			{
				if(isRoot[i])
				{
					q.push(i);
					alreadyProcessed[i] = true;
				}
			}
			while(!q.isEmpty())
			{
				int current = q.pop();
				ArrayList<Integer> cowsBefore = constraints.get(current);
				
			}
			//for(int i = 0; i < n; i++)
			//	System.out.println(constraints.get(i).toString());
			//String s = f.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}
