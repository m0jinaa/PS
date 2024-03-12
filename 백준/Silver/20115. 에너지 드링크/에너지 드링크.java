import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		long max = 0;

		long sum = 0;

		long x;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			sum += x;
			if (x > max) {
				max = x;
			}
		}

		double answer = max + (sum - max) / 2.0;

		System.out.println(answer);
	}
}