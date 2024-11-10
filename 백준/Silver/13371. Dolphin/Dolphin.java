import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int n;

		long s, e, m;

		long g;
		long cnt;

		int c;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			s = 1;
			e = 40000;
			g = e;
			while (s <= e) {
				m = (s + e) / 2;
				cnt = 3 * m * (m + 1) / 2;

				if (n > cnt) {
					s = m + 1;
				} else {
					g = m;
					e = m - 1;
				}
			}

			cnt = 3 * g * (g + 1) / 2;

			c = 0;

			while (n <= cnt) {
				cnt -= g;
				c++;
			}

			switch (c) {
			case 1:
				sb.append("splash\n");
				break;
			case 2:
				sb.append(g).append(" ").append(g != 1 ? "jumps\n" : "jump\n");
				break;
			case 3:
				sb.append(g).append(" ").append(g != 1 ? "dolphins\n" : "dolphin\n");
				break;
			}
		}

		System.out.print(sb.toString());
	}
}