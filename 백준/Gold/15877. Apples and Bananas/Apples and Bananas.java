import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int a, b;

	static int[] dx = new int[] { 0, 1, 3, 1 };
	static int[] dy = new int[] { 1, 0, 1, 3 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x > a || y < 0 || y > b);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		boolean[][] dp = new boolean[a + 1][b + 1];

		int nx, ny;

		for (int x = 0; x <= a; x++) {
			for (int y = 0; y <= b; y++) {
				for (int k = 0; k < 4; k++) {
					nx = x - dx[k];
					ny = y - dy[k];

					if (!inRange(nx, ny) || dp[nx][ny])
						continue;

					dp[x][y] = true;
					break;
				}
			}
		}

		System.out.println(dp[a][b] ? "Alice" : "Bob");
	}
}