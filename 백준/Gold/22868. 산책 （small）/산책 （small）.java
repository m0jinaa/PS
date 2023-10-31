import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] canGo;
	static boolean[] v;
	static LinkedList<Node> q;

	static class Node {
		int x;
		String p;

		public Node(int x, String p) {
			super();
			this.x = x;
			this.p = p;
		}
	}

	static String bfs(int s, int e) {
		q.clear();

		q.add(new Node(s, " "));
		v[s] = true;

		Node now;

		String answer = "";

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.x == e) {
				answer = now.p;
				break;
			}

			for (int y : canGo[now.x]) {
				if (v[y])
					continue;
				v[y] = true;
				q.add(new Node(y, now.p + " " + y));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();

		v = new boolean[n + 1];
		canGo = new ArrayList[n + 1];

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

		// 사전순 방문을 위한 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(canGo[i]);
		}

		int s, e;

		st = new StringTokenizer(br.readLine(), " ");

		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		// s -> e

		String path = bfs(s, e);

		Arrays.fill(v, false);

		st = new StringTokenizer(path, " ");

		int cnt = st.countTokens();

		int x;

		// s->e로 갈 때 들렀던 노드 제외하기

		while (st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			if (x == e)
				break;
			v[x] = true;
		}

		// e -> s

		path = bfs(e, s);

		st = new StringTokenizer(path, " ");

		cnt += st.countTokens();

		System.out.println(cnt);

	}
}