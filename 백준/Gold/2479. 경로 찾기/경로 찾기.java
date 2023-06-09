import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static boolean check(int a, int b) {
		int c = a ^ b;
		int cnt = 0;
		while (c > 0) {
			if (c % 2 != 0) {
				cnt++;
			}
			c >>= 1;
		}

		return cnt == 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] nums = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(br.readLine(), 2);
		}

		st = new StringTokenizer(br.readLine(), " ");

		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] canGo = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				if (check(nums[i], nums[j])) {
					canGo[i].add(j);
					canGo[j].add(i);
				}
			}
		}

		int[] bef = new int[n + 1];
		boolean[] v = new boolean[n + 1];

		v[s] = true;
		LinkedList<Integer> q = new LinkedList<>();

		q.add(s);
		int now;
		boolean success = false;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now == e) {
				success = true;
			}
			for (int nx : canGo[now]) {
				if (v[nx])
					continue;
				bef[nx] = now;
				v[nx] = true;
				q.add(nx);
			}
		}

		if (success) {
			int x = e;
			Stack<Integer> stack = new Stack<>();
			while (x != 0) {
				stack.add(x);
				x = bef[x];
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}
		} else {
			sb.append(-1);
		}

		System.out.println(sb.toString());
	}
}