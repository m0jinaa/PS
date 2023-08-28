import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int n, m, l;
	static int[] dx, dy;
	static char[][] map;
	static char[] word;
	static int[][][] dp;

	static int getCnt(int x, int y, int ind) {
		if (dp[x][y][ind] != -1)
			return dp[x][y][ind];
		else if (ind == l - 1) {
			return dp[x][y][ind] = 1;
		}
		int cnt = 0;
		int nx, ny;
		for (int i = 0; i < 8; i++) {
			nx = (x + dx[i]) % n;
			ny = (y + dy[i]) % m;

			if (map[nx][ny] != word[ind + 1])
				continue;
			cnt += getCnt(nx, ny, ind + 1);
		}

		return dp[x][y][ind] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		dx = new int[] { n - 1, n - 1, n - 1, 0, 1, 1, 1, 0 };
		dy = new int[] { m - 1, 0, 1, 1, 1, 0, m - 1, m - 1 };
		map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		HashMap<String, Integer> record = new HashMap<>();
		String w;
		int c;
		while (k-- > 0) {
			w = br.readLine();

			if (record.containsKey(w)) {
				c = record.get(w);
			} else {
				l = w.length();
				c = 0;
				word = w.toCharArray();

				dp = new int[n][m][l];

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						Arrays.fill(dp[i][j], -1);
					}
				}

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if(map[i][j] ==word[0])
							c += getCnt(i, j, 0);
					}
				}

				record.put(w, c);
			}

			sb.append(c).append("\n");
		}

		System.out.println(sb.toString());
	}
}