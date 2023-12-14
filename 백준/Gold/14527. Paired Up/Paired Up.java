import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Cow implements Comparable<Cow> {
		int x, y;

		public Cow(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Cow c) {
			return this.y - c.y;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Cow[] cows = new Cow[n];

		int x, y;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			cows[i] = new Cow(x, y);
		}

		Arrays.sort(cows);

		int s = 0, e = n - 1;

		int answer = 0;

		int sum;

		int t1, t2;

		while (s <= e) {
			t1 = 0;
			t2 = 0;

			t1 = cows[s].y;
			cows[s].x--;
			if (cows[e].x != 0) {
				t2 = cows[e].y;
				cows[e].x--;
			}

			sum = t1 + t2;
			answer = Math.max(answer, sum);

			if (cows[s].x == 0) {
				s++;
			}

			if (cows[e].x == 0) {
				e--;
			}
		}

		System.out.println(answer);
	}
}