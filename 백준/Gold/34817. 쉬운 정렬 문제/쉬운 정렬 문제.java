import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int min = A[n - 1];

		boolean possible = true;

		for (int i = n - 2; i >= 0; i--) {
			if (min > A[i]) {
				min = A[i];
			} else if (A[i] - min > k) {
				possible = false;
			}
		}

		System.out.println(possible ? "YES" : "NO");
	}
}