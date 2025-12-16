import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] sum = new long[n];
		long[] A = new long[n];
		long[] B = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			B[i] = Long.parseLong(st.nextToken());
		}

		long[] diff = new long[n];

		for (int i = 0; i < n; i++) {
			diff[i] = A[i] - B[i];
		}

		sum[0] = diff[0];

		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + diff[i];
		}

		Map<Long, Long> cnt = new HashMap<>();

		long answer = 0;

		for (int i = 0; i < n; i++) {
			if (sum[i] == 0)
				answer++;
			answer += cnt.getOrDefault(sum[i], 0L);

			cnt.put(sum[i], cnt.getOrDefault(sum[i], 0L) + 1);
		}

		System.out.println(answer);
	}
}