import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Driver implements Comparable<Driver> {
		String name;
		int loc;

		public Driver(String name, int loc) {
			super();
			this.name = name;
			this.loc = loc;
		}

		@Override
		public int compareTo(Driver d) {
			return this.loc - d.loc;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int bef = 0;

		String name;
		int x;
		int loc;

		Driver[] drivers = new Driver[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			name = st.nextToken();
			x = Integer.parseInt(st.nextToken());

			loc = (bef - (x % t) + t) % t;

			drivers[i] = new Driver(name, loc);

			bef = loc;
		}

		Arrays.sort(drivers);

		LinkedList<String> names = new LinkedList<>();

		int diff;

		for (int i = 0; i + 1 < n; i++) {

			diff = drivers[i + 1].loc - drivers[i].loc;

			if (diff == 0 || diff > 1000)
				continue;

			names.add(drivers[i].name);
		}

		if (t - drivers[n - 1].loc <= 1000) {
			names.add(drivers[n - 1].name);
		}

		if (names.isEmpty()) {
			sb.append(-1);
		} else {

			Collections.sort(names);

			for (String w : names) {
				sb.append(w).append(" ");
			}
		}

		System.out.print(sb.toString());
	}
}