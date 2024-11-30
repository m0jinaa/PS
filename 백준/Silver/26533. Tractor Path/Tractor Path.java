import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] map = new char[n + 1][];
		boolean[][] v = new boolean[n + 1][n + 1];
		v[0][1] = v[1][0] = true;

		for (int i = 1; i <= n; i++) {
			map[i] = (" " + br.readLine()).toCharArray();
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 'x')
					continue;
				v[i][j] = v[i - 1][j] || v[i][j - 1];
			}
		}

		System.out.println(v[n][n] ? "Yes" : "No");
	}
}