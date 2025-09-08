import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 1_000_000_007;

	static int[] inDegree, cost, prestige;

	static class Menu {
		int x;
		int c, p;

		public Menu(int x, int c, int p) {
			super();
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}

	static int ind = 0;
	static Map<String, Integer> map;
	static LinkedList<Menu>[] canMake;

	static int getInd(String name) {
		if (!map.containsKey(name)) {
			map.put(name, ind++);
		}

		return map.get(name);
	}

	static void setPrestige() {
		LinkedList<Integer> q = new LinkedList<>();

		// inDegree가 0인 메뉴부터 시작
		for (int i = 0; i < ind; i++) {
			if (inDegree[i] != 0)
				continue;

			q.add(i);
			cost[i] = 0;
			prestige[i] = 0;
		}

		int x;
		int nc, np;

		while (!q.isEmpty()) {
			x = q.poll();

			for (Menu menu : canMake[x]) {
				nc = cost[x] + menu.c;
				np = prestige[x] + menu.p;

				// 가격이 싼 쪽으로, 가격이 같다면 prestige가 높은 쪽으로 설정
				if (cost[menu.x] > nc) {
					cost[menu.x] = nc;
					prestige[menu.x] = np;
				} else if (cost[menu.x] == nc && prestige[menu.x] < np) {
					prestige[menu.x] = np;
				}

				inDegree[menu.x]--;

				// inDegree가 0이 되면 큐에 추가
				if (inDegree[menu.x] == 0) {
					q.add(menu.x);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int b = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		map = new HashMap<>();
		cost = new int[2 * n];
		prestige = new int[2 * n];
		inDegree = new int[2 * n];

		Arrays.fill(cost, INF);

		canMake = new LinkedList[2 * n];

		int x, y, c, p;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = getInd(st.nextToken());
			y = getInd(st.nextToken());

			st.nextToken();

			c = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			if (canMake[y] == null) {
				canMake[y] = new LinkedList<>();
			}
			if (canMake[x] == null) {
				canMake[x] = new LinkedList<>();
			}

			canMake[y].add(new Menu(x, c, p));
			inDegree[x]++;
		}

		// 메뉴마다 cost와 prestige 설정
		setPrestige();

		int[] dp = new int[b + 1];

		Arrays.fill(dp, -1);

		dp[0] = 0;

		for (int i = 0; i < ind; i++) {
			if (cost[i] == 0)
				continue;
			for (int j = b; j >= cost[i]; j--) {
				if (dp[j - cost[i]] == -1)
					continue;
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + prestige[i]);
			}
		}

		int minCost = -1;
		int maxPrestige = -1;

		for (int i = 0; i <= b; i++) {
			if (dp[i] > maxPrestige) {
				maxPrestige = dp[i];
				minCost = i;
			}
		}

		sb.append(maxPrestige).append("\n").append(minCost).append("\n");

		System.out.print(sb.toString());
	}
}