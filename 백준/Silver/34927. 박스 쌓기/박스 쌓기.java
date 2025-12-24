import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		long sum = 0;

		int[] weight = new int[n];

		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(weight);

		int answer = 0;

		for (int w : weight) {
			if (sum <= w) {
				sum += w;
				answer++;
			}
		}

		System.out.println(answer);
	}
}