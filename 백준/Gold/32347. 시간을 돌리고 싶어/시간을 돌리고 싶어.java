import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] closest;

	static boolean check(int t) {
		int cnt = 0;
		int now = n - 1;
		int next;
		while (now != 0 && cnt < k) {
			next = Math.max(0, now - t);

			if (next != 0 && closest[next] == now) {
				return false;
			}

			cnt++;
			now = closest[next];
		}
		return now == 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] A = new int[n];
		closest = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int c = n - 1;

		for (int i = n - 1; i > 0; i--) {
			if (A[i] == 1)
				c = i;
			closest[i] = c;
		}

		int s = 1;
		int e = n - 1;
		int m;

		int answer = e;

		while (s <= e) {
			m = (s + e) / 2;

			if (check(m)) {
				answer = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		System.out.println(answer);
	}
}