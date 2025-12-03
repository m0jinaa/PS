import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 5000;
	static int[] cnt;

	static void init() {
		int x, d;
		boolean[] digit = new boolean[10];
		boolean possible;

		// cnt[i] => 1~i까지의 수 중에 반복되는 숫자가 없는 수의 개수
		cnt = new int[MAX + 1];

		for (int i = 1; i <= MAX; i++) {
			Arrays.fill(digit, false);
			possible = true;
			x = i;

			while (x > 0) {
				d = x % 10;
				x /= 10;

				if (digit[d]) {
					possible = false;
					break;
				}
				digit[d] = true;
			}

			cnt[i] = cnt[i - 1];

			if (possible)
				cnt[i]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String input;

		int n, m, answer;

		init();

		while ((input = br.readLine()) != null && !input.isEmpty()) {

			st = new StringTokenizer(input, " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			answer = cnt[m] - cnt[n - 1];

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}