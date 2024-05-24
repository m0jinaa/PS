import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long answer = 0;

		int tc = Integer.parseInt(br.readLine());

		long cnt;

		long a, b;

		long now;
		long next;
		int c;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			cnt = b - a + 1;

			answer = cnt / 9 * 45;

			now = a;

			while (now / 10 != 0) {
				next = 0;

				while (now != 0) {
					next += (now % 10);
					now /= 10;
				}

				now = next;
			}

			c = (int) (cnt % 9);

			while (c-- > 0) {
				answer += now;

				if (now == 9)
					now = 1;
				else
					now++;
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}