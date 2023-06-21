import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
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

		int n, m, s, v, cnt;
		double x, y;
		double[][] gophers;
		double[][] holes;
		double dist;
		String input;
		int limit;
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input, " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			matched = new int[m + 1];
			used = new boolean[m + 1];
			canMatch = new ArrayList[n + 1];
			gophers = new double[n + 1][2];
			holes = new double[m + 1][2];

			limit = s * s * v * v;

			for (int i = 1; i <= n; i++) {
				canMatch[i] = new ArrayList<>();

				st = new StringTokenizer(br.readLine(), " ");
				x = Double.parseDouble(st.nextToken());
				y = Double.parseDouble(st.nextToken());

				gophers[i][0] = x;
				gophers[i][1] = y;
			}

			for (int i = 1; i <= m; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				x = Double.parseDouble(st.nextToken());
				y = Double.parseDouble(st.nextToken());

				holes[i][0] = x;
				holes[i][1] = y;
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					dist = Math.pow(gophers[i][0] - holes[j][0], 2) + Math.pow(gophers[i][1] - holes[j][1], 2);
					if (dist <= limit) {
						canMatch[i].add(j);
					}
				}
			}

			cnt = n;

			for (int i = 1; i <= n; i++) {
				Arrays.fill(used, false);
				if (match(i)) {
					cnt--;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}