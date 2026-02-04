import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[] L = new int[n];
		int[] R = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			L[i] = Integer.parseInt(st.nextToken());
			R[i] = Integer.parseInt(st.nextToken());
		}

		boolean survive = false;

		int s, e;

		boolean possible;

		for (int i = -1; i < n && !survive; i++) {
			// i번째 광역기를 방패로 막으면 생존가능?
			// (i == -1 -> 방패 안씀)

			possible = true;
			s = -INF;
			e = INF;

			for (int j = 0; j < n; j++) {
				if (i != j) {
					s = Math.max(s, L[j]);
					e = Math.min(e, R[j]);

					if (s > e) {
						possible = false;
						break;
					}
				}

				s -= 1;
				e += 1;
			}

			survive = possible;
		}
		System.out.println(survive ? "World Champion\n" : "Surrender\n");
	}
}