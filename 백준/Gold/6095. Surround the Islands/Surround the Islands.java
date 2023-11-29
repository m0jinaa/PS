import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent;
	static int[][] cost;

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;
		else if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		parent = new int[n + 1];
		cost = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		int a, b;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			union(a, b);

			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}

		int x, y, c;
		for (int i = 1; i <= n; i++) {
			x = find(i);
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				c = Integer.parseInt(st.nextToken());
				y = find(j);
				cost[x][y] = Math.min(cost[x][y], c);
			}
		}

		int answer = Integer.MAX_VALUE;

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (find(i) == i) {
				list.add(i);
			}
		}

		int sum = 0;

		for (int i : list) {
			sum = 0;

			for (int j : list) {
				sum += cost[i][j];
			}
			answer = Math.min(answer, sum * 2);
		}

		System.out.print(answer);
	}
}