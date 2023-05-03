import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] smaller = new boolean[n + 1][n + 1];
		boolean[][] bigger = new boolean[n + 1][n + 1];

		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			smaller[x][y] = true;
			bigger[y][x] = true;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (k == i || i == j || j == k)
						continue;
					smaller[i][j] = smaller[i][j] || (smaller[i][k] && smaller[k][j]);
					bigger[i][j] = bigger[i][j] || (bigger[i][k] && bigger[k][j]);
				}
			}
		}

		int answer = 0;
		int left, right;
		int limit = n / 2;
		for (int i = 1; i <= n; i++) {
			left = 0;
			right = 0;
			for (int j = 1; j <= n; j++) {
				if (smaller[i][j])
					right++;
				if (bigger[i][j])
					left++;
			}

			if (left > limit || right > limit)
				answer++;
		}
		
		System.out.println(answer);
	}
}