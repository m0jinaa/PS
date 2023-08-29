import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] canTransport;
	static int[] v;

	static int bfs(int s, int e) {
		LinkedList<Integer> q = new LinkedList<>();
		q.add(s);
		v[s] = 0;
		int x;
		int answer = -1;
		while (!q.isEmpty()) {
			x = q.poll();
			if (x == e) {
				answer = v[x];
				break;
			}
			if (x - 1 > 0 && v[x - 1] == -1) {
				v[x - 1] = v[x] + 1;
				q.add(x - 1);
			}
			if (x + 1 <= n && v[x + 1] == -1) {
				v[x + 1] = v[x] + 1;
				q.add(x + 1);
			}

			for (int y : canTransport[x]) {
				if (v[y] != -1)
					continue;
				v[y] = v[x] + 1;
				q.add(y);
			}

		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canTransport = new ArrayList[n + 1];
		v = new int[n + 1];
		Arrays.fill(v, -1);
		st = new StringTokenizer(br.readLine(), " ");

		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			canTransport[i] = new ArrayList<>();
		}
		int x, y;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canTransport[x].add(y);
			canTransport[y].add(x);
		}

		System.out.println(bfs(s, e));
	}
}