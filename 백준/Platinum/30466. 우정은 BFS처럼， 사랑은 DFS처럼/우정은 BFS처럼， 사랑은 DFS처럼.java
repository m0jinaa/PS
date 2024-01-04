import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int h = n / 2;

		long max = 1L * 2 * (h - 1) * (n - h - 1);

		sb.append(max).append("\n");

		for (int i = 2; i <= h + 1; i++) {
			sb.append(i - 1).append(" ").append(i).append("\n");
		}

		for (int i = h + 2; i <= n; i++) {
			sb.append(1).append(" ").append(i).append("\n");
		}

		System.out.print(sb.toString());
	}
}