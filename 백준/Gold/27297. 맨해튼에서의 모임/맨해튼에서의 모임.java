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
		int m = Integer.parseInt(st.nextToken());

		long[][] dots = new long[n][m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				dots[j][i] = Long.parseLong(st.nextToken());
			}
		}

		long answer = 0;

		long meet;

		for (int i = 0; i < n; i++) {
			Arrays.sort(dots[i]);
			meet = dots[i][(m - 1) / 2];

			sb.append(meet).append(" ");

			for (long x : dots[i]) {
				answer += Math.abs(x - meet);
			}
		}

		System.out.println(answer);
		System.out.println(sb.toString());
	}
}