import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static StringBuilder trace = new StringBuilder();

	static void move(int h, int w) {

		while (h < 0) {
			trace.append("U");
			h++;
		}

		while (h > 0) {
			trace.append("D");
			h--;
		}

		while (w < 0) {
			trace.append("L");
			w++;
		}

		while (w > 0) {
			trace.append("R");
			w--;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int INF = 1_000_000_007;

		int[] need = new int[26];
		LinkedList<Node>[] have = new LinkedList[26];

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[] row;

		int l;

		for (int i = 0; i < n; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				l = row[j] - 'a';
				if (have[l] == null) {
					have[l] = new LinkedList<>();
				}
				have[l].add(new Node(i, j));
			}
		}

		char[] name = br.readLine().toCharArray();

		for (char letter : name) {
			need[letter - 'a']++;
		}

		int c = INF;

		for (int i = 0; i < 26; i++) {
			if (need[i] == 0)
				continue;
			else if (have[i] == null) {
				c = 0;
				break;
			}
			c = Math.min(c, have[i].size() / need[i]);
		}

		int x = 0;
		int y = 0;

		Node loc;
		int h, w;

		for (int i = 0; i < c; i++) {
			for (char letter : name) {
				loc = have[letter - 'a'].poll();
				h = loc.x - x;
				w = loc.y - y;

				move(h, w);

				trace.append("P");

				x = loc.x;
				y = loc.y;
			}
		}

		move(n - 1 - x, m - 1 - y);

		sb.append(c).append(" ").append(trace.length()).append("\n");

		sb.append(trace.toString());

		System.out.print(sb.toString());
	}
}