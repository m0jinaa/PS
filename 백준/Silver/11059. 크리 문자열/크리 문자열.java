import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] row = br.readLine().toCharArray();

		int n = row.length;

		int[] sum = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + (row[i - 1] - '0');
		}

		int answer = 0;

		int left, right;

		for (int e = 1; e <= n; e++) {
			for (int l = 1; l <= e / 2; l++) {
				left = sum[e - l] - sum[e - 2 * l];
				right = sum[e] - sum[e - l];

				if (left == right) {
					answer = Math.max(answer, l * 2);
				}
			}
		}

		System.out.println(answer);
	}
}