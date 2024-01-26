import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] row = br.readLine().toCharArray();

		Arrays.sort(row);

		int n = row.length;

		int[] cnt = new int[26];

		boolean possible = true;
		for (char c : row) {
			cnt[c - 'a']++;

			if (cnt[c - 'a'] > (n + 1) / 2) {
				possible = false;
			}
		}

		char c;

		if (possible) {
			for (int i = (n + 1) / 2; i < n; i++) {
				if (row[i] != row[n - 1 - i])
					continue;
				for (int j = i + 1; j < n; j++) {
					if (row[j] != row[i]) {
						c = row[j];
						row[j] = row[i];
						row[i] = c;
						break;
					}
				}
			}

			sb.append(String.valueOf(row));
		} else {
			sb.append(-1);
		}

		System.out.println(sb.toString());
	}
}