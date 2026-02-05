import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX = 10_000;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] cnt = new int[MAX + 1];

		int a;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				a = Integer.parseInt(st.nextToken());

				cnt[a]++;
			}
		}

		int odd = 0;

		for (int i = 1; i <= MAX; i++) {
			odd += (cnt[i]) % 2;
		}

		boolean possible = (m % 2 == 0 ? odd == 0 : odd <= n);

		System.out.print(possible ? "YES\n" : "NO\n");

	}
}