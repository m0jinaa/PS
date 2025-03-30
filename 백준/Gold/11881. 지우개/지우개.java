import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int MAX_A = 100_000;
		final int MOD = 1_000_000_007;

		long[] cnt = new long[MAX_A + 1];

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		// 큰수의 합
		long high = 0;

		int a;

		// 같은 수를 가진 원소 개수 세고 큰수 합 구하기
		for (int i = 0; i < n; i++) {
			a = Integer.parseInt(st.nextToken());

			cnt[a]++;
			high += a;
		}

		// 현재 수보다 낮은수의 합
		long low = 0;

		long answer = 0;

		for (int i = 1; i <= MAX_A; i++) {
			// 해당 하는 원소 없으면 패스
			if (cnt[i] == 0)
				continue;
			// 큰수에서 현재 수*개수 빼기 => 현재수보다 큰 수의 합 구할 수 있음
			high = (high - (i * cnt[i]) % MOD + MOD) % MOD;

			// 해답 = (해답 + 현재 수를 중간 수로 두고 구할 수 있는 모든 지우개 부피의 합 * 개수)%MOD
			answer = (answer + (((((low * i) % MOD) * high) % MOD) * cnt[i]) % MOD) % MOD;

			low = (low + (i * cnt[i]) % MOD) % MOD;

		}

		System.out.print(answer);
	}
}