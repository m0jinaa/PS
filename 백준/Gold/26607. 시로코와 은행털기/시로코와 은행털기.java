import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k, x, max;
	static boolean[][] dp;
	static int[] nums;

	static void fill() {
		dp[0][0] = true;

		for (int num : nums) {
			for (int i = k; i > 0; i--) {
				for (int j = max; j >= num; j--) {
					dp[i][j] |= dp[i - 1][j - num];
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		nums = new int[n];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			nums[i] = a;
		}

		max = k * x;

		dp = new boolean[k + 1][max + 1];

		fill();

		int answer = 0;

		int temp;

		for (int i = 0; i <= max; i++) {
			if (!dp[k][i])
				continue;
			temp = i * (max - i);

			answer = Math.max(answer, temp);
		}

		System.out.println(answer);
	}
}