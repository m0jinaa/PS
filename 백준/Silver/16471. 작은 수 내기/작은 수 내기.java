import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];
		int[] B = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int cnt = 0;
		int ind = n - 1;
		for (int i = n - 1; i >= 0; i--) {
			if (A[i] >= B[ind])
				continue;
			else {
				cnt++;
				ind--;
			}
		}

		System.out.println((cnt >= (n + 1) / 2) ? "YES" : "NO");
	}
}