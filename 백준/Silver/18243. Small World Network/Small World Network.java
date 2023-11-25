import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] canGo;
	static int[] v;
	static LinkedList<Integer> q;

	static boolean bfs(int x) {

		q.clear();
		q.add(x);
		v[x] = 0;

		int now;
		int cnt = 1;

		boolean answer = true;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : canGo[now]) {
				if (v[y] != -1)
					continue;
				v[y] = v[now] + 1;
				q.add(y);
				cnt++;
				if (v[y] > 6)
					answer = false;
			}
		}

		return answer && cnt == n;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		canGo = new ArrayList[n + 1];
		v = new int[n + 1];
		q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
			canGo[b].add(a);
		}

		boolean result = true;

		for (int start = 1; start <= n; start++) {

			Arrays.fill(v, -1);

			result &= bfs(start);

		}

		System.out.println(result ? "Small World!" : "Big World!");
	}
}