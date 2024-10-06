import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int gcd(int x, int y) {
		int t;

		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int m = Math.abs(Integer.parseInt(st.nextToken()));
		int n = Math.abs(Integer.parseInt(st.nextToken()));

		int answer = -1;

		if (m == 0 && n == 0)
			answer = 0;
		else if (gcd(m, n) == 1)
			answer = 1;
		else
			answer = 2;

		System.out.println(answer);
	}
}