import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 뒤에서부터 역순으로 살펴보면서 최솟값을 구하면서 더하기

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		long sum = A[n - 1];

		int min = A[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			min = Math.min(min, A[i]);

			sum += min;
		}

		System.out.println(sum);
	}
}