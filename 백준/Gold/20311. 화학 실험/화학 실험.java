import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Bottle implements Comparable<Bottle> {
		int t, c;

		public Bottle(int t, int c) {
			super();
			this.t = t;
			this.c = c;
		}

		@Override
		public int compareTo(Bottle b) {
			return b.c - this.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Bottle[] bottles = new Bottle[k];

		st = new StringTokenizer(br.readLine(), " ");

		int c;

		for (int i = 0; i < k; i++) {
			c = Integer.parseInt(st.nextToken());

			bottles[i] = new Bottle(i + 1, c);
		}

		Arrays.sort(bottles);

		if (bottles[0].c > (n + 1) / 2) {
			sb.append(-1);
		} else {
			int s = 0;

			int[] align = new int[n];

			int ind = 0;

			while (ind < n) {
				align[ind] = bottles[s].t;
				bottles[s].c = bottles[s].c - 1;

				ind += 2;

				if (bottles[s].c == 0) {
					s++;
				}
			}

			ind = 1;

			while (ind < n) {
				align[ind] = bottles[s].t;
				bottles[s].c = bottles[s].c - 1;

				ind += 2;

				if (bottles[s].c == 0) {
					s++;
				}
			}

			for (int i = 0; i < n; i++) {
				sb.append(align[i]).append(" ");
			}
		}

		System.out.println(sb.toString());
	}
}
