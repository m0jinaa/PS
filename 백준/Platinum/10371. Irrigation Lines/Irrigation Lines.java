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

		int tc = Integer.parseInt(br.readLine());
		int n, m, cnt;
		char[] row;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			used = new boolean[m + 1];
			matched = new int[m + 1];
			canMatch = new ArrayList[n + 1];

			for (int i = 0; i < n; i++) {
				canMatch[i + 1] = new ArrayList<>();
				row = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					if (row[j] == '1') {
						canMatch[i + 1].add(j + 1);
					}
				}
			}

			cnt = 0;

			for (int i = 1; i <= n; i++) {
				Arrays.fill(used, false);
				if (match(i)) {
					cnt++;
				}
			}

			sb.append("Case #").append(t).append(": ").append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}