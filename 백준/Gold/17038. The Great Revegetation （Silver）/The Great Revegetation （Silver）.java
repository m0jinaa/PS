import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;

	static ArrayList<Integer>[] s, d;
	static boolean possible = true;

	static void visit(int x, int v) {
		visited[x] = v;
		for (int y : s[x]) {
			if (visited[y] == 3 - v)
				possible = false;
			if (visited[y] == 0)
				visit(y, v);
		}
		for (int y : d[x]) {
			if (visited[y] == v)
				possible = false;
			if (visited[y] == 0)
				visit(y, 3 - v);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new int[n + 1];
		s = new ArrayList[n + 1];
		d = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			s[i] = new ArrayList<>();
			d[i] = new ArrayList<>();
		}

		int o, a, b;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			o = "S".equals(st.nextToken()) ? 0 : 1;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (o == 0) {
				s[a].add(b);
				s[b].add(a);
			} else {
				d[a].add(b);
				d[b].add(a);
			}
		}
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (visited[i] == 0) {
				visit(i, 1);
				answer++;
			}
		}

		if (!possible) {
			sb.append(0);
		} else {
			sb.append(1);
			for (int i = 0; i < answer; i++) {
				sb.append(0);
			}
		}

		System.out.println(sb.toString());
	}
}