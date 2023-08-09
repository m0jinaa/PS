import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static boolean[] v;
	static int n;

	static class Node {
		char[] nums;
		int ind;
		int r;

		public Node(char[] nums, int ind, int r) {
			super();
			this.nums = nums;
			this.ind = ind;
			this.r = r;
		}
	}

	static String bfs() {
		LinkedList<Node> q = new LinkedList<>();
		Node now;
		String answer = "-1";
		char[] nums = new char[100];
		nums[0] = '1';

		v[n == 1 ? 0 : 1] = true;
		q.add(new Node(nums, 1, n == 1 ? 0 : 1));

		int[] dr = new int[] { 0, 1 };
		int nr;
		char[] next;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.r == 0) {
				answer = String.valueOf(now.nums, 0, now.ind);
				break;
			}

			for (int i = 0; i < 2; i++) {
				nr = (now.r * 10 + dr[i]) % n;
				if (v[nr])
					continue;
				v[nr] = true;
				next = new char[100];
				System.arraycopy(now.nums, 0, next, 0, 100);
				if (i == 0) {
					next[now.ind] = '0';
				} else {
					next[now.ind] = '1';
				}
				q.add(new Node(next, now.ind + 1, nr));
			}

		}
		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			v = new boolean[n];
			sb.append(bfs()).append("\n");
		}

		System.out.print(sb.toString());
	}
}