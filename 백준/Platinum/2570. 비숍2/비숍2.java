import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] map;
	static int[][] vertical;
	static int[] put;
	static boolean[] used;
	static ArrayList<Integer>[] canPut;

	static boolean match(int x) {
		for (int y : canPut[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (put[y] == 0 || match(put[y])) {
				put[y] = x;
				return true;
			}
		}
		return false;
	}

	static int getVertical() {
		int ind = 1;
		int x, y;
		for (int j = 1; j <= 2 * N - 1; j++) {
			if (j <= N) {
				x = 1;
				y = N + 1 - j;
			} else {
				x = j + 1 - N;
				y = 1;
			}
			while (x != N + 1 && y != N + 1) {
				if (map[x][y]) {
					ind++;
				} else {
					vertical[x][y] = ind;
				}
				x += 1;
				y += 1;
			}
			ind++;
		}
		return ind - 1;
	}

	static int getHorizontal() {
		int ind = 1;
		int x, y;
		for (int j = 1; j <= 2 * N - 1; j++) {
			if (j <= N) {
				x = 1;
				y = j;
			} else {
				x = j - N + 1;
				y = N;
			}
			while (x != N + 1 && y != 0) {
				if (map[x][y]) {
					ind++;
				} else {
					canPut[vertical[x][y]].add(ind);
				}
				x += 1;
				y -= 1;
			}
			ind++;
		}
		return ind - 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		map = new boolean[N + 1][N + 1];
		vertical = new int[N + 1][N + 1];

		int x, y;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x][y] = true;
		}

		int n = getVertical();

		canPut = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			canPut[i] = new ArrayList<>();
		}

		int m = getHorizontal();

		used = new boolean[m + 1];
		put = new int[m + 1];

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			Arrays.fill(used, false);
			if (match(i)) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}