import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		long k = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		long answer = 0;

		if (0 < a || b < 0) {
			a = Math.abs(a);
			b = Math.abs(b);

			if (a > b) {
				long t = a;
				a = b;
				b = t;
			}
			answer = b / k - a / k + (a % k == 0 ? 1 : 0);
		} else {
			answer = (-a) / k + b / k + 1;
		}

		System.out.println(answer);
	}
}