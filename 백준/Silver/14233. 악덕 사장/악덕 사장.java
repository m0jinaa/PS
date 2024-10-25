import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] deadline = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			deadline[i] = Integer.parseInt(st.nextToken());
		}

		int answer = Integer.MAX_VALUE;

		Arrays.sort(deadline);

		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, deadline[i] / i);
		}

		System.out.println(answer);
	}
}