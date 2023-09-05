import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int h, w, l;
	static long[][][] dp;
	static char[] word;
	static char[][] map;
	static int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= h || y < 0 || y >= w)
			return false;
		return true;
	}

	static long getCnt(int x, int y, int ind) {
		if (dp[x][y][ind] != -1) {
			return dp[x][y][ind];
		} else if (ind == l - 1) {
			return dp[x][y][ind] = 1;
		}
		long cnt = 0;

		int nx, ny;

		for (int i = 0; i < 8; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (!inRange(nx, ny) || map[nx][ny] != word[ind + 1])
				continue;
			cnt += getCnt(nx, ny, ind + 1);
		}

		return dp[x][y][ind] = cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		map = new char[h][];
		dp = new long[h][w][l];

		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < w; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		word = br.readLine().toCharArray();
		long answer = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == word[0]) {
					answer += getCnt(i, j, 0);
				}
			}
		}

		System.out.println(answer);
	}
}