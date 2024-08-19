import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int gcd(int a, int b) {
		int t;
		while (b != 0) {
			t = a % b;
			a = b;
			b = t;
		}

		return a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int g = gcd(x, y);

		int answer = x + y - g;

		System.out.println(answer);
	}
}