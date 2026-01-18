import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int a;

		st = new StringTokenizer(br.readLine(), " ");

		int dx, dy;

		int left = 0;
		int meal = 0;

		while (n-- > 0) {
			a = Integer.parseInt(st.nextToken());
			dx = a / x;
			dy = a / y;

			if (dx == dy) {
				meal += dy;
				left += (a % y);
			} else {
				meal += dx;
			}
		}

		sb.append(meal).append("\n").append(left).append("\n");

		System.out.print(sb.toString());
	}
}