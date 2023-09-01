import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		boolean[][] v = new boolean[n + 1][n + 1];
		int m, x;
		for (int i = 1; i < n; i++) {
			m = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine(), " ");
			while (m-- > 0) {
				x = Integer.parseInt(st.nextToken());
				v[i][x] = true;
			}
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= n; j++) {
					if (k == j)
						continue;
					v[i][j] = v[i][j] || (v[i][k] && v[k][j]);
				}
			}
		}
		String answer = "NO CYCLE";

		for (int i = 1; i <= n; i++) {
			if (v[1][i] && v[i][i]) {
				answer = "CYCLE";
				break;
			}
		}

		System.out.println(answer);
	}
}