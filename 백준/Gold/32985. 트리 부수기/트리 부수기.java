import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static LinkedList<Integer>[] connectedTo;
	static int[] dist;

	static void bfs() {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(0);
		dist[0] = (n - 1) % 2;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			for (int nx : connectedTo[x]) {
				if (dist[nx] != -1)
					continue;
				dist[nx] = 1 - dist[x];
				q.add(nx);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 노드 개수
		n = Integer.parseInt(br.readLine());

		connectedTo = new LinkedList[n];
		dist = new int[n];

		for (int i = 0; i < n; i++) {
			connectedTo[i] = new LinkedList<>();
			dist[i] = -1;
		}

		// 간선 체크
		int a, b;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			connectedTo[a].add(b);
			connectedTo[b].add(a);
		}

		bfs();

		// 높은 노드번호부터 내림차순으로
		for (int i = n - 1; i > 0; i--) {
			sb.append(dist[i]);
		}

		System.out.println(sb.toString());
	}
}