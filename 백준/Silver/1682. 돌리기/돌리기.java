import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[][] target;

	static class Node {
		int[][] board;
		int c;

		public Node() {
			super();
			board = new int[][] { { 1, 2, 3, 4 }, { 8, 7, 6, 5 } };
			c = 0;

		}

		public boolean equal() {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					if (board[i][j] != target[i][j])
						return false;
				}
			}
			return true;
		}

		public Node A() {
			Node next = new Node();

			next.board[0] = this.board[1];
			next.board[1] = this.board[0];

			next.c = this.c + 1;

			return next;
		}

		public Node B() {
			Node next = new Node();

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					next.board[i][j] = this.board[i][(j + 3) % 4];
				}
			}

			next.c = this.c + 1;

			return next;
		}

		public Node C() {
			Node next = new Node();

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					next.board[i][j] = this.board[i][j];
				}
			}

			int t = next.board[0][1];
			next.board[0][1] = next.board[0][2];
			next.board[0][2] = next.board[1][2];
			next.board[1][2] = next.board[1][1];
			next.board[1][1] = t;

			next.c = this.c + 1;

			return next;
		}

		public Node D() {
			Node next = new Node();

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					next.board[i][j] = this.board[i][j];
				}
			}

			int t = next.board[0][0];
			next.board[0][0] = next.board[1][3];
			next.board[1][3] = t;
			next.c = this.c + 1;

			return next;
		}

		public String toString() {
			String ret = "";
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 4; j++) {
					ret += this.board[i][j];
				}
			}

			return ret;
		}
	}

	static int bfs() {
		LinkedList<Node> q = new LinkedList<>();
		Set<String> set = new HashSet<>();

		Node start = new Node();

		set.add(start.toString());

		q.add(start);

		Node now, next;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.equal()) {
				answer = now.c;
				break;
			}

			next = now.A();

			if (set.add(next.toString())) {
				q.add(next);
			}

			next = now.B();

			if (set.add(next.toString())) {
				q.add(next);
			}

			next = now.C();

			if (set.add(next.toString())) {
				q.add(next);
			}

			next = now.D();

			if (set.add(next.toString())) {
				q.add(next);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		target = new int[2][4];

		st = new StringTokenizer(br.readLine(), " ");

		for (int j = 0; j < 4; j++) {
			target[0][j] = Integer.parseInt(st.nextToken());
		}
		for (int j = 3; j >= 0; j--) {
			target[1][j] = Integer.parseInt(st.nextToken());
		}

		System.out.println(bfs());
	}
}