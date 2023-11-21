import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] E = new int[][] { { 1, 0 }, { 0, 1 } };

	static int[][] multiply(int[][] A, int[][] B) {
		int[][] answer = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					answer[i][j] += A[i][k] * B[k][j];
					answer[i][j] %= m;

				}
			}
		}

		return answer;
	}

	static int[][] pow(int[][] A, int p) {
		if (p == 0) {
			return E;
		} else if (p == 1) {
			return A;
		} else {
			int[][] half = pow(A, p / 2);
			if (p % 2 == 0) {
				return multiply(half, half);
			} else {
				return multiply(multiply(half, half), A);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int p;
		int[][] matrix, answer;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0 && p == 0)
				break;

			matrix = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken()) % m;

				}
			}

			answer = pow(matrix, p);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(answer[i][j]).append(j == n - 1 ? "\n" : " ");
				}
			}

			sb.append("\n");
		}

		System.out.print(sb.toString());

	}
}