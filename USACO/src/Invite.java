import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Invite {
	static class Queue {
		private static final int MAX_SIZE = 10000000;
		private int[] queue;
		private int head;
		private int tail;
		public Queue()
		{
			queue = new int[MAX_SIZE];
			head = 0;
			tail = 0;
		}
		public void push(int value)
		{
			queue[tail] = value;
			tail++;
		}
		public int pop()
		{
			head++;
			return queue[head - 1];
		}
	}
	/*static class BinarySearchTree()
	{
		
	}*/
	public static void main(String[] args) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("invite.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());
			
			FileWriter fout = new FileWriter("invite.out");
			//fout.write( + "");
			fout.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}


}
