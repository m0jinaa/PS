import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int r = Integer.parseInt(br.readLine());
		int n, m, k, x, y, cnt;
		while (r-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			matched = new int[m + 1];
			used = new boolean[m + 1];
			canMatch = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				canMatch[i] = new ArrayList<>();
			}

			while (k-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				x = (int) Math.ceil(Double.parseDouble(st.nextToken()));
				y = (int) Math.ceil(Double.parseDouble(st.nextToken()));

				canMatch[x].add(y);
			}

			cnt = 0;

			for (int i = 1; i <= n; i++) {
				Arrays.fill(used, false);
				if (match(i)) {
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}