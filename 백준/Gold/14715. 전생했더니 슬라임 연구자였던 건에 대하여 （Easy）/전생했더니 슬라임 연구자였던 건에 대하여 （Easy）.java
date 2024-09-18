import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int c = 0;

		int x = 2;

		while (n != 1 && x <= n) {
			while (n % x == 0) {
				c++;
				n /= x;
			}
			x++;
		}

		int answer = (int) Math.ceil(Math.log(c) / Math.log(2));

		System.out.println(answer);
	}
}