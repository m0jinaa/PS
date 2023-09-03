import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	static int n, k;
	static int[] num;
	static int[] digit;
	static int[] digitV;
	static long[][] dp;

	static long gcd(long x, long y) {
		long t;
		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x + y;
	}

	static long combi(int r, int p) {
		if (dp[r][p] != -1)
			return dp[r][p];
		long cnt = 0;
		int nr;
		for (int i = 0; i < n; i++) {
			if ((p & (1 << i)) != 0)
				continue;
			nr = (r*digitV[digit[i]]+num[i])%k;

			cnt += combi(nr, p | (1 << i));
		}

		return dp[r][p] = cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		digit = new int[n];
		num = new int[n];
		BigInteger[] temp = new BigInteger[n];
		String x;
		for (int i = 0; i < n; i++) {
			x = br.readLine();
			digit[i] = x.length();
			temp[i] = new BigInteger(x);
		}

		BigInteger bk = new BigInteger(br.readLine());
		k = bk.intValue();
		for (int i = 0; i < n; i++) {
			num[i]  = temp[i].remainder(bk).intValue();
		}
		long total = 1;
		for (int i = 1; i <= n; i++) {
			total *= i;
		}
		digitV = new int[51];
		digitV[1] = 10 % k;
		for (int i = 2; i < 51; i++) {
			digitV[i] = (digitV[i - 1] * 10) % k;
		}

		dp = new long[k][1 << n];

		for (int i = 0; i < k; i++) {
			Arrays.fill(dp[i], -1);
			dp[i][(1 << n) - 1] = 0;
		}

		dp[0][(1 << n) - 1] = 1;

		long v = combi(0, 0);

		long r = gcd(total, v);

		v /= r;
		total /= r;

		System.out.println(v + "/" + total);
	}
}