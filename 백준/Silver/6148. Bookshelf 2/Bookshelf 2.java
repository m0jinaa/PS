import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;
	static int n, b;
	static int[] cow;

	static int getMinDiff(int ind, int s) {
		if (s >= b) {
			return s - b;
		} else if (ind == n) {
			return INF;
		} else {
			int min = INF;

			// ind번째 소 쌓기
			min = Math.min(min, getMinDiff(ind + 1, s + cow[ind]));

			// 안쌓고 넘어가기
			min = Math.min(min, getMinDiff(ind + 1, s));

			return min;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		cow = new int[n];

		for (int i = 0; i < n; i++) {
			cow[i] = Integer.parseInt(br.readLine());
		}

		int answer = getMinDiff(0, 0);

		System.out.println(answer);
	}
}