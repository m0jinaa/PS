import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int a, b;

		boolean[][] changible = new boolean[26][26];

		char[] row;

		while (n-- > 0) {
			row = br.readLine().toCharArray();
			a = row[0] - 'a';
			b = row[2] - 'a';

			changible[a][b] = true;
		}

		for (int k = 0; k < 26; k++) {
			for (int i = 0; i < 26; i++) {
				if (i == k || !changible[i][k])
					continue;
				for (int j = 0; j < 26; j++) {
					if (j == k || i == j || !changible[k][j])
						continue;
					changible[i][j] |= (changible[i][k] && changible[k][j]);
				}
			}
		}

		char[] first, second;
		int l;

		boolean answer;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			first = st.nextToken().toCharArray();
			second = st.nextToken().toCharArray();

			answer = true;

			if (first.length != second.length)
				answer = false;
			else {
				l = first.length;

				for (int i = 0; i < l; i++) {
					if (first[i] == second[i])
						continue;
					else if (changible[first[i] - 'a'][second[i] - 'a'])
						continue;
					else
						answer = false;
				}
			}

			sb.append(answer ? "yes\n" : "no\n");
		}

		System.out.print(sb.toString());
	}
}