import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];
		int[] B = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(A);

		int N = 2 * n;
		int j = 0;
		int ind = 0;

		for (int i = 1; i <= N; i++) {
			if (j < n && A[j] == i) {
				j++;
				continue;
			}
			B[ind++] = i;
		}

		int answer = 0;

		j = 0;

		for (int i = 0; i < n && j < n; i++) {
			if (B[i] > A[j]) {
				answer++;
				j++;
			}
		}

		System.out.println(answer);
	}
}