import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int sqrtN;
	static int[] count;
	static int[] totalCount;
	static int[] array;
	static int max;

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
			if (v1 == v2)
				return this.e - query.e;
			return v1 - v2;

		}
	}

	static void plus(int x) {
		totalCount[count[x]]--;
		if (++totalCount[++count[x]] == 1 && count[x] > max)
			max = count[x];
	}

	static void minus(int x) {
		if (--totalCount[count[x]] == 0 && max == count[x])
			max--;
		totalCount[--count[x]]++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int q;
		int s, e;
		int[] answers;

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			q = Integer.parseInt(st.nextToken());

			sqrtN = (int) Math.sqrt(n);
			array = new int[n + 1];
			count = new int[200020];
			totalCount = new int[100010];
			totalCount[0] = 200020;
			max = 0;

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				array[i] = Integer.parseInt(st.nextToken()) + 100000;
			}

			Query[] queries = new Query[q];
			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());

				queries[i] = new Query(i, s, e);
			}

			Arrays.sort(queries);

			answers = new int[q];

			for (int i = queries[0].s; i <= queries[0].e; i++) {
				plus(array[i]);
			}

			answers[queries[0].i] = max;
			s = queries[0].s;
			e = queries[0].e;

			Query now;

			for (int i = 1; i < q; i++) {
				now = queries[i];

				for (int x = now.s; x < s; x++)
					plus(array[x]);

				for (int x = e + 1; x <= now.e; x++)
					plus(array[x]);

				for (int x = s; x < now.s; x++)
					minus(array[x]);

				for (int x = now.e + 1; x <= e; x++)
					minus(array[x]);

				s = now.s;
				e = now.e;

				answers[now.i] = max;

			}

			for (int ans : answers) {
				sb.append(ans).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}