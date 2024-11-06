import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[] barn = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			barn[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			barn[i] -= Integer.parseInt(st.nextToken());
		}

		Arrays.sort(barn);

		int v, s;

		int l, r, m;

		int c;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			v = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			l = 0;
			r = n - 1;
			c = n;

			while (l <= r) {
				m = (l + r) / 2;

				if (barn[m] > s) {
					c = m;
					r = m - 1;
				} else {
					l = m + 1;
				}
			}

			sb.append((n - c) >= v ? "YES\n" : "NO\n");
		}

		System.out.println(sb.toString());
	}
}