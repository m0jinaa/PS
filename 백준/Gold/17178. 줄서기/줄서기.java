import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Ticket implements Comparable<Ticket> {
		int x, y;

		public Ticket(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Ticket t) {
			if (this.x != t.x) {
				return this.x - t.x;
			} else {
				return this.y - t.y;
			}
		}

		public boolean equals(Ticket t) {
			return (this.x == t.x) && (this.y == t.y);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		LinkedList<Ticket> waiting = new LinkedList<>();
		LinkedList<Ticket> ideal = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());

		Ticket[][] tickets = new Ticket[n][5];

		int x, y;
		String alp;

		Ticket ticket;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " -");

			for (int j = 0; j < 5; j++) {
				alp = st.nextToken();
				x = alp.charAt(0) - 'A';
				y = Integer.parseInt(st.nextToken());

				ticket = new Ticket(x, y);

				ideal.add(ticket);
				tickets[i][j] = ticket;
			}
		}

		Collections.sort(ideal);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				while (!waiting.isEmpty() && ideal.peek().equals(waiting.peekLast())) {
					ideal.pollFirst();
					waiting.pollLast();
				}

				if (ideal.peek().equals(tickets[i][j])) {
					ideal.pollFirst();
				} else {
					waiting.add(tickets[i][j]);
				}

				while (!waiting.isEmpty() && ideal.peek().equals(waiting.peekLast())) {
					ideal.pollFirst();
					waiting.pollLast();
				}
			}
		}
        
		boolean possible = waiting.isEmpty();

		System.out.println(possible ? "GOOD" : "BAD");
	}
}