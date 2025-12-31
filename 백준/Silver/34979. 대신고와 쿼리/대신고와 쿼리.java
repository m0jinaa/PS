import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m = 4;
	static int[][] school;
	static int[] floor;

	static int[] dx = new int[] { 0, 0, 0, 1, -1 };
	static int[] dy = new int[] { 0, 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		return !(x <= 0 || x > m || y <= 0 || y > n);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		school = new int[m + 1][n + 1];
		floor = new int[m + 1];

		Arrays.fill(floor, 1);

		int o, a, b, x, y;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());

			if (o == 1) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				for (int i = 0; i < 5; i++) {
					x = a + dx[i];
					y = b + dy[i];

					if (!inRange(x, y))
						continue;

					school[x][y]++;

					if (school[x][floor[x]] < school[x][y]) {
						floor[x] = y;
					} else if (school[x][floor[x]] == school[x][y] && floor[x] > y) {
						floor[x] = y;
					}
				}
			} else {
				a = Integer.parseInt(st.nextToken());
				sb.append(floor[a]).append("\n");
			}
		}

		int max = 1;

		for (int i = 1; i <= m; i++) {
			if (school[max][floor[max]] < school[i][floor[i]]) {
				max = i;
			}
		}

		sb.append(max).append(" ").append(floor[max]);

		System.out.print(sb.toString());
	}
}