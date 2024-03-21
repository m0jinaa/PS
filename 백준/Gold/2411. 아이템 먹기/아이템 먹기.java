import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m, a, b;
	static int[][] dp;
	static int[][] map; // 1 : 아이템, -1 : 장애물

	static class Item implements Comparable<Item> {
		int x, y;

		public Item(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Item item) {
			if (this.x != item.x) {
				return this.x - item.x;
			} else {
				return this.y - item.y;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		dp = new int[n + 1][m + 1];

		Item[] items = new Item[a + 1];

		int x, y;

		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			items[i] = new Item(x, y);
			map[x][y] = 1;
		}

		items[a] = new Item(n, m);

		Arrays.sort(items);

		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			map[x][y] = -1;
		}

		int sx = 1, sy = 1;

		dp[1][1] = 1;

		int ex, ey;

		for (Item item : items) {
			ex = item.x;
			ey = item.y;

			for (int i = sx; i <= ex; i++) {
				for (int j = sy; j <= ey; j++) {
					if (i == sx && j == sy)
						continue;

					if (map[i][j] == -1) {
						dp[i][j] = 0;
					} else {
						if (map[i - 1][j] != -1) {
							dp[i][j] += dp[i - 1][j];
						}
						if (map[i][j - 1] != -1) {
							dp[i][j] += dp[i][j - 1];
						}
					}
				}
			}

			sx = ex;
			sy = ey;
		}

		System.out.println(dp[n][m]);
	}
}