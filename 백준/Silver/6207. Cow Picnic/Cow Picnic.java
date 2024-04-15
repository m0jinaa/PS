import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static boolean[] v;
	static LinkedList<Integer> q;
	static int[] cnt;

	static void bfs(int x) {

		q.clear();
		cnt[x]++;
		q.add(x);
		v[x] = true;
		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int nx : canGo[now]) {
				if (v[nx])
					continue;
				v[nx] = true;
				cnt[nx]++;
				q.add(nx);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		v = new boolean[n + 1];
		q = new LinkedList<>();
		cnt = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int s;
		int[] start = new int[k];

		for (int i = 0; i < k; i++) {
			s = Integer.parseInt(br.readLine());
			start[i] = s;
		}
		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
		}

		for (int i = 0; i < k; i++) {
			Arrays.fill(v, false);
			bfs(start[i]);
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (cnt[i] == k)
				answer++;
		}

		System.out.println(answer);
	}
}