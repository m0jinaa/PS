import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] canGo;
	static int[] v;
	static LinkedList<Integer> queue;

	static void bfs() {
		queue.clear();
		queue.add(1);

		Arrays.fill(v, -1);

		v[1] = 0;
		int now;
		while (!queue.isEmpty()) {
			now = queue.poll();

			for (int i = 1; i <= n; i++) {
				if (!canGo[now][i] || v[i] != -1)
					continue;
				v[i] = v[now] + 1;
				queue.add(i);

			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		v = new int[n + 1];
		canGo = new boolean[n + 1][n + 1];

		queue = new LinkedList<>();

		int x, y;
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x][y] = true;
			canGo[y][x] = true;
		}

		int q = Integer.parseInt(br.readLine());

		int a, i, j;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());

			if (a == 1) {
				canGo[i][j] = true;
				canGo[j][i] = true;
			} else {
				canGo[i][j] = false;
				canGo[j][i] = false;
			}

			bfs();

			for (int k = 1; k <= n; k++) {
				sb.append(v[k]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}