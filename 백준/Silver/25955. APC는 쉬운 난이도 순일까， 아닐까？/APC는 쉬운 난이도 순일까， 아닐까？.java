import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Problem implements Comparable<Problem> {
		int ind;
		int tier;
		int level;
		String p;

		public Problem(int ind, int tier, int level, String p) {
			super();
			this.ind = ind;
			this.tier = tier;
			this.level = level;
			this.p = p;
		}

		@Override
		public int compareTo(Problem p) {
			if (this.tier == p.tier) {
				return p.level - this.level;
			} else {
				return this.tier - p.tier;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Problem[] problems = new Problem[n];

		st = new StringTokenizer(br.readLine(), " ");

		int t, l;
		String p;

		for (int i = 0; i < n; i++) {
			p = st.nextToken();

			switch (p.charAt(0)) {
			case 'B':
				t = 0;
				break;
			case 'S':
				t = 1;
				break;
			case 'G':
				t = 2;
				break;
			case 'P':
				t = 3;
				break;
			default:
				t = 4;
				break;
			}

			l = Integer.parseInt(p.substring(1));

			problems[i] = new Problem(i, t, l, p);
		}

		Arrays.sort(problems);

		boolean changed = false;
		String answer = "OK";

		for (int i = 0; i < n; i++) {
			if (problems[i].ind != i) {
				if (changed) {
					answer = "KO\n" + answer + " " + problems[i].p;
					break;
				} else {
					answer = problems[i].p;
					changed = true;
				}
			}
		}

		System.out.println(answer);
	}
}