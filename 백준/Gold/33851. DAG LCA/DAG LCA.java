import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000;
	static int n;
	static LinkedList<Integer>[] canGo;
	static int[][] v;
	static LinkedList<Node> queue;

	static class Node {
		int ind, x;

		public Node(int ind, int x) {
			super();
			this.ind = ind;
			this.x = x;
		}
	}

	static int move(int a, int b) {

		// 초기화
		Arrays.fill(v[0], INF);
		Arrays.fill(v[1], INF);

		queue.clear();
		queue.add(new Node(0, a));
		queue.add(new Node(1, b));

		v[0][a] = 0;
		v[1][b] = 0;

		Node now;

		// a와 b에서 출발해서 갈 수 있는 모든 노드까지의 거리 구하기
		while (!queue.isEmpty()) {
			now = queue.poll();

			for (int y : canGo[now.x]) {
				if (v[now.ind][y] != INF)
					continue;
				v[now.ind][y] = v[now.ind][now.x] + 1;
				queue.add(new Node(now.ind, y));
			}
		}

		int ret = INF;

		// 1번부터 살펴보면서 a와 b 모두 갈 수 있는 노드면 최댓값의 최솟값 구하기
		for (int i = 1; i <= n; i++) {
			if (v[0][i] == INF || v[1][i] == INF)
				continue;
			ret = Math.min(ret, Math.max(v[0][i], v[1][i]));
		}

		return ret == INF ? -1 : ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		canGo = new LinkedList[n + 1];
		v = new int[2][n + 1];
		queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			canGo[i] = new LinkedList<>();
		}

		int a, b;

		// 방향 간선 저장 => 역방향으로 저장하기
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[b].add(a);
		}

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append(move(a, b)).append("\n");
		}

		System.out.print(sb.toString());
	}
}