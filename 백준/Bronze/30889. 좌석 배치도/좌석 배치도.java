import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		char[][] map = new char[10][20];
		for (int i = 0; i < 10; i++) {
			Arrays.fill(map[i], '.');
		}
		char[] row;
		int r, c;
		while (n-- > 0) {
			row = br.readLine().toCharArray();

			r = row[0] - 'A';
			c = 0;
			for (int i = 1; i < row.length; i++) {
				c = c * 10 + (row[i] - '0');
			}
			c -= 1;
			map[r][c] = 'o';
		}

		for (int i = 0; i < 10; i++) {
			sb.append(String.valueOf(map[i])).append("\n");
		}

		System.out.print(sb.toString());
	}
}