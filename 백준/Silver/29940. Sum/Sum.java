import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		int l, r, m;
		int cnt = 0;
		int sum;

		for (int i = 0; i < n; i++) {
			l = i + 1;
			r = n - 1;

			while (l <= r) {
				m = (l + r) / 2;
				sum = A[i] + A[m];

				if (sum == s) {
					cnt++;
					break;
				} else if (sum < s) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
		}

		System.out.println(cnt);
	}
}