import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] dx = new int[] { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
		int[] dy = new int[] { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] attacked = new boolean[9];

		st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int a, b, x, y;

		int[][] locs = new int[9][2];
		int cnt = 0;

		for (int i = 0; i < 9; i++) {
			x = r + dx[i];
			y = c + dy[i];

			locs[i][0] = x;
			locs[i][1] = y;

			if (x <= 0 || y <= 0 || x > n || y > n) {
				attacked[i] = true;
				cnt++;
			}
		}

		boolean king = false;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 9; i++) {
				x = locs[i][0] - a;
				y = locs[i][1] - b;

				if (!attacked[i] && (x == 0 || y == 0 || Math.abs(x) == Math.abs(y))) {
					attacked[i] = true;
					if (i == 4)
						king = true;
					else
						cnt++;
				}
			}
		}

		String answer = "NONE";

		if (king && cnt != 8)
			answer = "CHECK";
		else if (king && cnt == 8)
			answer = "CHECKMATE";
		else if (!king && cnt == 8)
			answer = "STALEMATE";

		System.out.println(answer);
	}
}