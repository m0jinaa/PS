import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()) + 2;
		int k = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] sleep = new boolean[n + 1];
		boolean[] attend = new boolean[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (k-- > 0) {
			x = Integer.parseInt(st.nextToken());
			sleep[x] = true;
		}

		st = new StringTokenizer(br.readLine(), " ");

		while (q-- > 0) {
			x = Integer.parseInt(st.nextToken());
			if (sleep[x])
				continue;
			attend[x] = true;
		}

		int[] cnt = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			cnt[i] = cnt[i - 1];
			if (attend[i]) {
				cnt[i]++;
				for (int j = i * 2; j <= n; j += i) {
					if (sleep[j])
						continue;
					attend[j] = true;
				}
			}
		}

		int s, e, c;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			c = e - s + 1 - (cnt[e] - cnt[s - 1]);

			sb.append(c).append("\n");
		}

		System.out.print(sb.toString());
	}
}