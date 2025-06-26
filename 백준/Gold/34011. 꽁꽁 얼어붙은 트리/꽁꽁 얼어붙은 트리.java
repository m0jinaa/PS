import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dist, cnt;
	static int[] parent;

	static int getDist(int x) {
		if (dist[x] != -1)
			return dist[x];
		dist[x] = getDist(parent[x]) + 1;
		cnt[dist[x]]++;
		return dist[x];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		parent = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}

		// 거리가 i인 노드의 개수 저장
		cnt = new int[n + 1];

		// 각 노드에서 1번노드까지의 거리 저장
		dist = new int[n + 1];

		Arrays.fill(dist, -1);

		dist[1] = 0;
		cnt[0] = 1;

		for (int i = 2; i <= n; i++) {
			if (dist[i] != -1)
				continue;
			getDist(i);
		}

		int answer = 0;
		int c;

		for (int i = 2; i <= n; i++) {
			c = 0;
			for (int j = 0; j <= n; j += i) {
				c += cnt[j];
			}
			answer = Math.max(answer, c);
		}

		System.out.println(answer);
	}
}