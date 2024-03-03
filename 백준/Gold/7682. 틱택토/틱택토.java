import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] row;

	static boolean check(char c) {
		if (row[0] == c && row[0] == row[1] && row[1] == row[2]) {
			return true;
		} else if (row[3] == c && row[3] == row[4] && row[4] == row[5]) {
			return true;
		} else if (row[6] == c && row[6] == row[7] && row[7] == row[8]) {
			return true;
		} else if (row[0] == c && row[0] == row[3] && row[3] == row[6]) {
			return true;
		} else if (row[1] == c && row[1] == row[4] && row[4] == row[7]) {
			return true;
		} else if (row[2] == c && row[2] == row[5] && row[5] == row[8]) {
			return true;
		} else if (row[0] == c && row[0] == row[4] && row[4] == row[8]) {
			return true;
		} else if (row[2] == c && row[2] == row[4] && row[4] == row[6]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		String end = "end";
		String answer;
		int x, o;

		boolean xSuccess, oSuccess;

		while (!end.equals((input = br.readLine()))) {
			row = input.toCharArray();

			x = 0;
			o = 0;

			answer = "valid";
			for (int i = 0; i < 9; i++) {
				switch (row[i]) {
				case 'X':
					x++;
					break;
				case 'O':
					o++;
					break;
				}
			}

			xSuccess = check('X');
			oSuccess = check('O');

			if (o > x || x > o + 1) {
				answer = "invalid";
			} else if (xSuccess && oSuccess || (x + o != 9 && !xSuccess && !oSuccess)) { // 둘 다 성공하거나 하나도 성공하지 못한 경우
				answer = "invalid";
			} else if (xSuccess && x == o) { // x가 성공했는데 놓은 개수가 같은 경우
				answer = "invalid";
			} else if (oSuccess && x > o) { // o가 성공했는데 x가 더 많이 놓은 경우
				answer = "invalid";
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}