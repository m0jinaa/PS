import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] dx = new int[] { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
		int[] dy = new int[] { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

		int[] filter = new int[9];

		int[][] original = new int[r][c];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int t = Integer.parseInt(br.readLine());

		int x, y;
		int answer = 0;

		for (int i = 1; i < r - 1; i++) {
			for (int j = 1; j < c - 1; j++) {
				for (int k = 0; k < 9; k++) {
					x = i + dx[k];
					y = j + dy[k];

					filter[k] = original[x][y];
				}

				Arrays.sort(filter);

				if (filter[4] >= t) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}