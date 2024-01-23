import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long n, k, p, a, b, answer = 0;
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {

			st = new StringTokenizer(br.readLine(), " ");
			n = Long.parseLong(st.nextToken());
			k = Long.parseLong(st.nextToken());

			p = (long) Math.floor(Math.log10(n) / Math.log10(2));

			a = 0;

			if (k > p) {
				a = 0;
			} else {
				a = n / (long) (Math.pow(2, k));
			}

			b = 0;

			if (k + 1 > p) {
				b = 0;
			} else {
				b = n / (long) (Math.pow(2, k + 1));
			}

			answer = a - b;
			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}