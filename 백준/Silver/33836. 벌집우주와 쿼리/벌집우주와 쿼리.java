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

		int answer = 0;

		while (n-- > 0) {

			answer = 0;

			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (x > 0) {
				if (y != 0)
					answer = 1;
			} else if (x < 0) {
				if (y == 0)
					answer = 1;
				else if (x < y)
					answer = 2;
				else {
					answer = 1;
				}
			} else if (y != 0) {
				answer = 1;
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}