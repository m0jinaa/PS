import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Double> list = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());

		double[] answer = new double[8];

		answer[0] = -1;

		int i = 1;

		for (; i <= 7; i++)
			answer[i] = Double.parseDouble(br.readLine());

		Arrays.sort(answer);

		for (; i <= n; i++) {
			double d = Double.parseDouble(br.readLine());
			if (d >= answer[7])
				continue;
			for (int j = 7; j >= 0; j--) {
				if (answer[j] <= d) {
					for (int k = 7; k > j + 1; k--)
						answer[k] = answer[k - 1];
					answer[j + 1] = d;
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int j = 1; j < 8; j++) {
			sb.append(String.format("%.03f\n", answer[j] + 1e-8));
		}

		System.out.print(sb.toString());
	}
}
