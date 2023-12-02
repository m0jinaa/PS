import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] supervisor;

	static int find(int x) {
		if (supervisor[x] != x) {
			supervisor[x] = find(supervisor[x]);
		}
		return supervisor[x];
	}

	static boolean union(int a, int b) {
		if (a < b) {
			if (supervisor[b] != b) {
				return false;
			}
			supervisor[b] = a;
		} else {
			if (supervisor[a] != a) {
				return false;
			}
			supervisor[a] = b;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int k, p, s;

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		supervisor = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			supervisor[i] = i;
		}

		int a, b;
		StringBuilder delete = new StringBuilder();
		StringBuilder add = new StringBuilder();

		p = 0;

		k = m;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) {
				delete.append(a).append(" ").append(b).append("\n");
				p++;
			}
		}

		s = 0;

		for (int i = 1; i <= n; i++) {
			if (find(i) == i) {
				if (i != 1) {
					add.append(1).append(" ").append(i).append("\n");
					s++;
				}
			}
		}

		k -= p;
		k += s;

		sb.append(k).append(" ").append(p).append(" ").append(s).append("\n");

		sb.append(delete.toString());
		sb.append(add.toString());

		System.out.println(sb.toString());

	}
}