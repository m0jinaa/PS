import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] input = br.readLine().toCharArray();

		String ans = input[0] + "";

		int n = input.length;
		for (int i = 1; i < n; i++) {
			if (ans.charAt(i - 1) < input[i]) {
				ans = input[i] + ans;
			} else {
				ans = ans + input[i];
			}
		}

		sb.append(ans);

		System.out.println(sb.reverse());
	}
}