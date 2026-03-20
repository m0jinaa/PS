import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] R = new int[n];

		int total = 0;

		int sum = 0;

		for (int i = 0; i < n; i++) {
			R[i] = Integer.parseInt(br.readLine());
			total += R[i] * i;
			sum += R[i];
		}

		int answer = total;

		for (int i = 0; i < n; i++) {
			total -= (sum - R[i]);
			total += R[i] * (n - 1);

			answer = Math.min(answer, total);
		}

		System.out.println(answer);
	}
}