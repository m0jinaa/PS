import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int n, x;
		int five;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			five = 0;

			x = n;

			while (x > 0) {
				five += (x / 5);
				x /= 5;
			}

			sb.append(five).append("\n");
		}

		System.out.print(sb.toString());
	}
}