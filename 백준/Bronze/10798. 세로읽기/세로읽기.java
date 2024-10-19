import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = 5;

		int m = 0;

		char[][] input = new char[n][];

		for (int i = 0; i < n; i++) {
			input[i] = br.readLine().toCharArray();
			m = Math.max(m, input[i].length);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (input[j].length > i) {
					sb.append(input[j][i]);
				}
			}
		}

		System.out.println(sb.toString());
	}
}