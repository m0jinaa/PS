import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n, k;
		int[] chests;

		long sum, answer;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			chests = new int[n];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				chests[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(chests);

			sum = 0;

			for (int i = n - k - 1; i >= 0; i--) {
				sum += chests[i];
			}

			answer = Math.max(sum, chests[n - 1]);

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}