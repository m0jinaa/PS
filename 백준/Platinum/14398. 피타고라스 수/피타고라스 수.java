import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canMatch;
	static boolean[] used;
	static int[] matched;

	static boolean match(int x) {
		for (int y : canMatch[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (matched[y] == 0 || match(matched[y])) {
				matched[y] = x;
				matched[x] = y;
				return true;
			}
		}
		return false;
	}

	static long gcd(long x, long y) {
		long t;
		if (x < y) {
			t = x;
			x = y;
			y = t;
		}
		while (y != 0) {
			t = y;
			y = x % y;
			x = t;
		}
		return x + y;
	}

	static boolean matchCheck(long x, long y) {
		if (gcd(x, y) != 1)
			return false;
		else {
			long c = x * x + y * y;
			long sqrt = (long) Math.sqrt(c);

			return sqrt * sqrt == c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] stick = new int[n + 1];

		canMatch = new ArrayList[n + 1];
		used = new boolean[n + 1];
		matched = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			stick[i] = Integer.parseInt(st.nextToken());
			canMatch[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (matchCheck(stick[i], stick[j])) {
					canMatch[i].add(j);
					canMatch[j].add(i);
				}
			}
		}
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (matched[i] != 0)
				continue;
			Arrays.fill(used, false);
			if (match(i)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}