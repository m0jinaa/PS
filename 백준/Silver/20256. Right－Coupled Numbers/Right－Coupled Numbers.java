import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int x, sqrt;

		int res;

		while (n-- > 0) {
			x = Integer.parseInt(br.readLine());

			res = 0;

			sqrt = (int) Math.sqrt(x);

			for (int i = 1; i <= sqrt; i++) {
				if (x % i == 0 && i * 2 >= x / i) {
					res = 1;
					break;
				}
			}
			sb.append(res).append("\n");
		}

		System.out.print(sb.toString());
	}
}