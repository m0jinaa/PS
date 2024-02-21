import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] sum = new long[n + 1];
		long[] honey = new long[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			honey[i] = Long.parseLong(st.nextToken());
			sum[i] = sum[i - 1] + honey[i];
		}

		long answer = 0;

		// 벌(1)-벌(i)-꿀통(n)
		for (int i = 2; i < n; i++) {
			answer = Math.max(answer, (sum[n] - honey[1] - honey[i]) + (sum[n] - sum[i]));
		}

		// 꿀통(1)-벌(i)-벌(n)
		for (int i = 2; i < n; i++) {
			answer = Math.max(answer, sum[i - 1] + (sum[n] - honey[n] - honey[i]));
		}

		// 벌(1)-꿀통(i)-벌(n)
		for (int i = 2; i < n; i++) {
			answer = Math.max(answer, (sum[i] - honey[1]) + (sum[n] - sum[i - 1] - honey[n]));
		}

		System.out.println(answer);
	}
}