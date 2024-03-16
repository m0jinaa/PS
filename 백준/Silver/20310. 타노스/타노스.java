import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] row = br.readLine().toCharArray();

		int n = row.length;

		int zero = 0;
		int one = 0;

		for (int i = 0; i < n; i++) {
			if (row[i] == '1')
				one++;
			else
				zero++;
		}

		zero /= 2;
		one /= 2;

		boolean[] deleted = new boolean[n];

		for (int i = n - 1, j = 0; i >= 0 && j < zero; i--) {
			if (row[i] == '0') {
				j++;
				deleted[i] = true;
			}
		}

		for (int i = 0, j = 0; i < n && j < one; i++) {
			if (row[i] == '1') {
				j++;
				deleted[i] = true;
			}
		}

		for (int i = 0; i < n; i++) {
			if (deleted[i])
				continue;
			sb.append(row[i]);
		}

		System.out.println(sb.toString());
	}
}