import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[] input;

	static boolean isPalindrome(int s, int e) {

		while (s <= e) {
			if (input[s] == input[e])
				return false;
			s++;
			e--;
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = br.readLine().toCharArray();

		n = input.length;

		int answer = 0;
		int c;
		for (int i = 0; i < n; i++) {
			c = 0;
			for (int j = i; j < n; j++) {
				if (input[j] == '(') {
					c++;
					continue;
				} else if (c == 0) {
					break;
				}

				c--;

				if ((j - i) % 2 == 0) {
					continue;
				} else if (isPalindrome(i, j)) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}