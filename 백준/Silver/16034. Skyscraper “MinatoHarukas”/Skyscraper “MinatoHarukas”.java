import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n;
		int c;

		while ((n = Integer.parseInt(br.readLine())) != 0) {

			c = (int) Math.sqrt(2 * n);

			while (c > 0) {
				if ((n - (c * (c - 1) / 2)) % c == 0) {
					sb.append((n - (c * (c - 1) / 2)) / c).append(" ").append(c).append("\n");
					break;
				} else
					c--;
			}
		}

		System.out.print(sb.toString());
	}
}