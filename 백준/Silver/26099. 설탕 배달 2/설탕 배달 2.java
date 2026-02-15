import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		long five = n / 5;
		long r = n % 5;

		long answer = -1;

		if (r == 0) {
			answer = five;
		} else if (r == 1 && five >= 1) {
			answer = five + 1;
		} else if (r == 2 && five >= 2) {
			answer = five + 2;
		} else if (r == 3) {
			answer = five + 1;
		} else if (r == 4 && five >= 1) {
			answer = five + 2;
		}

		System.out.println(answer);
	}
}