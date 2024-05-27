import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		r *= r;

		int[][] locs = new int[n][2];

		int sx = 101, sy = 101, ex = -101, ey = -101;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			locs[i][0] = Integer.parseInt(st.nextToken());
			locs[i][1] = Integer.parseInt(st.nextToken());

			sx = Math.min(sx, locs[i][0]);
			sy = Math.min(sy, locs[i][1]);
			ex = Math.max(ex, locs[i][0]);
			ey = Math.max(ey, locs[i][1]);
		}

		int cnt = 0;

		int max = 0;

		int answerX = 0;
		int answerY = 0;

		int d;

		for (int i = sx; i <= ex; i++) {
			for (int j = sy; j <= ey; j++) {
				cnt = 0;
				for (int k = 0; k < n; k++) {
					d = (int) (Math.pow(i - locs[k][0], 2) + Math.pow(j - locs[k][1], 2));
					if (d <= r)
						cnt++;
				}

				if (cnt > max) {
					max = cnt;
					answerX = i;
					answerY = j;
				}
			}
		}

		System.out.println(answerX + " " + answerY);
	}
}