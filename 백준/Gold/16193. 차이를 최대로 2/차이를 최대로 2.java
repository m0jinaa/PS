import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		int left = A[0];
		int right = A[0];

		int l = 1;
		int r = n - 1;

		long answer = 0;

		int ll, lr, rl, rr;

		int max;

		while (l <= r) {
			ll = Math.abs(left - A[l]);
			lr = Math.abs(left - A[r]);
			rl = Math.abs(right - A[l]);
			rr = Math.abs(right - A[r]);

			max = Math.max(ll, Math.max(lr, Math.max(rl, rr)));

			answer += max;

			if (max == ll) {
				left = A[l++];
			} else if (max == lr) {
				left = A[r--];
			} else if (max == rl) {
				right = A[l++];
			} else {
				right = A[r--];
			}
		}

		System.out.println(answer);
	}
}