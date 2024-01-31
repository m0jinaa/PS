import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean AWins(int x, int y) {
		if (x % y == 0)
			return true;
		else if (x - y < y)
			return !AWins(y, x - y);
		else
			return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int x, y, t;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0)
				break;

			if (x < y) {
				t = x;
				x = y;
				y = t;
			}

			if (AWins(x, y))
				sb.append("A wins\n");
			else {
				sb.append("B wins\n");
			}
		}

		System.out.println(sb.toString());
	}
}