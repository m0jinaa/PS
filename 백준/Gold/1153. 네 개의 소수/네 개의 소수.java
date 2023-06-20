import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb;
	static int[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		selected = new int[4];

		boolean[] isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < 1000001; i++) {
			if (isPrime[i]) {
				for (int j = i * 2; j < 1000001; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int n = Integer.parseInt(br.readLine());

		if (n < 8) {
			sb.append(-1).append("\n");
		} else if (n % 2 == 0) {
			for (int i = 2; i <= n; i++) {
				if (isPrime[i] && isPrime[n - 4 - i]) {
					sb.append(2).append(" ").append(2).append(" ").append(i).append(" ").append(n - 4 - i).append("\n");
					break;
				}
			}
		} else {
			for (int i = 2; i <= n; i++) {
				if (isPrime[i] && isPrime[n - 5 - i]) {
					sb.append(2).append(" ").append(3).append(" ").append(i).append(" ").append(n - 5 - i).append("\n");
					break;
				}
			}
		}

		System.out.print(sb.toString());
	}
}