import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		long m = Integer.parseInt(st.nextToken());

		long digit = ((int) Math.log10(n)) + 1;

		m = Math.min(m, digit * n);
		long t = m / digit;

		while (t-- > 0) {
			sb.append(n);
		}

		if (m % digit != 0) {
			sb.append(n / (int) Math.pow(10, digit - m % digit));
		}

		System.out.println(sb.toString());
	}
}