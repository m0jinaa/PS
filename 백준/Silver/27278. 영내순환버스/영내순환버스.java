import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] busStop = new int[2 * n];

		st = new StringTokenizer(br.readLine(), " ");

		int[] time = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 2; i < 2 * n; i++) {
			busStop[i] = busStop[i - 1] + time[((i - 2) % n) + 1];
		}

		long max = 0;

		int p, r, c;

		long s, e;
		int cycle = busStop[n + 1];

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			s = cycle * (long) Math.ceil(Math.max(0, c - busStop[p]) * 1.0 / cycle) + busStop[p];

			e = s + (p > r ? busStop[r + n] : busStop[r]) - busStop[p];

			max = Math.max(e, max);
		}

		System.out.println(max);
	}
}