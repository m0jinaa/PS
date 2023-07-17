import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Loc {
		int x, y;

		public Loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine().trim());

		int x, y;

		Loc[] locs = new Loc[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			locs[i] = new Loc(x, y);
		}

		Arrays.sort(locs, new Comparator<Loc>() {

			@Override
			public int compare(Loc l1, Loc l2) {
				return l1.x - l2.x;
			}
		});

		x = locs[(n - 1) / 2].x;

		Arrays.sort(locs, new Comparator<Loc>() {

			@Override
			public int compare(Loc l1, Loc l2) {
				return l1.y - l2.y;
			}
		});

		y = locs[(n - 1) / 2].y;

		long answer = 0;

		for (Loc l : locs) {
			answer += Math.abs(x - l.x) + Math.abs(y - l.y);
		}

		System.out.println(answer);
	}
}