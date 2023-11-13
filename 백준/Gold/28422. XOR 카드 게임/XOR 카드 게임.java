import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] xor;
	static int[] dp;

	static int getMax(int ind) {
		if (ind > n)
			return 0;
		if (dp[ind] != -1)
			return dp[ind];

		int MAX = -1;
		int temp;
		if (ind + 1 <= n) {
			temp = getMax(ind + 2);
			if (temp != -1) {
				temp += Integer.bitCount(xor[ind + 1] ^ xor[ind - 1]);
				MAX = Math.max(temp, MAX);
			}
		}

		if (ind + 2 <= n) {
			temp = getMax(ind + 3);
			if (temp != -1) {
				temp += Integer.bitCount(xor[ind + 2] ^ xor[ind - 1]);
				MAX = Math.max(temp, MAX);
			}
		}

		return dp[ind] = MAX;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		xor = new int[n + 1];
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			xor[i] = xor[i - 1] ^ Integer.parseInt(st.nextToken());
		}

		int answer = getMax(1);

		System.out.println(answer == -1 ? 0 : answer);

	}
}