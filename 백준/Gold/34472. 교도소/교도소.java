import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		long[] A = new long[n];

		long sum = 0;

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			sum += A[i];
		}

		long mean = sum / n;

		long rest = 0;

		long answer = 0;

		for (int i = 0; i < n; i++) {
			answer += rest;
			if (A[i] >= mean) {
				rest += (A[i] - mean);
			} else if (A[i] + rest >= mean) {
				rest = (rest + A[i] - mean);
			} else {
				answer += (mean - (A[i] + rest)) * (i + 1);
				rest = 0;
			}
		}

		System.out.println(answer);
	}
}