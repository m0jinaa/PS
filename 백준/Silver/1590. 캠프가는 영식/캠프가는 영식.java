import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		final int INF = 1_000_000_007;

		int answer = INF;

		int s, i, c, e;
		int wait;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			i = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			e = s + i * (c - 1);

			if (e < t)
				continue;
			else if (s > t) {
				answer = Math.min(answer, s - t);
			} else {
				wait = (i - ((t - s) % i)) % i;

				answer = Math.min(answer, wait);
			}
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}