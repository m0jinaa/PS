import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent;
	static int[] cnt;// 자신을 부모로 가지는 집합에 속하는 정점의 개수
	static int[] line;// 자신과 연결된 정점의 개수

	static int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			return;
		} else if (x < y) {
			cnt[x] += cnt[y];
			cnt[y] = 0;
			parent[y] = x;
		} else {
			cnt[y] += cnt[x];
			cnt[x] = 0;
			parent[x] = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (n != m) {
			sb.append("NO");
		} else {

			cnt = new int[n + 1];
			parent = new int[n + 1];
			line = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				cnt[i] = 1;
				parent[i] = i;
			}

			int a, b;

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				union(a, b);

				line[a]++;
				line[b]++;
			}

			int one = 0;
			int three = 0;
			int fourOrMore = 0;

			for (int i = 1; i <= n; i++) {
				if (line[i] == 1) {
					one++;
				} else if (line[i] == 3) {
					three++;
				} else if (line[i] > 3) {
					fourOrMore++;
				}
			}

			// 전체 정점이 서로 이어져있지 않거나
			// 한 정점과 연결된 정점이 4개 이상이거나
			// 사이클과 비사이클과 연결된 노드가 하나 이상이거나
			// 리프노드가 업는 경우
			if (cnt[1] != n || fourOrMore > 0 || three != 1 || one != 1) {
				sb.append("NO");
			} else {
				sb.append("YES");
			}
		}

		System.out.println(sb.toString());
	}
}