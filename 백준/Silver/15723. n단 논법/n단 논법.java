import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		boolean[][] rel = new boolean[26][26];
		String[] input;
		int a, b;
		while (n-- > 0) {
			input = br.readLine().split(" is ");
			a = input[0].charAt(0) - 'a';
			b = input[1].charAt(0) - 'a';
			rel[a][b] = true;
		}

		for (int k = 0; k < 26; k++) {
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					if (k == i || i == j || j == k)
						continue;
					rel[i][j] = rel[i][j] || (rel[i][k] && rel[k][j]);
				}
			}
		}

		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			input = br.readLine().split(" is ");
			a = input[0].charAt(0) - 'a';
			b = input[1].charAt(0) - 'a';
			sb.append(rel[a][b] ? "T" : "F").append("\n");
		}

		System.out.println(sb.toString());
	}
}