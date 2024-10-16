import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		int c = 0;

		long t = n;

		for (long i = 2; i * i <= t && c < 2; i++) {
			while (t % i == 0) {
				c++;
				t /= i;
			}
		}

		if (t > 1) {
			c++;
		}

		System.out.println(c == 2 ? "cubelover" : "koosaga");
	}
}