import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int y, m, d;

	static boolean isExpired(int a, int b, int c) {
		if (y > a || (y == a && m > b) || (y == a && m == b && d > c))
			return true;
		return false;
	}

	static boolean isValid(int y, int m, int d) {
		if (m <= 0 || m > 12 || d <= 0 || d > 31)
			return false;
		else if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30)
			return false;
		else if (m == 2) {
			if (d > 29)
				return false;
			else if (y % 4 != 0 && d == 29) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());

		String answer;
		int a, b, c;

		while (n-- > 0) {
			answer = "invalid";

			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (isValid(a, b, c) && !"unsafe".equals(answer)) {
				answer = "safe";
				if (isExpired(a, b, c)) {
					answer = "unsafe";
				}
			}
			if (isValid(c, b, a) && !"unsafe".equals(answer)) {
				answer = "safe";
				if (isExpired(c, b, a)) {
					answer = "unsafe";
				}
			}
			if (isValid(c, a, b) && !"unsafe".equals(answer)) {
				answer = "safe";
				if (isExpired(c, a, b)) {
					answer = "unsafe";
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}