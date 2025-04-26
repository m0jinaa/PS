import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int x;
		long ans;

		while (t-- > 0) {
			x = Integer.parseInt(br.readLine());

			// x가 짝수가 아닌 경우에는 0
			if (x % 2 != 0) {
				ans = 0;
			} else {
				ans = (long) Math.pow(2, x / 2);
			}

			sb.append(ans).append("\n");
		}

		System.out.print(sb.toString());
	}
}