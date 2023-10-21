import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int n, h, v;
	static char[][] map;
	static int[][] horizontal;
	static boolean[] used;
	static ArrayList<Integer>[] canConnect;
	static int[] connected;

	static int getHorizontal() {
		int ind = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'X') {
					ind++;
					continue;
				} else {
					horizontal[i][j] = ind;
					if (j == n - 1)
						ind++;
				}
			}
		}

		return ind - 1;
	}

	static int getVertical() {
		int ind = 1;

		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (map[i][j] == 'X') {
					ind++;
					continue;
				} else {
					canConnect[horizontal[i][j]].add(ind);
					if (i == n - 1)
						ind++;
				}
			}
		}

		return ind - 1;
	}

	static boolean connect(int x) {
		used[x] = true;

		for (int y : canConnect[x]) {
			if (connected[y] == 0 || (!used[connected[y]] && connect(connected[y]))) {
				connected[y] = x;
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int cnt;

		while (true) {

			n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			map = new char[n][];
			horizontal = new int[n][n];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			h = getHorizontal();

			canConnect = new ArrayList[h + 1];
			used = new boolean[h + 1];

			for (int i = 1; i <= h; i++) {
				canConnect[i] = new ArrayList<>();
			}

			v = getVertical();

			connected = new int[v + 1];

			cnt = 0;

			for (int i = 1; i <= h; i++) {
				Arrays.fill(used, false);
				if (connect(i)) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}