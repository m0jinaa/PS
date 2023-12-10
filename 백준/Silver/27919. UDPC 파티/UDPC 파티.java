import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cu = 0;
		int dp = 0;

		char[] row = br.readLine().toCharArray();

		for (char c : row) {
			switch (c) {
			case 'C':
			case 'U':
				cu++;
				break;
			case 'D':
			case 'P':
				dp++;
				break;
			}
		}

		String answer = "";

		if (cu > (dp + 1) / 2)
			answer += "U";

		if (dp > 0) {
			answer += "DP";
		}

		System.out.println(answer);

	}
}