import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		boolean[][] canGo = new boolean[n + 1][n + 1];

		int a, b;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[b][a] = true;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= n; j++) {
					if (k == j || j == i)
						continue;
					canGo[i][j] = canGo[i][j] | (canGo[i][k] && canGo[k][j]);
				}
			}
		}
		int c;
		int answer = -1;
		for (int i = 1; i <= n; i++) {
			c = 1;
			for (int j = 1; j <= n; j++) {
				if (canGo[i][j])
					c++;
			}

			if (c == n) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}