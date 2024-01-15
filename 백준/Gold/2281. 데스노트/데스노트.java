import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] name;
	static int[] dp;

	static int getMin(int ind) {
		if (ind >= n)
			return 0;
		else if (dp[ind] != -1)
			return dp[ind];

		int len = 0;
		int sum = m * m * n;

		int temp;
		int i = ind;
		while (i < n && len + name[i] <= m) {
			len += name[i];
			if (i == n - 1) {
				temp = 0;
			} else {
				temp = (m - len) * (m - len) + getMin(i + 1);
			}
			sum = Math.min(sum, temp);

			len++; // 띄어쓰기
			i++;// 다음 이름
		}

		return dp[ind] = sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		name = new int[n];
		dp = new int[n];

		for (int i = 0; i < n; i++) {
			name[i] = Integer.parseInt(br.readLine());
			dp[i] = -1;
		}

		int answer = getMin(0);

		System.out.println(answer);
	}
}