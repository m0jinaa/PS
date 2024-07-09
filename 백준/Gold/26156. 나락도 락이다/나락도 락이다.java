import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] cnt = new int[5];

		cnt[0] = 1;

		final int MOD = 1_000_000_007;

		char[] row = br.readLine().toCharArray();

		for (char c : row) {
			switch (c) {
			case 'R':
				cnt[1] = (cnt[1] + cnt[0]) % MOD;
				cnt[0] = (cnt[0] + cnt[0]) % MOD;
				break;

			case 'O':
				cnt[2] = (cnt[2] + cnt[1]) % MOD;
				cnt[0] = (cnt[0] + cnt[0]) % MOD;
				break;

			case 'C':
				cnt[3] = (cnt[3] + cnt[2]) % MOD;
				cnt[0] = (cnt[0] + cnt[0]) % MOD;
				break;

			case 'K':
				cnt[4] = (cnt[4] + cnt[3]) % MOD;
				cnt[0] = (cnt[0] + cnt[0]) % MOD;
				break;

			default:
				cnt[0] = (cnt[0] + cnt[0]) % MOD;
				break;

			}
		}
		System.out.println(cnt[4]);
	}
}