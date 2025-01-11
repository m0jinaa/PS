import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Test implements Comparable<Test> {
		int x, y;

		public Test(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Test t) {
			return this.x == t.x ? (this.y - t.y) : (this.x - t.x);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		Test[] tests = new Test[n];

		int x, y;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			tests[i] = new Test(x, x + y);
		}

		Arrays.sort(tests);

		int now = 0;

		int answer = -1;

		for (Test t : tests) {
			if (t.x - now >= m) {
				answer = now;
				break;
			} else {
				now = t.y;
			}
		}

		if (answer == -1 && s - now >= m) {
			answer = now;
		}

		System.out.println(answer);
	}
}