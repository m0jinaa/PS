import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[] isPrime;

	static void init() {
		int limit = (int) Math.floor(Math.sqrt(100000));

		isPrime = new boolean[100001];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < 100001; i++) {
			if (!isPrime[i] || i > limit)
				continue;
			for (int j = i * i; j < 100001; j += i)
				isPrime[j] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();

		char[] row;
		int now, n, answer;
		String input;
		while (!"0".equals((input = br.readLine()))) {
			row = input.toCharArray();
			n = row.length;
			answer = 0;
			for (int s = 0; s < n; s++) {
				now = 0;
				for (int e = s; e < n; e++) {
					now = now * 10 + (row[e] - '0');
					if (now > 100000)
						break;
					else if (!isPrime[now])
						continue;
					answer = Math.max(answer, now);
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}