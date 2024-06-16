import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static BigInteger total;
	static int answer;
	static BigInteger[] horizontal;
	static BigInteger[] vertical;

	static void getMin(BigInteger x, int ind, int c) {
		if (x.equals(BigInteger.ZERO) || x.equals(total)) {
			answer = Math.min(answer, c);
			return;
		} else if (ind == 2 * n || c == n) {
			int cnt = x.bitCount();
			answer = Math.min(answer, c + Math.min(cnt, n * n - cnt));
		} else {

			if (ind < n) {
				getMin(x.xor(horizontal[ind]), ind + 1, c + 1);
			} else {
				getMin(x.xor(vertical[ind % n]), ind + 1, c + 1);
			}

			getMin(x, ind + 1, c);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		horizontal = new BigInteger[n];
		vertical = new BigInteger[n];
		total = BigInteger.ZERO;
		
		BigInteger start = BigInteger.ZERO;
		int x;
		BigInteger v;

		for (int i = 0; i < n; i++) {
			horizontal[i] = BigInteger.ZERO;
			vertical[i] = BigInteger.ZERO;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				x = Integer.parseInt(st.nextToken());

				v = BigInteger.ONE.shiftLeft(i * n + j);

				horizontal[i] = horizontal[i].add(v);
				vertical[j] = vertical[j].add(v);
				total = total.add(v);

				if (x == 0)
					continue;

				start = start.add(v);
			}
		}

		answer = Integer.MAX_VALUE;

		getMin(start, 0, 0);

		System.out.println(answer);
	}
}