import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		long answer = 0;

		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int c;

		for (int i = 1; i <= t; i++) {
			c = t / i - (s - 1) / i;

			if (i % 2 == 0) {
				answer += c;
			} else {
				answer -= c;
			}
		}

		System.out.println(answer);
	}
}