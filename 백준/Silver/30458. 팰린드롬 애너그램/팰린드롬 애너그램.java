import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] row = br.readLine().toCharArray();

		int[] cnt = new int[26];

		for (char c : row) {
			cnt[c - 'a']++;
		}

		if (n % 2 != 0) {
			cnt[row[n / 2] - 'a']--;
		}

		boolean can = true;

		for (int i = 0; i < 26; i++) {
			if (cnt[i] % 2 != 0) {
				can = false;
				break;
			}
		}

		System.out.println(can ? "Yes" : "No");
	}
}