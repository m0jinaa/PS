import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Loc {
		int x, y, l;

		public Loc(int x, int y, int l) {
			super();
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][];
		boolean[][] canBuild = new boolean[n][m];
		int l = Math.min(n, m);

		int[] cnt = new int[l + 1];

		LinkedList<Loc> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 'X')
					continue;
				q.add(new Loc(i, j, 1));
				cnt[1]++;
				canBuild[i][j] = true;
			}
		}

		Loc now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x + now.l >= n || now.y + now.l >= m || !canBuild[now.x + 1][now.y + 1]
					|| map[now.x + now.l][now.y] == 'X' || map[now.x][now.y + now.l] == 'X') {
				canBuild[now.x][now.y] = false;
				continue;
			}
			cnt[now.l + 1]++;
			q.add(new Loc(now.x, now.y, now.l + 1));
		}

		for (int i = 1; i <= l; i++) {
			sb.append(cnt[i]).append("\n");
		}

		System.out.print(sb.toString());
	}
}