import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static int[] v;

	static LinkedList<Integer> queue;

	static void bfs() {
		queue.clear();
		queue.add(1);
		v[1] = 0;
		int now;
		while (!queue.isEmpty()) {
			now = queue.poll();
			for (int y : canGo[now]) {
				if (v[y] != -1)
					continue;
				v[y] = v[now] + 1;
				queue.add(y);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		v = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList();
		}

		int x, y;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			canGo[x].add(y);
			canGo[y].add(x);

		}

		queue = new LinkedList<>();

		int q = Integer.parseInt(br.readLine());

		while (q-- > 0) {
			Arrays.fill(v, -1);
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			canGo[x].add(y);
			canGo[y].add(x);
			bfs();
			for (int i = 1; i <= n; i++) {
				sb.append(v[i]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}