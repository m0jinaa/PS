import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Problem implements Comparable<Problem> {
		int t, d;

		public Problem(int t, int d) {
			super();
			this.t = t;
			this.d = d;
		}

		@Override
		public int compareTo(Problem p) {
			return this.d - p.d;
		}

		@Override
		public String toString() {
			return this.t + " " + d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int m = n * k;

		Problem[] problems = new Problem[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < k; j++) {
				problems[i * k + j] = new Problem(i + 1, Integer.parseInt(st.nextToken()));
			}
		}

		Arrays.sort(problems);

		int cnt = 0;
		int answer = 10000000;

		int[] c = new int[n + 1];

		int s = 0;
		int e = 0;
		cnt++;
		c[problems[s].t]++;

		while (e < m) {
			if (cnt < n) {
				e++;
				if (e < m && c[problems[e].t]++ == 0)
					cnt++;
			} else {
				answer = Math.min(answer, problems[e].d - problems[s].d);
				if (--c[problems[s++].t] == 0)
					cnt--;
			}
		}

		System.out.println(answer);
	}
}