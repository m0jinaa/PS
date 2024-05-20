import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n;
		char[][] map;
		int c, total;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			map = new char[n][];

			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}

			// 가로
			for (int i = 0; i < n; i++) {
				total = 0;
				c = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] == '.' && c != 0) {
						sb.append(c).append(" ");
						c = 0;
					} else if (map[i][j] == 'X') {
						c++;
						total++;
					}
				}
				if (c != 0 || total == 0)
					sb.append(c);
				sb.append("\n");
			}

			// 세로
			for (int j = 0; j < n; j++) {
				total = 0;
				c = 0;
				for (int i = 0; i < n; i++) {
					if (map[i][j] == '.' && c != 0) {
						sb.append(c).append(" ");
						c = 0;
					} else if (map[i][j] == 'X') {
						c++;
						total++;
					}
				}
				if (c != 0 || total == 0)
					sb.append(c);
				sb.append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}