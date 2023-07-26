import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int a, b;
	static boolean[] v;
	static boolean[] isPrime;
	static LinkedList<Node> q;

	static void init() {
		isPrime = new boolean[1000001];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < 1000001; i++) {
			if (!isPrime[i])
				continue;
			for (int j = i * 2; j < 1000001; j += i) {
				isPrime[j] = false;
			}
		}
	}

	static boolean inRange(int x) {
		if (x < 0 || x > 1000000)
			return false;
		return true;
	}

	static class Node {
		int x, d;

		public Node(int x, int d) {
			super();
			this.x = x;
			this.d = d;
		}

	}

	static int bfs(int x) {
		q.clear();
		q.add(new Node(x, 0));
		v[x] = true;

		Node now;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (a <= now.x && now.x <= b && isPrime[now.x]) {
				answer = now.d;
				break;
			}

			if (inRange(now.x / 2) && !v[now.x / 2]) {
				v[now.x / 2] = true;
				q.add(new Node(now.x / 2, now.d + 1));
			}
			if (inRange(now.x / 3) && !v[now.x / 3]) {
				v[now.x / 3] = true;
				q.add(new Node(now.x / 3, now.d + 1));
			}
			if (inRange(now.x + 1) && !v[now.x + 1]) {
				v[now.x + 1] = true;
				q.add(new Node(now.x + 1, now.d + 1));
			}
			if (inRange(now.x - 1) && !v[now.x - 1]) {
				v[now.x - 1] = true;
				q.add(new Node(now.x - 1, now.d + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		init();

		int t = Integer.parseInt(br.readLine());
		v = new boolean[1000001];
		q = new LinkedList<>();

		int n;
		while (t-- > 0) {
			Arrays.fill(v, false);

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			sb.append(bfs(n)).append("\n");
		}

		System.out.println(sb.toString());
	}
}