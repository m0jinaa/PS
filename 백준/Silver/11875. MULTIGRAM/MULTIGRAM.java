import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int getGcd(int x, int y) {
		int t;

		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();
		int n = input.length;

		int[] cnt = new int[26];

		for (int c : input) {
			cnt[c - 'a']++;
		}

		int gcd = -1;

		for (int i = 0; i < 26; i++) {
			if (cnt[i] == 0)
				continue;
			else if (gcd == -1) {
				gcd = cnt[i];
			} else {
				gcd = getGcd(gcd, cnt[i]);
			}
		}

		if (gcd == 1) {
			sb.append(-1);
		} else {
			int m = n / gcd;

			for (int i = 0; i < m; i++) {
				sb.append(input[i]);
			}
		}

		System.out.println(sb.toString());
	}
}