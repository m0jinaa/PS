import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int size = 13;

		char[] isbn = br.readLine().toCharArray();

		int sum = 0;

		int mult = 1;

		for (int i = 0; i < size; i++) {
			if (isbn[i] == '*') {
				if (i % 2 != 0) {
					mult = 3;
				}
			} else if (i % 2 == 0) {
				sum = (sum + (isbn[i] - '0')) % 10;
			} else {
				sum = (sum + (isbn[i] - '0') * 3) % 10;
			}
		}

		int answer = 0;

		for (int i = 0; i < 10; i++) {
			if ((sum + i * mult) % 10 == 0) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}