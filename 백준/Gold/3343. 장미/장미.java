import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		long n = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long d = Long.parseLong(st.nextToken());

		long t;

		if (b * c < d * a) {
			t = b;
			b = d;
			d = t;

			t = a;
			a = c;
			c = t;
		}

		long answer = 1_000_000_000_000_000_001L;
		boolean enough;
		long j;

		for (int i = 0; i < c; i++) {
			enough = false;
			j = (long) Math.ceil((double) (n - i * a) / c);

			if (j < 0) {
				enough = true;
				j = 0;
			}
			answer = Math.min(answer, i * b + j * d);

			if (enough)
				break;
		}

		System.out.println(answer);
	}
}