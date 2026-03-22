import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int n = h + x;
		int m = w + y;

		int[][] B = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] A = new int[h][w];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < w; j++) {
				A[i][j] = B[i][j];
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < y; j++) {
				A[i][j] = B[i][j];
			}
		}

		for (int i = h; i < n; i++) {
			for (int j = y; j < m; j++) {
				A[i - x][j - y] = B[i][j];
			}
		}

		for (int i = x; i < n; i++) {
			for (int j = w; j < m; j++) {
				A[i - x][j - y] = B[i][j];
			}
		}

		for (int i = x; i + x < h; i++) {
			for (int j = y; j + y < w; j++) {
				A[i][j] = B[i][j] - A[i - x][j - y];
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());

	}
}