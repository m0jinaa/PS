import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n + 1];

		int[] dp = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			dp[i] = -1;
		}

		int s, e;

		for (int i = 2; i <= n; i += 2) {
			for (int j = i - 1; j > 0; j -= 2) {
				s = j;
				e = i;

				while (s <= e) {
					if (A[s] != A[e])
						break;
					s++;
					e--;
				}

				if (s < e || dp[j - 1] == -1)
					continue;

				dp[i] = Math.max(dp[i], dp[j - 1] + 1);
			}
		}

		System.out.println(dp[n]);
	}
}