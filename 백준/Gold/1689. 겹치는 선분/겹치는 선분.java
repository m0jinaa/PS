import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static class Loc implements Comparable<Loc> {
		int x, v;

		public Loc(int x, int v) {
			super();
			this.x = x;
			this.v = v;
		}

		@Override
		public int compareTo(Loc l) {
			if (this.x != l.x)
				return this.x - l.x;
			else
				return this.v - l.v;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Loc[] locs = new Loc[2 * n];

		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			locs[i * 2] = new Loc(s, 1);
			locs[i * 2 + 1] = new Loc(e, -1);
		}

		Arrays.sort(locs);

		int cnt = 0;
		int answer = 0;

		for (Loc l : locs) {
			cnt += l.v;
			answer = Math.max(answer, cnt);
		}

		System.out.println(answer);
	}
}