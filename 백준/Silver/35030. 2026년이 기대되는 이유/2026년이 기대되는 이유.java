import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static final int MAX = 1_000_000;
	static final int N_MAX = 100_000;

	static boolean[] isPrime;
	static int[] specialSum;

	static boolean isSpecial(int x) {
		int l = 1;
		int r = x;
		int t = (int) Math.log10(x);
		int d = (int) Math.pow(10, t);
		while (t-- >= 0) {
			if (!isPrime[l * r + 1])
				return false;

			if (r == x) {
				l = r / d;
			} else {
				l = l * 10 + r / d;
			}
			r = r % d;
			d /= 10;
		}

		return true;
	}

	static void init() {
		// 소수 구하기
		isPrime = new boolean[MAX];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < MAX; i++) {
			if (!isPrime[i] || i >= 1000)
				continue;
			for (int j = i * i; j < MAX; j += i) {
				isPrime[j] = false;
			}
		}

		// 특별한 수 구하기+누적합으로 관리
		specialSum = new int[N_MAX + 1];

		for (int i = 1; i <= N_MAX; i++) {
			specialSum[i] = specialSum[i - 1] + (isSpecial(i) ? 1 : 0);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		int tc = Integer.parseInt(br.readLine());

		int n;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			sb.append(specialSum[n]).append("\n");
		}

		System.out.print(sb.toString());
	}
}