import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		long a, b, c;
		long answer;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());

			answer = Math.min((a + b) * (a + b) + c * c,
					Math.min((a + c) * (a + c) + b * b, (b + c) * (b + c) + a * a));

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}