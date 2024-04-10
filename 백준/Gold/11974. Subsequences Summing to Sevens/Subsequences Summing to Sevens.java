import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] sum = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i && i - j + 1 > answer; j++) {
				if ((sum[i] - sum[j - 1]) % 7 == 0) {
					answer = Math.max(answer, i - j + 1);
					break;
				}
			}
		}

		System.out.println(answer);
	}
}