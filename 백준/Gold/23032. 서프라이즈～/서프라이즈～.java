import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] steak;

	static int getMinDiff(int s, int e) {

		int l = s;
		int r = e;

		int m;

		int left, right;

		int minDiff = Integer.MAX_VALUE;

		while (l <= r) {
			m = (l + r) / 2;

			left = steak[m] - steak[s - 1];
			right = steak[e] - steak[m];

			minDiff = Math.min(minDiff, Math.abs(left - right));

			if (left < right) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}

		return minDiff;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		steak = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			steak[i] = steak[i - 1] + Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		int answer = 0;
		int ret;

		for (int s = 1; s < n; s++) {
			for (int e = s + 1; e <= n; e++) {
				ret = getMinDiff(s, e);

				if (ret < min) {
					answer = steak[e] - steak[s - 1];
					min = ret;
				} else if (ret == min) {
					answer = Math.max(answer, steak[e] - steak[s - 1]);
				}
			}
		}

		System.out.println(answer);
	}
}