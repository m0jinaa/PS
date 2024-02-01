import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean AWins(long x, long y) {
		if (x % y == 0)
			return true;
		else if (x - y < y)
			return !AWins(y, x - y);
		else
			return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long x, y, t;
		String answer = "";

		st = new StringTokenizer(br.readLine(), " ");

		x = Long.parseLong(st.nextToken());
		y = Long.parseLong(st.nextToken());

		if (x < y) {
			t = x;
			x = y;
			y = t;
		}

		if (AWins(x, y))
			answer = "win";
		else
			answer = "lose";

		System.out.println(answer);
	}
}