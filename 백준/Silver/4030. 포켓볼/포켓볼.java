import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int a, b;
		long m, s, e;

		int cnt;
		int tc = 0;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0)
				break;

			tc++;
			cnt = 0;

			for (int i = 1; i * i < b; i++) {

				if (i * i <= a)
					continue;

				s = 1;
				e = 1_000_000_000;

				while (s <= e) {
					m = (s + e) / 2;

					if (i * i - 1 == m * (m + 1) / 2) {
						cnt++;
						break;
					} else if (i * i - 1 < m * (m + 1) / 2)
						e = m - 1;
					else
						s = m + 1;
				}
			}

			sb.append("Case ").append(tc).append(": ").append(cnt).append("\n");
		}

		System.out.print(sb.toString());

	}
}