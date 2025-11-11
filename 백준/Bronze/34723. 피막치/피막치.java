import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		st = new StringTokenizer(br.readLine(), " ");

		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int x = Integer.parseInt(br.readLine());

		int pmc;

		int answer = INF;

		for (int i = 1; i <= p; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 1; k <= c; k++) {
					pmc = (i + j) * (j + k);

					answer = Math.min(answer, Math.abs(pmc - x));
				}
			}
		}

		System.out.println(answer);
	}
}