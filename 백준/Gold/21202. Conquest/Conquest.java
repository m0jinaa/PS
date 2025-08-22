import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] army;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] checked = new boolean[n + 1];

		ArrayList<Integer>[] canGo = new ArrayList[n + 1];
		army = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
			canGo[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			army[i] = Integer.parseInt(br.readLine());
		}

		checked[1] = true;

		int armySize = army[1];

		// 군대 규모 순으로 오름차순 정렬
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				return army[x] - army[y];
			}
		});

		for (int y : canGo[1]) {
			checked[y] = true;
			q.add(y);
		}

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			// 갈 수 있는 곳들 중 최소군대규모가 현재 규모보다 같거나 크다면 탈출
			if (armySize <= army[now])
				break;

			armySize += army[now];

			for (int y : canGo[now]) {
				if (checked[y])
					continue;
				checked[y] = true;
				q.add(y);
			}
		}

		System.out.println(armySize);
	}
}