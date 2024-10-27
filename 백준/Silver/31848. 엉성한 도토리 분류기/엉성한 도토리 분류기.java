import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[n];

		int bef = 0;
		int now;

		for (int i = 0; i < n; i++) {
			now = Integer.parseInt(st.nextToken()) + i;

			if (now > bef)
				bef = now;
			A[i] = bef;
		}

		int q = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int x;
		int s, e, m;
		int answer;
		while (q-- > 0) {
			s = 0;
			e = n - 1;

			answer = n;

			x = Integer.parseInt(st.nextToken());

			while (s <= e) {
				m = (s + e) / 2;

				if (A[m] >= x) {
					answer = m;
					e = m - 1;
				} else {
					s = m + 1;
				}
			}

			sb.append(answer + 1).append(" ");
		}

		System.out.println(sb.toString());
	}
}