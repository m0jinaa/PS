import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k, t;
	static int[] parent;
	static int[][] info;
	static boolean[] hasPhoto;

	static int find(int x) {
		if (parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return;
		else if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

	static boolean canSend(int x, int y) {
		return (Math.pow(info[x][0] - info[y][0], 2) + Math.pow(info[x][1] - info[y][1], 2) <= k * k
				&& Math.abs(info[x][2] - info[y][2]) <= t);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		info = new int[n + 1][3];
		parent = new int[n + 1];
		hasPhoto = new boolean[n + 1];

		info[0][0] = Integer.parseInt(st.nextToken());
		info[0][1] = Integer.parseInt(st.nextToken());
		info[0][2] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
			info[i][2] = Integer.parseInt(st.nextToken());
			hasPhoto[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
			parent[i] = i;

			for (int j = 0; j < i; j++) {
				if (canSend(i, j))
					union(i, j);
			}
		}

		boolean atLeastOne = false;

		for (int i = 1; i <= n; i++) {
			if (hasPhoto[i] && find(i) == 0) {
				sb.append(i).append(" ");
				atLeastOne = true;
			}
		}

		if (!atLeastOne)
			sb.append(0);

		System.out.println(sb.toString());
	}
}