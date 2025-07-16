import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int MAX = 100;

		// 앞자리 짝수짝수 또는 홀수홀수의 경우의 수 => 앞자리라서 0으로 시작하면 안됨
		int even = 4 * 5 + 5 * 5;

		// 100미만 소수의 개수 => 뒷자리라서 0으로 시작해도 됨
		int prime = 25;

		int MOD = 9973;

		// 앞 두자리와 뒷 두자리를 제외하고 나머지 자릿수를 채우는 방법의 수
		int[] digit = new int[MAX];

		digit[0] = 1;

		for (int i = 1; i < MAX; i++) {
			digit[i] = (digit[i - 1] * 10) % MOD;
		}

		int t = Integer.parseInt(br.readLine());

		int n;
		int answer;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			answer = (((even * 100 + 90 * prime - even * prime) % MOD) * digit[n - 4]) % MOD;

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}