import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		double[] scores = new double[n];
		double sum = 0;
		double x;
		for (int i = 0; i < n; i++) {
			x = Double.parseDouble(br.readLine());
			sum += x;
			scores[i] = x;
		}

		Arrays.sort(scores);

		for (int i = 0; i < k; i++) {
			sum -= (scores[i] + scores[n - 1 - i]);
		}

		sb.append(String.format("%.02f\n", sum / (n - 2 * k) + 1e-8));
		sb.append(String.format("%.02f\n", (sum + scores[k] * k + scores[n - 1 - k] * k) / n + 1e-8));

		System.out.print(sb.toString());
	}
}