import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static String[] dp;
	static HashMap<String, Integer> map;

	static String fill(int x) {
		if (dp[x] != null)
			return dp[x];
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < x; i++) {
			sb.append(fill(i));
			if (i != x - 1) {
				sb.append(",");
			}
		}
		sb.append("}");

		dp[x] = sb.toString();
		map.put(dp[x], x);
		sb.setLength(0);
		return dp[x];
	}

	static void init() {
		dp = new String[16];

		dp[0] = "{}";
		map.put("{}", 0);
		fill(15);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		map = new HashMap<>();
		init();

		int n = Integer.parseInt(br.readLine());
		int a, b;
		String A, B;

		while (n-- > 0) {
			A = br.readLine();
			B = br.readLine();
			a = map.get(A);
			b = map.get(B);
			sb.append(dp[a + b]).append("\n");
		}
        
		System.out.print(sb.toString());
	}
}