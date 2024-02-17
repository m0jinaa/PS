import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] v;
	static int n, s;

	static boolean check(int x, int y) {
		if (x == 0 && y == s)
			return true;
		else if (x == 0 || y > s || v[x][y])
			return false;
		v[x][y] = true;
		boolean res = false;

		for (int i = 1; i <= x; i++) {
			res |= check(x - i, y + ((i * (i + 1)) / 2));
		}

		return res;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		v = new boolean[n + 1][s + 1];

		System.out.println(check(n - 2, 0) ? "1" : "0");
	}
}