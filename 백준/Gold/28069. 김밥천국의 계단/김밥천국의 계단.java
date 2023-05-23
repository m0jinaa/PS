import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Stair {
		int x, t;

		public Stair(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String answer = "water";

		LinkedList<Stair> q = new LinkedList<>();

		q.add(new Stair(0, 0));

		Stair now, next;
		boolean[] dp = new boolean[1000001];
		dp[0] = true;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.x == n && now.t <= k) {
				answer = "minigimbob";
				break;
			} else if (now.x >= n || now.t >= k) {
				continue;
			} else {
				if (now.x + 1 <= 1000000 && !dp[now.x + 1]) {
					dp[now.x + 1] = true;
					next = new Stair(now.x + 1, now.t + 1);
					q.add(next);
				}
				if (now.x + now.x / 2 <= 1000000 && !dp[now.x + now.x / 2]) {
					dp[now.x + now.x / 2] = true;
					next = new Stair(now.x + now.x / 2, now.t + 1);
					q.add(next);
				}
			}
		}

		System.out.println(answer);
	}
}