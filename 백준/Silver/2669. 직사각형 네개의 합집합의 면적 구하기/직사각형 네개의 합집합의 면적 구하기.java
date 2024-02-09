import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean[][] board = new boolean[101][101];

		int t = 4;
		int a, b, c, d;
		while (t-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			for (int i = a; i < c; i++) {
				for (int j = b; j < d; j++) {
					board[i][j] = true;
				}
			}
		}

		int s = 0;

		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (!board[i][j])
					continue;
				s++;
			}
		}

		System.out.println(s);
	}
}