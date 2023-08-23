import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] array;
	static int sqrtN;
	static long cnt;
	static int[] count;
	static int[] xor;

	static class Query implements Comparable<Query> {
		int i, s, e;

		public Query(int i, int s, int e) {
			super();
			this.i = i;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Query query) {
			int v1 = this.s / sqrtN;
			int v2 = query.s / sqrtN;

			if (v1 != v2) {
				return v1 - v2;
			} else {
				return this.e - query.e;
			}
		}
	}

	static void update(int x, int v) {
		while (x <= 100000) {
			count[x] += v;
			x += (x & (-x));
		}
	}

	static int get(int x) {
		int ret = 0;
		while (x > 0) {
			ret += count[x];
			x -= (x & (-x));
		}
		return ret;
	}

	static void plus(int x) {
		int l = Math.max(1, x - k);
		int r = Math.min(100000, x + k);

		cnt += get(r) - get(l - 1);
		update(x, 1);
	}

	static void minus(int x) {
		int l = Math.max(1, x - k);
		int r = Math.min(100000, x + k);

		update(x, -1);
		cnt -= (get(r) - get(l - 1));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		sqrtN = (int) Math.sqrt(n);

		array = new int[n + 1];
		count = new int[100001];
		xor = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());

		Query[] queries = new Query[m];
		int s, e;
		long[] answers = new long[m];

		cnt = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			queries[i] = new Query(i, s, e);
		}

		Arrays.sort(queries);

		for (int i = queries[0].e; i >= queries[0].s; i--) {
			plus(array[i]);
		}

		answers[queries[0].i] = cnt;

		Query now;
		s = queries[0].s;
		e = queries[0].e;

		for (int i = 1; i < m; i++) {
			now = queries[i];

			for (; s > now.s;) {
				plus(array[--s]);
			}
			for (; s < now.s; s++) {
				minus(array[s]);
			}

			for (; e < now.e;) {
				plus(array[++e]);
			}

			for (; e > now.e; e--) {
				minus(array[e]);
			}

			answers[now.i] = cnt;
		}

		for (long x : answers) {
			sb.append(x).append("\n");
		}

		System.out.print(sb.toString());
	}
}