import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long pow(int x) {
		if (x == 0) {
			return 1L;
		} else if (x == 1) {
			return 2L;
		} else if (x % 2 != 0) {
			return 2 * pow(x - 1);
		} else {
			long ret = pow(x / 2);

			return ret * ret;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int n;
		long c;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			if (n % 3 != 0) {
				c = 0;
			} else {
				c = pow(n / 3);
			}

			sb.append(c).append("\n");
		}

		System.out.println(sb.toString());
	}
}