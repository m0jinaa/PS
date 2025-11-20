import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		else if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n, m, a, b, answer;
		int tc = 0;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			tc++;

			parent = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}

			answer = n;

			while (m-- > 0) {

				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				if (union(a, b)) {
					answer--;
				}
			}

			sb.append("Case ").append(tc).append(": ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}