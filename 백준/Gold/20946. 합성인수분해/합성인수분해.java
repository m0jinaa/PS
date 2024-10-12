import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long n = Long.parseLong(br.readLine());

		int limit = (int) Math.sqrt(n);

		int l = (int) Math.ceil(Math.log(n) / Math.log(2));
		long[] list = new long[l];

		int j = 0;

		for (long i = 2; i <= limit; i++) {
			while (n % i == 0) {
				list[j++] = i;
				n /= i;
			}
		}

		if (n != 1) {
			list[j++] = n;
		}

		if (j == 1) {
			sb.append(-1);
		} else {
			for (int i = 0; i < j; i += 2) {
				if (j - i == 3) {
					sb.append(list[i] * list[i + 1] * list[i + 2]);
					i += 3;
				} else {
					sb.append(list[i] * list[i + 1]).append(" ");
				}
			}
		}

		System.out.println(sb.toString());
	}
}