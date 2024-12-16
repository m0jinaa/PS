import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] pay = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			pay[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(pay);

		long max = 0;
		long fee = 0;

		long money;

		for (int i = 0; i < n; i++) {
			money = pay[i] * (n - i);

			if (money > max) {
				max = money;
				fee = pay[i];
			}
		}

		sb.append(max).append(" ").append(fee);

		System.out.println(sb.toString());
	}
}