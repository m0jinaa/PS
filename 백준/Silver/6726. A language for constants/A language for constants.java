import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	static int[] v;
	static LinkedList<Integer> q;
	static final int MAX = 100000;

	static void bfs(int x) {
		v[MAX + 1] = 1;
		v[MAX - 1] = 2;

		q.clear();
		q.add(1);
		q.add(-1);

		int now, next;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == x) {
				break;
			}

			next = now * 2;

			if (-MAX <= next && next < MAX && v[next + MAX] == 0) {
				v[next + MAX] = 4;
				q.add(next);
			}

			next = now + 1;

			if (-MAX <= next && next < MAX && v[next + MAX] == 0) {
				v[next + MAX] = 3;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int target;
		Stack<String> ans = new Stack<>();
		v = new int[2 * MAX];
		q = new LinkedList<>();
		int t = 1;

		while ((target = Integer.parseInt(br.readLine())) != 0) {
			Arrays.fill(v, 0);

			if (t != 1)
				sb.append("\n");

			sb.append("Constant ").append(target).append("\n");

			bfs(target);

			ans.clear();

			end: while (true) {
				switch (v[target + MAX]) {
				case 1:
					ans.add("C+1");
					break end;
				case 2:
					ans.add("C-1");
					break end;
				case 3:
					ans.add("INCR");
					target--;
					break;
				case 4:
					ans.add("DBL");
					target /= 2;
					break;
				}
			}

			while (!ans.isEmpty()) {
				sb.append(ans.pop()).append("\n");
			}

			t++;
		}

		System.out.print(sb.toString());
	}
}