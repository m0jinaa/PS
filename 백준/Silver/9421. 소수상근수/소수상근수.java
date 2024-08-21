import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean[] isPrime;
	static int[] state;
	static Set<Integer> set;

	static boolean check(int x) {
		if (state[x] != 0)
			return state[x] == 1 ? true : false;

		set.clear();

		int nx;

		while (x != 1) {
			if (set.contains(x)) {
				for (Integer s : set) {
					state[s] = -1;
				}
				return false;
			}
			set.add(x);

			nx = 0;

			while (x != 0) {
				nx += (x % 10) * (x % 10);
				x /= 10;
			}

			x = nx;
		}

		return true;
	}

	static void getAnswer(int n) {
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		int limit = (int) Math.floor(Math.sqrt(n));
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i])
				continue;
			else if (check(i))
				sb.append(i).append("\n");

			if (i > limit)
				continue;
			for (int j = i * i; j <= n; j += i)
				isPrime[j] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		isPrime = new boolean[1000001];
		state = new int[1000001];

		state[1] = 1;

		set = new HashSet();

		getAnswer(n);

		System.out.print(sb.toString());
	}
}