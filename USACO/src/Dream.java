import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Dream {
	static class Pair
	{
		int x;
		int y;
		boolean o;
		public Pair(int x, int y, boolean o)
		{
			this.x = x;
			this.y = y;
			this.o = o;
		}
	}
	static class Queue
	{
		private static final int QUEUE_SIZE = 500;
		private Pair[] queue;
		private int head;
		private int tail;
		public Queue()
		{
			queue = new Pair[QUEUE_SIZE];
			head = 0;
			tail = 0;
		}
		public void push(Pair p)
		{
			queue[tail] = p;
			tail = (tail + 1)%queue.length;
			if(head == tail)
			{
				Pair[] newQueue = new Pair[queue.length + QUEUE_SIZE];
				for(int i = 0; i < queue.length; i++)
					newQueue[i] = queue[(head + i)%queue.length];
				head = 0;
				tail = queue.length;
				queue = newQueue;
			}
		}
		public Pair pop()
		{
			Pair p = queue[head];
			head = (head + 1)%queue.length;
			return p;
		}
		public boolean isEmpty()
		{
			return head == tail;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("dream.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			byte[][] maze = new byte[n][m];
			for(int i = 0; i < n; i++)
			{
				st = new StringTokenizer(f.readLine());
				for(int j = 0; j < m; j++)
				{
					maze[i][j] = Byte.parseByte(st.nextToken());
				}
			}
			f.close();
			int[][][] dp = new int[n][m][2];
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
				{
					dp[i][j][0] = Integer.MAX_VALUE;
					dp[i][j][1] = Integer.MAX_VALUE;
				}
			}
			dp[0][0][0] = 0;
			Queue q = new Queue();
			q.push(new Pair(0, 0, false));
			while(!q.isEmpty())
			{
				Pair p = q.pop();
				int x = p.x;
				int y = p.y;
				//System.out.println(x + " " + y);
				if(x > 0)
				{
					boolean isOrange = p.o;
					int iindex = 0;
					if(isOrange)
						iindex = 1;
					int step = 1;
					while(x - step >= 0 && maze[x - step][y] == 4)
					{
						step++;
						isOrange = false;
					}
					if(x - step == -1)
						step--;
					else if(maze[x - step][y] == 2)
						isOrange = true;
					else if(maze[x - step][y] == 1 || (maze[x - step][y] == 3 && isOrange))
						step = step;
					else
						step--;
					int index = 0;
					if(isOrange)
						index = 1;
					if(dp[x][y][iindex] + step < dp[x - step][y][index])
					{
						dp[x - step][y][index] = dp[x][y][iindex] + step;
						q.push(new Pair(x - step, y, isOrange));
					}
				}
				if(x < n - 1)
				{
					boolean isOrange = p.o;
					int iindex = 0;
					if(isOrange)
						iindex = 1;
					int step = 1;
					while(x + step <= n - 1 && maze[x + step][y] == 4)
					{
						step++;
						isOrange = false;
					}
					if(x + step == n)
						step--;
					else if(maze[x + step][y] == 2)
						isOrange = true;
					else if(maze[x + step][y] == 1 || (maze[x + step][y] == 3 && isOrange))
						step = step;
					else
						step--;
					int index = 0;
					if(isOrange)
						index = 1;
					if(dp[x][y][iindex] + step < dp[x + step][y][index])
					{
						dp[x + step][y][index] = dp[x][y][iindex] + step;
						q.push(new Pair(x + step, y, isOrange));
					}
				}
				if(y > 0)
				{
					boolean isOrange = p.o;
					int iindex = 0;
					if(isOrange)
						iindex = 1;
					int step = 1;
					while(y - step >= 0 && maze[x][y - step] == 4)
					{
						step++;
						isOrange = false;
					}
					if(y - step == -1)
						step--;
					else if(maze[x][y - step] == 2)
						isOrange = true;
					else if(maze[x][y - step] == 1 || (maze[x][y - step] == 3 && isOrange))
						step = step;
					else
						step--;
					int index = 0;
					if(isOrange)
						index = 1;
					if(dp[x][y][iindex] + step < dp[x][y - step][index])
					{
						dp[x][y - step][index] = dp[x][y][iindex] + step;
						q.push(new Pair(x, y - step, isOrange));
					}
				}
				if(y < m - 1)
				{
					boolean isOrange = p.o;
					int iindex = 0;
					if(isOrange)
						iindex = 1;
					int step = 1;
					while(y + step <= m - 1 && maze[x][y + step] == 4)
					{
						step++;
						isOrange = false;
					}
					if(y + step == m)
						step--;
					else if(maze[x][y + step] == 2)
						isOrange = true;
					else if(maze[x][y + step] == 1 || (maze[x][y + step] == 3 && isOrange))
						step = step;
					else
						step--;
					int index = 0;
					if(isOrange)
						index = 1;
					if(dp[x][y][iindex] + step < dp[x][y + step][index])
					{
						dp[x][y + step][index] = dp[x][y][iindex] + step;
						q.push(new Pair(x, y + step, isOrange));
					}
				}
			}
			/*for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
					System.out.print(dp[i][j][0] + ", ");
				System.out.println();
			}
			System.out.println();
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < m; j++)
					System.out.print(dp[i][j][1] + ", ");
				System.out.println();
			}*/
			int output = Math.min(dp[n - 1][m - 1][0], dp[n - 1][m - 1][1]);
			if(output == Integer.MAX_VALUE)
				output = -1;
			FileWriter fout = new FileWriter("dream.out");
			fout.write(output + "\n");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}


	}

}
