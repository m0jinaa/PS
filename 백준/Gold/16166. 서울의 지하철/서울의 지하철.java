import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int end;
	static HashMap<Integer, Integer>[] v;
	static HashMap<Integer, ArrayList<Integer>> metro, line;
	static PriorityQueue<Node> q;

	static class Node implements Comparable<Node> {
		int x, l, c;

		public Node(int x, int l, int c) {
			super();
			this.x = x;
			this.l = l;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}

	static int bfs() {

		int answer = 11;

		Node now;
		while (!q.isEmpty()) {
			now = q.poll();
			if (v[now.l].get(now.x) < now.c)
				continue;
			if (now.x == end) {
				answer = Math.min(answer, now.c);
			}

			for (int l : line.get(now.x)) {
				for (int y : metro.get(l)) {
					if (v[l].containsKey(y) && v[l].get(y) <= now.c + (now.l == l ? 0 : 1))
						continue;
					v[l].put(y, now.c + (now.l == l ? 0 : 1));
					q.add(new Node(y, l, now.c + (now.l == l ? 0 : 1)));
				}
			}

		}
		return answer == 11 ? -1 : answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		v = new HashMap[n + 1];

		metro = new HashMap<>();
		line = new HashMap<>();

		int k, x;

		ArrayList<Integer> list, station;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			v[i] = new HashMap<>();
			while (k-- > 0) {
				x = Integer.parseInt(st.nextToken());
				list.add(x);

				if (!line.containsKey(x)) {
					line.put(x, new ArrayList<>());
				}

				station = line.get(x);
				station.add(i);

				line.put(x, station);
			}

			metro.put(i, list);
		}

		end = Integer.parseInt(br.readLine());
		q = new PriorityQueue<>();

		Node node;

		for (int y : line.get(0)) {
			node = new Node(0, y, 0);
			v[y].put(0, 0);
			q.add(node);
		}

		System.out.println(bfs());
	}
}