import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] v;
	static LinkedList<Integer> q;

	static int bfs(int s, int e) {
		v[s] = 0;
		q.add(s);

		int now;

		int next;

		int answer = -1;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == e) {
				answer = v[now];
				break;
			}

			// riffle
			if (now <= n / 2) {
				next = 2 * now - 1;
			} else {
				next = 2 * now - n;
			}

			if (v[next] == -1) {
				v[next] = v[now] + 1;
				q.add(next);
			}

			// scuffle

			if (now % 2 == 0) {
				next = now - 1;
			} else {
				next = now + 1;
			}

			if (v[next] == -1) {
				v[next] = v[now] + 1;
				q.add(next);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()) * 2;

		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		v = new int[n + 1];
		Arrays.fill(v, -1);

		q = new LinkedList<>();

		int answer = bfs(s, e);

		System.out.println(answer);
	}
}