import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static class Order implements Comparable<Order> {
		int time, table;
		boolean done;

		public Order(int table, int time) {
			super();
			this.table = table;
			this.time = time;
			this.done = false;
		}

		@Override
		public int compareTo(Order o) {
			if (this.time != o.time)
				return this.time - o.time;
			else
				return this.table - o.table;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Order> orders = new ArrayList<>();

		String arg;
		int time, table, c;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			arg = st.nextToken();

			switch (arg) {
			case "order":
				table = Integer.parseInt(st.nextToken());
				time = Integer.parseInt(st.nextToken());
				orders.add(new Order(table, time));
				break;
			case "sort":
				Collections.sort(orders);
				break;
			case "complete":
				table = Integer.parseInt(st.nextToken());
				for (Order o : orders) {
					if (o.table == table && o.done == false) {
						o.done = true;
						break;
					}
				}
			}

			c = 0;

			for (Order o : orders) {
				if (o.done)
					continue;
				sb.append(o.table).append(" ");
				c++;
			}
			if (c == 0) {
				sb.append("sleep");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}