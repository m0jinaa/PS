import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int min = 10001;

		int[] sum = new int[n + 1];

		int[] grades = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		int total = 0;
		for (int i = 0; i < n; i++) {
			grades[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = n - 1; i >= 0; i--) {
			min = Math.min(min, grades[i]);
			sum[i] = total + grades[i] - min;
			total += grades[i];
		}

		long s = 0;
		long d = n - 1;

		for (int i = 1; i < n - 1; i++) {
			if (s * (n - i - 1) < d * sum[i]) {
				sb.setLength(0);
				sb.append(i).append("\n");
				s = sum[i];
				d = n - i - 1;
			} else if (s * (n - i - 1) == d * sum[i]) {
				sb.append(i).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}