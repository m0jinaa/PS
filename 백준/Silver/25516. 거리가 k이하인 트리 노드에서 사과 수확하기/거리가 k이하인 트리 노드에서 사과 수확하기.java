import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static ArrayList<Integer>[] canGo;
	static int[] depth;
	static int[] apple;

	static int bfs(int x) {

		depth[0] = 0;

		LinkedList<Integer> q = new LinkedList<>();

		q.add(0);

		int now;

		int ret = 0;

		while (!q.isEmpty()) {
			now = q.poll();

			ret += apple[now];

			if (depth[now] >= k)
				continue;

			for (int y : canGo[now]) {
				depth[y] = depth[now] + 1;
				q.add(y);
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n];
		depth = new int[n];
		apple = new int[n];

		for (int i = 0; i < n; i++) {
			canGo[i] = new ArrayList<>();
		}

		Arrays.fill(depth, -1);

		int p, c;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			canGo[p].add(c);
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			apple[i] = Integer.parseInt(st.nextToken());
		}

		int answer = bfs(0);

		System.out.println(answer);
	}
}