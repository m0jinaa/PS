import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Customer {
		int ind, p;

		public Customer(int ind, int p) {
			super();
			this.ind = ind;
			this.p = p;
		}

		public void serve() {
			this.p = this.p - 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		LinkedList<Customer> q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		int p;

		for (int i = 0; i < n; i++) {
			p = Integer.parseInt(st.nextToken());

			q.add(new Customer(i, p));
		}

		int[] time = new int[n];

		Customer now;

		int t = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			now.serve();
			t++;

			if (now.p == 0) {
				time[now.ind] = t;
			} else {
				q.add(now);
			}
		}

		for (int tm : time) {
			sb.append(tm).append(" ");
		}

		System.out.println(sb.toString());
	}
}