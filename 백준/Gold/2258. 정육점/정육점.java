import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Meat implements Comparable<Meat> {
		int w, p;

		public Meat(int w, int p) {
			super();
			this.w = w;
			this.p = p;
		}

		@Override
		public int compareTo(Meat m) {
			if (this.p != m.p) {
				return this.p - m.p;
			} else {
				return m.w - this.w;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Meat[] meats = new Meat[n];

		int w, p;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			meats[i] = new Meat(w, p);
		}

		Arrays.sort(meats);

		long answer = Long.MAX_VALUE;

		int weight = 0;
		int price = 0;

		for (int i = 0; i < n; i++) {
			weight += meats[i].w;
			if (i > 0 && meats[i].p == meats[i - 1].p) {
				price += meats[i].p;
			} else {
				price = 0;
			}

			if (weight >= m) {
				answer = Math.min(answer, meats[i].p + price);
			}

		}

		System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
	}
}