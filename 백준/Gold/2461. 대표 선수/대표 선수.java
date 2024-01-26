import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int x, i;

		public Node(int x, int i) {
			super();
			this.x = x;
			this.i = i;
		}

		@Override
		public int compareTo(Node node) {
			return node.x - this.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer>[] rooms = new PriorityQueue[n];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		int min = 1_000_000_001;

		for (int i = 0; i < n; i++) {
			rooms[i] = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer a, Integer b) {
					return b - a;
				}

			});
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				rooms[i].add(Integer.parseInt(st.nextToken()));
			}

			min = Math.min(min, rooms[i].peek());
			pq.add(new Node(rooms[i].poll().intValue(), i));
		}
		int max, ind;
		Node node;

		int answer = 1_000_000_001;

		while (true) {
			node = pq.poll();

			max = node.x;
			ind = node.i;

			answer = Math.min(answer, max - min);

			if (rooms[ind].size() == 0) {
				break;
			}

			min = Math.min(min, rooms[ind].peek());
			pq.add(new Node(rooms[ind].poll(), ind));
		}

		System.out.println(answer);
	}
}