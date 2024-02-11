import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[][] p;

	static void swap(int i, int a, int b) {
		char t = p[i][a];
		p[i][a] = p[i][b];
		p[i][b] = t;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		p = new char[2][k];
		char[] alpha = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		for (int i = 0; i < k; i++) {
			p[0][i] = alpha[i];
		}
		p[1] = br.readLine().toCharArray();
		char[] row;
		end: while (n-- > 0) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < k - 1; j++) {
				if (row[j] == '-') {
					swap(0, j, j + 1);
				} else if (row[j] == '?') {
					break end;
				}
			}
		}

		char[][] ladder = new char[n][];
		int temp = n;

		while (temp-- > 0) {
			ladder[temp] = br.readLine().toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k - 1; j++) {
				if (ladder[i][j] == '-') {
					swap(1, j, j + 1);
				}
			}
		}

		for (int i = 0; i < k - 1;) {
			if (p[0][i] == p[1][i]) {
				sb.append('*');
				i++;
			} else if (p[0][i] == p[1][i + 1] && p[0][i + 1] == p[1][i]) {
				sb.append('-');
				swap(0, i, i + 1);
				if (i + 1 < k - 1) {
					sb.append('*');
				}
				i += 2;

			} else {
				sb.setLength(0);
				for (int j = 1; j < k; j++) {
					sb.append('x');
				}
				break;
			}
		}

		System.out.println(sb.toString());
	}
}