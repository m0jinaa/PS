import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] X = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			X[i] = X[i - 1] + Integer.parseInt(st.nextToken());
		}

		final int MAX = 1_000_000;
		boolean[] possible = new boolean[MAX + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				possible[X[j] - X[i - 1]] = true;
			}
		}

		int y;

		st = new StringTokenizer(br.readLine(), " ");

		while (m-- > 0) {
			y = Integer.parseInt(st.nextToken());

			sb.append(possible[y] ? "JAH\n" : "EI\n");
		}

		System.out.print(sb.toString());
	}
}