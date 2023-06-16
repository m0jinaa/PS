import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] scores = new int[n];

		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}

		int i = n;

		int answer = 0;

		int target;
		target = scores[n - 1];
		while (i-- > 0) {
			if (scores[i] > target) {
				answer += scores[i] - target;
				target--;
			} else {
				target = scores[i] - 1;
			}
		}

		System.out.println(answer);
	}
}