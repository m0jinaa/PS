import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int left;
		int right;

		int[] marble = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			marble[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(marble);

		left = right = marble[0];
		long answer = 0;

		for (int i = 1; i < n; i++) {
			if (i % 2 == 0) {
				answer += marble[i] - left;
				left = marble[i];
			} else {
				answer += marble[i] - right;
				right = marble[i];
			}
		}

		if (n > 2) {
			answer += Math.abs(left - right);
		}

		System.out.println(answer);
	}
}