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
		int q = Integer.parseInt(st.nextToken());

		int[][] cnt = new int[n + 1][4];

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(br.readLine());

			for (int j = 1; j < 4; j++) {
				cnt[i][j] = cnt[i - 1][j];
			}

			cnt[i][x]++;
		}

		int a, b, c;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			for (int i = 1; i < 4; i++) {
				c = cnt[b][i] - cnt[a - 1][i];

				sb.append(c).append(i == 3 ? "\n" : " ");
			}
		}

		System.out.print(sb.toString());
	}
}