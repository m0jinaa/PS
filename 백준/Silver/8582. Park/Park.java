import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] line = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 0; i < n; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		left[0] = line[0];

		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], line[i]);
		}

		right[n - 1] = line[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], line[i]);
		}

		for (int i = 0; i < n; i++) {
			sb.append(left[i]).append(" ").append(right[i]).append("\n");
		}

		System.out.print(sb.toString());
	}
}