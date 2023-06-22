import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] matched;
	static boolean[] used;
	static int[][] canMatch;

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

		int n = Integer.parseInt(br.readLine());

		used = new boolean[n + 1];
		matched = new int[n + 1];
		canMatch = new int[n + 1][];

		int l;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			canMatch[i] = new int[l];

			for (int j = 0; j < l; j++) {
				canMatch[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}

		int answer = n;

		for (int i = 1; i <= n; i++) {
			Arrays.fill(used, false);
			if (match(i)) {
				answer--;
			}
		}

		System.out.println(answer);
	}
}