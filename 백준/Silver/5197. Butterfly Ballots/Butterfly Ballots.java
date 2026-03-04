import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int n, s, e;
		int[] candidate, vote;
		boolean possible;

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			candidate = new int[n - 1];
			vote = new int[n];
			vote[n - 1] = Integer.parseInt(br.readLine());

			for (int i = 0; i < n - 1; i++) {
				candidate[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(candidate);

			s = 0;
			e = n - 2;

			for (int i = n - 2; i >= 0; i--) {
				if ((n - i) % 2 == 0) {
					vote[i] += candidate[e] / 2;
					vote[i + 1] += candidate[e] / 2;
					e--;
				} else {
					vote[i] += candidate[s] / 2;
					vote[i + 1] += candidate[s] / 2;
					s++;
				}
			}

			possible = true;

			for (int i = 0; i < n - 1; i++) {
				if (vote[i] > vote[n - 1]) {
					possible = false;
					break;
				}
			}
			
			sb.append("Data Set ").append(t).append(":\n");

			if (possible) {
				sb.append("Possible\n");
			} else {
				sb.append("Impossible\n");
			}
		}

		System.out.println(sb.toString());
	}
}