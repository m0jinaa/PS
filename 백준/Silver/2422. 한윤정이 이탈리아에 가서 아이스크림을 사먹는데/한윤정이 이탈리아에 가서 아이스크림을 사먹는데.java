import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean[][] bad;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		bad = new boolean[n + 1][n + 1];

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			bad[a][b] = true;
			bad[b][a] = true;
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (bad[i][j])
					continue;
				for (int k = j + 1; k <= n; k++) {
					if (bad[i][k] || bad[j][k])
						continue;
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}