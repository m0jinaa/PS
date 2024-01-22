import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static long a;
	static long[] canShoot;

	static boolean canPromote(int x) {
		long score = 0;

		int target = x;

		for (int i = 0; i < m; i++) {
			score += canShoot[target];
			target = (int) Math.min(100000, target + canShoot[target]);
		}

		return score >= a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		canShoot = new long[100001];

		int s;

		for (int i = 0; i < n; i++) {
			s = Integer.parseInt(st.nextToken());
			canShoot[s] = s;
		}

		for (int i = 1; i <= 100000; i++) {
			if (canShoot[i] == 0) {
				canShoot[i] = canShoot[i - 1];
			}
		}

		int l = 1;
		int r = 100000;
		int mid;
		int answer = r;

		while (l <= r) {
			mid = (l + r) / 2;
			if (canPromote(mid)) {
				answer = Math.min(mid, answer);
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		System.out.println(answer);
	}
}