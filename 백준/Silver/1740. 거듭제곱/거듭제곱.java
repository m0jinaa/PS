import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long answer = 0L;

		long x = 1;

		while (n > 0) {
			if (n % 2 != 0) {
				answer += x;
			}
			x *= 3;
			n >>= 1;
		}
		
		System.out.println(answer);
	}
}