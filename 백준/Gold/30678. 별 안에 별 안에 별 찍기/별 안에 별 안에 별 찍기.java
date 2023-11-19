import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] map;

	static void drawStar(int sx, int sy, int ex, int ey) {
		if (sx == ex && sy == ey) {
			map[sx][sy] = '*';
		} else {
			// 한 칸 사이즈
			int size = (ex - sx + 1) / 5;

			drawStar(sx, sy + 2 * size, sx + size - 1, sy + 3 * size - 1);

			drawStar(sx + size, sy + 2 * size, sx + 2 * size - 1, sy + 3 * size - 1);

			drawStar(sx + 2 * size, sy, sx + 3 * size - 1, sy + size - 1);
			drawStar(sx + 2 * size, sy + size, sx + 3 * size - 1, sy + 2 * size - 1);
			drawStar(sx + 2 * size, sy + 2 * size, sx + 3 * size - 1, sy + 3 * size - 1);
			drawStar(sx + 2 * size, sy + 3 * size, sx + 3 * size - 1, sy + 4 * size - 1);
			drawStar(sx + 2 * size, sy + 4 * size, sx + 3 * size - 1, sy + 5 * size - 1);

			drawStar(sx + 3 * size, sy + size, sx + 4 * size - 1, sy + 2 * size - 1);
			drawStar(sx + 3 * size, sy + 2 * size, sx + 4 * size - 1, sy + 3 * size - 1);
			drawStar(sx + 3 * size, sy + 3 * size, sx + 4 * size - 1, sy + 4 * size - 1);

			drawStar(sx + 4 * size, sy + size, sx + 5 * size - 1, sy + 2 * size - 1);
			drawStar(sx + 4 * size, sy + 3 * size, sx + 5 * size - 1, sy + 4 * size - 1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		// 전체 크기
		int l = (int) Math.pow(5, n);

		map = new char[l][l];

		for (int i = 0; i < l; i++) {
			Arrays.fill(map[i], ' ');
		}

		drawStar(0, 0, l - 1, l - 1);

		for (int i = 0; i < l; i++) {
			sb.append(String.valueOf(map[i])).append("\n");
		}

		System.out.print(sb.toString());
	}
}