import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int a, b;

		int[][] stars;
		char[] row;
		int answer;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			stars = new int[n][n];

			for (int i = 0; i < n; i++) {
				row = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					switch (row[j]) {
					case 'W':
						break;
					case 'G':
						stars[i][j] = 1;
						break;
					case 'B':
						stars[i][j] = 2;
						break;
					}
				}
			}

			answer = 0;

			// 검은색 먼저 탐색
			loop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (stars[i][j] != 2)
						continue;
					// 새로운 별이 나타난 경우
					else if (!inRange(i - b, j - a) || stars[i - b][j - a] == 0) {
						answer = -1;
						break loop;
					}
					stars[i - b][j - a]--;
					stars[i][j]--;
					answer++;
				}
			}

			if (answer != -1) {
				// 나머지 별 탐색
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (stars[i][j] == 0)
							continue;

						answer++;

						// 사진 범위를 벗어나거나 별이 사라진 경우
						if (!inRange(i + b, j + a) || stars[i + b][j + a] == 0)
							continue;

						// 최소 개수를 구하는 것이기 때문에 빼준다
						stars[i + b][j + a]--;

					}
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}