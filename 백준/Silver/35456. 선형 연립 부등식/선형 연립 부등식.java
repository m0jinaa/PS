import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;

		int n = Integer.parseInt(br.readLine());

		int a, b, c;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (a < 0) {
				min = Math.max(min, (long) Math.ceil((c - b) * 1.0 / a));
			} else {
				max = Math.min(max, (long) Math.floor((c - b) * 1.0 / a));
			}
		}

		long answer = 0;

		if (min == Long.MIN_VALUE || max == Long.MAX_VALUE)
			answer = -1;
		else if (min > max) {
			answer = 0;
		} else {
			answer = max - min + 1;
		}

		System.out.println(answer);
	}
}