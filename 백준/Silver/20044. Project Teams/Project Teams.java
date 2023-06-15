import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] w = new int[2 * n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 2 * n; i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(w);

		int answer = 200001;

		int s;
		for (int i = 0; i < n; i++) {
			s = w[i] + w[2 * n - 1 - i];
			answer = Math.min(answer, s);
		}

		System.out.println(answer);
	}
}