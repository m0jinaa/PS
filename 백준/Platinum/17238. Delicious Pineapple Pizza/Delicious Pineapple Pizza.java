import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] matched;
	static boolean[] used;
	static ArrayList<Integer>[] canMatch;

	static boolean match(int x) {
		for (int y : canMatch[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (matched[y] == 0 || match(matched[y])) {
				matched[y] = x;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		matched = new int[n + 1];
		used = new boolean[n + 1];
		long[] pineapple = new long[n + 1];
		long[] dough = new long[n + 1];
		canMatch = new ArrayList[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			canMatch[i] = new ArrayList<>();
			pineapple[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			dough[i] = Integer.parseInt(st.nextToken());
		}

		long s = 0;
		long e = 1L << 31;
		long answer = 0;
		long m;
		boolean possible;
		while (s <= e) {
			m = (s + e) / 2;

			for (int i = 1; i <= n; i++) {
				canMatch[i].clear();
				for (int j = 1; j <= n; j++) {
					if ((pineapple[i] ^ dough[j]) >= m) {
						canMatch[i].add(j);
					}
				}
			}

			possible = true;

			Arrays.fill(matched, 0);

			for (int i = 1; i <= n; i++) {
				Arrays.fill(used, false);
				if (!match(i)) {
					possible = false;
					break;
				}
			}

			if (possible) {
				answer = Math.max(answer, m);
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		System.out.println(answer);
	}
}