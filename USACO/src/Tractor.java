import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
//import java.util.Queue;
import java.util.StringTokenizer;

public class Tractor {
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
	public static boolean bfs(int[][] fields, int cost, int n)
	{
		boolean[][] alreadyProcessed = new boolean[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(!alreadyProcessed[i][j])
				{
					int componentSize = 1;
					Queue q = new Queue();
					q.push(n*i + j);
					alreadyProcessed[i][j] = true;
					while(!q.isEmpty())
					{
						int current = q.pop();
						int r = current/n;
						int c = current%n;
						if(r > 0)
						{
							if(!alreadyProcessed[r - 1][c] && abs(fields[r][c], fields[r - 1][c]) <= cost)
							{
								alreadyProcessed[r - 1][c] = true;
								componentSize++;
								q.push((r - 1)*n + c);
							}
						}
						if(r < n - 1)
						{
							if(!alreadyProcessed[r + 1][c] && abs(fields[r][c], fields[r + 1][c]) <= cost)
							{
								alreadyProcessed[r + 1][c] = true;
								q.push((r + 1)*n + c);
								componentSize++;
							}
						}
						if(c > 0)
						{
							if(!alreadyProcessed[r][c - 1] && abs(fields[r][c], fields[r][c - 1]) <= cost)
							{
								alreadyProcessed[r][c - 1] = true;
								q.push(r*n + c - 1);
								componentSize++;
							}
						}
						if(c < n - 1)
						{
							if(!alreadyProcessed[r][c + 1] && abs(fields[r][c], fields[r][c + 1]) <= cost)
							{
								alreadyProcessed[r][c + 1] = true;
								q.push(r*n + c + 1);
								componentSize++;
							}
						}
					}
					if(componentSize >= (n*n + 1)/2)
						return true;
				}
			}
		}
		return false;
	}
	public static int abs(int a, int b)
	{
		if(a > b)
			return a - b;
		return b - a;
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("tractor.in"));
			int n = Integer.parseInt(f.readLine());
			int[][] fields = new int[n][n];
			int min = 1000000;
			int max = 0;
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(f.readLine());
				for(int j = 0; j < n; j++)
				{
					fields[i][j] = Integer.parseInt(st.nextToken());
					if(min > fields[i][j])
						min = fields[i][j];
					if(max < fields[i][j])
						max = fields[i][j];
				}
			}
			f.close();
			int med = 0;
			long a = System.currentTimeMillis();
			while(min < max)
			{
				//System.out.println(min + " " + max);
				med = (min + max)/2;
				boolean componentSize = bfs(fields, med, n);
				//System.out.println(componentSize + " " + med);
				if(componentSize)
					max = med;
				else
					min = med + 1;
			}
			long b = System.currentTimeMillis();
			System.out.println(min + " " + max + " " + (b - a));
			System.out.println(max);
			FileWriter fout = new FileWriter("tractor.out");
			fout.write(max + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
