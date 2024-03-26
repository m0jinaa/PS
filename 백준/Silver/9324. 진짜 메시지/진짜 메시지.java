import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		boolean thirdUsed;
		boolean fake;
		char[] row;
		char check;

		while (tc-- > 0) {
			row = br.readLine().toCharArray();
			check = '0';
			thirdUsed = false;
			fake = true;

			int[] cnt = new int[26];

			for (char c : row) {
				if (check != '0') {
					if (c != check) {
						fake = false;
						break;
					} else {
						check = '0';
						continue;
					}
				}

				if (++cnt[c - 'A'] % 3 == 0) {
					check = c;
					thirdUsed = true;
				} else {
					check = '0';
				}
			}

			if (check != '0')
				fake = false;

			sb.append((!thirdUsed || fake) ? "OK\n" : "FAKE\n");
		}

		System.out.print(sb.toString());
	}
}