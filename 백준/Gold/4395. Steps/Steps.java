import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int x, y;

		int d;
		int t;
		int answer;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			d = y - x;

			t = (int) Math.sqrt(d);

			answer = 2 * t - 1;
			if (d != 0) {
				if (d != t * t) {
					answer++;
					if (t + 0.5 < Math.sqrt(d))
						answer++;
				}
			} else
				answer = 0;

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());

	}
}