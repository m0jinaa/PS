import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] prime;
	static boolean[] isPrime;
	static final int MAX = 100000;
	static final int CNT = 9592;

	static void init() {
		prime = new int[CNT];
		int ind = 0;

		isPrime = new boolean[MAX];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		int limit = (int) Math.sqrt(MAX);

		for (int i = 2; i < MAX; i++) {
			if (!isPrime[i])
				continue;

			// 소수 저장
			prime[ind++] = i;

			if (i > limit)
				continue;

			for (int j = i * i; j < MAX; j += i) {
				isPrime[j] = false;
			}
		}
	}

	// 나보다 같거나 큰 값 중 최소값의 인덱스 찾기
	static int findRight(int x) {
		int s = 0;
		int e = CNT - 1;

		int ret = -1;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (prime[m] <= x) {
				ret = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return ret;
	}

	// 나보다 같거나 작은 값 중 최대값의 인덱스 찾기
	static int findLeft(int x) {
		int s = 0;
		int e = CNT - 1;

		int ret = CNT;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (prime[m] >= x) {
				ret = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		init();

		String least = "";
		int leastValue = CNT + 1;

		String most = "";
		int mostValue = -1;

		int n = Integer.parseInt(br.readLine());

		String name;
		String number;

		int left, right;
		int temp;

		int l, r, c;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			name = st.nextToken();
			number = st.nextToken();
			left = Integer.parseInt(number.substring(0, 5));
			right = Integer.parseInt(number.substring(5, 10));

			if (left > right) {
				temp = left;
				left = right;
				right = temp;
			}

			l = findLeft(left);
			r = findRight(right);

			c = r - l + 1;

			if (c > mostValue || (c == mostValue && most.compareTo(name) > 0)) {
				most = name;
				mostValue = c;
			}

			if (c < leastValue || (c == leastValue && least.compareTo(name) > 0)) {
				least = name;
				leastValue = c;
			}
		}

		sb.append(most).append("\n").append(least).append("\n");

		System.out.print(sb.toString());
	}
}