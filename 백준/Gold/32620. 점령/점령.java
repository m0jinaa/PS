import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 노드 개수, 간선 개수, 시작노드
		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		// 점령시 필요한 기력, 점령시 얻는 기력 저장

		int[] A = new int[n + 1]; // 점령하는데 필요한 기력
		int[] B = new int[n + 1]; // 점령했을 때 얻는 기력

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// 간선 정보 저장
		LinkedList<Integer>[] canGo = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new LinkedList<>();
		}

		int u, v;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			canGo[u].add(v);
			canGo[v].add(u);
		}

		// 갈 수 있는 노드 관리용
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			// 점령하는데 필요한 기력 오름차순으로 정렬
			@Override
			public int compare(Integer x, Integer y) {
				return A[x] - A[y];
			}
		});

		// 방문여부 체크용
		boolean[] visited = new boolean[n + 1];

		// 얻은 총 기력
		long power = 0;

		q.add(r);
		visited[r] = true;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			if (A[x] > power)
				break;

			power += B[x];

			for (int nx : canGo[x]) {
				if (visited[nx])
					continue;
				q.add(nx);
				visited[nx] = true;
			}
		}

		System.out.println(power);
	}
}