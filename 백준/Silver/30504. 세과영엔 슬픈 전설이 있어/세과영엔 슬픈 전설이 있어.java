import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Day {
		int d, a, b;

		public Day(int d, int a, int b) {
			super();
			this.d = d;
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Day[] days = new Day[n];

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			days[i] = new Day(i, x, 0);
		}

		st = new StringTokenizer(br.readLine(), " ");

		int[] b = new int[n];

		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(days, new Comparator<Day>() {

			@Override
			public int compare(Day d1, Day d2) {
				return d1.a - d2.a;
			}

		});

		Arrays.sort(b);

		boolean possible = true;

		for (int i = 0; i < n && possible; i++) {
			if (days[i].a > b[i])
				possible = false;
			days[i].b = b[i];
		}

		if (possible) {
			Arrays.sort(days, new Comparator<Day>() {

				@Override
				public int compare(Day d1, Day d2) {
					return d1.d - d2.d;
				}
			});

			for (int i = 0; i < n; i++) {
				sb.append(days[i].b).append(" ");
			}
		} else
			sb.append(-1);

		System.out.println(sb.toString());
	}
}