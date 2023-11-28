import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] cost;

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
			cost[b] = Math.min(cost[b], cost[a]);
			parent[b] = a;
		} else {
			cost[a] = Math.min(cost[a], cost[b]);
			parent[a] = b;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];
		cost = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine(), " ");

		int x;
		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());
			cost[i] = x;
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			union(a, b);
		}

		int answer = 0;

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (find(i) == i) {
				list.add(cost[i]);
			}
		}

		Collections.sort(list);

		int min = -1;

		for (int c : list) {
			if (min == -1) {
				min = c;
			} else {
				answer += min * c;
			}
		}
		System.out.print(answer);
	}
}