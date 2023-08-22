import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int sqrtN;
	static int[] count;
	static int answer;
	static int[] array;

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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		sqrtN = (int) Math.sqrt(n);

		int q = Integer.parseInt(st.nextToken());

		array = new int[n + 1];
		count = new int[100001];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Query[] queries = new Query[q];
		int s, e;
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			queries[i] = new Query(i, s, e);
		}

		Arrays.sort(queries);

		int[] answers = new int[q];

		int target = 0;

		for (int i = queries[0].s; i <= queries[0].e; i++) {
			count[array[i]]++;
			if (count[array[i]] == 2) {
				target++;
			} else if (count[array[i]] == 3) {
				target--;
			}
		}

		answers[queries[0].i] = target;
		s = queries[0].s;
		e = queries[0].e;

		Query now;

		for (int i = 1; i < q; i++) {
			now = queries[i];
			while (now.s < s) {
				count[array[--s]]++;
				if (count[array[s]] == 2) {
					target++;
				} else if (count[array[s]] == 3) {
					target--;
				}
			}
			while (now.s > s) {
				count[array[s]]--;
				if (count[array[s]] == 1) {
					target--;
				} else if (count[array[s]] == 2) {
					target++;
				}
				s++;
			}
			while (now.e < e) {
				count[array[e]]--;
				if (count[array[e]] == 1) {
					target--;
				} else if (count[array[e]] == 2) {
					target++;
				}
				e--;
			}
			while (now.e > e) {
				count[array[++e]]++;
				if (count[array[e]] == 2) {
					target++;
				} else if (count[array[e]] == 3) {
					target--;
				}
			}

			answers[now.i] = target;
		}

		for (int ans : answers) {
			sb.append(ans).append("\n");
		}

		System.out.print(sb.toString());
	}
}