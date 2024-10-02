import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, l;
	static Chicken[] chickens;
	static long[] weight;
	static long[] xw;

	static class Chicken implements Comparable<Chicken> {
		int x;
		long w;

		public Chicken(int x, long w) {
			super();
			this.x = x;
			this.w = w;
		}

		@Override
		public int compareTo(Chicken c) {
			return this.x - c.x;
		}
	}

	static boolean check(double m) {
		int s = 0;
		int e = n - 1;
		int mid;
		int p = n;
		while (s <= e) {
			mid = (s + e) / 2;
			if (chickens[mid].x <= m) {
				p = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		double left = m * weight[p] - xw[p];
		double right = xw[n - 1] - xw[p] - m * (weight[n - 1] - weight[p]);

		return left <= right;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		chickens = new Chicken[n];

		int x;
		long w;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			chickens[i] = new Chicken(x, 0);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			w = Integer.parseInt(st.nextToken());

			chickens[i].w = w;
		}

		Arrays.sort(chickens);

		xw = new long[n];
		weight = new long[n];

		for (int i = 0; i < n; i++) {
			xw[i] = (i > 0 ? xw[i - 1] : 0) + chickens[i].x * chickens[i].w;
			weight[i] = (i > 0 ? weight[i - 1] : 0) + chickens[i].w;
		}

		double answer = 0;

		double s = 0;
		double e = l;

		double m;

		while (s < e) {
			m = (s + e) / 2;

			if (check(m)) {
				if (Math.abs(answer - m) < 0.0000001) {
					break;
				}

				answer = m;
				s = m;
			} else {
				e = m;
			}
		}

		System.out.println(answer);
	}
}