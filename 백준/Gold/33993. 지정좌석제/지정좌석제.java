import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		w /= 2;

		int[][] seat = new int[r + 1][c + 1];
		int[][] sum = new int[r + 1][c + 1];

		int x, y;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			seat[x][y] = 1;
		}

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				sum[i][j] = seat[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
			}
		}

		int max = 0;
		int cnt;

		int sx, sy, ex, ey;

		int maxX = -1;
		int maxY = -1;

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				// 친구가 앉아있는 자리에는 앉을 수 없음
				if (seat[i][j] == 1)
					continue;

				sx = Math.max(1, i - w);
				sy = Math.max(1, j - w);
				ex = Math.min(r, i + w);
				ey = Math.min(c, j + w);

				cnt = sum[ex][ey] - sum[ex][sy - 1] - sum[sx - 1][ey] + sum[sx - 1][sy - 1];

				if (cnt > max) {
					maxX = i;
					maxY = j;
					max = cnt;
				}
			}
		}

		sb.append(max).append("\n");
		sb.append(maxX).append(" ").append(maxY).append("\n");

		System.out.print(sb.toString());
	}
}