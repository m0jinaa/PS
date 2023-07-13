import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Event implements Comparable<Event> {
		int id, time;
		String input;

		public Event(int id, int time, String input) {
			super();
			this.id = id;
			this.time = time;
			this.input = input;
		}

		@Override
		public int compareTo(Event e) {
			if (this.time != e.time) {
				return this.time - e.time;
			} else {
				return this.id - e.id;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Event[] events = new Event[m];
		int a, b;
		String c;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = st.nextToken();

			events[i] = new Event(a, b, c);
		}

		Arrays.sort(events);


		for (Event e : events) {
			sb.append(e.input);
		}

		System.out.println(sb.toString());
	}
}