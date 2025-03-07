import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int INF = 1_000_000_007;
	static int n;
    static char[] word;
	static int[][] dp;
	static int[] left, right;

	static int getLength(int now, int s, int e) {
		// now에서 출발해서 s를 거쳐 e로 끝내는 거리
		return Math.abs(now - s) + Math.abs(s - e);
	}

	static int getMin(int ord, int now) {
		if (dp[ord][now] != INF)
			return dp[ord][now];
		else if (left[ord] == n) // 문자열에 해당 문자 등장x
			return getMin(ord + 1, now);

		// 최소거리 = min(현재 문자를 왼쪽->오른쪽으로 순회돌았을 때 최소거리, 오른쪽->왼쪽으로 순회돌았을 때 최소거리)
		return dp[ord][now] = Math.min(getLength(now, left[ord], right[ord]) + getMin(ord + 1, right[ord]),
				getLength(now, right[ord], left[ord]) + getMin(ord + 1, left[ord]));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		word = br.readLine().toCharArray();

		n = word.length;

		dp = new int[27][n];
		left = new int[26];
		right = new int[26];

		Arrays.fill(left, n);
		Arrays.fill(right, -1);

		for (int i = 0; i < 26; i++) {
			Arrays.fill(dp[i], INF);
		}

		int l;

		for (int i = 0; i < n; i++) {
			l = word[i] - 'a';
			left[l] = Math.min(left[l], i);
			right[l] = Math.max(right[l], i);
		}

		// 움직이는 최소거리 + 엔터누르는 횟수
		int answer = getMin(0, 0) + n;

		System.out.println(answer);
	}
}