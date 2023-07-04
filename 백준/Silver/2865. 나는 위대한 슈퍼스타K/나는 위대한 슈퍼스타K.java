import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		double[] ability = new double[n];
		int i;
		double s;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				i = Integer.parseInt(st.nextToken()) - 1;
				s = Double.parseDouble(st.nextToken());
				if (ability[i] < s) {
					ability[i] = s;
				}
			}
		}

		Arrays.sort(ability);

		double answer = 0;

		for (int j = n - 1; j >= n - k; j--) {
			answer += ability[j];
		}

		System.out.printf("%.01f\n", answer + 1e-8);
	}
}