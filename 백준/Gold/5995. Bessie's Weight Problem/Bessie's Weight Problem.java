import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] hays;
	static boolean[] dp;

	static int getMax() {
		dp[0] = true;

		for (int h : hays) {
			for (int i = n; i >= h; i--) {
				dp[i] = dp[i] | dp[i - h];
			}
		}
		int answer = 0;

		for (int i = n; i >= 0; i--) {
			if (dp[i]) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dp = new boolean[n + 1];

		hays = new int[m];

		for (int i = 0; i < m; i++) {
			hays[i] = Integer.parseInt(br.readLine());
		}

		int answer = getMax();

		System.out.println(answer);
	}
}