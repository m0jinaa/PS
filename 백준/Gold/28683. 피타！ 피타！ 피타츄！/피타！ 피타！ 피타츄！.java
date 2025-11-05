import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		int answer = 0;

		long limit;

		// 1. n이 제곱수인 경우 -> -1
		if (n == (long) Math.pow((long) Math.sqrt(n), 2)) {
			answer = -1;
		} else {
			long b;

			// 2. 루트 n이 빗변인 경우

			limit = (long) Math.sqrt(n / 2);

			for (long a = 1; a <= limit; a++) {
				b = (long) Math.sqrt(n - a * a);

				if (a * a + b * b == n) {
					answer++;
				}
			}

			// 3. 루트 n이 빗변이 아닌 경우

			// 빗변을 c, 빗변이 아닌 변을 a라고 했을 때
			// c*c-a*a = (c+a)(c-a) == n을 만족하는 쌍 찾기
			// 홀수홀수이거나 짝수짝수이어야함.

			long c;

			limit = (long) Math.sqrt(n);

			for (int a = 1; a <= limit; a++) {
				if (n % a != 0)
					continue;
				c = n / a;

				if (a % 2 == c % 2) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}