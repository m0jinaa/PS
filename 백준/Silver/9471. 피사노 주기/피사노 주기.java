import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int a, b, t, c;
		int n, m;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			a = 1;
			b = 1;
			c = 0;

			do {
				t = (a + b) % m;
				a = b;
				b = t;
				c++;

			} while (a != 1 || b != 1);

			sb.append(n).append(" ").append(c).append("\n");
		}

		System.out.print(sb.toString());
	}
}