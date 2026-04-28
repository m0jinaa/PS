import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		long A, B, C, P;
		long a, b, c, p;

		int n;
		long need, can;
		boolean possible;

		while (t-- > 0) {
			A = 0;
			B = 0;
			C = 0;
			P = 0;

			possible = true;

			n = Integer.parseInt(br.readLine());

			while (n-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");

				a = Long.parseLong(st.nextToken());
				b = Long.parseLong(st.nextToken());
				c = Long.parseLong(st.nextToken());
				p = Long.parseLong(st.nextToken());

				need = 1 + Math.max(a - A, 0) + Math.max(b - B, 0) + Math.max(c - C, 0);

				can = p - P;

				if (need > can) {
					possible = false;
				} else {
					P += need;
					A = Math.max(a, A);
					B = Math.max(b, B);
					C = Math.max(c, C);
				}
			}

			sb.append(possible ? "YES\n" : "NO\n");
		}

		System.out.print(sb.toString());
	}
}