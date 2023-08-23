import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] array;
	static int sqrtN;
	static long cnt;
	static int[] countLeft;
	static int[] countRight;
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

	static void plusLeft(int i) {
		int v = k ^ xor[i - 1];

		countLeft[xor[i]]++;
		countRight[xor[i - 1]]++;
		cnt += countLeft[v];

	}

	static void minusLeft(int i) {
		int v = k ^ xor[i - 1];

		cnt -= countLeft[v];
		countLeft[xor[i]]--;
		countRight[xor[i - 1]]--;

	}

	static void plusRight(int i) {
		int v = k ^ xor[i];

		countLeft[xor[i]]++;
		countRight[xor[i - 1]]++;
		cnt += countRight[v];

	}

	static void minusRight(int i) {
		int v = k ^ xor[i];

		cnt -= countRight[v];
		countLeft[xor[i]]--;
		countRight[xor[i - 1]]--;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		sqrtN = (int) Math.sqrt(n);

		array = new int[n + 1];
		countLeft = new int[1050000];
		countRight = new int[1050000];
		xor = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			xor[i] = xor[i - 1] ^ array[i];
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
			plusLeft(i);
		}

		answers[queries[0].i] = cnt;

		Query now;
		s = queries[0].s;
		e = queries[0].e;

		for (int i = 1; i < m; i++) {
			now = queries[i];

			for (; s > now.s;) {
				plusLeft(--s);
			}
			for (; s < now.s; s++) {
				minusLeft(s);
			}

			for (; e < now.e;) {
				plusRight(++e);
			}

			for (; e > now.e; e--) {
				minusRight(e);
			}

			answers[now.i] = cnt;
		}

		for (long x : answers) {
			sb.append(x).append("\n");
		}

		System.out.println(sb.toString());
	}
}