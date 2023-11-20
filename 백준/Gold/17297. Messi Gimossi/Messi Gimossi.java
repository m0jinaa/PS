import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] first, second;
	static int[] cnt;

	static char getChar(int ind, int loc) {
		if (loc == -1) {
			return ' ';
		}
		if (ind == 0) {
			return first[loc];
		} else if (ind == 1) {
			return second[loc];
		} else if (loc < cnt[ind - 1]) {
			return getChar(ind - 1, loc);
		} else {
			return getChar(ind - 2, loc - cnt[ind - 1] - 1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		first = new char[] { 'M', 'e', 's', 's', 'i' };
		second = new char[] { 'M', 'e', 's', 's', 'i', ' ', 'G', 'i', 'm', 'o', 's', 's', 'i' };

		int n = Integer.parseInt(br.readLine());

		cnt = new int[42];

		cnt[0] = 5;
		cnt[1] = 13;

		for (int i = 2; i < 42; i++) {
			cnt[i] = cnt[i - 1] + cnt[i - 2] + 1;
		}
		char answer = getChar(41, n-1);

		if (answer == ' ') {
			System.out.println("Messi Messi Gimossi");
		} else {
			System.out.println(answer);
		}
	}
}