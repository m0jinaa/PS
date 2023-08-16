import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static HashMap<Integer, Integer> index;
	static HashMap<Integer, Integer> number;
	static int[] v;

	static void bfs() {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(1);
		v[1] = 0;
		int now, next;
		int x, y;

		while (!q.isEmpty()) {
			now = q.poll();
			x = number.get(now);

			for (int i = 0; i < k; i++) {
				y = x ^ (1 << i);
				next = index.getOrDefault(y, -1);
				if (next == -1 || v[next] != -1)
					continue;
				v[next] = now;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		v = new int[n + 1];
		index = new HashMap<>();
		number = new HashMap<>();
		Arrays.fill(v, -1);
		int x;
		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(br.readLine(), 2);
			index.put(x, i);
			number.put(i, x);
		}

		bfs();

		int m = Integer.parseInt(br.readLine());
		int t;
		Stack<Integer> stack = new Stack<>();

		while (m-- > 0) {
			t = Integer.parseInt(br.readLine());

			if (v[t] == -1) {
				sb.append(-1).append("\n");
				continue;
			}
			stack.clear();
			while (true) {
				if (t == 0)
					break;
				stack.push(t);
				t = v[t];
			}

			while (!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}