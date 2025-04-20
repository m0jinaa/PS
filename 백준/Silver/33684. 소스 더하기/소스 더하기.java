import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int[] sauce = new int[n];

		for (int i = 0; i < n; i++) {
			sauce[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(sauce);

		long answer = 0L;

		if (sauce[n - 1] > k) {
			answer = 0L;
		} else if (sauce[0] <= 0) {
			answer = -1;
		} else {
			answer = 1;

			for (int i = 1; i < n; i++) {
				answer += ((k - sauce[i]) / sauce[0]);
			}
		}

		System.out.println(answer);
	}
}