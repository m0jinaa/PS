import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] scores = new int[n];

		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(scores);

		int max = scores[n - 1] + 1;

		int answer = 1;

		for (int i = n - 2; i >= 0; i--) {
			if (scores[i] + n >= max)
				answer++;

			max = Math.max(max, scores[i] + n - i);
		}

		System.out.println(answer);
	}
}