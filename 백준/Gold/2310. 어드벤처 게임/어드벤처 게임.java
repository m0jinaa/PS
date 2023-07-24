import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[][] v;
	static int[] cost;
	static ArrayList<Integer>[] canGo;
	static LinkedList<Person> q;

	static class Person {
		int loc;
		int money;

		public Person(int loc, int money) {
			super();
			this.loc = loc;
			this.money = money;
		}
	}

	static String bfs() {
		q.clear();
		q.add(new Person(1, 0));
		int nm;
		v[0][1] = true;
		Person p;
		boolean canEscape = false;
		while (!q.isEmpty()) {
			p = q.poll();

			if (p.loc == n) {
				canEscape = true;
				break;
			}

			for (int x : canGo[p.loc]) {
				if (v[p.money][x])
					continue;
				if (cost[x] < 0 && p.money + cost[x] < 0)
					continue;

				v[p.money][x] = true;
				if (cost[x] > 0)
					nm = Math.max(cost[x], p.money);
				else {
					nm = p.money + cost[x];
				}

				v[nm][x] = true;
				q.add(new Person(x, nm));

			}

		}

		return canEscape ? "Yes\n" : "No\n";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		String type;
		int m, x;

		q = new LinkedList<>();

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			cost = new int[n + 1];
			canGo = new ArrayList[n + 1];
			v = new boolean[501][n + 1];
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				canGo[i] = new ArrayList<>();

				type = st.nextToken();
				m = Integer.parseInt(st.nextToken());
				if ("T".equals(type)) {
					m *= -1;
				}
				cost[i] = m;

				while ((x = Integer.parseInt(st.nextToken())) != 0) {
					canGo[i].add(x);
				}

			}
			sb.append(bfs());
		}
		System.out.println(sb.toString());
	}
}