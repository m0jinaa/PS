import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static int[] isHappy;
	static Set<Integer> set;

	static boolean check(int x) {
		if (isHappy[x] != 0)
			return isHappy[x] == 1 ? true : false;

		int nx;
		set.clear();

		while (x != 1) {
			if (isHappy[x] == 1) {
				for (int s : set) {
					isHappy[s] = 1;
				}
				return true;
			} else if (set.contains(x) || isHappy[x] == -1) {
				for (int s : set) {
					isHappy[s] = -1;
				}
				return false;
			}

			set.add(x);

			nx = 0;

			while (x != 0) {
				nx += ((x % 10) * (x % 10));
				x /= 10;
			}

			x = nx;
		}

		for (int s : set) {
			isHappy[s] = 1;
		}

		return true;
	}

	static void init() {
		set = new HashSet<>();
		isPrime = new boolean[10001];
		isHappy = new int[10001];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		isHappy[1] = 1;

		for (int i = 2; i < 10001; i++) {
			if (!isPrime[i])
				continue;

			check(i);

			if (i > 100)
				continue;

			for (int j = i * i; j < 10001; j += i)
				isPrime[j] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		init();

		int tc = Integer.parseInt(br.readLine());

		int t, x;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			sb.append(t).append(" ").append(x).append(" ").append((isPrime[x] && isHappy[x] == 1) ? "YES\n" : "NO\n");
		}

		System.out.println(sb.toString());
	}
}