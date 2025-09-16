import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] used;
	static int[][] triangles;

	static int answer;

	static void makeHexagon(int c, int x, int e, int sum) {
		if (c == 6) {
			if (x == e)
				answer = Math.max(answer, sum);
		} else {
			for (int i = 0; i < 6; i++) {
				if (used[i])
					continue;
				for (int j = 0; j < 3; j++) {
					if (triangles[i][j] != x)
						continue;

					used[i] = true;
					makeHexagon(c + 1, triangles[i][(j + 1) % 3], e, sum + triangles[i][(j + 2) % 3]);
					used[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String hasNext;

		used = new boolean[6];
		triangles = new int[6][3];

		while (true) {
			answer = 0;

			for (int i = 0; i < 6; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < 3; j++) {
					triangles[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			used[0] = true;

			for (int i = 0; i < 3; i++) {
				makeHexagon(1, triangles[0][(i + 1) % 3], triangles[0][i], triangles[0][(i + 2) % 3]);
			}

			used[0] = false;

			sb.append(answer == 0 ? "none" : answer).append("\n");

			hasNext = br.readLine();

			if ("$".equals(hasNext))
				break;
		}

		System.out.print(sb.toString());
	}
}