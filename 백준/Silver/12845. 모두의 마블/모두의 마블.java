import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int sum = 0;
		int max = 0;

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			sum += x;
			max = Math.max(max, x);
		}

		int answer = max * (n - 1) + (sum - max);

		System.out.println(answer);
	}
}