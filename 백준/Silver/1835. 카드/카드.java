import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static class Deque {
		int n;
		int front, rear;
		int[] numbers;

		public Deque(int n) {
			super();
			this.n = n;
			this.front = -1;
			this.rear = -1;
			this.numbers = new int[n];
			for (int i = 0; i < n; i++) {
				this.push(i);
			}
		}

		public boolean isEmpty() {
			return this.rear == this.front;
		}

		public int poll() {
			this.front = (this.front + 1) % this.n;
			int ret = this.numbers[this.front];
			return ret;
		}

		public void push(int x) {
			
			this.rear = (this.rear + 1) % this.n;
			this.numbers[rear] = x;
		}
		
		public int size() {
			return (n+rear-front)%n;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Deque q = new Deque(n);
		
		int[] answer = new int[n];
		int ind;
		int x = 1;
		while(!q.isEmpty()) {
			for(int i = 0;i<x;i++) {
				q.push(q.poll());
			}
			ind = q.poll();
			answer[ind] = x++;
		}
		
		for(int card : answer) {
			sb.append(card).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}