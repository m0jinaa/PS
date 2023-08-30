import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] isFriend = new boolean[n + 1][n + 1];
		int[] cnt = new int[n + 1];
		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			cnt[x]++;
			cnt[y]++;
			isFriend[x][y] = isFriend[y][x] = true;
		}
		int INF = 12000;

		int answer = INF;
		int fc;
		for (int a = 1; a <= n; a++) {
			for (int b = a + 1; b <= n; b++) {
				if (!isFriend[a][b])
					continue;
				for (int c = b + 1; c <= n; c++) {
					if (!isFriend[b][c] || !isFriend[a][c])
						continue;
					fc = cnt[a] + cnt[b] + cnt[c] - 6;
					if (fc < answer)
						answer = fc;
				}
			}
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}