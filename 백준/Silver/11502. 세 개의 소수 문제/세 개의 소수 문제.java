import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static StringBuilder sb;
	static int[] prime;
	static int[] selected;

	static boolean check(int target, int sum, int ind, int start) {
		if (ind == 3 && target == sum) {
			sb.append(selected[0]).append(" ").append(selected[1]).append(" ").append(selected[2]).append("\n");
			return true;
		} else if (ind == 3 || sum > target) {
			return false;
		} else {
			for (int i = start; i < 168; i++) {
				selected[ind] = prime[i];
				if (check(target, sum + prime[i], ind + 1, i)) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		prime = new int[168];
		selected = new int[3];

		int ind = 0;

		boolean[] isPrime = new boolean[1001];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < 1001; i++) {
			if (isPrime[i]) {
				prime[ind++] = i;
				for (int j = i * i; j < 1001; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int t = Integer.parseInt(br.readLine());

		int k;

		while (t-- > 0) {
			k = Integer.parseInt(br.readLine());

			if (!check(k, 0, 0, 0)) {
				sb.append(0).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}