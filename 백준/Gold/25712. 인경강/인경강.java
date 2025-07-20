import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int isCoincide(int s1, int e1, int s2, int e2) {
		if (e2 < s1)
			return 1;
		else if (e1 < s2)
			return -1;
		else
			return 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] length = new int[m + 1];

		for (int i = 1; i <= m; i++) {
			length[i] = Integer.parseInt(st.nextToken()) / 2;
		}
		length[0] = 1;

		int[][] start = new int[m + 1][10];
		int[][] end = new int[m + 1][10];
		boolean[][] alive = new boolean[m + 1][10];

		start[0][0] = 1;
		end[0][0] = n;
		alive[0][0] = true;

		boolean possible = false;

		int ind, c;

		for (int i = 1; i <= m; i++) {
			ind = 0;

			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < length[i]; j++) {
				start[i][j] = Integer.parseInt(st.nextToken());
				end[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < length[i] && ind < length[i - 1];) {
				while (ind + 1 < length[i - 1] && !alive[i - 1][ind])
					ind++;

				if (!alive[i - 1][ind])
					break;

				c = isCoincide(start[i - 1][ind], end[i - 1][ind], start[i][j], end[i][j]);

				if (c == 0) {
					alive[i][j] = true;
					j++;
				} else if (c == -1) {
					ind++;
				} else {
					j++;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			if (alive[m][i]) {
				possible = true;
				break;
			}
		}
		System.out.println(possible ? "YES" : "NO");

	}
}