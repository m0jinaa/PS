import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final String INF = "9999999999999999999999999999999999999999999999999999999999999999999999";
	static final int MAX_N = 1000;
	static String[] dp;
	static final char[] bracket = new char[] { ' ', '(', ')', '{', '}', '[', ']' };

	static String min(String a, String b) {
		if (a.length() != b.length()) {
			return a.length() < b.length() ? a : b;
		} else {
			return a.compareTo(b) < 0 ? a : b;
		}
	}

	static String getMin(int x) {
		if (dp[x] != null)
			return dp[x];
		String ret = INF;

		if (x % 5 == 0) {
			ret = min(ret, "5" + getMin(x / 5) + "6");
		}
		if (x % 3 == 0) {
			ret = min(ret, "3" + getMin(x / 3) + "4");
		}
		if (x % 2 == 0) {
			ret = min(ret, "1" + getMin(x / 2) + "2");
		}

		ret = min(ret, "12" + getMin(x - 1));
		ret = min(ret, getMin(x - 1) + "12");
		ret = min(ret, "34" + getMin(x - 2));
		ret = min(ret, getMin(x - 2) + "34");
		ret = min(ret, "56" + getMin(x - 3));
		ret = min(ret, getMin(x - 3) + "56");

		return dp[x] = ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int n;

		char[] answer;

		dp = new String[MAX_N + 1];

		dp[0] = "";
		dp[1] = "12";
		dp[2] = "34";
		dp[3] = "56";

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			answer = getMin(n).toCharArray();

			for (char c : answer) {
				sb.append(bracket[c - '0']);
			}

			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}