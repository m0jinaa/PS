import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		char[] row = (" " + br.readLine()).toCharArray();

		int n = row.length;

		HashMap<String, Integer> map = new HashMap<>();

		int m = Integer.parseInt(br.readLine());

		String a;
		int x;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = st.nextToken();
			x = Integer.parseInt(st.nextToken());

			if (a.length() > x)
				continue;

			map.put(a, x);
		}

		int[] dp = new int[n];

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= i; j++) {
				a = String.copyValueOf(row, j, i - j + 1);

				dp[i] = Math.max(dp[i], dp[j - 1] + map.getOrDefault(a, i - j + 1));
			}
		}

		System.out.println(dp[n - 1]);
	}
}