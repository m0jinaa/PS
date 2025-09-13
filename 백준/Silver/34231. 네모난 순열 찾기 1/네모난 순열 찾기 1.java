import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static boolean[] contains;

	static boolean check(int x1, int y1, int x2, int y2) {
		int c = (x2 - x1 + 1) * (y2 - y1 + 1);

		Arrays.fill(contains, false);

		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				if (contains[board[i][j]] || board[i][j] > c)
					return false;
				contains[board[i][j]] = true;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		contains = new boolean[n * n + 1];

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				for (int c = a; c < n; c++) {
					for (int d = b; d < n; d++) {
						if (check(a, b, c, d))
							answer++;
					}
				}
			}
		}

		System.out.println(answer);
	}
}