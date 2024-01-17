import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int w, h;
	static boolean[][] board;
	static boolean[][] sticker;

	static int check(int x, int y) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (sticker[i][j] && board[x + i][y + j])
					return 0;
			}
		}
		int c = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!sticker[i][j])
					continue;
				board[x + i][y + j] = true;
				c++;
			}
		}

		return c;
	}

	static void rotate() {

		boolean[][] nsticker = new boolean[w][h];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				nsticker[j][h - 1 - i] = sticker[i][j];
			}
		}

		int t = w;
		w = h;
		h = t;

		sticker = nsticker;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		board = new boolean[n][m];
		int answer = 0;
		int v;
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			sticker = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					v = Integer.parseInt(st.nextToken());
					if (v == 0)
						continue;
					sticker[i][j] = true;
				}
			}

			end: for (int t = 0; t < 4; t++) {
				for (int x = 0; x <= n - h; x++) {
					for (int y = 0; y <= m - w; y++) {
						v = check(x, y);
						if (v != 0) {
							answer += v;
							break end;
						}

					}
				}
				rotate();
			}
		}

		System.out.println(answer);
	}
}