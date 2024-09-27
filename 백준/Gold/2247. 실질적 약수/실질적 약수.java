import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		final int MOD = 1_000_000;

		int n = Integer.parseInt(br.readLine());

		int limit = n / 2;
    
        //1~n까지의 수 중 i가 약수인 수의 개수 = n/i 인데 i==n 인 경우 제외 => n/i-1;
		for (int i = 2; i <= limit; i++) {
			answer = (answer + i * (n / i - 1)) % MOD;
		}

		System.out.println(answer);
	}
}