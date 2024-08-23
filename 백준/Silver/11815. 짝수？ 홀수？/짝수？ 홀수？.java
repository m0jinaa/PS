import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long x, sqrt;

		st = new StringTokenizer(br.readLine(), " ");

		while (n-- > 0) {
			x = Long.parseLong(st.nextToken());

			sqrt = (long) Math.floor(Math.sqrt(x));

			if (sqrt * sqrt == x)
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}

		System.out.println(sb.toString());
	}
}