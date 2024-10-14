import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int getGCD(int x, int y) {
		int t;

		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int a, b, c, gcd, max;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			gcd = getGCD(a, b);

			max = Math.max(a, b);

			if (max < c)
				sb.append("NO\n");
			else if (a == c || b == c)
				sb.append("YES\n");
			else if (c % gcd == 0)
				sb.append("YES\n");
			else if (gcd == 1 && c < max)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}

		System.out.print(sb.toString());
	}
}