import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, i, j;

		public Node(int x, int i, int j) {
			super();
			this.x = x;
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Node node) {
			return node.x - this.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] rooms = new int[n][m];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		int min = 1_000_000_001;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				rooms[i][j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(rooms[i]);
			min = Math.min(min, rooms[i][m - 1]);
			pq.add(new Node(rooms[i][m - 1], i, m - 1));
		}
		int max;
		Node node;

		int answer = 1_000_000_001;
		int i, j;
		while (true) {
			node = pq.poll();

			max = node.x;
			i = node.i;
			j = node.j;
			answer = Math.min(answer, max - min);

			if (j == 0) {
				break;
			}

			min = Math.min(min, rooms[i][j - 1]);
			pq.add(new Node(rooms[i][j - 1], i, j - 1));
		}

		System.out.println(answer);
	}
}