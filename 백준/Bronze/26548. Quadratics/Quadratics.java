import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		double a, b, c;

		int n = Integer.parseInt(br.readLine());

		double plus, minus;

		while (n-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			a = Double.parseDouble(st.nextToken());
			b = Double.parseDouble(st.nextToken());
			c = Double.parseDouble(st.nextToken());

			plus = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
			minus = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

			sb.append(String.format("%.3f, %.3f\n", plus, minus));
		}

		System.out.println(sb.toString());
	}
}